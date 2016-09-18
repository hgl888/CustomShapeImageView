package com.meg7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by Mostafa Gazar on 11/2/13.
 */
public class CircleImageView extends BaseImageView {

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public static Bitmap getBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        canvas.drawOval(new RectF(0.0f, 0.0f, width, height), paint);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bitmap;
    }

    public static Bitmap testBitmap(Bitmap bitmap)
    {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        float[] array = {1,0,0,0,100,
                0,1,0,0,100,
                0,0,1,0,0,
                0,0,0,1,0};
        cm.set(array);
        paint.setColorFilter(new ColorMatrixColorFilter(cm));

        canvas.drawBitmap(bitmap, 0, 0, paint);
        return output;
    }

    public static Bitmap test1Bitmap(Bitmap bitmap)
    {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        Matrix cm = new Matrix();

        float[] array = {1,0,50,
                0,1,50,
                0,0,1};
        cm.setValues(array);
        canvas.drawBitmap(bitmap, cm, paint);
        return output;
    }

    @Override
    public Bitmap getBitmap() {
        return getBitmap(getWidth(), getHeight());
    }
}
