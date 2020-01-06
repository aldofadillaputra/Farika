package com.example.farika.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.farika.Model.Produk;
import com.example.farika.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProdukAdapter extends PagerAdapter {
    Context context;
    List<Produk> produkList;
    LayoutInflater inflater;

    public ProdukAdapter(Context context, List<Produk> produkList) {
        this.context = context;
        this.produkList = produkList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produkList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = inflater.inflate(R.layout.slide_product,container,false);

        //view
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView gambar_produk = (ImageView)  view.findViewById(R.id.gambar_produk);
        TextView nama_produk = (TextView) view.findViewById(R.id.nama_produk);
        TextView deskripsi_produk = (TextView) view.findViewById(R.id.deskripsi_produk);
        layoutslide.setBackgroundColor(Color.parseColor("#373737"));

        //get data
        Picasso.get()
                .load(produkList.get(position).getGambar_produk())
                .resize(1000,600)
                .centerInside()
                .noFade()
                .placeholder(R.drawable.spinnerr)
                .into(gambar_produk);
        nama_produk.setText(produkList.get(position).getNama_produk());
        deskripsi_produk.setText((produkList.get(position).getDeskripsi_produk()));

        container.addView(view);
        return view;
    }
}