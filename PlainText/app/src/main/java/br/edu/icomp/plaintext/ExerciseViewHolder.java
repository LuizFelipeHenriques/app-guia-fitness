package br.edu.icomp.plaintext;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {
    public Context context;
    public TextView type, date, firstExercise,secondExercise,thirdExercise;
    public Button button;
    public ExerciseViewHolder(ConstraintLayout constraintLayout, Context context) {
        super(constraintLayout);
        this.context = context;
        type = constraintLayout.findViewById(R.id.typeitem);
        date = constraintLayout.findViewById(R.id.dateitem);
        firstExercise = constraintLayout.findViewById(R.id.firstitem);
        secondExercise = constraintLayout.findViewById(R.id.seconditem);
        thirdExercise = constraintLayout.findViewById(R.id.thirditem);
        button = constraintLayout.findViewById(R.id.delete);
    }


}
