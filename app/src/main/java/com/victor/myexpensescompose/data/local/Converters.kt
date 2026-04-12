package com.victor.myexpensescompose.data.local

import androidx.room.TypeConverter
import com.victor.myexpensescompose.Category
import com.victor.myexpensescompose.Tags

class Converters {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(value: String): Category = Category.valueOf(value)

    @TypeConverter
    fun fromTag(tag: Tags): String = tag.name

    @TypeConverter
    fun toTag(value: String): Tags = Tags.valueOf(value)
}

