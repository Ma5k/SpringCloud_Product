package com.mask.product.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mask.product.ProductApplicationTests;
import com.mask.product.dataobject.ProductInfo;

@Component
public class ProductServiceTest extends ProductApplicationTests{

	@Autowired
	private ProductService productService;
	
	@Test
	public void testFindUpAll() throws Exception{
		List<ProductInfo> list = productService.findUpAll();
		Assert.assertTrue(list.size() > 0);
	}

}
