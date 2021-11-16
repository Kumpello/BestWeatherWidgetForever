package com.example.bestweatherwidget.Utils;

public interface OnResult<T> {
    void onSuccess(T result);

    void onError(Throwable error);
}
