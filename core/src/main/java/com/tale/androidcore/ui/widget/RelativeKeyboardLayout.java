package com.tale.androidcore.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import timber.log.Timber;

/**
 * Created by tale on 5/7/15.
 */
public class RelativeKeyboardLayout extends RelativeLayout {

    private static final int ASSUME_KEYBOARD_HEIGHT = 100;
    private KeyboardEventListener keyboardEventListener;

    public RelativeKeyboardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setKeyboardEventListener(
            KeyboardEventListener keyboardEventListener) {
        this.keyboardEventListener = keyboardEventListener;
    }

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Timber.d("onSizeChanged => {w=%d, h=%d, oldw=%d, oldh=%d}", w, h, oldw, oldh);
        if (keyboardEventListener != null && oldh != 0) {
            final int diff = h - oldh;
            if (Math.abs(diff) > ASSUME_KEYBOARD_HEIGHT) {
                final boolean show = diff < 0;
                Timber.d("onKeyboardShow: %s", show);
                keyboardEventListener.onChanged(show);
            }
        }
    }

    public interface KeyboardEventListener {

        void onChanged(boolean show);

    }
}
