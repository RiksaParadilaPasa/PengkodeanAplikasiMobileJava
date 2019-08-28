package com.example.pengkodeanaplikasimobilejava.TugasTerstruktur;

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
import com.example.pengkodeanaplikasimobilejava.latihan1MenghitungLuas.HitungLuasActivity;
import com.example.pengkodeanaplikasimobilejava.latihan2Kalkulator.KalkulatorActivity;

public class KonversiSuhu extends AppCompatActivity {

    EditText cel,kel,fah,rea;
    Button btnKonvers,btnclears;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi_suhu);

        cel = (EditText)findViewById(R.id.et_celcius);
        kel = (EditText)findViewById(R.id.et_kelvin);
        fah = (EditText)findViewById(R.id.et_fahrenheit);
        rea = (EditText)findViewById(R.id.et_reamur);

        btnKonvers = (Button)findViewById(R.id.btn_konversi);
        btnclears = (Button)findViewById(R.id.btn_clear);


        btnKonvers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celcius = cel.getText().toString();
                String kelvin = kel.getText().toString();
                String fahrenheit = fah.getText().toString();
                String reamur = rea.getText().toString();


                    Double c = Double.parseDouble(celcius);

                    Double c_k = c*273.15;
                    Double c_f = c*1.8+32;
                    Double c_r = c*0.8;

                    kel.setText(String.valueOf(c_k));
                    fah.setText(String.valueOf(c_f));
                    rea.setText(String.valueOf(c_r));


//                 else if (kel != null){
//                    Double k = Double.parseDouble(kelvin);
//
//                    Double k_c = k-273.15;
//                    Double k_f = k*1.8-259.67;
//                    Double k_r = (k-273.15)*0.8;
//
//                    cel.setText(String.valueOf(k_c));
//                    fah.setText(String.valueOf(k_f));
//                    rea.setText(String.valueOf(k_r));
//                }
//
//                else if (fah != null){
//                    Double f = Double.parseDouble(fahrenheit);
//
//                    Double f_k = (f+459.67)/1.8;
//                    Double f_c = (f-320)/1.8;
//                    Double f_r = (f-320)/0.44;
//
//                    kel.setText(String.valueOf(f_k));
//                    cel.setText(String.valueOf(f_c));
//                    rea.setText(String.valueOf(f_r));
//                }
//
//                else if (rea != null){
//                    Double r = Double.parseDouble(reamur);
//
//                    Double r_k = r/0.8+273.15;
//                    Double r_f = r*2.25+32;
//                    Double r_c = r/0.8;
//
//                    kel.setText(String.valueOf(r_k));
//                    fah.setText(String.valueOf(r_f));
//                    cel.setText(String.valueOf(r_c));
//                }
//





            }
        });


        btnclears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel.setText("0");
                fah.setText("0");
                rea.setText("0");
                kel.setText("0");
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
