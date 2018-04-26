package com.example.administrator.graduation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Auther 于亿鑫
 * @CreateTime 2018/4/26  12:08
 */

public class FilletImageView extends View {

    private Paint paint;

    public FilletImageView(Context context) {
        super(context);
    }

    public FilletImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FilletImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Bitmap bitmap = BitmapFactory.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user_header);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint = new Paint();

        paint.setAntiAlias(true);

        paint.setShader(shader);
        canvas.scale(0.35f,0.35f);
        canvas.drawCircle(getX()+110, getY()+230, 260, paint);
    }
}
