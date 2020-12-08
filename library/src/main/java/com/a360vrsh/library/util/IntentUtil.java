package com.a360vrsh.library.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * @author: wxj
 * @date: 2020/11/19
 * @description:
 */
public class IntentUtil {
    public static void callPhone(Context context, final String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) return;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private static Intent getIntent(final Intent intent, final boolean isNewTask) {
        return isNewTask ? intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) : intent;
    }

    public static void startUri(Context context, final String uriString) {
        if (TextUtils.isEmpty(uriString)) return;
        Uri content_url = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW, content_url);
        context.startActivity(intent);
    }
}
