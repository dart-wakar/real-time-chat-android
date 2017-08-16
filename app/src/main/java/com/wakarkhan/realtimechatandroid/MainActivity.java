package com.wakarkhan.realtimechatandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private EditText etUsername;
    private Button btnLogin;

    private Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"lol");
        initViews();
        initSocketIo();
    }

    private void initViews() {
        etUsername = (EditText)findViewById(R.id.et_username);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener((View view) -> login());
    }

    private void login() {
        String username = etUsername.getText().toString();
        Log.d(TAG,username);
        socket.emit("login",username);
    }

    private void initSocketIo() {
        try {
            socket = IO.socket("http://10.1.1.25:3000");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(TAG,"connected");
            }
        });
        socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(TAG,"ERROR in connection");
            }
        });
        socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(TAG,"Timeout");
            }
        });
    }
}
