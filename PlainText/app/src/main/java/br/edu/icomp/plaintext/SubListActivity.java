package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import storage.ExerciseDAO;

public class SubListActivity extends AppCompatActivity {
    private String typeRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_list);
        setTitle("         Monte a tabela de treino");
        if (getIntent().hasExtra("type-registro")){
            Bundle extras = getIntent().getExtras();
            typeRegistro = extras.getString("type-registro");
        }



    }
        public void entrarklicando(View view) {

            EditText editText = findViewById(R.id.diasemana);
            EditText editText1 = findViewById(R.id.EX1);
            EditText editText2 = findViewById(R.id.EX2);
            EditText editText3 = findViewById(R.id.EX3);

            ExerciseDAO exerciseDAO = new ExerciseDAO(this);
            boolean result = exerciseDAO.createExercise(typeRegistro,editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText.getText().toString());

         if (result) {
             Toast.makeText(this, "Exercício salvo", Toast.LENGTH_SHORT).show();
         } else {
             Toast.makeText(this, "Não funcionou", Toast.LENGTH_SHORT).show();
         }


    }





}