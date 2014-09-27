package com.example.myapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by leafxin on 2014/9/27.
 */
public class ContactListFragment extends Fragment {
    private String tag = "ContactListFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contactlist, container,false);
       // TextView contactTextView = (TextView)view.findViewById(R.id.contactTextView);
        return view;
    }
}
