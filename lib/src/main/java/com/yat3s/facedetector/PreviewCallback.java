package com.yat3s.facedetector;

import android.util.Size;

/**
 * Created by Yat3s on 22/08/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public interface PreviewCallback {
    void onPreviewFrame(byte[] data, Size frameSize, int format, int faceDetectMode, Face[] faces);
}
