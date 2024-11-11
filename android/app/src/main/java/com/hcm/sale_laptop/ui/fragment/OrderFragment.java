package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.databinding.FragmentOrderBinding;
import com.hcm.sale_laptop.ui.adapter.ViewPagerStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends BaseFragment<BaseViewModel<?>, FragmentOrderBinding> {
    ViewPagerStateAdapter viewPagerStateAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentOrderBinding.inflate(inflater, container, false);

        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new WaitConfirmFragment());
        fragments.add(new WaitPickupFragment());
        fragments.add(new WaitDeliveryFragment());
        fragments.add(new OrderReviewFragment());

        viewPagerStateAdapter = new ViewPagerStateAdapter(this, fragments);
        mBinding.viewPager.setAdapter(viewPagerStateAdapter);
        mBinding.viewPager.setUserInputEnabled(false);
    }

    @Override
    protected void setupAction() {
        mBinding.tab1.setOnClickListener(view -> updateViewPager(0));
        mBinding.tab2.setOnClickListener(view -> updateViewPager(1));
        mBinding.tab3.setOnClickListener(view -> updateViewPager(2));
        mBinding.tab4.setOnClickListener(view -> updateViewPager(3));
    }

    private void updateViewPager(int tab) {
        final int blackColor = getResources().getColor(R.color.black, null);
        final int redColor = getResources().getColor(com.hcm.base.R.color.red, null);

        mBinding.tvTab1.setTextColor(blackColor);
        mBinding.tvTab2.setTextColor(blackColor);
        mBinding.tvTab3.setTextColor(blackColor);
        mBinding.tvTab4.setTextColor(blackColor);

        switch (tab) {
            case 0:
                mBinding.tvTab1.setTextColor(redColor);
                break;
            case 1:
                mBinding.tvTab2.setTextColor(redColor);
                break;
            case 2:
                mBinding.tvTab3.setTextColor(redColor);
                break;
            case 3:
                mBinding.tvTab4.setTextColor(redColor);
                break;
        }

        mBinding.viewPager.setCurrentItem(tab);
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }
}