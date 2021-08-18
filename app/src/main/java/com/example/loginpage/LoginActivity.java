package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {
    public EditText username;
    public EditText password;
    public Button login;
    public TextView error;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            validate(username.getText().toString(),password.getText().toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.etusername);
        password = (EditText) findViewById(R.id.etpassword);
        login = (Button) findViewById(R.id.btnlogin);
        error = (TextView) findViewById(R.id.tverror);


        error.setText("");

        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),password.getText().toString());
            }
        });
    }


    public void validate (final String uname, String upasssword) {
        if (!uname.isEmpty() && !upasssword.isEmpty()) {
            login.setEnabled(true);
            login.setBackground(getDrawable(R.drawable.logininactive));
        }
        else
        {
            login.setEnabled(true);
            login.setBackground(getDrawable(R.drawable.tv_active));
        }
        if (uname.equals("abc@gmail.com") && upasssword.equals("12345678")) {
            username.setBackground(getDrawable(R.drawable.tv_active));
            password.setBackground(getDrawable(R.drawable.tv_active));
            error.setText("");
            login.setBackground(getDrawable(R.drawable.loginactive));
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        Log.d("LoginActivity", e.getLocalizedMessage());
                    }
                }
            });
        }
        else if (uname.equals("abc@gmail.com")) {
            if (upasssword.length() <= 6) {
                username.setBackground(getDrawable(R.drawable.tv_active));
                error.setText("Password must be more than six character");
                password.setBackground(getDrawable(R.drawable.tv_inactive));
            }
            else {
                error.setText("Password is invalid");
                password.setBackground(getDrawable(R.drawable.tv_inactive));
            }
        }
        else if (!(uname.contains("@gmail.com"))){
            error.setText("Username must be in mail format");
            username.setBackground(getDrawable(R.drawable.tv_inactive));
            password.setBackground(getDrawable(R.drawable.tv_inactive));
        }
        else if (upasssword.equals("12345678"))
        {
            password.setBackground(getDrawable(R.drawable.tv_active));
            error.setText("Username is invalid");
            username.setBackground(getDrawable(R.drawable.tv_inactive));
        }
        else {
            error.setText("Username and Password is invalid");
            username.setBackground(getDrawable(R.drawable.tv_inactive));
            password.setBackground(getDrawable(R.drawable.tv_inactive));
        }
    }



    @Override
    protected void onStart() {
        super.onStart();



        /*try {
            JSONObject jsonRootObject = new JSONObject(strJson);

            JSONArray jsonRemArray = jsonRootObject.optJSONArray("reminders");

            if (jsonRemArray != null) {
                for(int i=0; i < jsonRemArray.length(); i++){
                    JSONObject jsonObject = jsonRemArray.getJSONObject(i);

                    String Name = jsonObject.optString("name").toString();
                    String Date = jsonObject.optString("date").toString();
                    String Time = jsonObject.optString("time").toString();

                    UserDetails remainder = new UserDetails();
                    remainder.setName(Name);
                    remainder.setDate(Date);
                    remainder.setTime(Time);
                }
            }

            JSONArray jsonCredArray = jsonRootObject.optJSONArray("credientials");


            if (jsonCredArray != null) {
                for(int i = 0; i < jsonCredArray.length(); i++){
                    JSONObject jsonObject = jsonCredArray.getJSONObject(i);

                    String Email = jsonObject.optString("email").toString();
                    int AuthenticationType = Integer.parseInt(jsonObject.optString("authenticationType"));

                    UserDetails crediential = new UserDetails();
                    crediential.setEmail(Email);
                    crediential.setAuthenticationType(AuthenticationType);
                }
            }

            JSONArray jsonResponseArray = jsonRootObject.optJSONArray("user response");

            if (jsonResponseArray != null) {
                for(int i=0; i < jsonResponseArray.length(); i++){
                    JSONObject jsonObject = jsonResponseArray.getJSONObject(i);

                    Boolean UserActive = jsonObject.optBoolean("userActive");
                    String UserName = jsonObject.optString("userName").toString();
                    int UserId = jsonObject.optInt("userId");

                    UserDetails response = new UserDetails();
                    response.setUserActive(UserActive);
                    response.setUserName(UserName);
                    response.setUserId(UserId);
                }
            }
        } catch (JSONException e) {e.printStackTrace();}


        class Remainders {
            private String name;
            private String date;
            private String time;

            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getDate() {
                return date;
            }
            public void setDate(String date) {
                this.date = date;
            }
            public String getTime() {
                return time;
            }
            public void setTime(String time) {
                this.time = time;
            }
        }

    class Credentials {
        private String email;
        private int authenticationType;

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public int getAuthenticationType(int authenticationType) {
            return authenticationType;
        }
        public void setAuthenticationType(int authenticationType) {
            this.authenticationType = authenticationType;
        }
    }

    class UserDetails {
        private Boolean userActive;
        private String userName;
        private int userId;

        public Boolean getUserActive() {
            return userActive;
        }
        public void setUserActive(Boolean userActive) {
            this.userActive = userActive;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public int getUserId() {
            return userId;
        }
        public void setUserId(int userId) {
            this.userId = userId;
        }
    }*/

    }
}