package com.idputuwiprah.outlay.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "expense_id")
    var expenseId: Int = 0,

    @ColumnInfo(name = "expense_name")
    var expenseName: String? = null,

    @ColumnInfo(name = "nominal")
    var nominal: Int = 0,

    @ColumnInfo(name = "category_id")
    var categoryId: Int = 0,

    @ColumnInfo(name = "date")
    var date: String? = null,
)
