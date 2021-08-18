package com.example.loginpage;

import android.os.Parcel;
import android.os.Parcelable;

class Reminders implements Parcelable {
    private String name;
    private String date;
    private String time;

    public Reminders(Parcel in) {
        name = in.readString();
        date = in.readString();
        time = in.readString();
    }

    public static final Creator<Reminders> CREATOR = new Creator<Reminders>() {
        @Override
        public Reminders createFromParcel(Parcel in) {
            return new Reminders(in);
        }

        @Override
        public Reminders[] newArray(int size) {
            return new Reminders[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() { return date; }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(time);
    }
}