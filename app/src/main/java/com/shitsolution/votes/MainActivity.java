package com.shitsolution.votes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    AlertDialog.Builder alertDialog;
    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTexttotalVoterID);
        button = findViewById(R.id.startbtnId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String TotalVoter = editText.getText().toString();

                int TV = Integer.parseInt(TotalVoter);

                if (TV > 0) {

                    Toast.makeText(MainActivity.this, "Vote is Starting", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Votes.class);
                    intent.putExtra(Intent.EXTRA_TEXT, TotalVoter);
                    startActivity(intent);

                } else {
                    try {

                        alertDialog = new AlertDialog.Builder(MainActivity.this);

                        alertDialog.setTitle("Error!");
                        alertDialog.setMessage("Please Enter the valid Total voters");
                        alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog alert = alertDialog.create();


                        alert.show();

                    } catch (Exception e) {
                        Log.d(MainActivity.TAG, "Show Dialog: " + e.getMessage());
                    }


                }
            }
        });

    }
}