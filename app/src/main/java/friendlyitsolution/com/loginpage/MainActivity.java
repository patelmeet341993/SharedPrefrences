package friendlyitsolution.com.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;

    EditText etid,etpass;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref=getSharedPreferences("myinfo",MODE_PRIVATE);

            checkLogin();


        btnlogin=findViewById(R.id.btnlogin);
        etid=findViewById(R.id.etid);
        etpass=findViewById(R.id.etpass);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              if(!etid.getText().toString().trim().isEmpty())
              {

                  login();
              }
              else
              {
                  etid.setError("Please enter id");
              }
            }
        });


    }


    void login()
    {

        SharedPreferences.Editor edit=pref.edit();

        edit.putString("uid",etid.getText().toString());
        edit.putString("upass",etpass.getText().toString());
        edit.commit();

        Intent i=new Intent(MainActivity.this,Homepage.class);
        startActivity(i);
        finish();


    }

    void checkLogin()
    {

        String uid=pref.getString("uid","");

        if(!uid.equals(""))
        {
            Intent i=new Intent(MainActivity.this,Homepage.class);
            startActivity(i);
            finish();

        }



    }

}
