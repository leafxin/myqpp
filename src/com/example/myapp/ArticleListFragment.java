package com.example.myapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leafxin on 2014/9/25.
 */
public class ArticleListFragment extends Fragment {

    private String tag = "ArticleListFragment";
    interface onArticleSelectedListener {

        public void onArticleSelected(int position);

    }

    private ExpandableListView expandableListView;

    private onArticleSelectedListener mListener;

    private ExpandableListAdapter expandableListAdapter;

    private List<String> data = new ArrayList<String>();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (onArticleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implements the interface onArticleSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 18; i++) {
            data.add("the : " + String.valueOf(i));
        }
        expandableListAdapter = new MyBaseAdapter(getActivity(), this, data);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_total, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.listview);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                onChildSelected(groupPosition, childPosition);
                return false;
            }
        });
        return view;
    }


    private void onChildSelected(int groupPosition, int childPosition) {
        mListener.onArticleSelected(childPosition);
    }


}
