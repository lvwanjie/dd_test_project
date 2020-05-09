package com.example.myapplication.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.myapplication.R;

/**
 * 可自定义任意一个角为圆角的ImageView
 */
public class CustomRoundAngleImageView extends AppCompatImageView {
    private int width, height;
    private int defaultRadius = 0;
    private int radius;
    private int leftTopRadius;
    private int rightTopRadius;
    private int rightBottomRadius;
    private int leftBottomRadius;
    private Path path;
    private Paint borderPaint;
    private int borderWidth;
    private int borderColor;

    private boolean doClip = true;

    public CustomRoundAngleImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    public CustomRoundAngleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    public CustomRoundAngleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        path = new Path();
        doClip = true;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        // 读取配置
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable
                .Custom_Round_Image_View);
        radius = array.getDimensionPixelOffset(R.styleable.Custom_Round_Image_View_radius,
                defaultRadius);
        leftTopRadius = array.getDimensionPixelOffset(R.styleable
                .Custom_Round_Image_View_left_top_radius, defaultRadius);
        rightTopRadius = array.getDimensionPixelOffset(R.styleable
                .Custom_Round_Image_View_right_top_radius, defaultRadius);
        rightBottomRadius = array.getDimensionPixelOffset(R.styleable
                .Custom_Round_Image_View_right_bottom_radius, defaultRadius);
        leftBottomRadius = array.getDimensionPixelOffset(R.styleable
                .Custom_Round_Image_View_left_bottom_radius, defaultRadius);

        //如果四个角的值没有设置，那么就使用通用的radius的值。
        if (defaultRadius == leftTopRadius) {
            leftTopRadius = radius;
        }
        if (defaultRadius == rightTopRadius) {
            rightTopRadius = radius;
        }
        if (defaultRadius == rightBottomRadius) {
            rightBottomRadius = radius;
        }
        if (defaultRadius == leftBottomRadius) {
            leftBottomRadius = radius;
        }
        array.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //这里做下判断，只有图片的宽高大于设置的圆角距离的时候才进行裁剪
        if (doClip) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter (0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
            try {
                int maxLeft = Math.max(leftTopRadius, leftBottomRadius);
                int maxRight = Math.max(rightTopRadius, rightBottomRadius);
                int minWidth = maxLeft + maxRight;
                int maxTop = Math.max(leftTopRadius, rightTopRadius);
                int maxBottom = Math.max(leftBottomRadius, rightBottomRadius);
                int minHeight = maxTop + maxBottom;
                if (width >= minWidth && height >= minHeight) {
                    //四个角：右上，右下，左下，左上
                    path.moveTo(leftTopRadius, 0);
                    path.lineTo(width - rightTopRadius, 0);
                    path.quadTo(width, 0, width, rightTopRadius);
                    path.lineTo(width, height - rightBottomRadius);
                    path.quadTo(width, height, width - rightBottomRadius, height);
                    path.lineTo(leftBottomRadius, height);
                    path.quadTo(0, height, 0, height - leftBottomRadius);
                    path.lineTo(0, leftTopRadius);
                    path.quadTo(0, 0, leftTopRadius, 0);
                    canvas.clipPath(path);
                }
            } catch (UnsupportedOperationException e) {
                doClip = false;
            }
        }

        super.onDraw(canvas);
        if (doClip) {
            if (borderWidth != 0 && borderPaint != null) {
                canvas.drawPath(path, borderPaint);
            }
        }
    }

    public void setRectRadius(int leftTopRadius, int rightTopRadius, int rightBottomRadius, int
            leftBottomRadius) {
        this.leftTopRadius = leftTopRadius;
        this.rightTopRadius = rightTopRadius;
        this.rightBottomRadius = rightBottomRadius;
        this.leftBottomRadius = leftBottomRadius;
        invalidate();
    }

    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();
    }

    public void setRectRadius(int radius) {
        setRectRadius(radius, radius, radius, radius);
    }

    public void setBorder(int width, int color) {
        this.borderWidth = width;
        this.borderColor = color;
        if (borderPaint == null) {
            borderPaint = new Paint();
            borderPaint.setStyle(Paint.Style.STROKE);
            borderPaint.setAntiAlias(true);
        }
        borderPaint.setStrokeWidth(width);
        borderPaint.setColor(color);
    }
}
