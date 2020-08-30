package com.example.opencv_test.rendering;
import com.example.opencv_test.gles.MyGLSurfaceView;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

// Create an activity for OpenGL ES graphics
public class GLESDemo extends Activity {
    private GLSurfaceView glView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a GLSurface instance and set it
        // as the ContentView for this activity
        glView = new MyGLSurfaceView(this);
        setContentView(glView);
    }
}
