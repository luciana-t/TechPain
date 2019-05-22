package com.luciana.techpain;

import android.app.Application;
import android.content.Context;

public class AppContext extends Application{
    //This class allows the context to be recover anywhere in the program
    private static Context context;

    public void onCreate() {
        super.onCreate();
        AppContext.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return AppContext.context;
    }
}
