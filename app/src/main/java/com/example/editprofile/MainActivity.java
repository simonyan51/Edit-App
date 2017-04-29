package com.example.editprofile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTIVITY_NAME = "MainActivity";
    private TextView userName;
    private TextView gender;
    private TextView userImage;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userImage = (TextView) findViewById(R.id.activity_main_userImage);
        userName = (TextView) findViewById(R.id.activity_main_userName);
        gender = (TextView) findViewById(R.id.activity_main_gender);


        findViewById(R.id.activity_main_userShort).setOnClickListener(this);

        user = new User(0, "John", "Smith", "smith2017", Gender.MALE.getGender(), 19, "My Name Is John Smith, \nI am 19 Years old, \nmy nickname is smith2017.");
    }

    @Override
    protected void onStart() {
        super.onStart();

        userName.setText(user.getUserName());
        gender.setText(user.getGender());
        userImage.setText("This is The Picture Of " + user.getFirstName());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.activity_main_userShort:
                if (userImage.getVisibility() == View.GONE) {
                    userImage.setVisibility(View.VISIBLE);
                } else {

                    Intent userInfo = new Intent(this, UserInfoActivity.class);
                    userInfo.putExtra(ACTIVITY_NAME, user);
                    startActivity(userInfo);
                }
                break;
        }
    }

}
