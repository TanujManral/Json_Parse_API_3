package com.example.recyclerview123;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
class CustomAdapter implements ListAdapter {
    ArrayList<SubjectData> arrayList;
    Context context;
    public CustomAdapter(Context context, ArrayList<SubjectData> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubjectData subjectData=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.list_row, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView tittle=convertView.findViewById(R.id.title);
            TextView tittle2=convertView.findViewById(R.id.title2);
            TextView tittle3=convertView.findViewById(R.id.title3);
            TextView tittle4=convertView.findViewById(R.id.title4);





            ImageView imag=convertView.findViewById(R.id.list_image);
            ImageView imag1=convertView.findViewById(R.id.list_image1);
            ImageView imag2=convertView.findViewById(R.id.list_image2);
            ImageView imag3=convertView.findViewById(R.id.list_image3);
            ImageView imag4=convertView.findViewById(R.id.list_image4);

            tittle.setText(subjectData.SubjectName);
            tittle2.setText(subjectData.SubjectName2);
            tittle3.setText(subjectData.SubjectName3);
            tittle4.setText(subjectData.SubjectName4);






            Picasso.get()
                    .load(subjectData.Image)
                    .resize(600,350)
                    .centerCrop()
                    .into(imag);

            Picasso.get()
                    .load(subjectData.Image1)

                    .into(imag1);
            Picasso.get()
                    .load(subjectData.Image2)
                    .resize(600,350)
                    .centerCrop()
                    .into(imag2);
            Picasso.get()
                    .load(subjectData.Image3)
                    .resize(600,350)
                    .centerCrop()
                    .into(imag3);



        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}