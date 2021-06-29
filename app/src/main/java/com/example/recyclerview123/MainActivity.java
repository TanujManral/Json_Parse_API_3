package com.example.recyclerview123;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import android.widget.ListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private TextView mTextViewResult;
    private ImageView list_image;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_image=findViewById(R.id.list_image);


        setTitle("Offer");



        mQueue = Volley.newRequestQueue(MainActivity.this);

        jsonParse();


    }


    private void jsonParse() {
        String url = "https://virtuosos.in/be-konnected/mobile_api/json_all_ads_test.php?mobile=8800241012&dir_id=111";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("All");
                            ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject All = jsonArray.getJSONObject(i);


                                String advertiser = All.getString("advertiser");
                                String submitdate = All.getString("submitdate");
                                String offer_title = All.getString("offer_title");
                                String description = All.getString("description");
                                String banner_image1 = All.getString("banner_image1");
                                String banner_image2 = All.getString("banner_image2");
                                String banner_image3 = All.getString("banner_image3");
                                String banner_image4 = All.getString("banner_image4");
                                String banner_image5 = All.getString("banner_image5");

                                final ListView list = findViewById(R.id.list);

                                arrayList.add(new SubjectData(advertiser,submitdate,offer_title,description,banner_image1,banner_image2,banner_image3,banner_image4,banner_image5));
                                //,dir_logo, admin_photo
                                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, arrayList);

                                list.setAdapter(customAdapter);

                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
    public void onClick(View v) {
        Intent mIntent;
        mIntent  = new Intent(MainActivity.this, abc.class);
        startActivity(mIntent);

}
}
