package com.hcm.sale_laptop.ui.fragment.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentConfirmOrderSouldsBinding;
import com.hcm.sale_laptop.ui.adapter.AdminCancelOderAdapter;

import java.util.ArrayList;

public class CancelOderFragment extends BaseFragment<BaseViewModel<?>, FragmentConfirmOrderSouldsBinding> {


    AdminCancelOderAdapter confirmOderAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentConfirmOrderSouldsBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        ArrayList arrayList =  new ArrayList<>();
        ProductModel model = new ProductModel("id", "category_id", "title", "slug", "picture", "summary", "description", 100, "created_by" );
        arrayList.add(model);
        arrayList.add(model);

        confirmOderAdapter = new AdminCancelOderAdapter(arrayList, this::onClickDiscountedProduct);
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected int getLayoutResourceId() {
        return 0;
    }
}