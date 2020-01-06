package com.example.farika;

import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farika.Adapter.ProdukAdapter;
import com.example.farika.Model.Produk;
import com.example.farika.Transformer.DepthPageTransformer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private String TAG = ProductActivity.class.getSimpleName();

    ViewPager viewPager;
    ProdukAdapter myadapter;
    ImageView gambar_produk;
    TextView nama_produk;
    TextView deskripsi_produk;
    ArrayList<Produk> produkList = new ArrayList<Produk>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product);
        gambar_produk = (ImageView) findViewById(R.id.gambar_produk);
        nama_produk = (TextView) findViewById(R.id.nama_produk);
        deskripsi_produk = (TextView)findViewById(R.id.deskripsi_produk);

        new GetProduk().execute();

        viewPager = (ViewPager)findViewById(R.id.slideViewPagerProduct);
        viewPager.setPageTransformer(true,new DepthPageTransformer());
    }

    private class GetProduk extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            HttpHandler hh = new HttpHandler();

            String jsonStr = hh.tampilProduk();
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray produks = jsonObj.getJSONArray(Static.PRODUK);
                    if (!produks.getJSONObject(0).equals(Static.EMPTY)) {
                        for (int i = 0; i < produks.length(); i++) {
                            JSONObject p = produks.getJSONObject(i);
                            Produk produk = new Produk();
                            produk.setNama_produk(p.getString(Static.NAMA_PRODUK));
                            produk.setDeskripsi_produk(p.getString(Static.DESKRIPSI_PRODUK));
                            produk.setGambar_produk(p.getString(Static.GAMBAR_PRODUK));

                            produkList.add(produk);
                        }
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                getApplicationContext(), "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ProdukAdapter adapter = new
                        ProdukAdapter(getApplicationContext(), produkList);
            viewPager.setAdapter(adapter);
        }
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}