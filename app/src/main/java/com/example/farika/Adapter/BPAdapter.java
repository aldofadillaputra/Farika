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

import com.example.farika.Model.BatchingPlant;
import com.example.farika.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BPAdapter extends PagerAdapter {
    Context context;
    List<BatchingPlant> bpList;
    LayoutInflater inflater;

    public BPAdapter(Context context, List<BatchingPlant> bpList) {
        this.context = context;
        this.bpList = bpList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return bpList.size();
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

        View view = inflater.inflate(R.layout.slide_bp,container,false);

        //view
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayoutbp);
        ImageView gambar_bp = (ImageView)  view.findViewById(R.id.gambar_bp);
        TextView nama_bp = (TextView) view.findViewById(R.id.nama_bp);
        TextView alamat_bp = (TextView) view.findViewById(R.id.alamat_bp);
        layoutslide.setBackgroundColor(Color.parseColor("#373737"));

        //get data
        Picasso.get()
                .load(bpList.get(position).getGambar_bp())
                .resize(1000,600)
                .centerInside()
                .noFade()
                .placeholder(R.drawable.spinnerr)
                .into(gambar_bp);
        nama_bp.setText(bpList.get(position).getNama_bp());
        alamat_bp.setText((bpList.get(position).getAlamat_bp()));

        container.addView(view);
        return view;
    }

}
