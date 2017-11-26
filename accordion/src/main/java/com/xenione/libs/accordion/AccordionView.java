/*
Copyright 01/04/2017 Eugeni Josep Senent i Gabriel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.xenione.libs.accordion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import static android.graphics.Bitmap.createBitmap;

public class AccordionView extends FrameLayout {

    private float percentage = 0;

    private Matrix drawRightMatrix = new Matrix();

    private Matrix drawLeftMatrix = new Matrix();

    private Bitmap rightBitmap = null;

    private Bitmap leftBitmap = null;

    private MatrixHelper matrixHelper = new MatrixHelper();

    private Matrix projMatrix = new Matrix();

    private float[] srcPoint = new float[2];

    private float[] dstPoint = new float[2];

    public AccordionView(Context context) {
        super(context);
    }

    public AccordionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AccordionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AccordionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (isDrawingCacheEnabled() || !isClosing()) {
            super.dispatchDraw(canvas);
        } else {
            if (isDrawingCacheInvalidated()) {
                captureScreen();
            }
            drawFolder(canvas);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        invalidateDrawingCache();
        return isClosing() || super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return isClosing() || super.onTouchEvent(event);
    }

    private boolean isClosing() {
        return percentage > 0;
    }

    private boolean isDrawingCacheInvalidated() {
        return (leftBitmap == null || rightBitmap == null);
    }

    private void invalidateDrawingCache() {
        if (leftBitmap != null) {
            leftBitmap.recycle();
            leftBitmap = null;
        }

        if (rightBitmap != null) {
            rightBitmap.recycle();
            rightBitmap = null;
        }
    }

    private void drawFolder(Canvas canvas) {

        srcPoint[0] = getWidth() / 2;
        srcPoint[1] = 0;

        float alpha = calculateAlpha(percentage);

        canvas.translate(percentage * getWidth(), 0);

        // draw left half
        matrixHelper.rotateY(drawLeftMatrix, alpha, 0, getHeight() / 2);
        drawLeftMatrix.mapPoints(dstPoint, srcPoint);
        canvas.drawBitmap(leftBitmap, drawLeftMatrix, null);

        // draw right half
        projMatrix.setTranslate(getWidth() / 2, 0);
        matrixHelper.rotateY(drawRightMatrix, -alpha, getWidth() / 2, getHeight() / 2);
        drawRightMatrix.postTranslate(2 * (dstPoint[0] - getWidth() / 2), 0);
        drawRightMatrix.setConcat(projMatrix, drawRightMatrix);
        canvas.drawBitmap(rightBitmap, drawRightMatrix, null);
    }

    private float calculateAlpha(float percentage) {
        return (float) ((180 / Math.PI) * Math.asin((-(0.1111111 * Math.pow((1 - percentage), 2) * getWidth()) + Math.sqrt((0.01234567 * Math.pow((1 - percentage), 4) * Math.pow(getWidth(), 2)
                - 0.0123457 * (Math.pow((1 - percentage) * getWidth(), 2) + 1327104) * percentage * (percentage - 2))))
                / (Math.pow((1 - percentage) * getWidth(), 2) / 10368 + 128)));
    }

    public void setProgress(float percentage) {
        this.percentage = percentage;
        invalidate();
    }

    private void captureScreen() {
        this.setDrawingCacheEnabled(true);
        Bitmap cacheBitmap = createBitmap(this.getDrawingCache());
        leftBitmap = createBitmap(cacheBitmap, 0, 0, getWidth() / 2, getHeight());
        rightBitmap = createBitmap(cacheBitmap, getWidth() / 2, 0, getWidth() / 2, getHeight());
        this.setDrawingCacheEnabled(false);
    }
}
