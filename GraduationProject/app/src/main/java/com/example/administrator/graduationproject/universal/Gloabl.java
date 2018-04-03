package com.example.administrator.graduationproject.universal;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2018/4/3.
 */

public class Gloabl {

    private static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context, String title, String message) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(context, title,
                    message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }
        progressDialog.show();
    }

    public static void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
