package com.ltrsoft.police_app.fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.Feedback;
import com.ltrsoft.police_app.Model.FeedbackDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Feedback_Fragment extends Fragment {

    private RatingBar satisfaction, trustConfidence, qualityOfService, fairness, timeTaken,training_support,usability_navigation;
    private Button submit;
    private EditText bribeDescription;
    int rate;
    StringBuilder output = new StringBuilder();

    private static final String FEEDBACK_API_URL = "https://rj.ltr-soft.com/public/police_api/feedback/create_feedback.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.feed_back, container, false);


//        try {
//            FileInputStream fileInputStream = getActivity().openFileInput("mytextfile.txt");
//            InputStreamReader inputReader = new InputStreamReader(fileInputStream);
//            char[] buffer = new char[1024];
//            int read;
//            while ((read = inputReader.read(buffer)) > 0) {
//                output.append(buffer, 0, read);
//            }
//            Toast.makeText(getContext(), "your fiile ="+output.toString(), Toast.LENGTH_SHORT).show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        training_support=view.findViewById(R.id.training_support);
        usability_navigation=view.findViewById(R.id.usability_navigation);
        satisfaction = view.findViewById(R.id.satisfaction);
        trustConfidence = view.findViewById(R.id.confidance);
         qualityOfService = view.findViewById(R.id.quality_of_service);
        fairness = view.findViewById(R.id.fairness);
        timeTaken = view.findViewById(R.id.time_taken);

        submit = view.findViewById(R.id.submit_feedback);
        LayerDrawable layerDrawable = (LayerDrawable) satisfaction.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedbackDeo feedbackDeo=new FeedbackDeo();
                feedbackDeo.create_Feedback(new Feedback(satisfaction.getRating(), trustConfidence.getRating(), qualityOfService.getRating(),
                        fairness.getRating(), timeTaken.getRating(), training_support.getRating(), usability_navigation.getRating()), getContext(),getActivity(), new Callback() {
                    @Override
                    public void onSuccess(Object obj) {

                    }

                    @Override
                    public void onErro(String errro) {

                    }
                });

        FeedBackAllRate feedBackAllRate = new FeedBackAllRate();
        Bundle arguments = new Bundle();
        arguments.putFloat("satisfactionRating", satisfaction.getRating());
        arguments.putFloat("confidenceRating", trustConfidence.getRating());
        arguments.putFloat("qualityOfServiceRating", qualityOfService.getRating());
        arguments.putFloat("fairnessRating", fairness.getRating());
        arguments.putFloat("timeTakenRating", timeTaken.getRating());
        feedBackAllRate.setArguments(arguments);

        getFragmentManager().beginTransaction().replace(R.id.container_main, feedBackAllRate).addToBackStack(null).commit();
    }
});

        return view;
    }

    private void sendFeedback() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, FEEDBACK_API_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "Error: " + error.toString());
                        Toast.makeText(getContext(), "An error occurred. Please try again later.", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("satisfaction", String.valueOf(satisfaction.getRating()));
                params.put("trust", String.valueOf(trustConfidence.getRating()));
                params.put("quality_of_service", String.valueOf(qualityOfService.getRating()));
                params.put("fairness", String.valueOf(fairness.getRating()));
                params.put("time_taken_to_resoive_complaint", String.valueOf(timeTaken.getRating()));
                params.put("asked_for_brief", bribeDescription.getText().toString());


                params.put("user_id", output.toString());  // Replace with the actual user ID


                return params;
            }
       };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}
