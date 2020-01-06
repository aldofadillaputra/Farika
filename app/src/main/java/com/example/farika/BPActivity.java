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

import com.example.farika.Adapter.BPAdapter;
import com.example.farika.Model.BatchingPlant;
import com.example.farika.Transformer.DepthPageTransformer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BPActivity extends AppCompatActivity {

    private String TAG = BPActivity.class.getSimpleName();

    ViewPager viewPager;
    ImageView gambar_bp;
    TextView nama_bp;
    TextView alamat_bp;
    ArrayList<BatchingPlant> bpList = new ArrayList<BatchingPlant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bp);
        gambar_bp = (ImageView) findViewById(R.id.gambar_bp);
        nama_bp = (TextView) findViewById(R.id.nama_bp);
        alamat_bp = (TextView)findViewById(R.id.alamat_bp);

        new GetBP().execute();

        viewPager = (ViewPager)findViewById(R.id.slideViewPagerBP);
        viewPager.setPageTransformer(true,new DepthPageTransformer());
    }

    private class GetBP extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            HttpHandler hh = new HttpHandler();

            String jsonStr = hh.tampilBP();
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray bp = jsonObj.getJSONArray(Static.BATCHING_PLANT);

                    if (!bp.getJSONObject(0).equals(Static.EMPTY)) {
                        for (int i = 0; i < bp.length(); i++) {
                            JSONObject b = bp.getJSONObject(i);
                            BatchingPlant bps = new BatchingPlant();
                            bps.setNama_bp(b.getString(Static.NAMA_BP));
                            bps.setAlamat_bp(b.getString(Static.ALAMAT_BP));
                            bps.setGambar_bp(b.getString(Static.GAMBAR_BP));

                            bpList.add(bps);
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
            BPAdapter adapter = new
                    BPAdapter(getApplicationContext(), bpList);
            viewPager.setAdapter(adapter);
        }
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}