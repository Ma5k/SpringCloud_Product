package com.mask.product.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mask.product.ProductApplicationTests;
import com.mask.product.dataobject.ProductInfo;
import com.mask.product.dto.CartDTO;

@Component
public class ProductServiceTest extends ProductApplicationTests{

	@Autowired
	private ProductService productService;
	
	@Test
	public void testFindUpAll() throws Exception{
		List<ProductInfo> list = productService.findUpAll();
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void findList() throws Exception {
		List<ProductInfo> list = productService.findList(Arrays.asList("157875196366160022","157875196366160022","157875196366160022"));
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void decreaseStock() throws Exception { 
		CartDTO cartDTO = new CartDTO("157875196366160022", 2);
		productService.decreaseStock(Arrays.asList(cartDTO));
	}
}
