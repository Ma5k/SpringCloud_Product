package com.mask.product.client;

import com.mask.product.common.DecreaseStockInput;
import com.mask.product.common.ProductInfoOutput;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

	@PostMapping("/product/listForOrder")
	List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

	@PostMapping("/product/decreaseStock")
	void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

	@Component
	static class ProductClientFallback implements ProductClient {

		@Override
		public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
			// TODO Auto-generated method stub
		}

		@Override
		public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
