package com.yat3s.sample;

import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Size;

import com.yat3s.facedetector.PreviewCallback;
import com.yat3s.facedetector.PreviewFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private PreviewFragment mPreviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreviewFragment = PreviewFragment.newInstance();
        mPreviewFragment.setImageFrameSize(new Size(640, 480));
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, mPreviewFragment)
                    .commit();
        }
        mPreviewFragment.setPreviewCallback(new PreviewCallback() {
            @Override
            public void onPreviewFrame(byte[] data, int faceDetectMode, Face[] faces) {
                if (null != faces) {
                    Log.d(TAG, "onPreviewFrame: " + data.length + ", mode: " + faceDetectMode + ", face: " + faces.length);
                }
            }
        });
    }
}
