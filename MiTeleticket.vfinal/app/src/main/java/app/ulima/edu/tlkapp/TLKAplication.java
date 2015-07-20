package app.ulima.edu.tlkapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

/**
 * Created by Hiroshi on 04/07/2015.
 */
public class TLKAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "Vkog7rJzuGN9ZEhza0gLGQfpw8sZRZk8eV8SmW2B", "eF6q8eh2fpBsTs7K0x7Dmh9zJ1jaB8R9grSRluiD");

        ParseFacebookUtils.initialize(getApplicationContext());

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
