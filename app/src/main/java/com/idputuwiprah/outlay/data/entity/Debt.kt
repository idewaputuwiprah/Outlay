package com.idputuwiprah.outlay.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Debt(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "debt_id")
    var debtId: Int = 0,

    @ColumnInfo(name = "debt_name")
    var debtName: String? = null,

    @ColumnInfo(name = "nominal")
    var nominal: Int = 0,

    @ColumnInfo(name = "category_id")
    var categoryId: Int = 0,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "status")
    var status: String? = null
)