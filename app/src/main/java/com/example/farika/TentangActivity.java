package com.example.farika;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farika.Adapter.VideoAdapter;
import com.example.farika.Model.YouTubeVideo;

import java.security.PublicKey;
import java.util.Calendar;
import java.util.Vector;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class TentangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.farika)
                .setDescription("PT. Farika Riau Perkasa merupakan perusahaan yang bergerak dalam bidang penyediaan readymix concrete (beton readymix), produk precast beton dan rental equipment untuk proyek-proyek pembangunan dan distribusi umum.")
                .addItem(new Element().setTitle("Version 1.0.0"))
                .addGroup("Connect with us")
                .addEmail("farikariauperkasa@ymail.com")
                .addWebsite("http://www.farikariau.com")
                .addFacebook("AldoFadillaPutra")
                .addTwitter("aldofadillaptr")
                .addInstagram("aldofadillaputra")
                .addYoutube("UCEzf2p1qDRUzkHIphv5ylTw")
                .addItem(createCopyRight())
                .create();

        setContentView(aboutPage);
    }

    private Element createCopyRight(){
        final Element copyright = new Element();
        final String copyRightString = String.format("%d AFP.", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyRightString);
        copyright.setIconDrawable(R.drawable.ic_copyright_black_24dp);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(TentangActivity.this, copyRightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }

}