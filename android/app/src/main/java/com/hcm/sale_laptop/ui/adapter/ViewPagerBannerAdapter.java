package com.hcm.sale_laptop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hcm.base.BaseAdapter;
import com.hcm.base.OnItemClick;
import com.hcm.sale_laptop.databinding.ItemBannerBinding;
import com.hcm.sale_laptop.utils.AppUtils;

import java.util.List;

public class ViewPagerBannerAdapter extends BaseAdapter<String, ItemBannerBinding> {

    public ViewPagerBannerAdapter(List<String> itemList, OnItemClick<String> listener) {
        super(itemList, listener);
    }

    @Override
    protected ItemBannerBinding createBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemBannerBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bindData(String item, ItemBannerBinding binding, int position) {
        AppUtils.loadImageUrl(binding.imageViewBanner, item);
    }
}

