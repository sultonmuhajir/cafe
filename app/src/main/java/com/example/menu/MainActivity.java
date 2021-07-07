package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton cappucino, latte, espresso, mocha;
    TextView total, jumlah, kembalian;
    EditText bayar;
    Button tombolBayar;
    int mCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cappucino = findViewById(R.id.cappucino);
        latte = findViewById(R.id.latte);
        espresso = findViewById(R.id.espresso);
        mocha = findViewById(R.id.mocha);
        total = findViewById(R.id.total);
        jumlah = findViewById(R.id.jumlah);
        kembalian = findViewById(R.id.kembalian);
        bayar = findViewById(R.id.bayar);
        tombolBayar = findViewById(R.id.tombolBayar);
    }

    public void minJumlah(View view) {
        if (mCount > 1) {
            mCount--;
        }
        jumlah.setText(String.valueOf(mCount));
    }

    public void plusJumlah(View view) {
        mCount++;
        jumlah.setText(String.valueOf(mCount));
    }

    public void orderOnClick(View view) {
        int valJumlah = Integer.parseInt(jumlah.getText().toString());
        tombolBayar.setEnabled(true);
        bayar.setEnabled(true);
        if (cappucino.isChecked()) {
            total.setText(9000 * valJumlah+"");
        } else if (latte.isChecked()) {
            total.setText(7000 * valJumlah+"");
        } else if (espresso.isChecked()) {
            total.setText(8000 * valJumlah+"");
        } else if (mocha.isChecked()) {
            total.setText(7000 * valJumlah+"");
        } else {
            Toast.makeText(this, "Anda Belum Memilih Menu", Toast.LENGTH_SHORT).show();
            tombolBayar.setEnabled(false);
            bayar.setEnabled(false);
        }
    }

    public void bayarOnClick(View view) {
        if (bayar.getText().toString().length() <= 0) {
            Toast.makeText(this, "Anda Belum Bayar", Toast.LENGTH_SHORT).show();
        } else {
            int valBayar = Integer.parseInt(bayar.getText().toString());
            int valTotal = Integer.parseInt(total.getText().toString());
            if (valBayar == valTotal) {
                kembalian.setText("Uang Anda Pas, Terima Kasih");
            } else if (valBayar > valTotal) {
                int sisa = valBayar - valTotal;
                kembalian.setText("Kembalian : Rp."+sisa);
            } else if (valBayar < valTotal) {
                int min = valTotal - valBayar;
                kembalian.setText("Uang Anda Kurang Rp."+min);
            }
        }
    }

    public void menuOnClick(View view) {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }
}