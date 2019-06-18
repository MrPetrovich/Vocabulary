package com.example.vocabulary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vocabulary.App;
import com.example.vocabulary.R;
import com.example.vocabulary.database.AppDatabase;
import com.example.vocabulary.entity.Word;

public class AddWordActivity extends AppCompatActivity {

    private EditText wordEditText;
    private EditText translateEditText;
    private Button saveButton;

    private AppDatabase appDatabase = App.getAppDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        wordEditText = findViewById(R.id.word_edit_text);
        translateEditText = findViewById(R.id.translate_edit_text);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wordEng = wordEditText.getText().toString();
                String translate = translateEditText.getText().toString();
                //Toast.makeText(AddWordActivity.this, msg, Toast.LENGTH_SHORT).show();
                Word word = new Word(wordEng, translate);
                saveToDatabase(word);
            }
        });
    }

    private void saveToDatabase(final Word word){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.getWordDao().insert(word);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                setResult(RESULT_OK);
                finish();
            }
        }.execute();
    }
}