package com.mask.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mask.product.dataobject.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
