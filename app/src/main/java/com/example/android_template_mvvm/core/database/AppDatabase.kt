package com.example.android_template_mvvm.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_template_mvvm.feature.playground.model.PlaygroundDao
import com.example.android_template_mvvm.feature.playground.model.PlaygroundEntity
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(
    entities = [PlaygroundEntity::class],
    version = DatabaseConstants.VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    //TODO implement abstract dao
    abstract val playgroundDao: PlaygroundDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        operator fun invoke(@ApplicationContext context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { database ->
                    instance = database
                }
            }

        private fun buildDatabase(context: Context): AppDatabase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DatabaseConstants.NAME
        ).build()
    }
}
