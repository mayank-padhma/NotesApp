package com.intern.notesapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.notesapp.data.MyDbHandler;
import com.intern.notesapp.model.Note;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
//    LayoutInflater inflater;
    List<Note> notes;

    public Adapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;

    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = inflater.inflate(R.layout.noteshow, viewGroup, false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noteshow, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {
        Note note = notes.get(i);
        viewHolder.nTitle.setText(note.getTitle());
        viewHolder.nNote.setText(note.getNote());
        viewHolder.nDate.setText(note.getDate());
        viewHolder.cardView.setCardBackgroundColor(Color.parseColor(note.getColor()));
        viewHolder.bcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewHolder.delNote.getVisibility()==View.GONE){
                    viewHolder.delNote.setVisibility(View.VISIBLE);
                }else{
                    viewHolder.delNote.setVisibility(View.GONE);
                }
            }
        });



        viewHolder.delNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "clicked bruh!", Toast.LENGTH_SHORT).show();
                MyDbHandler db = new MyDbHandler(context);
                Note note = new Note();
                int pos = viewHolder.getAdapterPosition();
                note = db.getFullNote(pos);
                int noteid = note.getId();
                db.deleteNoteById(noteid);
                notes.remove(pos);
                notifyItemRemoved(pos);
            }
        });

    }


    @Override
    public int getItemCount() {
        return notes.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nTitle, nNote, nDate;
        public ImageView bcircle;
        public ImageButton delNote;
        public CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nTitle = itemView.findViewById(R.id.tileN);
            nNote = itemView.findViewById(R.id.noteText);
            nDate = itemView.findViewById(R.id.dateto);
            bcircle = itemView.findViewById(R.id.bcircle);
            delNote = itemView.findViewById(R.id.delNote);
            cardView = itemView.findViewById(R.id.cardview);
        }
        @Override
        public void onClick(View view){
            int position = this.getAdapterPosition();
            Intent intent1 = new Intent(context, notetext.class);
                intent1.putExtra("nid", position);
                context.startActivity(intent1);
//
        }
    }



}
