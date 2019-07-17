package com.example.sawe.scee;

import android.hardware.Camera;
import android.hardware.camera2.params.Face;
//import android.media.FaceDetector;
import android.os.Handler;
import android.util.Log;

import android.graphics.Rect;

import static com.example.sawe.scee.CameraFragment.randomi;
import static com.example.sawe.scee.CameraFragment.numFaces;

public class MyFaceDetectionListener implements Camera.FaceDetectionListener {

int x = 0;
    @Override
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {

        if (faces.length > 0){
            Log.d("FaceDetection", "face detected: "+ faces.length +
                    " Face 1 Location X: " + faces[0].rect.centerX() +
                    "Y: " + faces[0].rect.centerY() );


            //return

            /* I believe this code is used for starting/moving to another activity
            Intent myIntent = new Intent(this, FaceDetService.class);
            startActivity(myIntent);
            Toast.makeText(MainActivity.this, "I see a face(s) :)", Toast.LENGTH_SHORT).show();
            */


            // a service has proven itself so far that it does not want to be started
            // upon immediate face coming into contact with camera. I think the startfd()
            // has to be called everytime one wants to perform some level of facedetection
            // hence..

            //Context.startService(FaceDetService);

            //static void FaceDetService.onCreate();
            //public this1() = (FaceDetService.class.getMethods());
            // called to alert 1 face spotted
            if (CameraFragment.random2 == 0){
                x = 1;
                CameraFragment.random2 = 1;// in the case the same 1 face is still being spotted
            }
            // at this point I don't think I need randomi. It's redundant. NO
            // It is needed
            // This app should only send a service/broadcast from here

        }
        // Resets the whole process when there are no (new) faces spotted
        else{

            /*final Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    randomi = 0; // delays the transformation of randomi

                }
            }, 2000);*/

            x = 0;
            CameraFragment.random2 = 0;
        }
        randomi = x;
        numFaces = faces.length;
    }


}