package com.example.consolesell

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.room.*


@Entity
data class Console(@PrimaryKey(autoGenerate = true) var id:Int, var name:String, var cost:Int, var description:String){
}

//create Database Access Object
@Dao
interface ConsoleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContacts(contacts: Console)

    @Query("SELECT * FROM Console WHERE id LIKE:id")
    fun getContactId(id:Int): LiveData<Console>

    @Query("SELECT * FROM Console ")
    fun getAllContacts(): LiveData<List<Console>>

    @Query("DELETE FROM Console WHERE id LIKE:id")
    fun deleteContact(id:Int)
}

//create database
@Database(entities = [Console::class],
    version = 1)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun ConsoleDao(): ConsoleDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "contacts.db")
            .build()
    }


}

//dependencies
/*
apply plugin: 'kotlin-kapt'
* //room
    implementation "androidx.room:room-runtime:2.1.0-alpha01"
    annotationProcessor 'androidx.room:room-compiler:2.0.0'
    kapt 'androidx.room:room-compiler:2.0.0'
    *

*
*
* */