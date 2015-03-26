package com.lakshay.jimstimetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by saurabh on 17-02-2015.
 */
public class BBA_fragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.bba,container,false);
        Button mon = (Button) view.findViewById(R.id.bba_monday);
        mon.setOnClickListener(this);
        Button tues = (Button) view.findViewById(R.id.bba_tuesday);
        tues.setOnClickListener(this);
        Button wed = (Button) view.findViewById(R.id.bba_wednesday);
        wed.setOnClickListener(this);
        Button thurs = (Button) view.findViewById(R.id.bba_thursday);
        thurs.setOnClickListener(this);
        Button fri = (Button) view.findViewById(R.id.bba_friday);
        fri.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),ImageActivity.class);
       intent.putExtra("image",v.getId());
        startActivity(intent);
    }
}
