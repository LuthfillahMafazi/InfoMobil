package co.example.lutfillahmafazi.infomobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    private long ms = 0;
    private long splashTime = 3000;
    private Boolean splashActive = true;
    private Boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread MyThread = new Thread(){
            public void run(){
                try {
                    while (splashActive && ms < splashTime){
                        if (!paused){
                            ms = ms + 100;
                            sleep(100);
                        }
                    }
                }catch (Exception e){
                }finally {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        MyThread.start();
    }
}
