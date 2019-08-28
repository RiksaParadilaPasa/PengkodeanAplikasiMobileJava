package com.example.pengkodeanaplikasimobilejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pengkodeanaplikasimobilejava.TugasTerstruktur.KalkulatorsActivity;
import com.example.pengkodeanaplikasimobilejava.TugasTerstruktur.KonversiSuhu;
import com.example.pengkodeanaplikasimobilejava.latihan1MenghitungLuas.HitungLuasActivity;
import com.example.pengkodeanaplikasimobilejava.latihan2Kalkulator.KalkulatorActivity;

public class MainActivity extends AppCompatActivity {

    EditText namaDepan, namaBelakang;
    TextView txtOutput;
    Button btnTampill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaDepan = (EditText)findViewById(R.id.txtNamaDepan);
        namaBelakang = (EditText)findViewById(R.id.txtNamaBelakang);
        txtOutput = (TextView)findViewById(R.id.txtOutput);
        btnTampill = (Button)findViewById(R.id.btnTampil);

        btnTampill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nmDepan = namaDepan.getText().toString();
                String nmBelakang = namaBelakang.getText().toString();
                String output = nmDepan + nmBelakang;

                txtOutput.setText(output);
            }
        });

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
