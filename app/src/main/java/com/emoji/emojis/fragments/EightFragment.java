package com.emoji.emojis.fragments;

/**
 * Created by mdhalim on 15/04/16.
 */

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.emoji.emojis.R;


public class EightFragment extends Fragment{

    TextView mText;

    public EightFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.fragment_one, container, false);

        // Inflate the layout for this fragment
        mText = (TextView) V.findViewById(R.id.txtContent);
        if(getArguments() != null) {
            Float result=getArguments().getFloat("RESULT");
            mText.setText(String.valueOf(result));
        } else

        { AssetManager assetManager = getContext().getAssets();
            InputStream input;
            try {
                input = assetManager.open("cool.txt");
                int size = input.available();
                byte[] buffer = new byte[size];
                input.read(buffer);
                input.close();
                String text = new String(buffer);
                mText.setText(text);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return V;


    }

}
