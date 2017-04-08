package com.juemuren.frescobigpicbrowsing;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

public class ImageViewActivity extends Activity {
    private PhotoDraweeView mPhotoDraweeView;
    private String img_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mPhotoDraweeView = (PhotoDraweeView) findViewById(R.id.photoView);
    }

    private void initData() {
        img_url = getIntent().getStringExtra("img_url");
        if (!TextUtils.isEmpty(img_url)) {
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            controller.setUri(img_url);//设置图片url
            controller.setOldController(mPhotoDraweeView.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo == null || mPhotoDraweeView == null) {
                        return;
                    }
                    mPhotoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            });
            mPhotoDraweeView.setController(controller.build());
        } else {
            Toast.makeText(this, "图片获取失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void initEvent() {
        //添加点击事件
        mPhotoDraweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                finish();
            }
        });
    }
}
