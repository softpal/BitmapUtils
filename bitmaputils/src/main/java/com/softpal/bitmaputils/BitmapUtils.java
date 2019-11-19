package com.softpal.bitmaputils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BitmapUtils
{
	private static final String TAG = BitmapUtils.class.getSimpleName();
	
	// Decodes image and scales it to reduce memory consumption
	public static Bitmap decodeFile(File f)
	{
		try
		{
			// Decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			FileInputStream stream1 = new FileInputStream(f);
			BitmapFactory.decodeStream(stream1,null,o);
			stream1.close();
			// Find the correct scale value. It should be the power of 2.
			// Set width/edt_height of recreated image
			final int REQUIRED_SIZE = 85;
			int width_tmp = o.outWidth, height_tmp = o.outHeight;
			int scale = 1;
			while(true)
			{
				if(width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE)
				{
					break;
				}
				width_tmp /= 2;
				height_tmp /= 2;
				scale *= 2;
			}
			// decode with current scale values
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			FileInputStream stream2 = new FileInputStream(f);
			Bitmap bitmap = BitmapFactory.decodeStream(stream2,null,o2);
			stream2.close();
			return bitmap;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static float getImgFileSize(Uri uri)
	{
		File file = new File(uri.getPath());
		float fileSizeInMB = 0;
		if(file.exists())
		{
			// Get length of file in bytes
			long fileSizeInBytes = file.length();
			// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
			float fileSizeInKB = fileSizeInBytes / 1024;
			//  Convert the KB to MegaBytes (1 MB = 1024 KBytes)
			fileSizeInMB = fileSizeInKB / 1024;
		}
		return fileSizeInMB;
	}
}
