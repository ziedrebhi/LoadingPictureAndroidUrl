package com.tutozone.loadingpictureandroidurl;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// here we will load the picture into the imageView
		new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
        .execute("http://3.bp.blogspot.com/-K5cVS68LsGo/U-FuABuLdkI/AAAAAAAADYA/n-_g9jYvsac/s1600/arabic_android_by_badaoui-d4njty2.png");
	}
	
		// AsyckTask to download image (url given )
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		  ImageView bmImage;
		  
		  //constructor
		  public DownloadImageTask(ImageView bmImage) {
		      this.bmImage = bmImage;
		  }
		  
		  // laoding picture and put it into bitmap 
		  protected Bitmap doInBackground(String... urls) {
		      String urldisplay = urls[0];
		      Bitmap mIcon11 = null;
		      try {
		        InputStream in = new java.net.URL(urldisplay).openStream();
		        mIcon11 = BitmapFactory.decodeStream(in);
		      } catch (Exception e) {
		          Log.e("Error", e.getMessage());
		          e.printStackTrace();
		      }
		      return mIcon11;
		  }
		  
		  //after downloading
		  protected void onPostExecute(Bitmap result) {
		      bmImage.setImageBitmap(result);
		  }
		}
}
