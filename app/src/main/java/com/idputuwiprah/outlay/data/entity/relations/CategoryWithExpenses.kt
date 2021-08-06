package com.idputuwiprah.outlay.data.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.data.entity.Expense

data class CategoryWithExpenses(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "category_id"
    )
    val expenses: List<Expense>
)
