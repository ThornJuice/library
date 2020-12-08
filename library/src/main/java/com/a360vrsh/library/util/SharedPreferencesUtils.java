package com.a360vrsh.library.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPreferencesUtils {

	private static final String PREFERENCENAME = "cjsj";

	public static void saveParameter(Context context, String name, String string) {
		try {
			SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE);
			Editor editor = mSharedPreferences.edit();
			editor.putString(name, string);
			editor.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void removeParameter(Context context, String name) {
		try {
			SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE);
			Editor editor = mSharedPreferences.edit();
			editor.remove(name);
			editor.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressLint("NewApi") public static void saveListParameter(Context context, String name, List<String> list) {
		try {
			SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE);
			Editor editor = mSharedPreferences.edit();
			Set<String> listSet = new HashSet<String>(list);  
			editor.putStringSet(name, listSet);
			
			editor.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressLint("NewApi") public static List<String> getListParameter(Context context, String name) {
		try {
			SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE);
			Set<String> listSet = new HashSet<String>();
			listSet = mSharedPreferences.getStringSet(name, listSet);
			List<String> setList = new ArrayList<String>(listSet); 
			return setList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getParameter(Context context, String name) {
		try {
			SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE);
			return mSharedPreferences.getString(name, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	 public static void clear(Context context) {
    	 SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE);
    	 Editor editor = mSharedPreferences.edit();
    	 editor.clear();  
         editor.commit(); 
 	}
//	 自建保存list的方法
	 
	 public static String SceneList2String(List SceneList)
	            throws IOException {
	      // 实例化一个ByteArrayOutputStream对象，用来装载压缩后的字节文件。
	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      // 然后将得到的字符数据装载到ObjectOutputStream
	      ObjectOutputStream objectOutputStream = new ObjectOutputStream(
	              byteArrayOutputStream);
	      // writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
	      objectOutputStream.writeObject(SceneList);
	      // 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
	      String SceneListString = new String(Base64.encode(
	              byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
	      // 关闭objectOutputStream
	      objectOutputStream.close();
	      return SceneListString;
	}
	 
	 @SuppressWarnings("unchecked")
	  public static List String2SceneList(String SceneListString)
	          throws StreamCorruptedException, IOException,
	          ClassNotFoundException {
	      byte[] mobileBytes = Base64.decode(SceneListString.getBytes(),
	              Base64.DEFAULT);
	      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
	              mobileBytes);
	      ObjectInputStream objectInputStream = new ObjectInputStream(
	              byteArrayInputStream);
	      List SceneList = (List) objectInputStream
	              .readObject();
	      objectInputStream.close();
	      return SceneList;
	  }
	 
}
