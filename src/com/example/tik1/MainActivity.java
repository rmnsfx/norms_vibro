package com.example.tik1;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import java.io.IOException;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;



public class MainActivity extends Activity 

{

	int a=0;
	int b=0;
	int c=0;
	int d=0;
	//private SQLiteDatabase myDataBase; 
	int diametr = R.array.diametr1;
	int razrad = R.array.razrad1;
	String strData;
	
	


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
		
//Открываем БД
		
		
		MySQLiteHelper myDbHelper = new MySQLiteHelper(this);
		try {myDbHelper.createDataBase();} catch (IOException ioe) {throw new Error("Unable to create database");}
		try {myDbHelper.openDataBase();} catch(SQLException sqle){throw sqle;}
		final SQLiteDatabase db = myDbHelper.getReadableDatabase();
		
//Рисуем Спиннеры		
			
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.type, R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
				

		Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, diametr, R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(adapter2);
		

		Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
			this, razrad, R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(adapter3);
		
		
		Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
		ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
			this, R.array.freq, R.layout.simple_spinner_item);
		adapter4.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		spinner4.setAdapter(adapter4);
		
		
//Слушаем спинеры		
		
		
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() 
		
		{ 

			@Override
		    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
			{
				
				a=position;
							
				
//Выбираем таблицу из базы в зависимости от выбранного типа подшипника
				
				if (a==0) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null);
				
					if(cursor!=null && cursor.getCount()!=0)
					{ 
						cursor.moveToFirst();	
						strData = cursor.getString(cursor.getColumnIndex("norm"));
					}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
				diametr = R.array.diametr1;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
				
				} else if (a==1) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb2 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
					if(cursor!=null && cursor.getCount()!=0)
					{ 
						cursor.moveToFirst();	
						strData = cursor.getString(cursor.getColumnIndex("norm"));
					}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
				diametr = R.array.diametr1; //Меняем диаметры во втором спиннере 
				loadspinner (); 	
				
				razrad = R.array.razrad1; //Меняем разряд в третьем спиннере 
				loadspinner2 ();
				
				} else if (a==2) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb3 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
					if(cursor!=null && cursor.getCount()!=0)
					{ 
						cursor.moveToFirst();	
						strData = cursor.getString(cursor.getColumnIndex("norm"));
					}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				diametr = R.array.diametr1;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
										
				} else if (a==3) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb4 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				diametr = R.array.diametr2;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
				
				} else if (a==4) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb5 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr3;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
					
				} else if (a==5) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb6 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr4;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
					
				} else if (a==6) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb7 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
			
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr4;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
					
				} else if (a==7) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb8 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr5;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
					
				} else if (a==8) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb9 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr4;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
					
				} else if (a==9) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb10 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr5;
				loadspinner (); 
				
				razrad = R.array.razrad1;
				loadspinner2 ();
					
				} else if (a==10) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb11 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr7;
				loadspinner (); 
				
				razrad = R.array.razrad2;
				loadspinner2 ();
					
				} else if (a==11) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb12 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				diametr = R.array.diametr6;
				loadspinner (); 
				
				razrad = R.array.razrad2;
				loadspinner2 ();
					
				}
				
				
			}
			
	
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {} });
		

	
		
		
		
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() 
	
		{ 

		@Override
	    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
		{
			
				b=position;

				if (a==0) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
				
				
				} else if (a==1) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb2 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
					
				
				} else if (a==2) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb3 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				
										
				} else if (a==3) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb4 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				
				
				} else if (a==4) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb5 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==5) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb6 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				
					
				} else if (a==6) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb7 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				
					
				} else if (a==7) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb8 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
			
					
				} else if (a==8) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb9 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==9) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb10 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
			
					
				} else if (a==10) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb11 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==11) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb12 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
		
					
				}
			
			
		}	

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {} });
	

	
		spinner3.setOnItemSelectedListener(new OnItemSelectedListener() 
	
		{ 

		@Override
	    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
		{
			
			c=position;

				if (a==0) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
				
				
				} else if (a==1) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb2 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
					
				
				} else if (a==2) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb3 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				
										
				} else if (a==3) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb4 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				
				
				} else if (a==4) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb5 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==5) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb6 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				
					
				} else if (a==6) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb7 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				
					
				} else if (a==7) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb8 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
			
					
				} else if (a==8) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb9 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==9) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb10 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
			
					
				} else if (a==10) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb11 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==11) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb12 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
		
					
				}
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {} });
		
	
	
	
		spinner4.setOnItemSelectedListener(new OnItemSelectedListener() 
	
		{ 

		@Override
	    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
		{
			
			d=position;
			
				if (a==0) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
				
				
				} else if (a==1) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb2 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
				
					
				
				} else if (a==2) {
				
				Cursor cursor = db.rawQuery("SELECT * FROM pdb3 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
			
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				
										
				} else if (a==3) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb4 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
					
				
				
				} else if (a==4) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb5 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==5) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb6 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				
					
				} else if (a==6) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb7 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
				
					
				} else if (a==7) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb8 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
			
					
				} else if (a==8) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb9 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==9) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb10 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
			
					
				} else if (a==10) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb11 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
				
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
			
					
				} else if (a==11) {
					
				Cursor cursor = db.rawQuery("SELECT * FROM pdb12 WHERE diametr="+b+" AND razrad="+c+" AND parametr="+d, null); 
			
				if(cursor!=null && cursor.getCount()!=0)
				{ 
					cursor.moveToFirst();	
					strData = cursor.getString(cursor.getColumnIndex("norm"));
				}
				
				cursor.close();
				TextView text = (TextView) findViewById(R.id.textView8);
				text.setText(""+strData);
						
		
					
				}
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {} });

		
	
	}  //Закрыли onCreate(Bundle savedInstanceState) 
	

// Переключаем спиннеры 
	
		private void loadspinner () 
		
		{
	
			Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
			ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
					this, diametr, R.layout.simple_spinner_item);
			adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
			spinner2.setAdapter(adapter2);

		}	
		
		
		private void loadspinner2 () 
		
		{		
		
			Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
			ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
					this, razrad, R.layout.simple_spinner_item);
			adapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
			spinner3.setAdapter(adapter3);
	
		}
	
//Меню + логотип 
	
	public void logo_click(View v)
	{
	    Intent intent = new Intent(this, AboutActivity.class);
	    startActivity(intent);
	}

	
	public void about_company(View v)
	{
	    Intent intent = new Intent(this, AboutCompanyActivity.class);
	    startActivity(intent);
	}
	

//Меню
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
	{
		menu.add(Menu.NONE, 1, Menu.NONE, "О программе");
		menu.add(Menu.NONE, 2, Menu.NONE, "НПП «ТИК»");
		menu.add(Menu.NONE, 3, Menu.NONE, "Выход");
		
		return true;
    }
    
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
	    
		switch (item.getItemId()) 
		
		{
			
		case 1:	logo_click (null);
		return true;
		
		case 2:	about_company (null);
		return true;
			
		case 3:	finish();
		
		}		
		
		return false;	
	}
	
     
    
}
