package com.ramdhany.ari.mariramdhany_1202150087_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView battery;
    TextView ukuran;
    int volume = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView  nama = findViewById(R.id.detailNama);
        ImageView mineralImage = findViewById(R.id.detailGambar);
        ukuran = findViewById(R.id.liter);
        battery = findViewById(R.id.battery);


        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Menu.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        nama.setText(getIntent().getStringExtra(Menu.TITLE_KEY));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Menu.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(mineralImage);
    }



    public void onClickMinus(View view) {

        //apabila battery dikurangi sampai satu tingkat sebelum level terendah
        if (battery.getDrawable().getLevel() - 1 >= 0) {
            //volume air akan dikurangi sebanyak 2 Liter
            volume=volume-2;
            //set text view dengan ukuran yang sudah dihitung
            ukuran.setText(volume + "L");
            //maka set image battery dengan battery satu tingkat sebelum level terendah
            battery.setImageLevel(battery.getDrawable().getLevel() - 1);
        } else {
            //apabila battery dikurangi sampai level paling rendah
            battery.setImageLevel(0);
            //maka akan muncul toast yang memberi tahu bahwa air hampir habis
            Toast.makeText(this, "Hampir Kosong!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickPlus(View view) {
        //apabila battery ditambah sampai satu tingkat sebelum level tertinggi
        if (battery.getDrawable().getLevel() + 1 <=5) {
            //volume air akan ditambah sebanyak 2 liter
            volume=volume+2;
            //set text view dengan ukuran yang sudah dihitung
            ukuran.setText(volume + "L");
            //maka set image battery dengan battery satu tingkat sebelum level tertinggi
            battery.setImageLevel(battery.getDrawable().getLevel() + 1);
        } else {
            //apabila level battery penuh
            battery.setImageLevel(5);
            //maka akan muncul toast yang memberi tahu bahwa air sudah penuh
            Toast.makeText(this, "Sudah Penuh!", Toast.LENGTH_LONG).show();
        }
    }
}