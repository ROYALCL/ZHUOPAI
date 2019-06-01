package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private LinearLayout ucenterLinearLayout;
    private ImageView blurImageView;
    private ImageView avatarImageView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    String[] data1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data1);
                    listView.setAdapter(adapter1);
                    ucenterLinearLayout.setVisibility(View.INVISIBLE);
                    listView.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
                    listView.setAdapter(adapter);
                    ucenterLinearLayout.setVisibility(View.INVISIBLE);
                    listView.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    listView.setVisibility(View.GONE);
                    ucenterLinearLayout.setVisibility(View.VISIBLE);

                    //个人中心头像和背景绘图
                    Glide.with(MainActivity.this).load(R.drawable.head)
                            .bitmapTransform(new BlurTransformation(MainActivity.this, 25), new CenterCrop(MainActivity.this))
                            .into(blurImageView);
                    Glide.with(MainActivity.this).load(R.drawable.head)
                            .bitmapTransform(new CropCircleTransformation(MainActivity.this))
                            .into(avatarImageView);

                    return true;
            }
            return false;
        }
    };

    public void TextViewOnClick(View view) {
        Intent intent = null;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("确定吗？");
        alertDialog.setPositiveButton("是", null);
        alertDialog.setNegativeButton("否", null);
        switch (view.getId()) {
            case R.id.chagepasswd:
                alertDialog.setTitle(getResources().getString(R.string.chage_passwd));
                break;
            case R.id.clean_cache:
                alertDialog.setTitle(getResources().getString(R.string.clean_cache));
                break;
            case R.id.about:
                alertDialog.setTitle(getResources().getString(R.string.about));
                break;
            case R.id.version_update:
                alertDialog.setTitle(getResources().getString(R.string.version_update));
                break;
            case R.id.lagout:
                alertDialog.setTitle(getResources().getString(R.string.lagout));
                break;
        }
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        listView = findViewById(R.id.list_view);
        ucenterLinearLayout = findViewById(R.id.ucenter);
        blurImageView = findViewById(R.id.iv_blur);
        avatarImageView = findViewById(R.id.iv_avatar);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
