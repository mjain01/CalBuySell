package drt.com.shopfort;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import drt.com.shopfort.usersession.UserSession;

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    //to get user session data
    private UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session =new UserSession(SplashActivity.this);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

//        FirebaseMessaging.getInstance().subscribeToTopic("weather")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        String msg = "Successful";
//                        if (!task.isSuccessful()) {
//                            msg = "Failed";
//                        }
//
//                        Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
//        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "blacklist.ttf");
//       // Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
//
//        TextView appname= findViewById(R.id.app_slogan);
//        appname.setTypeface(myTypeFace);



//        YoYo.with(Techniques.Bounce)
//                .duration(7000)
//                .playOn(findViewById(R.id.logo));
//
//        YoYo.with(Techniques.FadeInUp)
//                .duration(5000)
//                .playOn(findViewById(R.id.app_slogan));

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}



