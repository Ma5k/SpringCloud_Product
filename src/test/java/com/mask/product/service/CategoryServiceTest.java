package com.mask.product.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mask.product.ProductApplicationTests;
import com.mask.product.dataobject.ProductCategory;

@Component
public class CategoryServiceTest extends ProductApplicationTests {
	
	@Autowired
	private CategoryService service;

	@Test
	public void testFindByCategoryTypeIn() throws Exception{
		List<ProductCategory> list = service.findByCategoryTypeIn(Arrays.asList(11,12));
		Assert.assertTrue(list.size() > 0);
	}

}
