package com.example.mynoteapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mynoteapp.Dao.NoteDao;
import com.example.mynoteapp.Entities.Note;

@Database(entities = Note.class,version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
        private static NoteDatabase noteDatabase;
        public synchronized NoteDatabase getDatabase(Context context){
            if(noteDatabase==null){
                noteDatabase=Room.databaseBuilder(
                        context,
                        NoteDatabase.class,
                        "notes_db"
                ).build();
            }
            return noteDatabase;

        }
        public abstract NoteDao noteDao();
    }


