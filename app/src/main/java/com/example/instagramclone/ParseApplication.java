package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hM0eNMnJI9NmifX2TXahCIJlE96ZjzkSGDfrLIxS")
                .clientKey("5dtE02ylat0eZTEuRCtXKyP41yEj5yHKejAhdQMe")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
