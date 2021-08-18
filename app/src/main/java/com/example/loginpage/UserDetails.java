package com.example.loginpage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UserDetails implements Parcelable {

    private Boolean userActive;
    private String userName;
    private int userId;
    private Credentials credentials;
    private List<Reminders> reminders;

    protected UserDetails(Parcel in) {
        byte tmpUserActive = in.readByte();
        userActive = tmpUserActive == 0 ? null : tmpUserActive == 1;
        userName = in.readString();
        userId = in.readInt();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    public UserDetails(Boolean userActive,String userName,int userId) {
        this.userActive=userActive;
        this.userName=userName;
        this.userId=userId;

    }
    public List<Reminders> getReminders() {
        return reminders;
    }
    public void setReminders(List<Reminders> reminders) {
        this.reminders = reminders;
    }
    public Credentials getCredentials() {
        return credentials;
    }
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (userActive == null ? 0 : userActive ? 1 : 2));
        dest.writeString(userName);
        dest.writeInt(userId);
    }

}