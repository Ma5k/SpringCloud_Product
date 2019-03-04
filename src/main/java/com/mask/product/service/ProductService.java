package com.mask.product.service;

import java.util.List;

import com.mask.product.dataobject.ProductInfo;
import com.mask.product.dto.CartDTO;

public interface ProductService {
	
	/**
	 * 查询所有在架的商品列表
	 * @return
	 */
	List<ProductInfo> findUpAll();
	
	/**
	 * 查询商品列表
	 * @param productIdList
	 * @return
	 */
	List<ProductInfo> findList(List<String> productIdList);
	
	/**
	 * 扣库存
	 * @param cartDTOList
	 */
	void decreaseStock(List<CartDTO> cartDTOList);
}
