package com.softpal.bitmaputilities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.softpal.bitmaputils.BitmapUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{
	private static String TAG = MainActivity.class.getSimpleName();
	private Uri.Builder builder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Uri uri = Uri.parse("file:///storage/emulated/0/com.himangi.imagepreview/ImagesPreview/2545.jpg");
		float imageSize = BitmapUtils.getImgFileSize(uri);
		
		Log.v(TAG,"onCreate imageSize=="+imageSize);
	}
}
