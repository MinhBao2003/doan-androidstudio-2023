package com.example.game2048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.content.Intent;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    private Button playgame, choitiep;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            try{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Bạn có muốn thoát!!").setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        finish();
                    }
                })
                               .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                   public void onClick(DialogInterface dialog, int id) {

                                   }
                               }).show();
            }catch (Exception e)
            {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        anhxa();
        batxukienclick();
    }
    public void batxukienclick()
    {
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, play2048.class);
                intent.putExtra("playgame", 1);
                startActivity(intent);
            }
        });
        choitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, play2048.class);
                intent.putExtra("playgame", 3);
                startActivity(intent);
            }
        });
    }
    public void anhxa()
    {
        playgame = (Button)findViewById(R.id.playgame2048);
        choitiep = (Button)findViewById(R.id.choitiep);
    }
}
