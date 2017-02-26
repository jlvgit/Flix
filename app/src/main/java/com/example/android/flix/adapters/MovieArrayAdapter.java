package com.example.android.flix.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.flix.R;
import com.example.android.flix.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by JLV on 2/26/2017.
 */

public class MovieArrayAdapter extends ArrayAdapter <Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        // check if view is being reused
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        // find the image view
        ImageView lvImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

        // clear out image from convertView
        lvImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate textviews
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        // populate imageview
        Picasso.with(getContext()).load(movie.getPosterPath()).into(lvImage);

        return convertView;
    }
}
