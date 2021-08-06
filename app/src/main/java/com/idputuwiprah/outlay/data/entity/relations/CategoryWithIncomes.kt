package com.idputuwiprah.outlay.data.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.data.entity.Income

data class CategoryWithIncomes(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "category_id"
    )
    val incomes: List<Income>
)
