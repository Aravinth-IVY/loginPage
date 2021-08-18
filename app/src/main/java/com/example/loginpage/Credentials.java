package com.example.loginpage;

import android.os.Parcel;
import android.os.Parcelable;

public class Credentials implements Parcelable {
    private String email;
    private int authenticationType;

    protected Credentials(Parcel in) {
        email = in.readString();
        authenticationType = in.readInt();
    }

    public static final Creator<Credentials> CREATOR = new Creator<Credentials>() {
        @Override
        public Credentials createFromParcel(Parcel in) {
            return new Credentials(in);
        }

        @Override
        public Credentials[] newArray(int size) {
            return new Credentials[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeInt(authenticationType);
    }
}

