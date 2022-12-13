package com.example.newsapp.data.db

import androidx.room.TypeConverter
import com.example.newsapp.data.api.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String = source.name

    @TypeConverter
    fun toSource(name: String): Source = Source(name, name)
}