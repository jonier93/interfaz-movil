package com.example.repaso_interfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Animation objAnimation;
    private ImageView logo;
    private BottomNavigationView barraNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        animacion();

        barraNav.setOnItemSelectedListener(item ->
        {
            int item_id = item.getItemId();
            if (item_id == R.id.menuHome) {
                visualizar_fragmento(new HomeFragment());
            }
            else if (item_id == R.id.menuCar1) {
                visualizar_fragmento(new CardFragment1());
            }
            else if (item_id == R.id.menuCard2) {
                visualizar_fragmento(new CardFragment2());
            }
            return true;
        });

    }

    private void inicializar(){
        logo = findViewById(R.id.imageLogo);
        barraNav = findViewById(R.id.barraNav);
    }

    private void animacion() {
        objAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.desplazar_logo);
        logo.startAnimation(objAnimation);
    }

    private void visualizar_fragmento(Fragment fragmentSelected) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmentSelected).commit();
    }
}