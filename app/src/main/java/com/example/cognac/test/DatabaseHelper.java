package com.example.cognac.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Cognac on 16/7/6.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Project.db";
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_USERTYPE = "Usertype";
    private static final String COLUMN_SELECTEDMODULES = "SelectedModules";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table Users (id integer primary key " +
            "not null , Password  text not null , Email text not null, Usertype text not null , SelectedModules );";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertUser(User c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASSWORD,c.getPassword());
        values.put(COLUMN_USERTYPE,c.getUsertype());
        values.put(COLUMN_SELECTEDMODULES,"");

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateSelectedModules(String ModuleCode, String Username){
        db = this.getWritableDatabase();

        String ori = searchSelectedModule(Username);

        String update = "UPDATE Users SET SelectedModules = " + "\'" + ori + " " +  ModuleCode + "\'" + " WHERE Email = '" + Username + "\'";

        Log.i("Update",update);

        db.execSQL(update);
    }

    public void deleteSelectedModules(String ModuleCode){
        db = this.getWritableDatabase();

        String update = "UPDATE Users SET SelectedModules = replace (SelectedModules, '"+ ModuleCode + "\', \"\")";

        Log.i("Update",update);

        db.execSQL(update);
    }



    public String searchSelectedModule(String username) {

        db = this.getReadableDatabase();

        String query = "select SelectedModules from Users where Email = '" + username + "' ";
        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a = "";
        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);

            }
            while (cursor.moveToNext());

        }return a;
    }

    public String searchPass (String Email){
        db = this.getReadableDatabase();
        String query = "select Email,Password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if (a.equals(Email)){

                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }return b;
    }
    public String searchUT (String Email){
        db = this.getReadableDatabase();
        String query = "select Email,Usertype from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if (a.equals(Email)){

                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }return b;
    }

    public String searchEmail(String Email){
        db = this.getReadableDatabase();
        String query = "select Email from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if (a.equals(Email)){

                    b = cursor.getString(0);
                    break;
                }
            }
            while (cursor.moveToNext());
        }return b;
    }

    public ArrayList<String> searchModuleName(String Level, String AssessmentType, String Credit,
                                              String Semester, String Interests) {

        db = this.getReadableDatabase();

        String query = "select distinct Name from Modules where" + " \"Level\""
                + " in("+Level+") and \"Assessment Type\" in("+AssessmentType+") " +
                "and \"Credit\" in("+Credit+") and \"Semester\" in("+Semester+") and " + Interests+";";

        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a;
        ArrayList<String> b = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
                b.add(a);
            }
            while (cursor.moveToNext());

            }return b;
        }


    public ArrayList<String> searchModuleID(String Level, String AssessmentType, String Credit,
                                              String Semester, String Interests) {

        db = this.getReadableDatabase();

        String query = "select distinct Code from Modules where" + " \"Level\""
                + " in("+Level+") and \"Assessment Type\" in("+AssessmentType+") " +
                "and \"Credit\" in("+Credit+") and \"Semester\" in("+Semester+") and " + Interests+";";

        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a;
        ArrayList<String> b = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
                b.add(a);
            }
            while (cursor.moveToNext());

        }return b;
    }


    public ArrayList<String> searchModuleLevel(String Level, String AssessmentType, String Credit,
                                            String Semester, String Interests) {

        db = this.getReadableDatabase();

        String query = "select Level from Modules where" + " \"Level\""
                + " in("+Level+") and \"Assessment Type\" in("+AssessmentType+") " +
                "and \"Credit\" in("+Credit+") and \"Semester\" in("+Semester+") and " + Interests+";";

        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a;
        ArrayList<String> b = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
                b.add(a);
            }
            while (cursor.moveToNext());

        }return b;
    }

    public ArrayList<String> searchModuleSemester(String Level, String AssessmentType, String Credit,
                                               String Semester, String Interests) {

        db = this.getReadableDatabase();

        String query = "select Semester from Modules where" + " \"Level\""
                + " in("+Level+") and \"Assessment Type\" in("+AssessmentType+") " +
                "and \"Credit\" in("+Credit+") and \"Semester\" in("+Semester+") and " + Interests+";";

        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a;
        ArrayList<String> b = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
                b.add(a);
            }
            while (cursor.moveToNext());

        }return b;
    }

    public String searchSelectedNameByCode(String Code) {

        db = this.getReadableDatabase();

        String query = "select distinct Name from Modules where Code = " + "\'" + Code +"\'";
        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a = "";

        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
            }
            while (cursor.moveToNext());

        }return a;
    }

    public String searchSelectedLevelByCode(String Code) {

        db = this.getReadableDatabase();

        String query = "select Level from Modules where Code = " + "\'" + Code +"\'";
        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a = "";

        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
            }
            while (cursor.moveToNext());

        }return a;
    }

    public String searchSelectedSemesterByCode(String Code) {

        db = this.getReadableDatabase();

        String query = "select Semester from Modules where Code = " + "\'" + Code +"\'";
        Log.i("MESSAGE",query);
        Cursor cursor = db.rawQuery(query,null);
        String a = "";

        if (cursor.moveToFirst()) {

            do {
                a = cursor.getString(0);
            }
            while (cursor.moveToNext());

        }return a;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
