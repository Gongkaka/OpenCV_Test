package com.example.opencv_test.gles;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

// Build a GLSurfaceView object
// A GLSurfaceView is a specialized view where you can draw OpenGL ES graphics.
public class MyGLSurfaceView extends GLSurfaceView {
    private final MyGLRenderer renderer;

    private final float TOUCH_SCALE_FACTOR = 180.0F / 320;
    private float previousX;
    private float previousY;
    public MyGLSurfaceView(Context context){
        super(context);

        // create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        renderer = new MyGLRenderer();

        // Set the Render for drawing on the GLSurfaceView
        setRenderer(renderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - previousX;
                float dy = y - previousY;

                // Reverse direction of rotation above the mid-line
                if(y > getHeight() / 2) {
                    dx = dx* -1;
                }

                if(x < getWidth() / 2) {
                    dy = dy * -1;
                }

                renderer.setAngle(renderer.getAngle() + ((dx + dy) * TOUCH_SCALE_FACTOR));
                requestRender();
        }

        previousX = x;
        previousY = y;

        return true;
    }

}
