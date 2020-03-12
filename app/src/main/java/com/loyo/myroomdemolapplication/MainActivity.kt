package com.loyo.myroomdemolapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.loyo.myroomdemoapplication.AppDataBase
import com.loyo.myroomdemoapplication.dao.UserDao
import com.loyo.myroomdemoapplication.entity.User
import com.loyo.myroomdemolapplication.entity.Book
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    //升级数据库，只要对表进行了修改就需要升级，并定义Migration
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE table Book ('bookId' INTEGER PRIMARY KEY NOT NULL,'name' TEXT)")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //获取dataBase
        val appDataBase: AppDataBase =
            Room.databaseBuilder(this, AppDataBase::class.java, "user").addMigrations(MIGRATION_1_2)
                .build()
        //获取dao
        val userDao = appDataBase.getUserDao()
        val bookDao = appDataBase.getBookDao()
        //对数据库进行增删改查，需要在子线程中进行，除异步查询（返回 LiveData 或 Flowable 实例的查询）
        thread {
            bookDao.insertBooks(Book(1, "大海"))
            bookDao.queryAll().iterator().forEach { Log.i("user_book", it.toString()) }
            userDao.clear()
            userDao.insertUsers(User(1, "junhui", "zhang"))
            userDao.insertUsers(User(2, "kaylee", "zhang"))
            userDao.insertUsers(User(3, "hong", "li"))
            userDao.insertUsers(User(4, "zhang", "li"))
            val users1 = userDao.search(arrayOf("junhui", "hong"))
            users1.iterator().forEach { Log.i("user1", it.toString()) }
        }
    }
}
