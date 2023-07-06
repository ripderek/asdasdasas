package com.example.myapplicationrevistas.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationrevistas.Modelos.Journal;
import com.example.myapplicationrevistas.R;

import java.util.ArrayList;

public class AdaptadorJournal extends ArrayAdapter<Journal> {
    public AdaptadorJournal(Context context, ArrayList<Journal> datos) {
        super(context, R.layout.lyitemjournal, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemjournal, null);
        TextView lblname = item.findViewById(R.id.name);
        lblname.setText(getItem(position).getName());
        TextView lblabbreviation = item.findViewById(R.id.lblabbreviation);
        lblabbreviation.setText(getItem(position).getAbbreviation());
        TextView lbldescription = item.findViewById(R.id.lbldescription);
        lbldescription.setText(getItem(position).getDescription());

        ImageView imageView = (ImageView) item.findViewById(R.id.portada);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada()).into(imageView);
        return(item);
    }
}
