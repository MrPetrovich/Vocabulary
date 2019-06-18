package com.example.vocabulary.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.vocabulary.entity.Word;

@Database(entities = Word.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
        public abstract WordDAO getWordDao();
}
