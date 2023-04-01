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

        recyclerView = (RecyclerView)findViewById(R.id.listofnotes);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        MyDbHandler db = new MyDbHandler(MainActivity.this);

        List<Note> allNotes = db.getAllNotes();
        Log.d("asdfasdf", allNotes.toString());

        adapter = new Adapter(this, allNotes);
        recyclerView.setAdapter(adapter);


        if (adapter.getItemCount()!=0){
            recyclerView.setVisibility(View.VISIBLE);
            escreen.setVisibility(View.GONE);
        } else{
            recyclerView.setVisibility(View.GONE);
            escreen.setVisibility(View.VISIBLE);
        }


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
    }
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


    @Override
    public void onBackPressed() {
        this.finishAffinity();

    }
}