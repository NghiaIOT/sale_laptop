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
import com.hcm.sale_laptop.databinding.FragmentPurchaseManagerBinding;
import com.hcm.sale_laptop.ui.adapter.ViewPagerStateAdapter;
import com.hcm.sale_laptop.ui.fragment.manager.CancelOderFragment;
import com.hcm.sale_laptop.ui.fragment.manager.ConfirmOderFragment;
import com.hcm.sale_laptop.ui.fragment.manager.RateFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PurchaseManagerFragment} factory method to
 * create an instance of this fragment.
 */
public class PurchaseManagerFragment extends BaseFragment<BaseViewModel<?>, FragmentPurchaseManagerBinding> {

    ViewPagerStateAdapter viewPagerStateAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentPurchaseManagerBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ConfirmOderFragment());
        fragments.add(new CancelOderFragment());
        fragments.add(new RateFragment());

        viewPagerStateAdapter = new ViewPagerStateAdapter(this, fragments);
        mBinding.viewPager.setAdapter(viewPagerStateAdapter);
        mBinding.viewPager.setUserInputEnabled(false);

    }

    @Override
    protected void setupAction() {
        mBinding.tab1.setOnClickListener(view -> {
            updateViewPager(0);
        });
        mBinding.tab2.setOnClickListener(view -> {
            updateViewPager(1);
        });
        mBinding.tab3.setOnClickListener(view -> {
            updateViewPager(2);
        });
    }

    private void updateViewPager(int tab) {
        mBinding.tvTab1.setTextColor(getResources().getColor(R.color.black));
        mBinding.tvTab2.setTextColor(getResources().getColor(R.color.black));
        mBinding.tvTab3.setTextColor(getResources().getColor(R.color.black));
        switch (tab) {
            case 0:
                mBinding.tvTab1.setTextColor(getResources().getColor(com.hcm.base.R.color.red));
                break;
            case 1:
                mBinding.tvTab2.setTextColor(getResources().getColor(com.hcm.base.R.color.red));
                break;
            case 2:
                mBinding.tvTab3.setTextColor(getResources().getColor(com.hcm.base.R.color.red));
                break;
        }
        mBinding.viewPager.setCurrentItem(tab);
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