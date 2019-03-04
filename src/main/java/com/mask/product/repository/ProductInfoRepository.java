package com.mask.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mask.product.dataobject.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
	List<ProductInfo> findByProductStatus(Integer productStatus);
	
	List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
