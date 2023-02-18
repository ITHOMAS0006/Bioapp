package com.example.bioapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BioFragment extends Fragment {

    private TextView bioTextView;

    public BioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);


        bioTextView = view.findViewById(R.id.bio_text_view);



        // Retrieve user data from bundle
        Bundle bundle = getActivity().getIntent().getExtras();
        String firstName = bundle.getString("firstName");
        String lastName = bundle.getString("lastName");
        String graduationYear = bundle.getString("graduationYear");
        String degree = bundle.getString("degree");
        String major = bundle.getString("major");
        String school = bundle.getString("school");
        String favoriteActivities = bundle.getString("favoriteActivities");

        // Set bio text
        String bioText = firstName + " " + lastName + " graduated in " + graduationYear +
                " with a " + degree + " in " + major + " from " + school +
                ". Their favorite activities are " + favoriteActivities + ".";
        bioTextView.setText(bioText);
System.out.println(bioText);
        return view;
    }
}
