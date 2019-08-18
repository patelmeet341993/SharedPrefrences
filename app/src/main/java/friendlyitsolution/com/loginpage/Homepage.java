package friendlyitsolution.com.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {


    Button btnlogout;
    TextView userid;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userid=findViewById(R.id.userid);
        btnlogout=findViewById(R.id.btnlogout);
        pref=getSharedPreferences("myinfo",MODE_PRIVATE);

        String uid=pref.getString("uid","");
        userid.setText(uid);



        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

    }

    void logout()
    {

        SharedPreferences.Editor editor=pref.edit();

        editor.clear();
        editor.commit();

        Intent i=new Intent(Homepage.this,MainActivity.class);
        startActivity(i);
        finish();

    }

}
