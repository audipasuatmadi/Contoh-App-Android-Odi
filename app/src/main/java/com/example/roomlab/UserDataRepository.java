package com.example.roomlab;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserDataRepository {
    private iUserDataDao mUserDataDao;
    private LiveData<List<UserData>> mAllUserData;

    public UserDataRepository(Application application) {
        UserDataDatabase database = UserDataDatabase.getDatabase(application);
        mUserDataDao = database.userDataDao();
        mAllUserData = mUserDataDao.getAllDatas();
    }

    public LiveData<List<UserData>> getAllWords() {
        return mAllUserData;
    }

    public void insertData(UserData userData) {
        new insertAsyncTask(mUserDataDao).execute(userData);
    }

    public void deleteAllDatas() {
        new deleteAllAsyncTask(mUserDataDao).execute();
    }

    public void deleteUserData(UserData userData) {
        new deleteDataAsyncTask(mUserDataDao).execute(userData);
    }

    private static class deleteDataAsyncTask extends AsyncTask<UserData, Void, Void> {
        private iUserDataDao userDataDao;

        public deleteDataAsyncTask(iUserDataDao userDataDao) {
            this.userDataDao = userDataDao;
        }

        @Override
        protected Void doInBackground(final UserData... params) {
            Log.d("FUCK: ", params[0].getUserName());
            userDataDao.deleteUserData(params[0]);
            return null;
        }
    }

    public static class deleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private iUserDataDao userDataDao;

        public deleteAllAsyncTask(iUserDataDao userDataDao) {
            this.userDataDao = userDataDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDataDao.deleteAllData();
            return null;
        }
    }

    public static class insertAsyncTask extends AsyncTask<UserData, Void, Void> {
        private iUserDataDao mAsyncTaskDao;

        insertAsyncTask(iUserDataDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final UserData... userData) {
            mAsyncTaskDao.insertData(userData[0]);
            return null;
        }
    }
}
