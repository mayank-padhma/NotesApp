package com.intern.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.intern.notesapp.data.MyDbHandler;
import com.intern.notesapp.model.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton addNote;
    LinearLayout llheading;
    LinearLayout choosecolor;
    GridLayout gll1;
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    ImageButton btn5;
    ImageButton btn6;
    ImageView bcircle;
    ImageView escreen;
    ImageButton delete;
//    ListView listView;
    RecyclerView recyclerView;
    Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        choosecolor = (LinearLayout)findViewById(R.id.choosecolor);
        llheading = (LinearLayout)findViewById(R.id.llheading);
        addNote = (ImageButton) findViewById(R.id.addnote);
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn6 = (ImageButton) findViewById(R.id.btn6);
        gll1 = (GridLayout)findViewById(R.id.gl1);
        escreen = (ImageView)findViewById(R.id.escreen);
        bcircle = (ImageView)findViewById(R.id.bcircle);
        delete = (ImageButton)findViewById(R.id.delNote);

//        listView = (ListView)findViewById(R.id.listView);
        recyclerView = (RecyclerView)findViewById(R.id.listofnotes);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

//        ArrayList<String> notes = new ArrayList<>();

        MyDbHandler db = new MyDbHandler(MainActivity.this);

//        Note mayank = new Note();
//        mayank.setNote("Hey brah wtf brah, who tf is this cunt");
//        mayank.setTitle("zyzz");
//
//        db.addNote(mayank);

        List<Note> allNotes = db.getAllNotes();
//        for (Note note: allNotes){
//            Log.d("\ndbmayank", "Id : " + note.getId() + "\nTitle : " + note.getTitle() + "\nNote : " + note.getNote());
//            notes.add(note.getTitle() + "--------________---------" + note.getNote());
//
//        }

        adapter = new Adapter(this, allNotes);
        recyclerView.setAdapter(adapter);





//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
//        listView.setAdapter(arrayAdapter);

        if (adapter.getItemCount()!=0){
            recyclerView.setVisibility(View.VISIBLE);
//            listView.setVisibility(View.VISIBLE);
            escreen.setVisibility(View.GONE);
        } else{
//            listView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            escreen.setVisibility(View.VISIBLE);
        }





        //listView

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent1 = new Intent(MainActivity.this, notetext.class);
//                intent1.putExtra("nid", i);
//                startActivity(intent1);
//
//
//            }
//        });

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (llheading.getVisibility()==View.VISIBLE){
                    change1();
                }else{
                    change2();
                }
            }
        });



//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                db.deleteNoteById(note.get);
//            }
//        });
//        bcircle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(delete.getVisibility()==View.GONE){
//                    delete.setVisibility(View.VISIBLE);
//                }else{
//                    delete.setVisibility(View.GONE);
//                }
//            }
//        });



    };
    public void change1(){
        llheading.setVisibility(View.GONE);
        choosecolor.setVisibility(View.VISIBLE);
        //btn listeners for colors

        bListener(btn6, 6);
        bListener(btn1, 1);
        bListener(btn2, 2);
        bListener(btn3, 3);
        bListener(btn4, 4);
        bListener(btn5, 5);


    }

    public void change2(){
        llheading.setVisibility(View.VISIBLE);
        choosecolor.setVisibility(View.GONE);
    }



    public void bListener(ImageButton button, int color){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, notetext.class);
                intent.putExtra("key",color);
                startActivity(intent);
            }
        });
    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        this.finishAffinity();

    }
}