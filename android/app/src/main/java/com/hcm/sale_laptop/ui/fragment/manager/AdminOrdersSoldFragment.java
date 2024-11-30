package com.hcm.sale_laptop.ui.fragment.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentOrderSouldsBinding;
import com.hcm.sale_laptop.ui.adapter.AdminOrderSoldAdapter;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminOrdersSoldFragment} factory method to
 * create an instance of this fragment.
 */
public class AdminOrdersSoldFragment extends BaseFragment<BaseViewModel<?>, FragmentOrderSouldsBinding> {

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
        final ArrayList<ProductModel> arrayList = new ArrayList<>();
        final ProductModel model = new ProductModel("id", "category_id", "title", "slug", "picture", "summary", "description", 100, "created_by", 43, 45);
        arrayList.add(model);
        arrayList.add(model);

        final AdminOrderSoldAdapter confirmOderAdapter = new AdminOrderSoldAdapter(arrayList, this::onClickDiscountedProduct);
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