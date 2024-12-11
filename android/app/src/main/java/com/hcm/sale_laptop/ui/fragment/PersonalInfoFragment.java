package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.data.model.other.UserModel;
import com.hcm.sale_laptop.databinding.FragmentPersonalInformationBinding;
import com.hcm.sale_laptop.ui.viewmodel.MainActivityViewModel;
import com.hcm.sale_laptop.utils.Constants;

public class PersonalInfoFragment extends BaseFragment<BaseViewModel<?>, FragmentPersonalInformationBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentPersonalInformationBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        hideOrShowBottomNavi(false);
        final UserModel user = Constants.getUserModel();

        mBinding.edtAccountName.setText(user.getName());
        mBinding.edtPhoneNumber.setText(user.getPhoneNumber());
        mBinding.edtGender.setText(user.getBio());
        mBinding.edtDateOfBirth.setText(user.getCreated_at());
    }

    @Override
    protected void setupAction() {
        setOnClickListener(mBinding.btnBackArrow, view -> onBack());
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideOrShowBottomNavi(true);
    }

    private void hideOrShowBottomNavi(boolean isShow) {
        final MainActivityViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        mainViewModel.setBottomNavVisibility(isShow);
    }
}
