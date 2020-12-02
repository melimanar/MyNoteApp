package com.example.mynoteapp;

import com.example.mynoteapp.Entities.Note;

public interface NoteListener {
    void onItemClick(Note note, int position);
}
