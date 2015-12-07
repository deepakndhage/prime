package com.dsquare;
import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DBHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 4;
 
    // Database Name
    private static final String DATABASE_NAME = "DSquarePrime";
 
    // Contacts table name
    private static final String TABLE_CURRENT_STATE = "current_state";
    private static final String TABLE_PREFERED_STATE = "prefered_state";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_STATE = "state";
    private static final String KEY_INTENSITY = "intensity";
 
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CURRENT_STATE_TABLE = "CREATE TABLE " + TABLE_CURRENT_STATE + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "+ KEY_DEVICE_ID + " INTEGER, " + KEY_STATE + " TEXT,"
                + KEY_INTENSITY + " INTEGER" + ")";
        String CREATE_PREFERED_STATE_TABLE = "CREATE TABLE " + TABLE_PREFERED_STATE + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "+ KEY_DEVICE_ID + " INTEGER, " + KEY_STATE + " TEXT,"
                + KEY_INTENSITY + " INTEGER" + ")";
        db.execSQL(CREATE_CURRENT_STATE_TABLE);
        db.execSQL(CREATE_PREFERED_STATE_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURRENT_STATE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREFERED_STATE);
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    void addCurrentState(CurrentState currentState) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_DEVICE_ID, currentState.getDeviceId()); 
        values.put(KEY_STATE, currentState.getState()); 
        values.put(KEY_INTENSITY, currentState.getIntensity()); 
        
        // Inserting Row
        db.insert(TABLE_CURRENT_STATE, null, values);
        db.close(); // Closing database connection
    }
    
    void savePreferedState(List<CurrentState> currentStates) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = null;
        for(CurrentState currentState:currentStates){
        	if(null != getPreferedState(currentState.getDeviceId())){
        		values = new ContentValues();
                values.put(KEY_STATE, currentState.getState());
                values.put(KEY_INTENSITY, currentState.getIntensity());
         
                // updating row
                db.update(TABLE_PREFERED_STATE, values, KEY_DEVICE_ID + " = ?",
                        new String[] { String.valueOf(currentState.getDeviceId()) });
        	}
        	else{
		        values = new ContentValues();
		        values.put(KEY_DEVICE_ID, currentState.getDeviceId()); 
		        values.put(KEY_STATE, currentState.getState()); 
		        values.put(KEY_INTENSITY, currentState.getIntensity()); 
		        
		        // Inserting Row
		        db.insert(TABLE_PREFERED_STATE, null, values);
        	}
        }
        db.close(); // Closing database connection
        
    }
    
 // Getting single contact
    CurrentState getCurrentState(int deviceId) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CURRENT_STATE, new String[] { KEY_DEVICE_ID,
                KEY_STATE, KEY_INTENSITY }, KEY_DEVICE_ID + "=?",
                new String[] { String.valueOf(deviceId) }, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()){
            
        CurrentState currentState= new CurrentState(Integer.parseInt(cursor.getString(0)),
        		Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)));
        // return contact
        return currentState;
        }
        return null;
    }
 // Getting single contact
    CurrentState getPreferedState(int deviceId) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_PREFERED_STATE, new String[] { KEY_DEVICE_ID,
                KEY_STATE, KEY_INTENSITY }, KEY_DEVICE_ID + "=?",
                new String[] { String.valueOf(deviceId) }, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()){
            
        CurrentState currentState= new CurrentState(Integer.parseInt(cursor.getString(0)),
        		Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)));
        // return contact
        return currentState;
        }
        return null;
    }
    // Getting All Contacts
    public List<CurrentState> getAllCurrentStates() {
        List<CurrentState> currentStateList = new ArrayList<CurrentState>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CURRENT_STATE;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	CurrentState currentState = new CurrentState();
                currentState.setId(Integer.parseInt(cursor.getString(0)));
                currentState.setDeviceId(Integer.parseInt(cursor.getString(1)));
                currentState.setState(Integer.parseInt(cursor.getString(2)));
                currentState.setIntensity(Integer.parseInt(cursor.getString(3)));
                // Adding contact to list
                currentStateList.add(currentState);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return currentStateList;
    }
    
 // Getting All Contacts
    public List<CurrentState> getPreferedState() {
        List<CurrentState> currentStateList = new ArrayList<CurrentState>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PREFERED_STATE;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	CurrentState currentState = new CurrentState();
                currentState.setId(Integer.parseInt(cursor.getString(0)));
                currentState.setDeviceId(Integer.parseInt(cursor.getString(1)));
                currentState.setState(Integer.parseInt(cursor.getString(2)));
                currentState.setIntensity(Integer.parseInt(cursor.getString(3)));
                // Adding contact to list
                currentStateList.add(currentState);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return currentStateList;
    }
 
    // Updating single contact
    public int updateCurrentState(CurrentState currentState) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_STATE, currentState.getState());
        values.put(KEY_INTENSITY, currentState.getIntensity());
 
        // updating row
        int rows = db.update(TABLE_CURRENT_STATE, values, KEY_DEVICE_ID + " = ?",
                new String[] { String.valueOf(currentState.getDeviceId()) });
        db.close();
        return rows;
    }
    
    public int allOff(int count) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_STATE, 0);
        values.put(KEY_INTENSITY, 0);
        int rows = 0;
        // updating row
        for(int i=1;i<=count;i++){
         rows += db.update(TABLE_CURRENT_STATE, values, KEY_DEVICE_ID + " = ?",
                new String[] { String.valueOf(i) });
        }
        db.close();
        return rows;
    }
 
    // Deleting single contact
    public void deleteCurrentState(CurrentState currentState) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CURRENT_STATE, KEY_DEVICE_ID + " = ?",
                new String[] { String.valueOf(currentState.getDeviceId()) });
        db.close();
    }
 
 
    // Getting contacts Count
    public int getCurrentStateCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CURRENT_STATE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
 
}
