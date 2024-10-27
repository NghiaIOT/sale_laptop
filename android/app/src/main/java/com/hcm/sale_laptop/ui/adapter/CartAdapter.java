package com.hcm.sale_laptop.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.ItemCartBinding;
import com.hcm.sale_laptop.utils.AppUtils;

import java.util.List;

public class CartAdapter extends BaseAdapter<ProductModel, ItemCartBinding> {

    public CartAdapter(List<ProductModel> itemList, OnItemClick<ProductModel> listener) {
        super(itemList, listener);
    }

    @Override
    protected ItemCartBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        final ItemCartBinding binding = ItemCartBinding.inflate(inflater, parent, false);

        return binding;
    }

    @Override
    protected void bindData(ProductModel model, ItemCartBinding binding, int position) {
        binding.txtProductName.setText(model.getTitle());
        binding.txtPrice.setText(AppUtils.customPrice(model.getPrice()));
        final String quantityString;
        if (model.getOrderNumber() < 10) {
            quantityString = "0" + model.getOrderNumber();
        } else {
            quantityString = String.valueOf(model.getOrderNumber());
        }
        binding.txtValueQuantity.setText(quantityString);

        // action
        handlerAction(binding, position, model);

    }

    @SuppressLint("NotifyDataSetChanged")
    private void handlerAction(ItemCartBinding binding, int position, ProductModel model) {
        binding.btnMinus.setOnClickListener(view -> {
            if (model.getOrderNumber() <= 1) return;
            model.setOrderNumber(model.getOrderNumber() - 1);
            notifyItemChanged(position);
        });
        binding.btnPlus.setOnClickListener(view -> {
            model.setOrderNumber(model.getOrderNumber() + 1);
            notifyItemChanged(position);
        });

        binding.checkbox.setOnCheckedChangeListener((compoundButton, isChecked) -> {

        });
    }
}
