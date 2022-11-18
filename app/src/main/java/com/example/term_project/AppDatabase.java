package com.example.term_project;


import android.content.Context;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.term_project.dao.UserDao;
import com.example.term_project.model.ExamSubjectModel;
import com.example.term_project.model.UserModel;

@Database(entities = {UserModel.class, ExamSubjectModel.class}, version = 7)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    @Nullable
    private static AppDatabase database;
    private static String DATABASE_NAME = "Term";

    public synchronized static AppDatabase getInstance(Context context)
    {
        if (database == null)
        {
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

}
