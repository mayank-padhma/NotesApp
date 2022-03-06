package com.intern.notesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.intern.notesapp.data.MyDbHandler;
import com.intern.notesapp.model.Note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class notetext extends AppCompatActivity {

    RelativeLayout relativeLayout;
    ImageButton back;
    ImageButton addImage;
    LinearLayout llv1;
    LinearLayout llv2;
    ImageButton textStyle;
    ImageButton addText;
    EditText finalText;
    EditText writeHere;
    ImageButton colors;
    HorizontalScrollView sv1;
    TextView clrText;
    ImageButton cbutton1;
    ImageButton cbutton2;
    ImageButton cbutton3;
    ImageButton cbutton4;
    ImageButton cbutton5;
    ImageButton cbutton6;
    ImageButton cbutton7;
    ImageButton cbutton8;
    ImageButton cbutton9;
    ImageButton cbutton10;
    ImageButton cbutton11;
    ImageButton cbutton12;
    ImageButton cbutton13;
    ImageButton cbutton14;
    ImageButton cbutton15;
    ImageButton cbutton16;
    ImageButton delete;
    ImageButton mic;
//    ImageButton camera;
//    ImageButton gallery;
    ImageButton save;
    LinearLayout ll1;
    ImageButton deleteimage;
//    private static final int REQUEST_CODE_SPEECH_INPUT = 100;
//    private static final int SELECT_IMAGE_CODE = 1;
    protected static final int RESULT_SPEECH = 1;

    String backClr;

    ImageView imageView;
    GridLayout gl1;


//    ImageButton undo;
//    String originalText = null;
//    Boolean undostate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notetext);
        relativeLayout = (RelativeLayout) findViewById(R.id.relay1);
        back = (ImageButton)findViewById(R.id.back);
//        addImage = (ImageButton)findViewById(R.id.addimage);
//        llv1 = (LinearLayout)findViewById(R.id.llv1);
        ll1 = (LinearLayout)findViewById(R.id.ll1);
        llv2 = (LinearLayout)findViewById(R.id.llv2);
        textStyle = (ImageButton)findViewById(R.id.textstyle);
        addText = (ImageButton)findViewById(R.id.addtext);
        finalText = (EditText)findViewById(R.id.finaltext);
        writeHere = (EditText)findViewById(R.id.writehere);
        mic = (ImageButton)findViewById(R.id.mic);
//        camera = (ImageButton)findViewById(R.id.camera);
//        gallery = (ImageButton)findViewById(R.id.gallery);
        colors = (ImageButton)findViewById(R.id.colors);
        sv1 = (HorizontalScrollView) findViewById(R.id.sv1);
        clrText = (TextView)findViewById(R.id.clrText);
        cbutton1 = (ImageButton) findViewById(R.id.clr1);
        cbutton2 = (ImageButton) findViewById(R.id.clr2);
        cbutton3 = (ImageButton) findViewById(R.id.clr3);
        cbutton4 = (ImageButton) findViewById(R.id.clr4);
        cbutton5 = (ImageButton) findViewById(R.id.clr5);
        cbutton6 = (ImageButton) findViewById(R.id.clr6);
        cbutton7 = (ImageButton) findViewById(R.id.clr7);
        cbutton8 = (ImageButton) findViewById(R.id.clr8);
        cbutton9 = (ImageButton) findViewById(R.id.clr9);
        cbutton10 = (ImageButton) findViewById(R.id.clr10);
        cbutton11 = (ImageButton) findViewById(R.id.clr11);
        cbutton12 = (ImageButton) findViewById(R.id.clr12);
        cbutton13 = (ImageButton) findViewById(R.id.clr13);
        cbutton14 = (ImageButton) findViewById(R.id.clr14);
        cbutton15 = (ImageButton) findViewById(R.id.clr15);
        cbutton16 = (ImageButton) findViewById(R.id.clr16);
        delete = (ImageButton) findViewById(R.id.delete);
        imageView = (ImageView)findViewById(R.id.imageView);
        deleteimage = (ImageButton) findViewById(R.id.deleteimage);
        save = (ImageButton) findViewById(R.id.save);
//        undo = (ImageButton) findViewById(R.id.undo);

        //finalText undo
//        finalText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if(i==KeyEvent.KEYCODE_DEL){
//                    if(undostate == false){
//                        originalText = finalText.getText().toString().trim();
//                        undostate = true;
//                    }
//                }
//                return false;
//            }
//        });




        startType(finalText);
        startType(writeHere);



        //********************************************************//


        //db handler

        MyDbHandler db = new MyDbHandler(notetext.this);



        //update note
//        mayank2.setId(16);
//        mayank2.setTitle("Huishh");
//        mayank2.setNote("Huishh sdfjl sudk dkd f sdfhksdf sdfkjhhsdf");
//
//        int affectedRows = db.noteUpdate(mayank2);

//        Log.d("dbMayank", "No. of affected rows are " + affectedRows);
//        db.deleteNoteById(4);
//        db.deleteNoteById(5);
//        db.deleteNoteById(6);
//        db.deleteNoteById(8);

        //get all notes




//        List<Note> allNotes = db.getAllNotes();
//        for (Note note: allNotes){
//            Log.d("\ndbmayank", "Id : " + note.getId() + "\nTitle : " + note.getTitle() + "\nNote : " + note.getNote());
//           notes.add(note.getTitle() + "--------________---------" + note.getNote());
//        }
//        Log.d("dbmayank", "bro you have " + db.getCount() + " notes in your database");


//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
//        listView.setAdapter(arrayAdapter);





        //********************************************************//



        int nn = getIntent().getIntExtra("nid",-1);
        Note note = new Note();
        if (nn!= -1){
            note = db.getFullNote(nn);
        }
        int noteid = note.getId();





        if(nn != -1) {
            finalText.setVisibility(View.VISIBLE);
            finalText.setText(note.getNote());
            writeHere.setText(note.getTitle());
            relativeLayout.setBackgroundColor(Color.parseColor(note.getColor()));

        }

// intent
        Integer key = getIntent().getIntExtra("key",0);
        if(key == 1){
            backClr = "#ff588a";
            relativeLayout.setBackgroundColor(Color.parseColor("#ff588a"));
        }else if(key == 2){
            relativeLayout.setBackgroundColor(Color.parseColor("#7958ff"));
            backClr = "#7958ff";
        }else if(key == 3){
            backClr = "#24da6d";
            relativeLayout.setBackgroundColor(Color.parseColor("#24da6d"));
        }else if(key == 4){
            backClr = "#ffc158";
            relativeLayout.setBackgroundColor(Color.parseColor("#ffc158"));
        }else if(key == 5){
            backClr = "#ff5858";
            relativeLayout.setBackgroundColor(Color.parseColor("#ff5858"));
        }else if(key == 6){
            backClr = "#01bff9";
            relativeLayout.setBackgroundColor(Color.parseColor("#01bff9"));
        }

        //back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //addimage
//        addImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                llv2.setVisibility(View.GONE);
//                if(llv1.getVisibility()==View.GONE){
//                    llv1.setVisibility(View.VISIBLE);
//                }else{
//                    llv1.setVisibility(View.GONE);
//                }
//            }
//        });

        //textStyle
        textStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                llv1.setVisibility(View.GONE);
                sv1.setVisibility(View.GONE);
                if(llv2.getVisibility()==View.GONE){
                    llv2.setVisibility(View.VISIBLE);
                }else{
                    llv2.setVisibility(View.GONE);
                }
            }
        });

        //addtext

        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalText.setVisibility(View.VISIBLE);
                sv1.setVisibility(View.GONE);
            }
        });


        writeHere.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
                llv2.setVisibility(View.GONE);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });


        finalText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
                llv2.setVisibility(View.GONE);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //  TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        //colors
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv1.setVisibility(View.VISIBLE);
                clrText.setTextColor(Color.parseColor("#000000"));

            }
        });

        //colors selection


        textColorSet(cbutton1, "#ffffff");
        textColorSet(cbutton2, "#000000");
        textColorSet(cbutton3, "#797573");
        textColorSet(cbutton4, "#7b57ff");
        textColorSet(cbutton5, "#ff1f62");
        textColorSet(cbutton6, "#f10f0d");
        textColorSet(cbutton7, "#94ff0d");
        textColorSet(cbutton8, "#ffe506");
        textColorSet(cbutton9, "#1dfec1");
        textColorSet(cbutton10, "#064fb1");
        textColorSet(cbutton11, "#6f00ff");
        textColorSet(cbutton12, "#fd05b6");
        textColorSet(cbutton13, "#208b08");
        textColorSet(cbutton14, "#99e7fe");
        textColorSet(cbutton15, "#f9698c");
        textColorSet(cbutton16, "#bbb1af");

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalText.setText(null);
                writeHere.setText(null);
            }
        });

        //undo
//        undo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finalText.setText(originalText);
//            }
//        });



        //camera



//        gallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent1 = new Intent();
//                intent1.setType("image/*");
//                intent1.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent1, SELECT_IMAGE_CODE);
//            }
//        });
//
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(ContextCompat.checkSelfPermission(notetext.this,
//                        Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(notetext.this,new String[]{Manifest.permission.CAMERA},100);
//                }
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, 100);
//
//            }
//        });
//        deleteimage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imageView.setImageBitmap(null);
//                gl1.setVisibility(View.GONE);
//            }
//        });

        //save
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date());

                Note newNote = new Note();
                Intent intent = new Intent(notetext.this, MainActivity.class);

                String wh = writeHere.getText().toString();
                String fs = finalText.getText().toString();


                if (nn != -1){ //update
                    if (wh.matches("") && fs.matches("")){
                        db.deleteNoteById(noteid);
                    }else{
                        newNote.setId(noteid);
                        newNote.setTitle(writeHere.getText().toString());
                        newNote.setNote(finalText.getText().toString());
                        newNote.setDate(date);
                        int affectedRows = db.noteUpdate(newNote);
                    }
                    startActivity(intent);


                }else{ //add new

                    newNote.setNote(finalText.getText().toString());
                    newNote.setTitle(writeHere.getText().toString());
                    newNote.setDate(date);
                    newNote.setColor(backClr);
                    if (wh.matches("") && fs.matches("")){
                        Toast.makeText(notetext.this, "Empty Note can't be saved", Toast.LENGTH_LONG).show();
                    }else{
                    db.addNote(newNote);
                    startActivity(intent);
                    }
                }



            }
        });


    }

    public void textColorSet(ImageButton button, String clr){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalText.setTextColor(Color.parseColor(clr));
                writeHere.setTextColor(Color.parseColor(clr));
            }
        });
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//                        if (requestCode == 100) {
//                            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
//                            imageView.setImageBitmap(bitmap2);
//                            gl1.setVisibility(View.VISIBLE);
//                        }
//                        if (requestCode == 1){
//                            Uri uri = data.getData();
//                            imageView.setImageURI(uri);
//                            gl1.setVisibility(View.VISIBLE);
//
//                        }
//
//
//    }
    public void startType(EditText editText){

    editText.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            llv2.setVisibility(View.GONE);
            return false;
        }
    });

    }

    public void getSpeechInput(View view){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        try {            startActivityForResult(intent, RESULT_SPEECH);
            finalText.setVisibility(View.VISIBLE);
        } catch (ActivityNotFoundException e){
            Toast.makeText(notetext.this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_SPEECH: if (resultCode == RESULT_OK && data!=null){
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                if (finalText.getText().toString().equals(""))
                    finalText.append(result.get(0));
                else
                finalText.append(" "+result.get(0));
            }
            break;
        }
    }
}