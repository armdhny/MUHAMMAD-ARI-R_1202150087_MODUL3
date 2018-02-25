package com.ramdhany.ari.mariramdhany_1202150087_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Menu> mMineralData;
    private Context mIsi;


    public ListAdapter(Context isi, ArrayList<Menu> datamineral) {
        this.mMineralData = datamineral;
        this.mIsi = isi;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mIsi,R.drawable.aqua);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mIsi).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        Menu mAir = mMineralData.get(position);
        holder.bindTo(mAir);

    }

    @Override
    public int getItemCount() {
        return mMineralData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //TextView yang ada pada layout
        private TextView judulText;
        private TextView infoText;
        private ImageView gambarAir;
        private Menu iAir;
        private GradientDrawable mGradientDrawable;

        ViewHolder(View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //inisiasi view
            judulText = (TextView) itemView.findViewById(R.id.judul);
            infoText = (TextView) itemView.findViewById(R.id.subJudul);
            gambarAir = (ImageView)itemView.findViewById(R.id.gmbrAir);

            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Menu mAir) {
            //Populate the textviews with data
            judulText.setText(mAir.getJudul());
            infoText.setText(mAir.getInfo());
            //MENG Get Air mineral yang saat ini
            iAir = mAir;

            //meload gambar into the ImageView menggunakan Glide library
            Glide.with(mIsi).load(mAir.getImageResource()).placeholder(mGradientDrawable).
                    into(gambarAir);
        }

        @Override
        public void onClick(View v) {
            //Set up the detail intent
            Intent detailIntent = Menu.starter(mIsi, iAir.getJudul(),
                    iAir.getImageResource());


            //Start the detail activity
            mIsi.startActivity(detailIntent);

        }
    }
}
