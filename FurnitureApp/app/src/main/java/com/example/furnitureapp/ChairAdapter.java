package com.example.furnitureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChairAdapter extends RecyclerView.Adapter<ChairAdapter.Holder> {
    ArrayList<ChairData> dataset;
    static Context context;
    ChairData currentItem;
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chairs_data_design,parent,false);
        return new ChairAdapter.Holder(view,currentItem);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        currentItem = dataset.get(position);
        holder.imageView.setImageResource(currentItem.getChair_img());
        holder.textView1.setText(currentItem.getChair_name());
        holder.textView2.setText(currentItem.getChair_price());

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public Holder(@NonNull View itemView,ChairData currentItem) {
            super(itemView);
            imageView=itemView.findViewById(R.id.chair_imageView);
            textView1=itemView.findViewById(R.id.chair_textView1);
            textView2=itemView.findViewById(R.id.chair_textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChairDetailFragment chairDetailFragment=ChairDetailFragment.newInstance(currentItem);
                    ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer,chairDetailFragment).commit();
                }
            });
        }

        public TextView getTextView1() {
            return textView1;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView2() {
            return textView2;
        }
    }

    public ChairAdapter(ArrayList<ChairData> dataset,Context context){
        this.dataset=dataset;
        this.context=context;
    }
}
