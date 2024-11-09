package com.hcm.sale_laptop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.ItemEvaluateBinding;
import com.hcm.sale_laptop.databinding.ItemOrderSoldBinding;

import java.util.List;


public class AdminOderSoldAdapter extends BaseAdapter<ProductModel, ItemOrderSoldBinding> {

    public AdminOderSoldAdapter(List<ProductModel> itemList, OnItemClick<ProductModel> listener) {
        super(itemList, listener);
    }

    @Override
    protected ItemOrderSoldBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemOrderSoldBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bindData(ProductModel item, ItemOrderSoldBinding binding, int position) {

    }
}