package com.example.hugo.test;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by hugo on 03/10/2016.
 */

public class Menu extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button jouer_button = (Button) findViewById(R.id.menu_1);
        jouer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Retour boutons", "Bouton jouer !");
                Intent jouer_intent =  new Intent(Menu.this, Running.class);
                startActivity(jouer_intent);
            }
        });
    }
}
