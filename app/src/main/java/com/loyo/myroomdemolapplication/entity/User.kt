package com.loyo.myroomdemoapplication.entity;

import androidx.room.*
@Entity(indices = arrayOf(Index(value =["firstName"],unique = true )))
data class User(
    //每个实体必须将至少 1 个字段定义为主键
    @PrimaryKey val id: Int,
    val firstName: String?,
    @ColumnInfo(name="last_name") val lastName: String?

)


