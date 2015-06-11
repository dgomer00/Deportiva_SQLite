package com.deportiva.database;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deportiva.main.R;

public class SignIn extends ActionBarActivity {

    EditText ET_User, ET_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button sign_in = (Button)findViewById(R.id.boton_sign_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Comprobamos si los dos campos están vacios y avisaremos con un mensaje. En cualquier otro caso,por ejemplo un solo campo vacío o datos incorrectos mostraremos otro mensaje.
                if (!estanVacios()) {
                    String user = ((EditText) findViewById(R.id.editText_user)).getText().toString();
                    String password = ((EditText) findViewById(R.id.editText_password)).getText().toString();

                    BaseDatosOpenHelper baseHelper = new BaseDatosOpenHelper(getApplicationContext(), "BaseDatosDeportiva", null, 1);
                    if (baseHelper.testCredentials(baseHelper, user, password)) {
                        Intent intent;
                        intent = new Intent(SignIn.this, PantallaSeleccion.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getBaseContext(), "Usuario no registrado", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(), "Rellene los datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean estanVacios(){
        boolean vacio=false;
        ET_User = (EditText)findViewById(R.id.editText_user);
        ET_Password = (EditText)findViewById(R.id.editText_password);
        if (ET_User.getText().toString().isEmpty() && ET_Password.getText().toString().isEmpty()){
            vacio=true;
        }
            return vacio;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
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
