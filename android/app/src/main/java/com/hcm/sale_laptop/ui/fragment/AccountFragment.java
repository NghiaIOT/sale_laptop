package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hcm.base.BaseActivity;
import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.databinding.FragmentAccountBinding;
import com.hcm.sale_laptop.ui.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends BaseFragment<BaseViewModel<?>, FragmentAccountBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentAccountBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected void setupAction() {
        setOnClickListener(mBinding.cvPersonalInfo, view -> {
            addFragment(new PersonalInfoFragment(), R.id.fragment_container, true);
        });

        setOnClickListener(mBinding.cvChangePassword, view -> {
            addFragment(new ChangePasswordFragment(), R.id.fragment_container, true);

        });
        setOnClickListener(mBinding.cvOrderCancelled, view -> {
            addFragment(new OrderCancelledFragment(), R.id.fragment_container, true);

        });
        setOnClickListener(mBinding.cvLogOut, view -> {
            BaseActivity<BaseViewModel<?>, ?> baseActivity = getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            baseActivity.navigateTo(LoginActivity.class);
            baseActivity.finishActivity();
        });
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }
}