package mw.wpam.trainapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TrainingPlans2.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_training_plan2";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "training_plan_name";
    private static final String COLUMN_1 = "Excercise1";
    private static final String COLUMN_2 = "Excercise2";
    private static final String COLUMN_3 = "Excercise3";
    private static final String COLUMN_4 = "Excercise4";
    private static final String COLUMN_5 = "Excercise5";
    private static final String COLUMN_6 = "Excercise6";
    private static final String COLUMN_7 = "Series";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_1 + " TEXT, " +COLUMN_2 + " TEXT, " + COLUMN_3 + " TEXT, " +
                        COLUMN_4 + " TEXT, "+ COLUMN_5 + " TEXT, " + COLUMN_6 + " TEXT, " +
                        COLUMN_7 + " TEXT);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addPlan(String title, String exc1, String exc2, String exc3, String exc4, String exc5, String exc6, String series){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_1, exc1);
        cv.put(COLUMN_2, exc2);
        cv.put(COLUMN_3, exc3);
        cv.put(COLUMN_4, exc4);
        cv.put(COLUMN_5, exc5);
        cv.put(COLUMN_6, exc6);
        cv.put(COLUMN_7, series);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String title){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
