package com.example.mynoteapp;

import android.content.Context;
import android.service.autofill.TextValueSanitizer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynoteapp.Entities.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private List<Note>notes_list;
    private NoteListener noteListener;

    public NotesAdapter(List<Note> notes_list, NoteListener noteListenerl) {
        this.notes_list = notes_list;
        this.noteListener = noteListener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_view,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, final int position) {
        holder.setNote(notes_list.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteListener.onItemClick(notes_list.get(position),position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notes_list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtDate,txtNoteText;
        CardView cardView;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txt_note_title);
            txtDate=itemView.findViewById(R.id.txt_date);
            txtNoteText=itemView.findViewById(R.id.txt_note_text);
            cardView=itemView.findViewById(R.id.card_view);


        }
        void setNote(Note note){
            txtNoteText.setText(note.getNoteText());
            txtDate.setText(note.getDateTime());
            txtTitle.setText(note.getTitle());
        }
    }
}
