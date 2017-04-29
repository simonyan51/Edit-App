package com.example.editprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserInfoEditActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTIVITY_NAME = "UserInfoEditActivity";
    private EditText userFirstName;
    private EditText userLastName;
    private EditText userName;
    private EditText gender;
    private EditText age;
    private EditText bio;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_edit);

        userFirstName = (EditText) findViewById(R.id.activity_user_info_edit_userFirstName);
        userLastName = (EditText) findViewById(R.id.activity_user_info_edit_userLastName);
        userName = (EditText) findViewById(R.id.activity_user_info_edit_userName);
        gender = (EditText) findViewById(R.id.activity_user_info_edit_gender);
        age = (EditText) findViewById(R.id.activity_user_edit_info_edit_age);
        bio = (EditText) findViewById(R.id.activity_user_info_edit_bio);

        findViewById(R.id.activity_user_info_edit_saveButton).setOnClickListener(this);
        findViewById(R.id.activity_user_info_edit_cancelButton).setOnClickListener(this);

        user = (User) getIntent().getSerializableExtra(UserInfoActivity.ACTIVITY_NAME);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userFirstName.setText(user.getFirstName());
        userLastName.setText(user.getLastName());
        userName.setText(user.getUserName());
        gender.setText(user.getGender());
        age.setText(Integer.toString(user.getAge()));
        bio.setText(user.getBio());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_user_info_edit_saveButton:
                if (!checkTyping()) {
                    Toast.makeText(this, "Wrong Data", Toast.LENGTH_LONG).show();
                    return;
                }
                sendResult();
                finish();
                break;
            case R.id.activity_user_info_edit_cancelButton:
                    finish();
                break;
        }
    }

    private void setEditedData() {
        user.setFirstName(userFirstName.getText().toString());
        user.setLastName(userLastName.getText().toString());
        user.setUserName(userName.getText().toString());
        user.setGender(gender.getText().toString());
        user.setAge(Integer.parseInt(age.getText().toString()));
        user.setBio(bio.getText().toString());
    }

    private boolean checkTyping() {
        ArrayList<String> data = new ArrayList<>();

        data.add(userFirstName.getText().toString());
        data.add(userLastName.getText().toString());
        data.add(userName.getText().toString());
        data.add(gender.getText().toString());
        data.add(age.getText().toString());

        for (String value : data) {

            if (value.equals("")) {
                return false;
            }
        }

        if (userFirstName.getText().toString().length() <= 3 ||
            userLastName.getText().toString().length() <= 3 ||
            userName.getText().toString().length() <= 3) {

            Toast.makeText(this, "first name, last name and username must be at least 3 characters long", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void sendResult() {
        setEditedData();
        Intent intent = new Intent();
        intent.putExtra(ACTIVITY_NAME, user);
        setResult(RESULT_OK, intent);
    }

    @Override
    public void onBackPressed() {

        if (!checkTyping()) {
            Toast.makeText(this, "Wrong Data", Toast.LENGTH_LONG).show();
        } else {
            sendResult();
        }
        super.onBackPressed();
    }
}
