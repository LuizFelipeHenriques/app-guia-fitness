package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

    setTitle("Grupos Musculares");


    }


        public void entrarClicandoOmbros(View view) {


        Intent intent = new Intent(this, showExerciseActivity2.class);
        intent.putExtra("type-render","OMBROS");
            startActivity(intent);

    }
    public void entrarClicandoCostas(View view) {


        Intent intent = new Intent(this, showExerciseActivity2.class);
        intent.putExtra("type-render","COSTAS");
        startActivity(intent);

    }
    public void entrarClicandoPeito(View view) {


        Intent intent = new Intent(this, showExerciseActivity2.class);
        intent.putExtra("type-render","PEITO");
        startActivity(intent);

    }


}