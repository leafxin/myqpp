package com.example.myapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;


public class MyActivity extends Activity implements ArticleListFragment.onArticleSelectedListener {
    private String tag = "MyActivity";

    @Override
    public void onArticleSelected(int position ) {
        Log.i("onArticleSelected", String.valueOf(position));
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        ArticleFragment articleFragment = new ArticleFragment() ;
        fragmentTransaction.replace(R.id.container, articleFragment);
        fragmentTransaction.addToBackStack(null) ;
        fragmentTransaction.commit() ;
        articleFragment.setChatFriend(position);
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
      /*  Drawable drawable = this.getResources().getDrawable(R.drawable.test_color);
        actionBar.setBackgroundDrawable(drawable);*/
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab = actionBar
                .newTab()
                .setText("Tab1")
                .setTabListener(
                        new TabListener(this, "articleList",
                                ArticleListFragment.class));
        actionBar.addTab(tab);
        tab = actionBar
                .newTab()
                .setText("Tab2")
                .setTabListener(
                        new TabListener(this,  "contacts",
                                ContactListFragment.class));
        actionBar.addTab(tab);

        setContentView(R.layout.activity_my);
        /*if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ArticleListFragment())
                    .commit();
        }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case  R.id.action_search:
               break;
           case R.id.action_compose:
               break;
           case R.id.action_setting:
               break;
           default:
               return super.onOptionsItemSelected(item);
       }

        return true ;
    }


}


