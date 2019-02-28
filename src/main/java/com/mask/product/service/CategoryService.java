package com.mask.product.service;

import java.util.List;

import com.mask.product.dataobject.ProductCategory;

public interface CategoryService {
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	
}
