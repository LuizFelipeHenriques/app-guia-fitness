package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class showExerciseActivity2 extends AppCompatActivity {
    private CardExerciseAdapter cardExerciseAdapter;
    private RecyclerView recyclerView;
    private String typeRender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_exercise2);
        setTitle(                      "Exercícios Cadastrados");

        if (getIntent().hasExtra("type-render")){
            Bundle extras = getIntent().getExtras();
            typeRender = extras.getString("type-render");
        }
        recyclerView = findViewById(R.id.recyclerExercise);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (!typeRender.isEmpty()){
            cardExerciseAdapter = new CardExerciseAdapter(this, typeRender);
            recyclerView.setAdapter(cardExerciseAdapter);
        }


    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        cardExerciseAdapter.update();
    }

    public void addExercise(View view){
        if (!typeRender.isEmpty()){
            Intent intent = new Intent(this, SubListActivity.class);
            intent.putExtra("type-registro",typeRender);
            startActivity(intent);
        }

    }

}