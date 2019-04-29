package com.example.vidown;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText linkInst;
    private Button paste, download;
    //private ButtonBarLayout;



    // МЕНЮ навигации

    public void BottomNavigationView (){

    }

    // Элементы главного экрана

    public void addListenerOnButton (){

        // поле свтавки сслыки из инстаграма
        linkInst =(EditText)findViewById(R.id.linkInst);


// кнопка ВСТАВИТЬ ССЛЫКУ
        paste = (Button)findViewById(R.id.pastelink);
        paste.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        paste.setText("link pasted");
                        Toast.makeText(
                                MainActivity.this, "link inserted",
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
// кнопка DOWNLOAD
        download = (Button)findViewById(R.id.download);
        download.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder downLoadAlertBuild = new AlertDialog.Builder(MainActivity.this);
                        downLoadAlertBuild.setMessage("Want download video on High Speed")
                                .setCancelable(false)
                                .setPositiveButton("watch video ads for activate high speed", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

// переделать в конопку, добавить рекламоу и переход на загрузки
                                        dialog.cancel();


                                    }
                                })
                                //
                                .setNegativeButton("Download slowly", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

// "медленая загрузка" дклать тулбар и преход на загрузку
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog downLoadAlert = downLoadAlertBuild.create();
                        //downLoadAlert.setTitle("Want download video on High Speed");
                        downLoadAlert.show();

                        Toast.makeText(
                                MainActivity.this, "Download Started",
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                        Intent intent = new Intent("android.intent.action.MAIN");
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Link", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorites:

                        Toast.makeText(MainActivity.this, "Instagram", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_nearby:
                        Intent intent3 = new Intent(".History");
                        startActivity(intent3);
                        Toast.makeText(MainActivity.this, "History", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });





        addListenerOnButton();
    }
}
