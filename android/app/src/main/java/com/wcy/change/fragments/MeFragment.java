package com.wcy.change.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wcy.change.AccountActivity;
import com.wcy.change.FeedBackActivity;
import com.wcy.change.ImageActivity;
import com.wcy.change.R;
import com.wcy.change.dao.UserDao;
import com.wcy.change.dao.UserGoalDao;
import com.wcy.change.dao.daoImpl.UserDaoImpl;
import com.wcy.change.dao.daoImpl.UserGoalDaoImpl;
import com.wcy.change.pojo.User;
import com.wcy.change.pojo.UserGoal;

import java.util.List;

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
        TextView name=getView().findViewById(R.id.user_name);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("change",Context.MODE_PRIVATE);
        UserDao userDao=new UserDaoImpl();
        final User user=userDao.getUser(sharedPreferences.getString("userID",""));
        name.setText(user.getName());

        RequestOptions options = RequestOptions.bitmapTransform(new MultiTransformation<>(new CenterCrop(), new BlurTransformation(30)));
        Glide.with(this).load(R.drawable.icon)
                .apply(options)
                .into(imageView1);
        Glide.with(this).load(R.drawable.icon)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView2);

        final TextView manageAccount=getView().findViewById(R.id.account_manage);
        final TextView aboutUs=getView().findViewById(R.id.about_us);
        final TextView story=getView().findViewById(R.id.me_story);
        final TextView cache=getView().findViewById(R.id.cache);
        final TextView feedback=getView().findViewById(R.id.fb_feedback);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FeedBackActivity.class);
                startActivity(intent);
            }
        });

        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserGoalDao userGoalDao=new UserGoalDaoImpl();
                List<UserGoal>  userGoals=userGoalDao.findAllGoal(user.getUserid());
                int count=0;
                for(UserGoal ug:userGoals){
                    count=ug.getContinuation()>count?ug.getContinuation():count;
                }
                int index=count/15>10?10:count/15;

                Intent intent=new Intent(getActivity(),ImageActivity.class);
                Context ctx=getActivity().getBaseContext();
                int resId = getResources().getIdentifier("index"+index, "drawable" , ctx.getPackageName());

                intent.putExtra("ImageIndex",String.valueOf(resId));
                startActivity(intent);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ImageActivity.class);
                intent.putExtra("ImageIndex",R.drawable.aboutus+"");
                startActivity(intent);
            }
        });

        manageAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AccountActivity.class);
                startActivity(intent);
            }
        });

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
