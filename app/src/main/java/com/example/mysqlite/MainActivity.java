package com.example.mysqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private Button mButtonRegister,mButtonLogin;
    private EditText mUserName,mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //wire up!
        mUserName = (EditText) findViewById(R.id.edit_text_user_name);
        mPass = (EditText) findViewById(R.id.edit_text_password);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonLogin = (Button) findViewById(R.id.button_login);

        //set listeners
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQLiteHelper helper = new MySQLiteHelper(MainActivity.this);
                helper.insertInfo(helper,mUserName.getText().toString(),mPass.getText().toString());
                Toast.makeText(MainActivity.this, "Registrition success.", Toast.LENGTH_SHORT).show();
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQLiteHelper helper = new MySQLiteHelper(MainActivity.this);
                Cursor cursor = helper.queryInfo(helper);
                cursor.moveToFirst();
                do{
                    if(cursor.getString(0).equals(mUserName.getText().toString()) && cursor.getString(1).equals(mPass.getText().toString())){
                        Toast.makeText(MainActivity.this,"Login success",Toast.LENGTH_SHORT).show();
                    }
                }while(cursor.moveToNext());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
