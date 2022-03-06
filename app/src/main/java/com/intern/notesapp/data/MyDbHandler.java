package com.intern.notesapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.intern.notesapp.model.Note;
import com.intern.notesapp.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "(" + Params.KEY_ID +
                " INTEGER PRIMARY KEY," + Params.KEY_TITLE + " TEXT," + Params.KEY_NOTE + " TEXT,"
                + Params.KEY_DATE + " TEXT," + Params.KEY_COLOR + " TEXT" + ")";

        Log.d("query runned" , create);
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, note.getTitle());
        values.put(Params.KEY_NOTE, note.getNote());
        values.put(Params.KEY_DATE, note.getDate());
        values.put(Params.KEY_COLOR, note.getColor());

        db.insert(Params.TABLE_NAME, null, values);
        Log.d("msg", "successfully inserted " + note.getTitle());
        db.close();
    }

    public List<Note> getAllNotes(){
        List<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //generate query to read from database

        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst())
            do {
                Note note = new Note();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setNote(cursor.getString(2));
                note.setDate(cursor.getString(3));
                note.setColor(cursor.getString(4));
                noteList.add(note);
            }while(cursor.moveToNext());

        return noteList;

    }

    public Note getFullNote(int i){
        Note note = new Note();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        cursor.moveToFirst();
            for (int j = 0 ; j<i ; j++){
            cursor.moveToNext();
        }

        note.setId(Integer.parseInt(cursor.getString(0)));
        note.setTitle(cursor.getString(1));
        note.setNote(cursor.getString(2));
        note.setDate(cursor.getString(3));
        note.setColor(cursor.getString(4));
        return note;
    }

    public int noteUpdate(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, note.getTitle());
        values.put(Params.KEY_NOTE, note.getNote());
        values.put(Params.KEY_DATE, note.getDate());

        //lets update
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?", new String[]{String.valueOf(note.getId())});

    }

    public void deleteNoteById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID + "=?", new String[]{String.valueOf(note.getId())});
        db.close();
    }

    public int getCount(){
        String query = "SELECT * FROM " + Params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }

}
