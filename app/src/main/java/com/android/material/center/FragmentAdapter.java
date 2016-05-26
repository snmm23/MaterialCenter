package com.android.material.center;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentAdapter extends RecyclerView.Adapter{

    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mOther;

    public FragmentAdapter(Context activity) {
        mLayoutInflater = LayoutInflater.from(activity);
    }

    public void setData(ArrayList<String> other) {
        this.mOther = other;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OtherViewHolder(mLayoutInflater.inflate(R.layout.fragment_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mOther == null ? 0 : mOther.size();
    }

    private class OtherViewHolder extends RecyclerView.ViewHolder {
        public OtherViewHolder(View itemView) {
            super(itemView);
        }
    }
}

