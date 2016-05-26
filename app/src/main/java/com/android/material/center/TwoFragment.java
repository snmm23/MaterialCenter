package com.android.material.center;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TwoFragment extends android.support.v4.app.Fragment {

    private RecyclerView live_rv;
    private FragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        live_rv=(RecyclerView)rootView.findViewById(R.id.recyclerView);
        adapter=new FragmentAdapter(this.getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        live_rv.setLayoutManager(linearLayoutManager);
        live_rv.setAdapter(adapter);
        ArrayList<String> e =new ArrayList<>();
        for(int a=0;a<50;a++){
            e.add(""+a);
        }
        adapter.setData(e);
        adapter.notifyDataSetChanged();
        return rootView;
    }
}
