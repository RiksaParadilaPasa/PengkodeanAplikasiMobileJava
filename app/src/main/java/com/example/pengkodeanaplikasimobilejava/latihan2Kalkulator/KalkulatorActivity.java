package com.example.pengkodeanaplikasimobilejava.latihan2Kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pengkodeanaplikasimobilejava.MainActivity;
import com.example.pengkodeanaplikasimobilejava.R;
import com.example.pengkodeanaplikasimobilejava.TugasTerstruktur.KalkulatorsActivity;
import com.example.pengkodeanaplikasimobilejava.TugasTerstruktur.KonversiSuhu;
import com.example.pengkodeanaplikasimobilejava.latihan1MenghitungLuas.HitungLuasActivity;

public class KalkulatorActivity extends AppCompatActivity implements View.OnClickListener{

    EditText vTxtA, vTxtB, vTxtC;
    float yTxtA,yTxtB,yTxtC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        vTxtA = (EditText) findViewById(R.id.txtA);
        vTxtB = (EditText) findViewById(R.id.txtB);
        vTxtC =(EditText) findViewById(R.id.txtC);
        Button vBtnTambah = (Button) findViewById(R.id.btnTambah);
        Button vBtnKurang = (Button) findViewById(R.id.btnKurang);
        Button vBtnKali = (Button) findViewById(R.id.btnKali);
        Button vBtnBagi = (Button) findViewById(R.id.btnBagi);

        vBtnTambah.setOnClickListener(this);
        vBtnKurang.setOnClickListener(this);
        vBtnKali.setOnClickListener(this);

        vBtnBagi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        yTxtA = Float.parseFloat(vTxtA.getText().toString());
        yTxtB = Float.parseFloat(vTxtB.getText().toString());
        switch (v.getId()) {
            case R.id.btnTambah:
                yTxtC = yTxtA + yTxtB;
                vTxtC.setText(Float.toString(yTxtC));
                break;
            case R.id.btnKurang:
                yTxtC = yTxtA - yTxtB;
                vTxtC.setText(Float.toString(yTxtC));
                break;
            case R.id.btnKali:
                yTxtC = yTxtA * yTxtB;
                vTxtC.setText(Float.toString(yTxtC));
                break;
            case R.id.btnBagi:
                yTxtC = yTxtA / yTxtB;
                vTxtC.setText(Float.toString(yTxtC));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_luas:
                Intent intent = new Intent(getApplicationContext(), HitungLuasActivity.class);
                startActivity(intent);
                break;
            case R.id.item_suhu:
                Intent inten = new Intent(getApplicationContext(), KonversiSuhu.class);
                startActivity(inten);
                break;
            case R.id.item_cal:
                Intent inte = new Intent(getApplicationContext(), KalkulatorActivity.class);
                startActivity(inte);
                break;
            case R.id.item_cals:
                Intent into = new Intent(getApplicationContext(), KalkulatorsActivity.class);
                startActivity(into);
                break;
            case R.id.item_nama:
                Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intento);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    }






