package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leafxin on 2014/9/25.
 */
class MyBaseAdapter extends BaseExpandableListAdapter{

    private String tag = "MyBaseAdapter";
    private ArticleListFragment mTestFragment;
    private String[]  groupTypes = new String[]{"好友","陌生人","黑名单"};
    private String[][]  groupFriends = new String[][]{
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}
    }           ;
    @Override
    public int getGroupCount() {
        return groupTypes.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return groupFriends[i].length;                     }

    @Override
    public Object getGroup(int i) {
        return groupTypes[i];
    }

    @Override
    public Object getChild(int i, int i2) {
        return groupFriends[i][i2];
    }

    @Override
    public long getGroupId(int i) {
        return i ;
    }

    @Override
    public long getChildId(int i, int i2) {
        return  i2 ;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        View result = LayoutInflater.from(mContext).inflate(R.layout.fragment_group,viewGroup,false);

        TextView tv1 = (TextView)result.findViewById(R.id.groupTextView1);
        TextView tv2 = (TextView)result.findViewById(R.id.groupTextView2);
        tv1.setText(groupTypes[groupPosition]);
        tv2.setText(groupTypes[groupPosition]);

        //result.setBackgroundColor(Color.BLUE);
        return result;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        View result = LayoutInflater.from(mContext).inflate(R.layout.fragment_friend,viewGroup,false);
        TextView tv1 = (TextView)result.findViewById(R.id.friendTextView1);
        TextView tv2 = (TextView)result.findViewById(R.id.friendTextView2);
        tv1.setText(groupFriends[groupPosition][childPosition]);
        tv2.setText(groupFriends[groupPosition][childPosition]);
        return result;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    final class Holder {
        TextView textView1;
        TextView textView2;
    }


    Context mContext;
    List<String> data;

    MyBaseAdapter(Context context, ArticleListFragment fragment, List<String> data) {
        this.mContext = context;
        this.mTestFragment = fragment ;
        this.data = data;
    }



}
