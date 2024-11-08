package com.hcm.sale_laptop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.ItemConfirmOrderBinding;
import com.hcm.sale_laptop.databinding.ItemEvaluateBinding;

import java.util.List;


public class RateAdapter extends BaseAdapter<ProductModel, ItemEvaluateBinding> {

    public RateAdapter(List<ProductModel> itemList, OnItemClick<ProductModel> listener) {
        super(itemList, listener);
    }

    @Override
    protected ItemEvaluateBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemEvaluateBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bindData(ProductModel item, ItemEvaluateBinding binding, int position) {

    }
}