package com.example.android.newsfeed;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * Created by Neeraj on 6/29/2016.
 */
public class GetThumbnail extends AsyncTask<String, Void, Bitmap> {
    private final static String TAG = GetThumbnail.class.getSimpleName();

    ImageView thumbnail;

    GetThumbnail(ImageView imageView) {
        thumbnail = imageView;
    }

    @Override protected Bitmap doInBackground(String... dron) {
        if (dron == null) return null;
        Bitmap imageBitmap = downloadImageBitmap(dron[0]);
        return imageBitmap;
    }

    @Override protected void onPostExecute(Bitmap bmp) {
        if (thumbnail != null) {
            if (bmp != null) {
                thumbnail.setImageBitmap(bmp);
            } else {
                thumbnail.setVisibility(View.GONE);
            }
        }
    }

    public Bitmap downloadImageBitmap(String imageUrl) {
        if (imageUrl == null || imageUrl.length() == 0) {
            Log.i(TAG,
                    "Url string passed to image download is either empty or null. Not attempting download.");
            return null;
        }
        Bitmap bitmap = null;
        try {
            InputStream input = new java.net.URL(imageUrl).openStream();
            bitmap = BitmapFactory.decodeStream(input);
            if (input != null) {
                input.close();
            }
        } catch (OutOfMemoryError e) {
            Log.e(TAG,
                    String.format("image download Out of Memory for Url: %s.", imageUrl), e);
        } catch (UnknownHostException e) {
            Log.e(TAG, String.format(
                    "Unknown Host Exception in image download for Url: %s. Device may be offline.",
                    imageUrl), e);
        } catch (MalformedURLException e) {
            Log.e(TAG, String.format(
                    "Malformed URL Exception in image download for Url: %s. Image Url may be corrupted.",
                    imageUrl), e);
        } catch (Exception e) {
            Log.e(TAG, String.format("Exception in image bitmap download for Url: %s", imageUrl), e);
        }
        return bitmap;
    }
}
