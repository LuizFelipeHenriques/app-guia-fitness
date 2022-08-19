package storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "GuiaFit.db";
    public static final String SQL_DELETE_EXERCISE = "DROP TABLE exercise";
    private static final String SQL_CREATE_EXERCISE = "CREATE TABLE exercise ( " +
            "idExercise INTEGER  PRIMARY KEY AUTOINCREMENT," +
            "type TEXT NOT NULL," +
            "date TEXT NOT NULL," +
            "firstExercise TEXT NOT NULL," +
            "secondExercise TEXT NOT NULL," +
            "thirdExercise TEXT NOT NULL)";
    private static final String SQL_POPULATE_EXERCISE = "INSERT INTO exercise (type,date,firstExercise,secondExercise,thirdExercise)"
            +" VALUES ('OMBROS','segunda','Remada alta','Elevação lateral','Desenvolvimento na barra')";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_EXERCISE);
        sqLiteDatabase.execSQL(SQL_POPULATE_EXERCISE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_EXERCISE);
        onCreate(sqLiteDatabase);
    }



}
