package com.hcm.sale_laptop.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hcm.sale_laptop.ui.fragment.manager.CancelOderFragment;
import com.hcm.sale_laptop.ui.fragment.manager.ConfirmOderFragment;
import com.hcm.sale_laptop.ui.fragment.manager.RateFragment;

import java.util.ArrayList;

public class ViewPagerStateAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> arrayList = new ArrayList<>();

    public ViewPagerStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
        arrayList.clear();
        arrayList.add(new ConfirmOderFragment());
        arrayList.add(new CancelOderFragment());
        arrayList.add(new RateFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}