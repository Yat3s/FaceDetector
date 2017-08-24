package com.yat3s.facedetector;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yat3s on 24/08/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class GraphicOverlay extends View {
    private final Object mLock = new Object();
    private float mWidthScaleFactor = 1.0f;
    private float mHeightScaleFactor = 1.0f;

    private Set<Face> mFaces = new HashSet<>();

    public GraphicOverlay(Context context) {
        this(context, null);
    }

    public GraphicOverlay(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GraphicOverlay(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Adds a graphic to the overlay.
     */
    public void add(Face face) {
        synchronized (mLock) {
            mFaces.add(face);
        }
        postInvalidate();
    }

    /**
     * Removes a graphic from the overlay.
     */
    public void remove(Face face) {
        synchronized (mLock) {
            mFaces.remove(face);
        }
        postInvalidate();
    }

    /**
     * Removes a graphic from the overlay.
     */
    public void clear() {
        synchronized (mLock) {
            mFaces.clear();
        }
        postInvalidate();
    }

    /**
     * Sets the camera attributes for size and facing direction, which informs how to transform
     * image coordinates later.
     */
    public void setScaleFactor(float widthScaleFactor, float heightScaleFactor) {
        synchronized (mLock) {
            mWidthScaleFactor = widthScaleFactor;
            mHeightScaleFactor = heightScaleFactor;
        }
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        synchronized (mLock) {
            for (Face face : mFaces) {
                face.scale(mWidthScaleFactor, mHeightScaleFactor);
                face.draw(canvas);
            }
        }
    }
}
