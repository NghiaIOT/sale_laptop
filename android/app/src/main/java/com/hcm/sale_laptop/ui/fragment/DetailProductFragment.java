package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentProductDetailBinding;
import com.hcm.sale_laptop.ui.viewmodel.MainActivityViewModel;
import com.hcm.sale_laptop.utils.CartManager;
import com.hcm.sale_laptop.utils.Constants;

public class DetailProductFragment extends BaseFragment<BaseViewModel<?>, FragmentProductDetailBinding> {

    ProductModel productModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentProductDetailBinding.inflate(inflater, container, false);
        final MainActivityViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        mainViewModel.setBottomNavVisibility(false);

        final Bundle bundle = getArguments();
        if (bundle == null) return mBinding.getRoot();
        final ProductModel productModel = bundle.getParcelable(Constants.KEY_PRODUCT_MODEL);
        if (productModel == null) return mBinding.getRoot();
        this.productModel = productModel;
        mBinding.txtProductName.setText(productModel.getTitle());
        mBinding.btnAddCart.setActivated(true);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected void setupAction() {
        setOnClickListener(mBinding.btnBackArrow, view -> onBack());
        setOnClickListener(mBinding.btnAddCart, view -> {
            CartManager.addProduct(productModel);
            showToast("Đã thêm sản phẩm " + productModel.getTitle() + " vào giỏ hàng");
        });
        backToStack();
    }

    @Override
    protected void setupData() {

    }

    private void backToStack() {
        setOnClickListener(mBinding.btnBackArrow, view -> {
            onBack();
        });
    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final MainActivityViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        mainViewModel.setBottomNavVisibility(true);
    }
}
