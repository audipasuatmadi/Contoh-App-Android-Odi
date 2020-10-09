package com.example.roomlab;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserDataViewModel extends AndroidViewModel {
    private UserDataRepository mRepository;
    private LiveData<List<UserData>> mAllDAtas;

    public UserDataViewModel(Application application) {
        super(application);
        mRepository = new UserDataRepository(application);
        mAllDAtas = mRepository.getAllWords();
    }

    public LiveData<List<UserData>> getAllUserDatas() {
        return mAllDAtas;
    }

    public void insert(UserData userData) {
        mRepository.insertData(userData);
    }

    public void deleteAll() {
        mRepository.deleteAllDatas();
    }

    public void deleteUserData(UserData userData) {
        mRepository.deleteUserData(userData);
    }

}
