package com.adl.service.callback;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.MainThread;
import lombok.Getter;
import lombok.Setter;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/1
 * Describe   : 请求回答
 */
public abstract class RequestLoadingCallback<T> implements RequestCallback<T> {

    private Context mContext;
    private String mHintText;
    private boolean mShowLoading;
    private boolean mShowError;
    private LoadingDialog mDialog;

    public RequestLoadingCallback() {
        this(null);
    }

    public RequestLoadingCallback(Context context) {
        this.mContext = context;
        this.mHintText = "加载中...";
        showErrorText(true);
    }

    public Context getContext() {
        return mContext;
    }

    public RequestLoadingCallback showDialog(boolean show) {
        mShowLoading = show;
        return this;
    }

    public boolean isShowDialog() {
        return mShowLoading;
    }

    public RequestLoadingCallback showErrorText(boolean show) {
        mShowError = show;
        return this;
    }

    public boolean isShowErrorText() {
        return mShowError;
    }

    public RequestLoadingCallback setLoadingText(String text) {
        mHintText = text;
        return this;
    }

    public String getLoadingText() {
        return mHintText;
    }

    public void start() {
        try {
            if (mShowLoading && mDialog == null && (mContext instanceof Activity)) {
                mDialog = new LoadingDialog(mContext);
                mDialog.showText(mHintText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void end() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
        mContext = null;
    }

    private void showError(String error) {
        if (mShowError && !TextUtils.isEmpty(error) && mContext != null) {
            Toast.makeText(mContext, error, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    @MainThread
    public void onSuccess(T data) {
        success(data);
    }

    @Override
    @MainThread
    public void onError(String error) {
        showError(error);
        error(error);
    }

    @Override
    @MainThread
    public void onFail(int code, String msg) {
        showError(msg);
        error(msg);
    }

    public abstract void success(T data);
    public abstract void error(String error);
}
