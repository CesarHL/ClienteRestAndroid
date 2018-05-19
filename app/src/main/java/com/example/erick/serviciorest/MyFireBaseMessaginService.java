package com.example.erick.serviciorest;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessaginService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(remoteMessage.getData().size() > 0){

        }

        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

    }
}
