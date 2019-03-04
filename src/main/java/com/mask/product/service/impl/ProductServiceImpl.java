package com.mask.product.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.mask.product.dataobject.ProductInfo;
import com.mask.product.dto.CartDTO;
import com.mask.product.enums.ProductStatusEnum;
import com.mask.product.enums.ResultEnum;
import com.mask.product.exception.ProductException;
import com.mask.product.repository.ProductInfoRepository;
import com.mask.product.service.ProductService;


@Service
@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository repository;

	@Override
	public List<ProductInfo> findUpAll() {
		return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public List<ProductInfo> findList(List<String> productIdList) {
		return repository.findByProductIdIn(productIdList);
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO: cartDTOList) {
			Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
			//判断商品是否存在
			if (!productInfoOptional.isPresent()) {
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			
			ProductInfo productInfo = productInfoOptional.get();
			//库存是否足够
			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if(result < 0) {
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			
			productInfo.setProductStock(result);
			repository.save(productInfo);
		}
	}

}
