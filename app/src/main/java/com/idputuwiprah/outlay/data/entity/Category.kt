package com.idputuwiprah.outlay.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "category_id")
    var categoryId: Int = 0,

    @ColumnInfo(name = "category_name")
    var categoryName: String? = null
)