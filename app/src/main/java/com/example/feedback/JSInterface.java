package com.example.feedback;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JSInterface {
    Context mContext;

    public JSInterface(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void goBack(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }
}