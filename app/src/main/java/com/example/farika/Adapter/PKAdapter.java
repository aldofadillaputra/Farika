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

import com.example.farika.Model.PengalamanKerja;
import com.example.farika.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PKAdapter extends PagerAdapter {
    Context context;
    List<PengalamanKerja> pkList;
    LayoutInflater inflater;

    public PKAdapter(Context context, List<PengalamanKerja> pkList) {
        this.context = context;
        this.pkList = pkList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pkList.size();
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

        View view = inflater.inflate(R.layout.slide_pk,container,false);

        //view
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayoutpk);
        ImageView gambar_pk = (ImageView)  view.findViewById(R.id.gambar_pk);
        TextView nama_pk = (TextView) view.findViewById(R.id.nama_pk);
        TextView deskripsi_pk = (TextView) view.findViewById(R.id.deskripsi_pk);
        layoutslide.setBackgroundColor(Color.parseColor("#373737"));

        //get data
        Picasso.get()
                .load(pkList.get(position).getGambar_pk())
                .resize(1000,600)
                .centerInside()
                .noFade()
                .placeholder(R.drawable.spinnerr)
                .into(gambar_pk);
        nama_pk.setText(pkList.get(position).getNama_pk());
        deskripsi_pk.setText((pkList.get(position).getDeskripsi_pk()));

        container.addView(view);
        return view;
    }


}
