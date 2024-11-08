package com.hcm.sale_laptop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.ItemCancelOrderBinding;
import com.hcm.sale_laptop.databinding.ItemConfirmOrderBinding;

import java.util.List;


public class CancelOderAdapter extends BaseAdapter<ProductModel, ItemCancelOrderBinding> {

    public CancelOderAdapter(List<ProductModel> itemList, OnItemClick<ProductModel> listener) {
        super(itemList, listener);
    }

    @Override
    protected ItemCancelOrderBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemCancelOrderBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bindData(ProductModel item, ItemCancelOrderBinding binding, int position) {

    }
}