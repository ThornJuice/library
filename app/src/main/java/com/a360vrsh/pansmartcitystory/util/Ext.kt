package com.a360vrsh.pansmartcitystory.util

/**
 * @author: wxj
 * @date: 2020/9/11
 * @description:
 */
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.a360vrsh.library.util.ToastUtil


fun Fragment.showToast(content: String? = "NONE") {
    ToastUtil.show(content)
}

fun Context.showToast(content: String? = "NONE") {
    ToastUtil.show(content)
}

fun Context.getContext(): Context {
    return this
}

fun Fragment.gotoActivity(clazz: Class<*>) {
    val intent = Intent(context, clazz)
    startActivity(intent)
}

fun Context.gotoActivity(clazz: Class<*>) {
    val intent = Intent(this, clazz)
    startActivity(intent)
}

fun Fragment.gotoActivity(clazz: Class<*>, bundle: Bundle) {
    val intent = Intent(context, clazz)
    intent.putExtras(bundle)
    startActivity(intent)
}

fun Context.gotoActivity(clazz: Class<*>, bundle: Bundle) {
    val intent = Intent(this, clazz)
    intent.putExtras(bundle)
    startActivity(intent)
}

fun Any?.toStringOrEmpty(): String {
    return this?.toString() ?: ""
}

fun TextView.setTxtColor(context: Context, color: Int) {
    setTextColor(ContextCompat.getColor(context, color))
}

fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setInVisible() {
    this.visibility = View.INVISIBLE
}


