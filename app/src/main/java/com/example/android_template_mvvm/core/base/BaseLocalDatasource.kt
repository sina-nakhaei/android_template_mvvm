package com.example.android_template_mvvm.core.base

import android.content.Context
import com.example.android_template_mvvm.core.database.DatabaseHandler
import dagger.hilt.android.qualifiers.ApplicationContext

abstract class BaseLocalDatasource(@ApplicationContext private val context: Context) {

    val databaseHandler = DatabaseHandler.getInstance(context)

}