package com.example.farika;

import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farika.Adapter.PKAdapter;
import com.example.farika.Model.PengalamanKerja;
import com.example.farika.Transformer.DepthPageTransformer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PKActivity extends AppCompatActivity {

    private String TAG = PKActivity.class.getSimpleName();

    ViewPager viewPager;
    ImageView gambar_pk;
    TextView nama_pk;
    TextView deskripsi_pk;
    ArrayList<PengalamanKerja> pkList = new ArrayList<PengalamanKerja>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pk);
        gambar_pk = (ImageView) findViewById(R.id.gambar_pk);
        nama_pk = (TextView) findViewById(R.id.nama_pk);
        deskripsi_pk = (TextView)findViewById(R.id.deskripsi_pk);

        new PKActivity.GetPK().execute();

        viewPager = (ViewPager)findViewById(R.id.slideViewPagerPK);
        viewPager.setPageTransformer(true,new DepthPageTransformer());
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private class GetPK extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            HttpHandler hh = new HttpHandler();

            String jsonStr = hh.tampilPK();
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray pk = jsonObj.getJSONArray(Static.PENGALAMAN_KERJA);

                    if (!pk.getJSONObject(0).equals(Static.EMPTY)) {
                        for (int i = 0; i < pk.length(); i++) {
                            JSONObject b = pk.getJSONObject(i);
                            PengalamanKerja pks = new PengalamanKerja();
                            pks.setNama_pk(b.getString(Static.NAMA_PK));
                            pks.setDeskripsi_pk(b.getString(Static.ALAMAT_PK));
                            pks.setGambar_pk(b.getString(Static.GAMBAR_PK));

                            pkList.add(pks);
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
            PKAdapter adapter = new
                    PKAdapter(getApplicationContext(), pkList);
            viewPager.setAdapter(adapter);
        }
    }
}
