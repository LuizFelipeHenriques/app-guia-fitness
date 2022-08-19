package br.edu.icomp.plaintext;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("         Bem - vindo ao Guia Fitness");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("O Guia Fit foi desenvolvido em 2022, com o objetivo de uma melhor experiência nos exercícios físicos através da comodidade de sugestão de treinos que o app oferece.")
                        .setNeutralButton("Ok", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    public void entrarClicado(View view) {
//        EditText editText = findViewById(R.id.editlogin1);
//        String login = editText.getText().toString();
//        String msg = "Olá " + login + "!!";
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }

    public void entrarClicado(View view) {
        EditText editText = findViewById(R.id.editlogin1);
        String login = editText.getText().toString();
        String msg = "Olá " + login + "!!";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


}