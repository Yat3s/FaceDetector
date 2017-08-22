package com.yat3s.facedetector;

import android.hardware.camera2.params.Face;

/**
 * Created by Yat3s on 22/08/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public interface PreviewCallback {

    void onPreviewFrame(byte[] data, int faceDetectMode, Face[] faces);
}
