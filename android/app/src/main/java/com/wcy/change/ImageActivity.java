package com.wcy.change;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView iv=findViewById(R.id.image_launch);
        Context context = getBaseContext();

        Intent intent=getIntent();
        int id_int =0;
        String storyLevel=intent.getStringExtra("storyLevel");
        String id_string=intent.getStringExtra("ImageIndex");
        if (storyLevel!=null)
            id_int = getResources().getIdentifier("index"+storyLevel, "drawable", context.getPackageName());
        if (id_string!=null)
            id_int=Integer.parseInt(id_string);
        iv.setImageResource(id_int);
    }


}
