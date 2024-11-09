package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentConfirmOrderSouldsBinding;
import com.hcm.sale_laptop.databinding.FragmentOrderSouldsBinding;
import com.hcm.sale_laptop.ui.adapter.AdminCancelOderAdapter;
import com.hcm.sale_laptop.ui.adapter.AdminConfirmOderAdapter;
import com.hcm.sale_laptop.ui.adapter.AdminOderSoldAdapter;
import com.hcm.sale_laptop.ui.adapter.AdminRateAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminOrdersSoldFragment} factory method to
 * create an instance of this fragment.
 */
public class AdminOrdersSoldFragment extends BaseFragment<BaseViewModel<?>, FragmentOrderSouldsBinding> {


    AdminOderSoldAdapter confirmOderAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentOrderSouldsBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        ArrayList arrayList = new ArrayList<>();
        ProductModel model = new ProductModel("id", "category_id", "title", "slug", "picture", "summary", "description", 100, "created_by");
        arrayList.add(model);
        arrayList.add(model);

        confirmOderAdapter = new AdminOderSoldAdapter(arrayList, this::onClickDiscountedProduct);
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