package com.example.vocabulary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocabulary.R;
import com.example.vocabulary.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter  extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    private List<Word> words;

    public WordAdapter() {
        this.words = new ArrayList<>();
    }

    public void setWords(List<Word> words){
        if(this.words.isEmpty()) this.words.clear();

        this.words.addAll(words);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.word_item_view, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = words.get(position);
        holder.bind(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private TextView englishVersion;
        private TextView russianVersion;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            englishVersion = itemView.findViewById(R.id.english_textView);
            russianVersion = itemView.findViewById(R.id.russian_textView);

        }

        public void bind(Word word) {
            englishVersion.setText(word.getEnglishVersion());
            russianVersion.setText(word.getRussianVersion());
        }
    }
}
