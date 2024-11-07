package com.hcm.sale_laptop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hcm.sale_laptop.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrdersSoldFragment} factory method to
 * create an instance of this fragment.
 */
public class OrdersSoldFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_soulds, container, false);
    }
}