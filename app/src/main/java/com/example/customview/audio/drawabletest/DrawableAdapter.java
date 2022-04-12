package com.example.customview.audio.drawabletest;

import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.R;

import java.util.List;

/**
 * Created by baoyz on 2014/6/29.
 */
public class DrawableAdapter extends RecyclerView.Adapter<DrawableAdapter.ViewHolder>{

    private List<String> mDataset;

    public DrawableAdapter(List<String> dataset) {
        super();
        mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.item_audio_drawable, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
