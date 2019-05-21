package com.example.tik1;


import java.io.IOException;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;


public class MySQLiteHelper extends SQLiteOpenHelper 

	{
 
		private static String DB_PATH = "/data/data/com.example.tik1/databases/";
		//private static String DB_PATH;
		private static final String DATABASE_NAME = "example_sql.db";
		private static final int DATABASE_VERSION = 1;
		private SQLiteDatabase myDataBase;
		private Context mContext;


		
		public MySQLiteHelper(Context context) 
		{

		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		
		
/*		
		if(android.os.Build.VERSION.SDK_INT >= 17)
		
			{
		            
		       //DB_PATH =  context.getDatabasePath(DATABASE_NAME).getPath();
			
			}
		    
		else
		    
		    {
		       DB_PATH = "/data/data/com.example.tik1/databases/";
		    }
		
*/
		this.mContext = context;


		
		}
		
		
		String myPath = DB_PATH + DATABASE_NAME;
		
	
		
		public void createDataBase() throws IOException
		
		{
			

			boolean dbExist = checkDataBase();			
			if(dbExist){
			}else{
				this.getReadableDatabase();
				 try {
					 
					 copyDataBase();
					  
					 } catch (IOException e) {
					  
					 throw new Error("Error copying database");
					  
					 }
					 }
					  
		}
			
			
			
			
			
/*			
			SQLiteDatabase checkDB = null;
			try{checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);} catch(SQLiteException e){}
			if(checkDB != null) checkDB.close();  
			boolean dbExist = (checkDB != null) ? true : false;
			if(!dbExist){ getReadableDatabase(); 
			try { copyDataBase(); } catch (IOException e) {}
					
		}
		}
*/			

		
		 private boolean checkDataBase(){
			 
			 SQLiteDatabase checkDB = null;
			  
			 try{
			 String myPath = DB_PATH + DATABASE_NAME;
			 checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
			  
			 }catch(SQLiteException e){
			  
			 //database does't exist yet.
			  
			 }
			  
			 if(checkDB != null){
			  
			 checkDB.close();
			  
			 }
			  
			 return checkDB != null ? true : false;
			 }
		

		private void copyDataBase() throws IOException
		
		{ 
			
				InputStream myInput = mContext.getAssets().open(DATABASE_NAME);
				OutputStream myOutput = new FileOutputStream(myPath);
				byte[] buffer = new byte[1024];
				int length;
					while ((length = myInput.read(buffer))>0){
						myOutput.write(buffer, 0, length);
				
					}
					myOutput.flush();
					myOutput.close();
					myInput.close();
		} 


		public void openDataBase() throws SQLException
		
		{
			
			//SQLiteDatabase myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
			myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		
			
		} 
		
	
		 @Override
		 public synchronized void close() {
		  
		 if(myDataBase != null)
		 myDataBase.close();
		  
		 super.close();
		  
		 }
		  

		@Override
		public void onCreate(SQLiteDatabase db) 
		{			
			
		}

		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
		{
		   
		}
	
	
		
		
		
	}
	
	
	
	
	
	
	
	

    



	
	
	
	
	
	
	
	
	
	





