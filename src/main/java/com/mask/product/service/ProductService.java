package com.mask.product.service;

import java.util.List;

import com.mask.product.dataobject.ProductInfo;

public interface ProductService {
	
	/**
	 * 查询所有在架的商品列表
	 * @return
	 */
	List<ProductInfo> findUpAll();
}
