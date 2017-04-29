package com.example.editprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTIVITY_NAME = "UserInfoActivity";

    public static final int REQUEST_CODE = 1;

    private TextView userFirstName;
    private TextView userLastName;
    private TextView userName;
    private TextView gender;
    private TextView age;
    private TextView bio;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userFirstName = (TextView) findViewById(R.id.activity_user_info_userFirstName);
        userLastName = (TextView) findViewById(R.id.activity_user_info_userLastName);
        userName = (TextView) findViewById(R.id.activity_user_info_userName);
        gender = (TextView) findViewById(R.id.activity_user_info_gender);
        age = (TextView) findViewById(R.id.activity_user_info_age);
        bio = (TextView) findViewById(R.id.activity_user_info_bio);
        user = (User) getIntent().getSerializableExtra(MainActivity.ACTIVITY_NAME);

        findViewById(R.id.activity_user_info_editProfileButton).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userFirstName.setText("First Name: " + user.getFirstName());
        userLastName.setText("Last Name: " + user.getLastName());
        userName.setText("User Name: " + user.getUserName());
        gender.setText("Gender: " + user.getGender());
        age.setText("Age: " + user.getAge());
        bio.setText("Biography\n" + user.getBio());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.activity_user_info_editProfileButton:
                Intent intent = new Intent(this, UserInfoEditActivity.class);
                intent.putExtra(ACTIVITY_NAME, user);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    user = (User) data.getSerializableExtra(UserInfoEditActivity.ACTIVITY_NAME);
                    break;
            }
        }
    }
}
