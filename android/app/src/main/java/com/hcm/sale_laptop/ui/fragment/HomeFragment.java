package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.hcm.base.BaseFragment;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.data.model.other.BannerModel;
import com.hcm.sale_laptop.data.model.other.BrandModel;
import com.hcm.sale_laptop.data.model.other.DiscountedProductModel;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentHomeBinding;
import com.hcm.sale_laptop.ui.adapter.BrandAdapter;
import com.hcm.sale_laptop.ui.adapter.DiscountedProductAdapter;
import com.hcm.sale_laptop.ui.adapter.PopularProductAdapter;
import com.hcm.sale_laptop.ui.adapter.ViewPagerBannerAdapter;
import com.hcm.sale_laptop.ui.viewmodel.HomeFragmentViewModel;
import com.hcm.sale_laptop.ui.viewmodel.factory.HomeFragmentViewModelFactory;
import com.hcm.sale_laptop.utils.AppLogger;
import com.hcm.sale_laptop.utils.AppUtils;
import com.hcm.sale_laptop.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomeFragmentViewModel, FragmentHomeBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup();
    }

    @Override
    protected void setupUI() {
        setupRVBrand();
        setupRVDiscountedProduct();
        setupRVPopularProduct();
        setupVPBanner();
    }

    private void setupVPBanner() {
        mBinding.vpBanner.setAdapter(new ViewPagerBannerAdapter(new ArrayList<>(), null));
        mBinding.wormDotsIndicator.attachTo(mBinding.vpBanner);
    }

    private void setupRVPopularProduct() {
        final PopularProductAdapter adapter = new PopularProductAdapter(
                new ArrayList<>(), this::onClickPopularProduct);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        mBinding.rvPopularProduct.setLayoutManager(gridLayoutManager);
        mBinding.rvPopularProduct.setAdapter(adapter);
    }

    private void setupRVDiscountedProduct() {
        final DiscountedProductAdapter adapter = new DiscountedProductAdapter(
                new ArrayList<>(), this::onClickDiscountedProduct);
        mBinding.rvDiscountedProduct.setAdapter(adapter);
    }

    private void setupRVBrand() {
        final BrandAdapter brandAdapter = new BrandAdapter(new ArrayList<>(), this::onClickBrand);
        mBinding.rvBrand.setAdapter(brandAdapter);
    }

    @Override
    protected void setupAction() {

    }

    @Override
    protected void setupData() {
        mViewModel = new ViewModelProvider(this, new HomeFragmentViewModelFactory(requireActivity().getApplication()))
                .get(HomeFragmentViewModel.class);
        mViewModel.fetch();
        mViewModel.errorMessage.observe(this, this::showToast);
        mViewModel.isLoading.observe(this, isLoading -> {
            if (isLoading) {
                showProgressBar();
            } else {
                hideProgressBar();
            }
        });

        mViewModel.getBannerModels().observe(this, bannerModels -> {
            final ViewPagerBannerAdapter adapter = (ViewPagerBannerAdapter) mBinding.vpBanner.getAdapter();
            if (adapter == null || !AppUtils.checkListHasData(bannerModels)) return;

            final List<String> listImageUrl = new ArrayList<>();
            for (final BannerModel model : bannerModels) {
                final String url = model.getPicture();
                if (!AppUtils.stringNullOrEmpty(url)) {
                    listImageUrl.add(url);
                }
            }
            if (AppUtils.checkListHasData(listImageUrl)) {
                adapter.setItems(listImageUrl);
            }
        });

        mViewModel.getBrandModels().observe(this, brandModels -> {
            final BrandAdapter adapter = (BrandAdapter) mBinding.rvBrand.getAdapter();
            if (adapter != null && AppUtils.checkListHasData(brandModels)) {
                adapter.setItems(brandModels);
            }
        });

        mViewModel.getProductModels().observe(this, productModels -> {
            final PopularProductAdapter adapter = (PopularProductAdapter) mBinding.rvPopularProduct.getAdapter();
            if (adapter != null && AppUtils.checkListHasData(productModels)) {
                adapter.setItems(productModels);
            }
        });
    }

    private void onClickPopularProduct(ProductModel object) {
        final DetailProductFragment fragment = new DetailProductFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.KEY_PRODUCT_MODEL, object);
        fragment.setArguments(bundle);
        addFragment(fragment, R.id.fragment_container, true);
    }

    private void onClickDiscountedProduct(DiscountedProductModel object) {
        AppLogger.d("onClickPopularProduct : ", object.getProductName());
    }

    private void onClickBrand(BrandModel object) {
        AppLogger.d("onClickPopularProduct : ", object.getName());
    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }

}