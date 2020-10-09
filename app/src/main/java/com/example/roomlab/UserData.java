package com.example.roomlab;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userdata_table")
public class UserData {

    @PrimaryKey
    @ColumnInfo(name = "pin")
    private int mPin;
    @NonNull
    @ColumnInfo(name = "user_name")
    private String mUserName;

    public UserData(@NonNull String userName, int pin) {
        this.mUserName = userName;
        this.mPin = pin;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public int getPin() {
        return this.mPin;
    }
}
