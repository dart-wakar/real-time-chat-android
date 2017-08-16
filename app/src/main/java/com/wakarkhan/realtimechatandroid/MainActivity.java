package com.wakarkhan.realtimechatandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private EditText etUsername;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"lol");
        initViews();
    }

    private void initViews() {
        etUsername = (EditText)findViewById(R.id.et_username);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener((View view) -> login());
    }

    private void login() {
        String username = etUsername.getText().toString();
        Log.d(TAG,username);
    }
}
