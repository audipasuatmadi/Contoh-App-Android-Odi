package com.example.roomlab;

import android.preference.PreferenceManager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface iUserDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertData(UserData userData);

    @Query("DELETE FROM userdata_table")
    void deleteAllData();

    @Query("SELECT * FROM userdata_table")
    LiveData<List<UserData>> getAllDatas();

    @Query("SELECT * FROM userdata_table LIMIT 1")
    UserData[] getOneUserData();

    @Delete
    void deleteUserData(UserData userData);
}
