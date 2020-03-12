package com.loyo.myroomdemolapplication.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(@PrimaryKey val bookId: Int, val name: String?)