package com.example.recyclerview123;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class abc extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    ImageSlider imageSlider;

  //  private ImageView img1;
    private ImageView img2;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);
        txt1 = findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.txt4);
        txt5=findViewById(R.id.txt5);
        txt6=findViewById(R.id.txt6);
     //   img1=findViewById(R.id.img1);
     //   img2=findViewById(R.id.img2);

        mQueue = Volley.newRequestQueue(this);

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
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject All = jsonArray.getJSONObject(i);


                                String dir_id = All.getString("dir_id");
                                String id = All.getString("id");
                                String advertiser = All.getString("advertiser");
                                String offer_title = All.getString("offer_title");
                                String description = All.getString("description");
                                String term_conditions = All.getString("term_conditions");
                                String valid_from = All.getString("valid_from");
                                String valid_to = All.getString("valid_to");
                                String submitdate = All.getString("submitdate");
                                String banner_image1 = All.getString("banner_image1");
                                String banner_image2 = All.getString("banner_image2");
                                String banner_image3 = All.getString("banner_image3");
                                String banner_image4 = All.getString("banner_image4");
                                String banner_image5 = All.getString("banner_image5");
                                String total_likes = All.getString("total_likes");
                                String total_comments = All.getString("total_comments");
                                String advertiser_mobile = All.getString("advertiser_mobile");
                                String advertiser_city=All.getString("advertiser_city");
                                String mobile1 = All.getString("mobile1");
                                String mobile2 = All.getString("mobile2");
                                String advertiser_email = All.getString("advertiser_email");
                                String advertiser_address = All.getString("advertiser_address");
                                String pincode = All.getString("pincode");
                                String open_time = All.getString("open_time");
                                String close_time = All.getString("close_time");
                                String user_like_flag = All.getString("user_like_flag");
                                String user_comments = All.getString("user_comments");
                                String ts = All.getString("ts");
                                String shortdate = All.getString("shortdate");
                                String shorttime = All.getString("shorttime");
                                String vendor_id = All.getString("vendor_id");



                                txt1.append(" "+advertiser);
                                txt2.setText(" "+submitdate);
                                txt3.setText(offer_title);
                                txt4.setText(description);
                                txt5.setText(" "+advertiser_address+","+advertiser_city);
                                txt6.setText(advertiser_mobile);
                              //  img2.setImageResource(R.drawable.1234);
                                //submitdate
                                //offer_title
                                //description
                                //advertiser_city   advertiser_address
                                //advertiser_mobile
                                //




                               // img1.setImageURI(banner_image1);

                                imageSlider=findViewById(R.id.image_slider);

                                ArrayList<SlideModel> images =new ArrayList<>();
                                images.add(new SlideModel(banner_image1,null));
                           //     images.add(new SlideModel("http://virtuosos.in/be-konnected/uploads/offers_image/301_banner1.png", null));
                           //     images.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",null));
                                images.add(new SlideModel(banner_image2,null));
                                images.add(new SlideModel(banner_image3,null));
                                images.add(new SlideModel(banner_image4,null));

                                imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);


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
}