package es.ifp.notitas;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public int numberOfNotes(){
        int num = 0;
        db = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(db, "notes");
        return num;
    }
    public ArrayList<String> getAllNotes(){
        ArrayList<String> filas = new ArrayList<String>();
        String contenido = "";
        Cursor res = null;
        db = this.getReadableDatabase();
        res = db.rawQuery("SELECT * FROM notes ORDER BY id ASC", null);
        while (res.isAfterLast()==false){
            contenido = res.getInt(res.getColumnIndex("id")) + res.getString(res.getColumnIndex("title"));
            res.moveToNext();
        }
        return filas;
    }

    public void close(){
        db.close();
    }
}
