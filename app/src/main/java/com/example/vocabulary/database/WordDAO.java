package com.example.vocabulary.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.vocabulary.entity.Word;

import java.util.List;

@Dao
public interface WordDAO {
    @Insert
    void insert(Word word);

    @Query("select * from Word")
    List<Word> getWords();
}
