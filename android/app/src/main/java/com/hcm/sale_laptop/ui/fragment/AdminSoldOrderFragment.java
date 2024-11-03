package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.databinding.FragmentPaymentsBinding;

public class AdminSoldOrderFragment extends BaseFragment<BaseViewModel<?>, FragmentPaymentsBinding> {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentPaymentsBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected void setupAction() {

    }

    @Override
    protected void setupData() {

    }

    @Override
    protected int getLayoutResourceId() {
        return 0;
    }
}
