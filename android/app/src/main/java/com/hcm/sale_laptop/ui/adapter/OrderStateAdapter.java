package com.hcm.sale_laptop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.data.enums.OrderStatus;
import com.hcm.sale_laptop.data.model.other.OrderStateModel;
import com.hcm.sale_laptop.databinding.ItemConfirmOrderBinding;
import com.hcm.sale_laptop.utils.AppUtils;

import java.util.List;

public class OrderStateAdapter extends BaseAdapter<OrderStateModel, ItemConfirmOrderBinding> {

    private final OrderStatus orderStatus;

    public OrderStateAdapter(List<OrderStateModel> itemList, OnItemClick<OrderStateModel> listener, OrderStatus status) {
        super(itemList, listener);
        this.orderStatus = status;
    }

    @Override
    protected ItemConfirmOrderBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemConfirmOrderBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bindData(OrderStateModel item, ItemConfirmOrderBinding binding, int position) {
        binding.tvAddress.setText(item.getAddress());
        binding.tvTrangThai.setText(orderStatus.getDescription());
        binding.tvMaDonHang.setText(item.getId());
        binding.rvProduct.setAdapter(new ItemProductAdapter(item.getProducts(), null));
        binding.tvTongTienHang.setText(AppUtils.customPrice(item.getPrices_order()));
        binding.tvTongTienPhiVanChuyen.setText("");
        binding.tvTongTienThanhToan.setText(AppUtils.customPrice(item.getPrices_order()));
    }
}
