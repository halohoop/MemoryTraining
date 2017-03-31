package com.halohoop.memorytraining.managers;

import android.app.Application;
import android.content.Context;

/**
 * Created by Pooholah on 2017/3/31.
 */

public class MainApplicaton extends Application {
    public static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;
    }
}
