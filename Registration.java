package com.example.sasa.sem_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseObject;


public class Registration extends FragmentActivity {

    EditText email;
    Button register;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email=(EditText)findViewById(R.id.email);

        register=(Button)findViewById(R.id.register);
        Parse.initialize(this, "3Mx8gxX2xLYxcSVYZkmoWj2Xhym0Y6lLy2FcZW8J", "i8UH0UibWNR89MEhi2jexXy3bsrI7DC5yLIHxowA");




        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String value = email.getText().toString();
                ParseObject registrationObject = new ParseObject("Registration");
                registrationObject.put("Email",value);
                registrationObject.saveInBackground();
                Intent i=new Intent(Registration.this,view_pager.class);
                startActivity(i);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
