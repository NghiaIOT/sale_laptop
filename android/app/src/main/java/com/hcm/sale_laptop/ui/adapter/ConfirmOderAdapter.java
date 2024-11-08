package com.hcm.sale_laptop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.ItemConfirmOrderBinding;

import java.util.List;


public class ConfirmOderAdapter extends BaseAdapter<ProductModel, ItemConfirmOrderBinding> {

    public ConfirmOderAdapter(List<ProductModel> itemList, OnItemClick<ProductModel> listener) {
        super(itemList, listener);
    }

    @Override
    protected ItemConfirmOrderBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemConfirmOrderBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bindData(ProductModel item, ItemConfirmOrderBinding binding, int position) {

    }
}