package com.idputuwiprah.outlay.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.data.entity.Debt
import com.idputuwiprah.outlay.data.entity.Expense
import com.idputuwiprah.outlay.data.entity.Income

@Database(
    entities = [Category::class, Debt::class, Expense::class, Income::class],
    version = 1
)
abstract class OutlayRoomDatabase: RoomDatabase() {

    abstract val outlayDao: OutlayDao

    companion object {
        private var INSTANCE: OutlayRoomDatabase? = null

        fun getDatabase(context: Context): OutlayRoomDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    OutlayRoomDatabase::class.java,
                    "outlay_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}