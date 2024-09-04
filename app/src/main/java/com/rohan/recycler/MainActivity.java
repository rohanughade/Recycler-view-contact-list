package com.rohan.recycler;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<contactModel> arrCon = new ArrayList<>();
    adapter adapter;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FloatingActionButton dialog = findViewById(R.id.floating);

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dailog_box);
                EditText nmae,number;
                nmae = dialog.findViewById(R.id.name);
                number = dialog.findViewById(R.id.number);
                Button btn = dialog.findViewById(R.id.btn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",num="";
                        if (!nmae.getText().toString().isEmpty()){
                            name = nmae.getText().toString();

                        }else {
                            Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!number.getText().toString().isEmpty()){
                            num = number.getText().toString();

                        }else {
                            Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                        }

                        arrCon.add(new contactModel(R.drawable.a,name,num));
                        adapter.notifyItemInserted(arrCon.size()-1);
                        recycler.scrollToPosition(arrCon.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

         recycler = findViewById(R.id.contact);


        arrCon.add(new contactModel(R.drawable.a,"a","987654321"));
        arrCon.add(new contactModel(R.drawable.b,"b","987654321"));
        arrCon.add(new contactModel(R.drawable.c,"c","987654321"));
        arrCon.add(new contactModel(R.drawable.d,"d","987654321"));
        arrCon.add(new contactModel(R.drawable.e,"e","987654321"));
        arrCon.add(new contactModel(R.drawable.f,"f","987654321"));
        arrCon.add(new contactModel(R.drawable.g,"g","987654321"));
        arrCon.add(new contactModel(R.drawable.h,"h","987654321"));
        arrCon.add(new contactModel(R.drawable.i,"i","987654321"));
        arrCon.add(new contactModel(R.drawable.a,"j","987654321"));
        arrCon.add(new contactModel(R.drawable.b,"k","987654321"));
        arrCon.add(new contactModel(R.drawable.c,"l","987654321"));
        arrCon.add(new contactModel(R.drawable.d,"m","987654321"));
        arrCon.add(new contactModel(R.drawable.e,"n","987654321"));
        arrCon.add(new contactModel(R.drawable.f,"o","987654321"));
        arrCon.add(new contactModel(R.drawable.g,"p","987654321"));
        arrCon.add(new contactModel(R.drawable.h,"q","987654321"));
        arrCon.add(new contactModel(R.drawable.i,"r","987654321"));

         adapter= new adapter(this,arrCon);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setAdapter(adapter);



    }
}