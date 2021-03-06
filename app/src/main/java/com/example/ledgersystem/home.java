package com.example.ledgersystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
public class home extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView lt;
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_hu_container,new home_fragment()).commit();
        SharedPreferences sf=getSharedPreferences("Login data",MODE_PRIVATE);
        String s=sf.getString("user","unable to fetch");

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        View l=navigationView.getHeaderView(0);
        lt=l.findViewById(R.id.nameo);
        lt.setText(s);

        ConstraintLayout c= findViewById(R.id.bcontrol);

        Button b1=c.findViewById(R.id.navbarcoming);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Vibrator vv = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(100);
                drawer.openDrawer(GravityCompat.START);
            }
        });
        Button b2=c.findViewById(R.id.noticoming);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Notifications",Toast.LENGTH_SHORT).show();
                AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Vibrator vv = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(100);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int l=menuItem.getItemId();
                if(l==R.id.nav_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_hu_container,new home_fragment()).commit();
                }
                if(l==R.id.nav_logout){
                    Toast.makeText(getApplicationContext(),"Logging Out",Toast.LENGTH_SHORT);
                    SharedPreferences sf=getSharedPreferences("Login Data",MODE_PRIVATE);
                    SharedPreferences.Editor edit=sf.edit();
                    edit.putInt("islogged",0);
                    edit.commit();
                    Intent i = new Intent(getApplicationContext(),login.class);
                    startActivity(i);
                    finish();
                }
                if(l==R.id.nav_about){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_hu_container,new about_fragment()).commit();
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

}
