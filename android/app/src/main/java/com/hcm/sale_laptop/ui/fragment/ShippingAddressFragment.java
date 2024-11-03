package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.databinding.FragmentShoppingCartBinding;
import com.hcm.sale_laptop.ui.adapter.ShoppingCartAdapter;
import com.hcm.sale_laptop.utils.CartManager;

public class ShippingAddressFragment extends BaseFragment<BaseViewModel<?>, FragmentShoppingCartBinding> {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentShoppingCartBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        mBinding.rvProductCart.setAdapter(new ShoppingCartAdapter(CartManager.getOrderList(), null));

    }

    @Override
    protected void setupAction() {
        setOnClickListener(mBinding.btnBackArrow, view -> onBack());
        setOnClickListener(mBinding.btnPay, view -> {
            addFragment(new PaymentsFragment(), R.id.fragment_container, true);
        });
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }
}
