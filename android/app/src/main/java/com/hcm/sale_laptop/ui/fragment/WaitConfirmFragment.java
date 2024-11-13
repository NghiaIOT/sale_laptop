package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.hcm.base.BaseFragment;
import com.hcm.sale_laptop.data.enums.OrderStatus;
import com.hcm.sale_laptop.databinding.FragmentWaitConfirmBinding;
import com.hcm.sale_laptop.ui.adapter.OrderStateAdapter;
import com.hcm.sale_laptop.ui.viewmodel.OrderViewModel;
import com.hcm.sale_laptop.utils.AppUtils;

import java.util.ArrayList;

public class WaitConfirmFragment extends BaseFragment<OrderViewModel, FragmentWaitConfirmBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentWaitConfirmBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        final OrderStateAdapter adapter = new OrderStateAdapter(new ArrayList<>(), null, OrderStatus.PENDING_CONFIRMATION);
        mBinding.recyclerView.setAdapter(adapter);

    }

    @Override
    protected void setupAction() {
    }

    @Override
    protected void setupData() {
        mViewModel = new OrderViewModel();

        mViewModel.getOrderAll();

        mViewModel.errorMessage.observe(this, this::showToast);

        mViewModel.isLoading.observe(this, isLoading -> {
            if (isLoading) {
                showProgressBar();
            } else {
                hideProgressBar();
            }
        });

        mViewModel.getOrderData().observe(this, orderStateModels -> {
            final OrderStateAdapter adapter = (OrderStateAdapter) mBinding.recyclerView.getAdapter();
            if (adapter != null && AppUtils.checkListHasData(orderStateModels)) {
                adapter.setItems(orderStateModels);
            }
        });

    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
