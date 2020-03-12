package com.loyo.myroomdemolapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loyo.myroomdemolapplication.entity.Book
@Dao
interface BookDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun insertBooks(vararg book: Book)

    @Query("SELECT * FROM Book")
    fun queryAll():Array<Book>

}