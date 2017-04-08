package com.juemuren.frescobigpicbrowsing;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by juemuren on 2017/4/8.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
