package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;


public class FeedBackAllRate extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_all_rate_feed_back, container, false);

        // Retrieve data passed to the fragment
        Bundle arguments = getArguments();
        if (arguments != null) {
            float satisfactionRating = arguments.getFloat("satisfactionRating", 0);
            float confidenceRating = arguments.getFloat("confidenceRating", 0);
            float qualityOfServiceRating = arguments.getFloat("qualityOfServiceRating", 0);
            float fairnessRating = arguments.getFloat("fairnessRating", 0);
            float timeTakenRating = arguments.getFloat("timeTakenRating", 0);

            // Find SeekBars in the fragment layout
            SeekBar satisfactionSeekBar = view.findViewById(R.id.satisfactionSeekBar);
            SeekBar confidenceSeekBar = view.findViewById(R.id.confidenceSeekBar);
            SeekBar qualityOfServiceSeekBar = view.findViewById(R.id.qualityOfServiceSeekBar);
            SeekBar fairnessSeekBar = view.findViewById(R.id.fairnessSeekBar);
            SeekBar finalreport = view.findViewById(R.id.Final);
            SeekBar timetekenseekbar = view.findViewById(R.id.timeTakenSeekBar);

            // Assuming you have a method to convert float ratings to SeekBar progress
            int satisfactionProgress = convertRatingToSeekBarProgress(satisfactionRating);
            int confidenceProgress = convertRatingToSeekBarProgress(confidenceRating);
            int qualityOfServiceProgress = convertRatingToSeekBarProgress(qualityOfServiceRating);
            int fairnessProgress = convertRatingToSeekBarProgress(fairnessRating);
            int timeTakenProgress = convertRatingToSeekBarProgress(timeTakenRating);

            // Set SeekBar progress
            satisfactionSeekBar.setProgress(satisfactionProgress);
            confidenceSeekBar.setProgress(confidenceProgress);
            qualityOfServiceSeekBar.setProgress(qualityOfServiceProgress);
            fairnessSeekBar.setProgress(fairnessProgress);
            timetekenseekbar.setProgress(timeTakenProgress);

            // Calculate the average rating
            float total = (satisfactionRating + confidenceRating + qualityOfServiceRating + fairnessRating + timeTakenRating) / 5;
            int totalProgress = convertRatingToSeekBarProgress(total);

            Toast.makeText(requireContext(), "Average Rating: " + total, Toast.LENGTH_SHORT).show();
            finalreport.setProgress(totalProgress);
        }

        return view;
    }

    private int convertRatingToSeekBarProgress(float rating) {
        return (int) (rating * 10);
    }
}
