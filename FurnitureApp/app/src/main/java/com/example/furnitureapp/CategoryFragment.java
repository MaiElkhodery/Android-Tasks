package com.example.furnitureapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    RecyclerView recyclerView;
    CategoryAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<CategoryData> dataList=new ArrayList<>();
        dataList.add(new CategoryData("Tables",R.drawable.splashscreen));
        dataList.add(new CategoryData("Sofas",R.drawable.sofa));
        dataList.add(new CategoryData("Chairs",R.drawable.chair2));
        dataList.add(new CategoryData("Beds",R.drawable.bed));
        dataList.add(new CategoryData("Lampshades",R.drawable.lamp));
        dataList.add(new CategoryData("Bookcases",R.drawable.bookcase));

        recyclerView= view.findViewById(R.id.category_recyclerView);
        adapter=new CategoryAdapter(dataList,getContext());
        recyclerView.setAdapter(adapter);
        layoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);


    }

}