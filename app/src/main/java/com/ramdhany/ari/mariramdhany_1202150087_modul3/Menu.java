package com.ramdhany.ari.mariramdhany_1202150087_modul3;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

public class Menu {
    private String judul;
    private String info;
    int imageResource;
    static final String TITLE_KEY = "nama mineral";
    static final String IMAGE_KEY = "Image Resource";
    static String DESC_KEY = "deskripsi mineral";




    public Menu(String judul, String info, int imageResource ) {
        this.judul = judul;
        this.info = info;
        this.imageResource = imageResource;
    }

    public String getInfo() {
        return info;
    }

    public String getJudul() {
        return judul;
    }
    public int getImageResource() {
        return imageResource;
    }
    static Intent starter(Context context, String nama, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, nama);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
