package com.example.term_project.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.term_project.model.UserModel;

import java.util.List;

@Dao
public interface UserDao{
    @Insert(onConflict = REPLACE)
    void insert(UserModel userModel);
    @Delete
    void delete(UserModel userModel);

//    @Query("update user set status = 'D'")
//    void deleteUser()

    @Query("select * from user where status='A'")
    List<UserModel> getUsers();

    @Nullable
    @Query("select * from user where userID = :userID and password = :password and status = 'A'")
    UserModel getUser(String userID, String password);



}
