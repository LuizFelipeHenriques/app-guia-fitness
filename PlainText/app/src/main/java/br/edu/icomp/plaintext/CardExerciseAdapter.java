package br.edu.icomp.plaintext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import storage.Exercise;
import storage.ExerciseDAO;

public class CardExerciseAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {

    private Context context;
    private ArrayList<Exercise> exerciseList;
    public ExerciseDAO exerciseDAO;
    private String type;
    public CardExerciseAdapter(Context context, String type) {
        this.context = context;
        this.type = type;
        exerciseDAO = new ExerciseDAO(context);
        update();

    }
    public void update(){
       exerciseList = exerciseDAO.getExercises(type);
        System.err.println(exerciseList);
    }
    public ExerciseViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewtype){
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.list_item, viewgroup, false);
        ExerciseViewHolder exerciseViewHolder = new ExerciseViewHolder(constraintLayout, context);
        return exerciseViewHolder;
    }

    public void onBindViewHolder(ExerciseViewHolder viewHolder, int position) {
        viewHolder.type.setText(exerciseList.get(position).getType());
        viewHolder.date.setText(exerciseList.get(position).getDate());
        viewHolder.firstExercise.setText(exerciseList.get(position).getFirstExercise());
        viewHolder.secondExercise.setText(exerciseList.get(position).getSecondExercise());
        viewHolder.thirdExercise.setText(exerciseList.get(position).getThirdExercise());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleUpdate (exerciseList.get(position).getIdExercise());
            }
        });
    }
    public int getItemCount(){
        return exerciseList.size();

    }

    private void handleUpdate (int id){
         boolean result = exerciseDAO.deleteExercise (id);
        if (result ){
            Toast.makeText(context, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Não deletado", Toast.LENGTH_SHORT).show();
        }
    }

}
