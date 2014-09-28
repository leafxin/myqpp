package com.example.myapp;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by leafxin on 2014/9/25.
 */
public class ArticleFragment extends DialogFragment {
    private String tag = "ArticleFragment";
    private EditText mEditText;
    private TextView nameTextView;
    private int position ;
    public ArticleFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container,false);
        nameTextView = (TextView)view.findViewById(R.id.lbl_your_name);
        int a=222222;
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        nameTextView.setText("FriendUin: "+String.valueOf(position));
        return view;
    }

    public void setChatFriend(int position){
        this.position = position ;
    }
}
