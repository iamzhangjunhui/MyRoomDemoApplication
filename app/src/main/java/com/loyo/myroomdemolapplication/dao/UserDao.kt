package com.loyo.myroomdemoapplication.dao;

import androidx.room.*

import com.loyo.myroomdemoapplication.entity.User
import com.loyo.myroomdemolapplication.entity.UserBean


@Dao
//定义为接口或抽象类
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User)

    @Update
    fun udateUser(vararg user: User)

    @Query("SELECT * FROM User")
    fun queryAll(): Array<User>

    //删除表中所以数据
    @Query("DELETE FROM USER")
    fun clear()

    @Query("SELECT firstName,last_name FROM USER WHERE firstName in (:searchs)")
    fun search(searchs:Array<String>):Array<UserBean>
}
