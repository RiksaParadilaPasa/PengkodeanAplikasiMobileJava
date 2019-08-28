package com.example.pengkodeanaplikasimobilejava.TugasTerstruktur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pengkodeanaplikasimobilejava.MainActivity;
import com.example.pengkodeanaplikasimobilejava.R;
import com.example.pengkodeanaplikasimobilejava.latihan1MenghitungLuas.HitungLuasActivity;
import com.example.pengkodeanaplikasimobilejava.latihan2Kalkulator.KalkulatorActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class KalkulatorsActivity extends AppCompatActivity {

    // inisialisasi button angka
    private int[] numericButtons = {R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine};
    // inisialisasi operasi mtk
    private int[] operatorButtons = {R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide};
    // TextView hasil
    private TextView txtScreen;
    // boolean angka terakhir angka atau tidak
    private boolean lastNumeric;
    // boolean kondisi benar salah
    private boolean stateError;
    // buat koma
    private boolean lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulators);


        this.txtScreen = (TextView) findViewById(R.id.txtScreen);

        setNumericOnClickListener();

        setOperatorOnClickListener();

    }

    /**
     * untuk button angka
     */
    private void setNumericOnClickListener() {
        // membuat agar bisa klik klik
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mengatur tombol yg di klik
                Button button = (Button) v;
                if (stateError) {
                    // jika salah tidak bisa ngeklik
                    txtScreen.setText(button.getText());
                    stateError = false;
                } else {
                    // jika benar ya bisa
                    txtScreen.append(button.getText());
                }
                // boolean angka terakhir
                lastNumeric = true;
            }
        };
        // untuk inisialisasi button jika di klik angka 1 maka keluar angka 1
        for (int id : numericButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }


    /**
     * untuk button selain angka
     */
    private void setOperatorOnClickListener() {
        // membuat agar bisa klik klik
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Jika angka terakhir bukan angka error
                // jika angka sebaliknya
                if (lastNumeric && !stateError) {
                    Button button = (Button) v;
                    txtScreen.append(button.getText());
                    lastNumeric = false;
                    lastDot = false;
                }
            }
        };
        // ntuk inisialisasi button jika di klik operator tambah maka keluar tambah
        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
        // ini untuk koma
        findViewById(R.id.btnDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastNumeric && !stateError && !lastDot) {
                    txtScreen.append(".");
                    lastNumeric = false;
                    lastDot = true;
                }
            }
        });
        // Clear button
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtScreen.setText("");

                //default
                lastNumeric = false;
                stateError = false;
                lastDot = false;
            }
        });
        // Equal button
        findViewById(R.id.btnEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqual();
            }
        });
    }


    private void onEqual() {
        // Jika error tidak terjadi apa apa
        // jika lastnumber maka bisa dijalankan
        if (lastNumeric && !stateError) {

            String txt = txtScreen.getText().toString();

            // memanggil library mtk
            Expression expression = new ExpressionBuilder(txt).build();
            try {
                // hitung
                double result = expression.evaluate();
                txtScreen.setText(Double.toString(result));
                lastDot = true;
            } catch (ArithmeticException ex) {
                txtScreen.setText("Error");
                stateError = true;
                lastNumeric = false;
            }
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
