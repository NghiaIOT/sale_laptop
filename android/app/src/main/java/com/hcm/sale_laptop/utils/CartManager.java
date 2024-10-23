package com.hcm.sale_laptop.utils;

import com.hcm.sale_laptop.data.model.other.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartManager {

    private static List<ProductModel> orderList = new ArrayList<>();

    public static List<ProductModel> getOrderList() {
        return orderList;
    }

    public static void clearOrderList() {
        orderList.clear();
    }

    public static void addProduct(ProductModel model) {
        if (model != null) orderList.add(model);
    }

    public static void addProducts(List<ProductModel> list) {
        if (AppUtils.checkListHasData(list)) orderList.addAll(list);
    }

    public static boolean removeProduct(String id) {
        return orderList.removeIf(model -> model.getId().equalsIgnoreCase(id));
    }

    public static boolean removeProduct(ProductModel productModel) {
        return orderList.removeIf(model -> model.equals(productModel));
    }

    public static ProductModel findById(String id) {
        final Optional<ProductModel> result = orderList.stream().filter(model -> model.getId().equalsIgnoreCase(id)).findFirst();
        return result.orElse(null);
    }
}
