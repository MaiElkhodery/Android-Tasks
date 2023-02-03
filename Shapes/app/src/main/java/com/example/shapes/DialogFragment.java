package com.example.shapes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    private final static String ARG_TITLE="title";
    private final static String ARG_MESSAGE="message";
    private final static String ARG_ICON="icon";

    private String title;
    private String message;
    private int icon;

    private OnPositiveButtonClick positiveListener;
    private OnNegativeButtonClick negativeListener;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnPositiveButtonClick){
            positiveListener = (OnPositiveButtonClick) context;
        }
        else
            throw new RuntimeException("Please implement the positive listener");
        if(context instanceof OnNegativeButtonClick){
            negativeListener = (OnNegativeButtonClick) context;
        }
        else
            throw new RuntimeException("Please implement the negative listener");
    }

    public DialogFragment() {
        // Required empty public constructor
    }


    public static DialogFragment newInstance(String title,String message,int icon) {
        DialogFragment fragment = new DialogFragment();
        Bundle args=new Bundle();
        args.putString(ARG_TITLE,title);
        args.putString(ARG_MESSAGE,message);
        args.putInt(ARG_ICON,icon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title=getArguments().getString(ARG_TITLE);
            message=getArguments().getString(ARG_MESSAGE);
            icon=getArguments().getInt(ARG_ICON);

        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setIcon(icon)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        positiveListener.onClickPositiveButton();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        negativeListener.onClickNegativeButton();
                    }
                });
        return dialogBuilder.create();
    }
    public interface OnPositiveButtonClick{
        public void onClickPositiveButton();
    }
    public interface OnNegativeButtonClick{
        public void onClickNegativeButton();
    }
}