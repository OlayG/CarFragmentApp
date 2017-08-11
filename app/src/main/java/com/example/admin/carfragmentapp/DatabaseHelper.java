package com.example.admin.carfragmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Admin on 8/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String TAG = "DatabaseHelper";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CarDatabase";

    public static final String TABLE_NAME = "Car";
    public static final String CAR_ID = "Id";
    public static final String CAR_MODEL = "Model";
    public static final String CAR_TYPE = "Type";
    public static final String CAR_YEAR = "Year";


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CAR_MODEL +
            " TEXT," + CAR_TYPE + " TEXT," + CAR_YEAR + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXIST" + TABLE_NAME);
        onCreate(db);
    }

    public void saveNewContact(Car car){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CAR_MODEL, car.getModel());
        cv.put(CAR_TYPE, car.getType());
        cv.put(CAR_YEAR, car.getYear());

        db.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<Car> getCars(){

        ArrayList<Car> cars = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Car car = new Car(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                cars.add(car);
            } while (cursor.moveToNext());
        }

        return cars;
    }
}
