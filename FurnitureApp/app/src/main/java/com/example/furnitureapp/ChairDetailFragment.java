package com.example.furnitureapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ChairDetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static ChairData view;

    public static ChairDetailFragment newInstance(ChairData v) {
        ChairDetailFragment fragment = new ChairDetailFragment();
        view=v;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chair_detail, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView=view.findViewById(R.id.chair_detail_imageView);
        //imageView.setImageResource(view.getChair_img());
    }
}