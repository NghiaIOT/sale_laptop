package com.hcm.sale_laptop.data.model.other;

import android.os.Parcel;

public class ProductSaleModel extends ProductModel {

    private float sales;

    public ProductSaleModel(String id, String category_id, String title, String slug, String picture, String summary, String description, float price, String created_by) {
        super(id, category_id, title, slug, picture, summary, description, price, created_by);
    }

    protected ProductSaleModel(Parcel in) {
        super(in);
    }


    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }
}
