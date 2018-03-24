package com.shakespace.template.base;

import android.view.View;

/**
 * Created by shakespace on 2018/3/22.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void initViews(View view);
}
