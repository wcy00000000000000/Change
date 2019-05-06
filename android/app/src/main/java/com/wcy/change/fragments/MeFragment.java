package com.wcy.change.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wcy.change.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MeFragment extends Fragment {

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ImageView imageView1 = getView().findViewById(R.id.h_back), imageView2 = getView().findViewById(R.id.h_head);
        RequestOptions options = RequestOptions.bitmapTransform(new MultiTransformation<>(new CenterCrop(), new BlurTransformation(30)));
        Glide.with(this).load(R.drawable.icon)
                .apply(options)
                .into(imageView1);
        Glide.with(this).load(R.drawable.icon)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
