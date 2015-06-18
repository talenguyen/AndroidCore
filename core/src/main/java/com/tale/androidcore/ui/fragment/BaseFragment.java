/*
 * Copyright (c) 2014 Giang Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tale.androidcore.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.tale.androidcore.BaseApp;

/**
 * Created by tale on 11/8/14.
 */
public class BaseFragment extends Fragment {

    private String tag;

    public BaseFragment() {
        tag = getClass().getSimpleName();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "onCreate");
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onResume() {
        Log.d(tag, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(tag, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(tag, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(tag, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "onDestroy");
        super.onDestroy();
        BaseApp.getRefWatcher(getActivity()).watch(this);
    }

    protected void injectDependencies() {
    }

}
