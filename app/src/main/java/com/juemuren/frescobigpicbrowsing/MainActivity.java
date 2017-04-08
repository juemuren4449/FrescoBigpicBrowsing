package com.juemuren.frescobigpicbrowsing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    private SimpleDraweeView mImageView;
    private String IMG_URL = "https://juemuren4449.com/uploads/mouse.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mImageView = (SimpleDraweeView) findViewById(R.id.sd_view);
    }

    private void initData() {
        mImageView.setImageURI(IMG_URL);
    }

    private void initEvent() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                intent.putExtra("img_url", IMG_URL);
                startActivity(intent);
            }
        });
    }
}
