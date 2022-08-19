package storage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ExerciseDAO {
   private Context context;
   private SQLiteDatabase database;

   public ExerciseDAO(Context context) {
      this.context = context;
      this.database = (new Database(context)).getWritableDatabase();
   }
   public boolean createExercise ( String type, String firstExercise, String secondExercise, String thirdExercise, String date) {
      String sql = "INSERT INTO exercise (type, date, firstExercise,secondExercise,thirdExercise) VALUES ('" + type
              + "', '" + date + "', '" + firstExercise + "', '" + secondExercise + "', '" + thirdExercise + "')";
      try {
         database.execSQL(sql);
         return true;
      } catch (SQLException e) {
         System.out.println(e);
         return false;
      }
   }
     public ArrayList<Exercise> getExercises (String typeExercise) {
        ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

        String sql = "SELECT * FROM exercise WHERE type = '" + typeExercise+"'";
        System.err.println(sql);
        try {
           Cursor cursor = database.rawQuery(sql, null);
           while (cursor.moveToNext()) {
              int idExercise = cursor.getInt(0);
              String type = cursor.getString(1);
              String date  = cursor.getString(2);
              String firstExercise = cursor.getString(3);
              String secondExercise = cursor.getString(4);
              String thirdExercise = cursor.getString(5);
              exercisesList.add(new Exercise(idExercise,type,firstExercise,secondExercise,thirdExercise,date));


           }
           System.err.println(exercisesList);
        return exercisesList;
      } catch (SQLException e){
           System.out.println(e);
           return null;
        }


   }
      public boolean deleteExercise (int id){
         String sql = "DELETE FROM exercise WHERE idExercise="+ id;
         try {
            database.execSQL(sql);
            return true;
         }catch (SQLException e){
            System.out.println(e);
            return false;
         }

      }

}
