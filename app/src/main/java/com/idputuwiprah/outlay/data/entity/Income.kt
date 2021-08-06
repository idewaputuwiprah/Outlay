package com.idputuwiprah.outlay.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Income(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "income_id")
    var incomeId: Int = 0,

    @ColumnInfo(name = "income_name")
    var incomeName: String? = null,

    @ColumnInfo(name = "nominal")
    var nominal: Int = 0,

    @ColumnInfo(name = "category_id")
    var categoryId: Int = 0,

    @ColumnInfo(name = "date")
    var date: String? = null,
)
