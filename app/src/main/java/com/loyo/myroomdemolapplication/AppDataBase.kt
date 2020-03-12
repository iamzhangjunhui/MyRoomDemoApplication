package com.loyo.myroomdemoapplication;

import androidx.room.Database
import androidx.room.RoomDatabase
import com.loyo.myroomdemoapplication.dao.UserDao
import com.loyo.myroomdemoapplication.entity.User
import com.loyo.myroomdemolapplication.dao.BookDao
import com.loyo.myroomdemolapplication.entity.Book
//添加相应的表到entities
@Database(entities = [User::class, Book::class], version = 2, exportSchema = false)
//继承RoomDatabase类
abstract class AppDataBase : RoomDatabase() {
    //返回对应的dao
    abstract fun getUserDao(): UserDao
    abstract fun getBookDao(): BookDao
}
