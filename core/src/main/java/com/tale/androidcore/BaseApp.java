package com.tale.androidcore;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tale.androidcore.compat.PlatformSpecificImplementationFactory;

/**
 * Created by tale on 3/8/15.
 */
public abstract class BaseApp extends Application {

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        return ((BaseApp) context.getApplicationContext()).refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebug()) {
            // Enable strictMode for development. This will help to keep project in high quality.
            PlatformSpecificImplementationFactory.getStrictMode().enableStrictMode();
        }

        refWatcher = LeakCanary.install(this);
    }

    protected abstract boolean isDebug();

}
