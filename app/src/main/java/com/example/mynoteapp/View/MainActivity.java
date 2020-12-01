package com.example.mynoteapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynoteapp.R;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ADD_NOTE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void floatingButtonClick(View view){
    startActivityForResult(new Intent(this,NoteWriteActivity.class),REQUEST_CODE_ADD_NOTE);
    }
}
