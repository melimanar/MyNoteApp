package com.example.mynoteapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mynoteapp.Database.NoteDatabase;
import com.example.mynoteapp.Entities.Note;
import com.example.mynoteapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteWriteActivity extends AppCompatActivity {
    EditText edtTitle,edtNoteText;
    TextView txtTitle,txtDateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_write);

        edtTitle=findViewById(R.id.edt_title);
        edtNoteText=findViewById(R.id.edt_noteText);
        txtTitle=findViewById(R.id.text_title);
        txtDateTime=findViewById(R.id.txt_date);

        txtDateTime.setText(
                new SimpleDateFormat("EEEE,dd MMM yyyy HH:mm a",
                        Locale.getDefault()).format(new Date())
        );



    }
    public void saveOnClick(View view){
        saveNote();
    }

    private void saveNote(){
        if(edtTitle.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this,"Empyt title",Toast.LENGTH_SHORT).show();
        }
        else if(edtNoteText.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this,"Empty Note Text",Toast.LENGTH_SHORT).show();
        }
        final Note note=new Note();
        note.setTitle(edtTitle.getText().toString());
        note.setNoteText(edtNoteText.getText().toString());
        note.setDateTime(txtDateTime.getText().toString());

        class SaveNoteTask extends AsyncTask<Void,Void,Void>{
            @Override
            protected Void doInBackground(Void... voids) {
                NoteDatabase.getDatabase(getApplicationContext()).noteDao().insertNote(note);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        }
        new SaveNoteTask().execute();
    }
}
