package com.hcm.sale_laptop.ui.fragment.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentAdminRequestCancelOrderBinding;
import com.hcm.sale_laptop.ui.adapter.AdminCancelOderAdapter;

import java.util.ArrayList;

public class AdminRequestCancelOrderFragment extends BaseFragment<BaseViewModel<?>, FragmentAdminRequestCancelOrderBinding> {

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
        final ArrayList<ProductModel> arrayList = new ArrayList<>();
        final ProductModel model = new ProductModel("id", "category_id", "title", "slug", "picture", "summary", "description", 100, "created_by", 43, 54);
        arrayList.add(model);
        arrayList.add(model);

        final AdminCancelOderAdapter confirmOderAdapter = new AdminCancelOderAdapter(arrayList, this::onClickDiscountedProduct);
        mBinding.recyclerView.setAdapter(confirmOderAdapter);
        confirmOderAdapter.setItems(arrayList);
    }

    @Override
    protected void setupAction() {

    }

    private void onClickDiscountedProduct(ProductModel object) {

    }

    @Override
    protected void setupData() {

    }
}