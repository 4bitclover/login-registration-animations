package com.example.loginregistrationanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;








public class MainActivity extends AppCompatActivity {
    private LinearLayout registration;
    private LinearLayout login;
    private TextView loginText;
    private TextView registrationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registration = findViewById(R.id.registration);
        login = findViewById(R.id.login);
        loginText = findViewById(R.id.login_text_view);
        registrationText = findViewById(R.id.registration_text_view);

        registration.setOnClickListener(new RegistrationClickHandler());
    }

    private class RegistrationClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, Registration.class);
            Pair [] transitions = new Pair[4];
            transitions[0] = new Pair(login, login.getTransitionName());
            transitions[1] = new Pair(registration, registration.getTransitionName());
            transitions[2] = new Pair(loginText, loginText.getTransitionName());
            transitions[3] = new Pair(registrationText, registrationText.getTransitionName());

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, transitions);

            startActivity(i, options.toBundle());
        }
    }
}
