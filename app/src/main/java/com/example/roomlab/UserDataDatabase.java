package com.example.roomlab;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = UserData.class, version = 1, exportSchema = false)
public abstract class UserDataDatabase extends RoomDatabase {

    public abstract iUserDataDao userDataDao();
    public static UserDataDatabase INSTANCE;

//    private static UserDataDatabase.Callback sUserDataDatabaseCallback = new UserDataDatabase.Callback() {
//
//        @Override
//        public void onOpen(@NonNull SupportSQLiteDatabase db) {
//            super.onOpen(db);
//            new PopulateDbAsync(INSTANCE).execute();
//        }
//    };

    public static UserDataDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserDataDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDataDatabase.class,
                            "first_database").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

//    public static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//        private final iUserDataDao userDataDao;
//        String[] usernames = {"odipasuatmadi", "wiragunawan", "megasaridewi"};
//        int[] pins = {112, 531, 125};
//
//        PopulateDbAsync(UserDataDatabase userDataDatabase) {
//            userDataDao = userDataDatabase.userDataDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            if (userDataDao.getOneUserData().length < 1) {
//                for (int i = 0; i < usernames.length; i++) {
//                    UserData userData = new UserData(usernames[i], pins[i]);
//                    userDataDao.insertData(userData);
//                }
//            }
//            return null;
//        }
//    }

}
