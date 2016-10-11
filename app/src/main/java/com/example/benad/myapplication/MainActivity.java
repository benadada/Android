package com.example.benad.myapplication;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.BtLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
       // Authentification.setLoginListener(loginListener);
        //Authentification.execute("nico","nico");


        Log.i(TAG, "onCreate");
    }

    private void goToSecondActivity() {
        Toast.makeText(MainActivity.this, "Logiiin !!", Toast.LENGTH_LONG).show();
        Authentification authentification = new Authentification();
        authentification.setLoginListener(new Authentification.LoginListener() {
            @Override
            public void onLogin(boolean result) {
                Intent intent = new Intent(getApplication(), Message.class);
                Intent intent1 = new Intent(getApplication(), LoginFalse.class);
                if (result) {
                    startActivity(intent);
                }
                else{
                    startActivity(intent1);
                }
            }
        });
        EditText editlogin = (EditText) findViewById(R.id.EditTextLogin);
        EditText editmdp = (EditText) findViewById(R.id.EditTextMdp);
        String login = editlogin.getText().toString();
        String mdp = editmdp.getText().toString();
        authentification.execute(login,mdp);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
