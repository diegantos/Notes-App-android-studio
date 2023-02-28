package es.ifp.notitas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {

    protected SQLiteDatabase db;

    public DataBaseSQL(Context context) {
        super(context, "notes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table notes (id integer primary key autoincrement not null, title text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS notes");
    }

    public void insertNote(String title){
        db = this.getReadableDatabase();
        db.execSQL("INSERT INTO notes (title) VALUES ('"+title+"')");
    }
    public void deleteNote(int id){
        db = this.getReadableDatabase();
        db.execSQL("DELETE FROM notes WHERE id=" + id);
    }
    public void deleteAllNotes(){
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notes");
    }
    public int numberOfNotes(){
        db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, "notes");
    }
    @SuppressLint("Range")
    public ArrayList<String> getAllNotes(){
        ArrayList<String> filas = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM notes ORDER BY id ASC", null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            //System.out.println("-->" + contenido);
            filas.add(res.getString(res.getColumnIndex("title")));
            res.moveToNext();
        }
        return filas;
    }

    public void close(){
        db.close();
    }
}
