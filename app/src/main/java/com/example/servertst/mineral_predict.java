package com.example.servertst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class mineral_predict extends AppCompatActivity {

    TextInputEditText editText;
    TextView result, progress;
    Button predict, refresh;
    RequestQueue requestQueue;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mineral_predict);

        editText = findViewById(R.id.impedance_value);
        result = findViewById(R.id.result_mineral);
        predict = findViewById(R.id.predict);
        refresh = findViewById(R.id.refresh);
        progress = findViewById(R.id.progress_text);
        progressBar = findViewById(R.id.processing);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(null);
                result.setText("");
                editText.requestFocus();
            }
        });

        requestQueue = Volley.newRequestQueue(mineral_predict.this);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                final String data = editText.getText().toString();
                String Url = "https://mineral-predict.herokuapp.com/post";
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("data_i", data);
                    jsonObject.put("min_name", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.POST, Url, jsonObject, new
                        Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                String x = "";
                                String y = "";
                                try {
                                    x = response.getString("min_name");
                                    y = response.getString("data_i");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                String res = "The Mineral corresponding to impedance value of " + y + " is " + x.substring(2, x.length() - 2);
                                result.setText(res);
                                progress.setVisibility(View.INVISIBLE);
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage() + "secod post", Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request1);
            }
        });

    }
}
