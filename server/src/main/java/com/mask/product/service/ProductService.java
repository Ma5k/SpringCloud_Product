package com.mask.product.service;

import java.util.List;

import com.mask.product.common.DecreaseStockInput;
import com.mask.product.common.ProductInfoOutput;
import com.mask.product.dataobject.ProductInfo;

public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
