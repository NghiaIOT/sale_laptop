package com.hcm.sale_laptop.data.model.other;

import java.util.List;

public class ProductSaleObject {
    private List<ProductSaleModel> product;

    public ProductSaleObject(List<ProductSaleModel> productModels) {
        this.product = productModels;
    }

    public List<ProductSaleModel> getProductModels() {
        return product;
    }

    public void setProductModels(List<ProductSaleModel> productModels) {
        this.product = productModels;
    }
}
