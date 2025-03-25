package ch.fvj.mobpro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ch.fvj.mobpro.models.User
import ch.fvj.mobpro.models.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao




    companion object {
        private const val DB_NAME = "app-database"
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE?: buildDatabase(context).also {INSTANCE = it}
        }
        private fun buildDatabase(context: Context): AppDatabase {
            val ioDispatcherExecutor = Dispatchers.IO.asExecutor()
            return Room
                .databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                )
                .setQueryExecutor(ioDispatcherExecutor)
                .setTransactionExecutor(ioDispatcherExecutor)
                .build()
        }
    }




}