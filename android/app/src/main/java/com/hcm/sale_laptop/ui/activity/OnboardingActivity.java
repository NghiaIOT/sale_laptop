package com.hcm.sale_laptop.ui.activity;

import android.os.Bundle;

import androidx.viewpager2.widget.ViewPager2;

import com.hcm.base.BaseActivity;
import com.hcm.base.BaseRepository;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.data.local.prefs.KeyPref;
import com.hcm.sale_laptop.data.local.prefs.SharedPrefManager;
import com.hcm.sale_laptop.data.model.other.OnboardingModel;
import com.hcm.sale_laptop.databinding.ActivityOnboardingBinding;
import com.hcm.sale_laptop.ui.adapter.ViewPagerOnboardingAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OnboardingActivity extends BaseActivity<BaseViewModel<BaseRepository>, ActivityOnboardingBinding> {

    private int mPageIndex = 0;
    private int mItemCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setup();
    }

    @Override
    protected void setupUI() {
        final List<OnboardingModel> list = new ArrayList<OnboardingModel>() {{
            add(new OnboardingModel("Chào mừng bạn đến với cửa hàng của chúng tôi", R.drawable.ic_welcome));
            add(new OnboardingModel("Giao hàng nhanh", R.drawable.ic_fast_delivery));
            add(new OnboardingModel("Hàng chất lượng", R.drawable.ic_quality_goods));
        }};

        mBinding.vp.setAdapter(new ViewPagerOnboardingAdapter(list, null));
        mItemCount = Objects.requireNonNull(mBinding.vp.getAdapter()).getItemCount();
        mPageIndex = mBinding.vp.getCurrentItem();
        mBinding.wormDotsIndicator.attachTo(mBinding.vp);
    }

    @Override
    protected void setupAction() {
        setOnClickListener(mBinding.btnNext, view -> {
            mPageIndex += 1;
            if (mPageIndex >= mItemCount) {
                mPageIndex = mItemCount - 1;
                handlerNext();
                return;
            }
            mBinding.vp.setCurrentItem(mPageIndex, true);
        });

        setOnClickListener(mBinding.btnPrevious, view -> {
            mPageIndex -= 1;
            if (mPageIndex < 0) {
                mPageIndex = 0;
                return;
            }
            mBinding.vp.setCurrentItem(mPageIndex, true);
        });

        setOnClickListener(mBinding.txtSkip, view -> handlerNext());
        mBinding.vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mPageIndex = position;
            }
        });
    }

    private void handlerNext() {
        SharedPrefManager.getInstance(this).saveBoolean(KeyPref.KEY_ONBOARDING_COMPLETED, true);
        navigateTo(MainActivity.class);
        finishActivity();
    }

    @Override
    protected void setupData() {

    }

}