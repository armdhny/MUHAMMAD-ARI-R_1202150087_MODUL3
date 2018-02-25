package com.ramdhany.ari.mariramdhany_1202150087_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(2500);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashAct.this, LoginAct.class));
                }
            }
        };
        thread.start();
        Toast toast = Toast.makeText(this,R.string.toast, Toast.LENGTH_LONG);
        toast.show();
    }
}

