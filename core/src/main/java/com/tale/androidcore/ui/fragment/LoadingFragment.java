package com.tale.androidcore.ui.fragment;

import android.view.View;

import com.tale.androidcore.ui.view.ViewSwitcher;

/**
 * Created by Larry on 3/31/2015.
 */
public class LoadingFragment extends RxFragment {

    private ViewSwitcher loadingViewSwitcher;

    protected void setupLoading(View mainView, View loadingView) {
        loadingViewSwitcher = new ViewSwitcher();
        loadingViewSwitcher.setMainView(mainView);
        loadingViewSwitcher.setAlterView(loadingView);
    }

    public void setShowLoading(boolean show) {
        loadingViewSwitcher.showMainView(!show);
    }

}
