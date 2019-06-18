package com.example.vocabulary.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Word {

    @PrimaryKey
    @NonNull
    private String englishVersion;

    private String russianVersion;

    public Word(String englishVersion, String russianVersion) {
        this.englishVersion = englishVersion;
        this.russianVersion = russianVersion;
    }

    public String getEnglishVersion() {
        return englishVersion;
    }

    public void setEnglishVersion(String englishVersion) {
        this.englishVersion = englishVersion;
    }

    public String getRussianVersion() {
        return russianVersion;
    }

    public void setRussianVersion(String russianVersion) {
        this.russianVersion = russianVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(englishVersion, word.englishVersion) &&
                Objects.equals(russianVersion, word.russianVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(englishVersion, russianVersion);
    }
}
