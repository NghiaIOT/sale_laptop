package com.hcm.sale_laptop.ui.fragment.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.hcm.base.BaseFragment;
import com.hcm.sale_laptop.data.model.other.OrderStateModel;
import com.hcm.sale_laptop.databinding.FragmentAdminRequestCancelOrderBinding;
import com.hcm.sale_laptop.ui.adapter.RequestCancelOrderAdapter;
import com.hcm.sale_laptop.ui.viewmodel.AdminRequestCancelOrderViewModel;
import com.hcm.sale_laptop.utils.AppUtils;

import java.util.ArrayList;


public class AdminRequestCancelOrderFragment extends BaseFragment<AdminRequestCancelOrderViewModel, FragmentAdminRequestCancelOrderBinding> {

    private OrderStateModel orderStateModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentAdminRequestCancelOrderBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {

        final RequestCancelOrderAdapter adapter = new RequestCancelOrderAdapter(new ArrayList<>(), null);
        mBinding.recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setupAction() {

    }

    @Override
    protected void setupData() {
        mViewModel = new AdminRequestCancelOrderViewModel();

        mViewModel.getDataOrdersCancel();

        mViewModel.errorMessage.observe(this, this::showToast);

        mViewModel.isLoading.observe(this, isLoading -> {
            if (isLoading) {
                showProgressBar();
            } else {
                hideProgressBar();
            }
        });

        mViewModel.getOrderData().observe(this, orderStateModels -> {
            final RequestCancelOrderAdapter adapter = (RequestCancelOrderAdapter) mBinding.recyclerView.getAdapter();
            if (adapter != null && AppUtils.checkListHasData(orderStateModels)) {
                adapter.setItems(orderStateModels);
            }
        });

        mViewModel.getIsConfirmOrderSuccess().observe(this, isSuccess -> {
            if (isSuccess) {
                final RequestCancelOrderAdapter adapter = (RequestCancelOrderAdapter) mBinding.recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.handlerRemoveItem(orderStateModel.getPosition());
                    orderStateModel = null;
                }
                showToast("Hủy đơn hàng thành công");
            } else {
                showToast("Hủy đơn hàng thất bại");
            }
        });

    }
}