package com.hcm.sale_laptop.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.hcm.base.BaseFragment;
import com.hcm.base.BaseViewModel;
import com.hcm.sale_laptop.R;
import com.hcm.sale_laptop.data.model.other.ProductModel;
import com.hcm.sale_laptop.databinding.FragmentShoppingCartBinding;
import com.hcm.sale_laptop.ui.adapter.ShoppingCartAdapter;
import com.hcm.sale_laptop.utils.AppUtils;
import com.hcm.sale_laptop.utils.CartManager;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFragment extends BaseFragment<BaseViewModel<?>, FragmentShoppingCartBinding> implements ShoppingCartAdapter.OnValueChanged {

    private final List<String> listProductId = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentShoppingCartBinding.inflate(inflater, container, false);
        setup();
        return mBinding.getRoot();
    }

    @Override
    protected void setupUI() {
        final ShoppingCartAdapter adapter = new ShoppingCartAdapter(CartManager.getOrderList(), null);
        mBinding.rvProductCart.setAdapter(adapter);
        adapter.setOnValueChanged(this);
        loadTotalAmount();
    }

    private void loadTotalAmount() {
        double totalAmount = 0;
        for (ProductModel item : CartManager.getOrderList()) {
            final double value = item.getTotalAmount();
            if (value == 0) {
                totalAmount += item.getPrice();
            } else {
                totalAmount += value;
            }
        }
        onTotalAmountChanged(totalAmount);
    }

    @Override
    protected void setupAction() {
        setOnClickListener(mBinding.btnBackArrow, view -> onBack());
        setOnClickListener(mBinding.btnPay, view -> {
            addFragment(new PaymentsFragment(), R.id.fragment_container, true);
        });
        setOnClickListener(mBinding.btnRemoveCart, view -> {
            if (!AppUtils.checkListHasData(listProductId)) {
                showToast("Bạn chưa chọn sản phẩm nào để xóa khỏi giỏ hàng");
                return;
            }
            showDialogWarning();
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void showDialogWarning() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có chắc chắn muốn xóa các sản phẩm vừa chọn ra khỏi giỏ hàng.");

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());
        builder.setPositiveButton("OK", (dialog, which) -> {
            for (String id : listProductId) {
                CartManager.removeProduct(id);
            }
            listProductId.clear();
            loadTotalAmount();
            final ShoppingCartAdapter adapter = (ShoppingCartAdapter) mBinding.rvProductCart.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            showToast("Đã xóa thành công");
            dialog.dismiss();
        });

        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void setupData() {

    }

    @Override
    protected int getLayoutResourceId() {
        return mBinding.getRoot().getId();
    }

    @Override
    public void onTotalAmountChanged(double totalAmount) {
        final SpannableString price = AppUtils.customPrice(totalAmount);
        mBinding.txtMoney.setText(price);
    }

    @Override
    public void onCheckBoxChanged(boolean isCheck, String id) {
        if (isCheck) {
            listProductId.add(id);
        } else {
            listProductId.removeIf(productId -> productId.equalsIgnoreCase(id));
        }
    }
}
