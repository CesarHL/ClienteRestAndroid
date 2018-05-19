package com.example.erick.serviciorest;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("prueba", "Refreshed token: " + refreshedToken);
        System.out.println("===========================================================>>>>" + refreshedToken);
    }

}
