package com.example.furnitureapp;


import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder>{

    ArrayList<CategoryData> categoryDataList;
    Context context;
    static MediaPlayer audio;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_design,parent,false);
        return new Holder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        CategoryData currentItem = categoryDataList.get(position);
        holder.categoryTextView.setText(currentItem.getCategory_name());
        holder.categoryImageView.setImageResource(currentItem.getCategory_img());
    }

    @Override
    public int getItemCount() {
        return categoryDataList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder implements com.example.furnitureapp.Holder {
        ImageView categoryImageView;
        TextView categoryTextView;
        public Holder(View view,Context context){
            super(view);
            categoryTextView=view.findViewById(R.id.category_textView);
            categoryImageView=view.findViewById(R.id.category_imageView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    audio = MediaPlayer.create(context.getApplicationContext(), R.raw.click_audio);
                    audio.start();
                    audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            audio.release();
                        }
                    });

                    switch (getAdapterPosition()){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            ChairFragment chairFragment= ChairFragment.newInstance();
                            ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragmentContainer,chairFragment).commit();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
                }
            });
        }

    }

    public CategoryAdapter(ArrayList<CategoryData> categoryDataList,Context context){
        this.categoryDataList=categoryDataList;
        this.context=context;
    }

}



