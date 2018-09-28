package com.example.root.chamna;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ImageUtils {

	public static Bitmap convert(String base64str) throws IllegalArgumentException
	{
	byte[] decodeBytes = Base64.decode(base64str.substring(base64str.indexOf(",")+1), Base64.DEFAULT);
	
	
		
		return BitmapFactory.decodeByteArray(decodeBytes,  0,decodeBytes.length);
				
	}
	
	public static String convert(Bitmap bitmap){
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
		
		return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
		
		
	}
}
