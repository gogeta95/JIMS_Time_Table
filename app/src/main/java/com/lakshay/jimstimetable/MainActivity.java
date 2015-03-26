package com.lakshay.jimstimetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    ViewPager viewPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ActionBar bar = getSupportActionBar();
        super.onCreate(savedInstanceState);
        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean first_start=pref.getBoolean("first_start",true);
        if(first_start){
            setContentView(R.layout.login);
            Button b= (Button) findViewById(R.id.button);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        EditText roll = (EditText) findViewById(R.id.roll);
                        EditText name = (EditText) findViewById(R.id.name);
                        if (name.getText().toString().isEmpty()||roll.getText().toString().isEmpty())
                            throw new Exception();
//                        Toast.makeText(MainActivity.this,roll.getText().toString(),Toast.LENGTH_LONG).show();
//                        Toast.makeText(MainActivity.this,name.getText().toString(),Toast.LENGTH_LONG).show();
                        setContentView(R.layout.activity_main);
                        viewPager = (ViewPager) findViewById(R.id.pager);
                        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), MainActivity.this));
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putBoolean("first_start", false);
                        edit.commit();
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this,"These fields cannot be blank",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else {
            setContentView(R.layout.activity_main);
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));
        }
    }
}
class MyAdapter extends FragmentPagerAdapter{

Context context;
    public MyAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        switch (i){
            case 0: fragment = new BBA_fragment();
                    break;
            case 1: fragment= new BCA_fragment();
                    break;
            case 2: fragment= new BJMC_fragment();
                   break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String s[]= context.getResources().getStringArray(R.array.tab_head);
        return s[position];
    }
}