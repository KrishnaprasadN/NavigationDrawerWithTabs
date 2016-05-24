package com.kp.nitteapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kp.nitteapp.homelistview.DividerItemDecoration;
import com.kp.nitteapp.homelistview.SimpleAdapter;
import com.kp.nitteapp.homelistview.SimpleSectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class LatestFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;
    private String[] mNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.latest_layout,null);
        initList(view);

        return view;
    }


    private void initList(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));

        //Your RecyclerView.Adapter
        mAdapter = new SimpleAdapter(this.getContext(), mNumbers);

        //This is the code to provide a sectioned list
        List<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        //Sections
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"University"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(3,"KSHMA"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(6,"NIC"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(9,"ABSMIDS"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(12,"NUINSD"));

        //Add your adapter to the sectionAdapter
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(this.getContext(), R.layout.section_header, R.id.section_text, mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecyclerView.setAdapter(mSectionedAdapter);
    }
}
