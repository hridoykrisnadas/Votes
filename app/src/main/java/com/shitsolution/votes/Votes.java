package com.shitsolution.votes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Votes extends AppCompatActivity {

    TextView totalVoter, currentVoterpoll, resultTextView;
    Button haveVoterButton, EndVoterButton, CheckResultButton, Nouka, DhanerSesh, VoteDoneButton;
    AlertDialog.Builder alertDialog;

    int poll = 0, NoukaSum= 0, DhanerSeshSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes);

        totalVoter = findViewById(R.id.totalVoterID);
        currentVoterpoll = findViewById(R.id.currentPollID);
        haveVoterButton = findViewById(R.id.haveVoterId);
        EndVoterButton = findViewById(R.id.endId);
        CheckResultButton = findViewById(R.id.checkresultId);
        DhanerSesh = findViewById(R.id.dhaner_seshID);
        Nouka = findViewById(R.id.noukaId);
        VoteDoneButton = findViewById(R.id.voteDoneId);
        resultTextView = findViewById(R.id.ResultTextView);


        Intent intent = getIntent();
        String V = intent.getStringExtra(Intent.EXTRA_TEXT);
        totalVoter.setText("Total Voter: "+V);

        int TotalV = Integer.parseInt(V);



        haveVoterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndVoterButton.setVisibility(View.INVISIBLE);
                CheckResultButton.setVisibility(View.INVISIBLE);
                haveVoterButton.setVisibility(View.INVISIBLE);
                DhanerSesh.setVisibility(View.VISIBLE);
                Nouka.setVisibility(View.VISIBLE);
                resultTextView.setVisibility(View.INVISIBLE);
                Nouka.setText("Nouka");
                DhanerSesh.setText("Dhaner Sesh");


                Nouka.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Votes.this, "You Voted on Nouka",Toast.LENGTH_LONG).show();

                        NoukaSum = NoukaSum+1;
                        DhanerSesh.setVisibility(View.INVISIBLE);
                        VoteDoneButton.setVisibility(View.VISIBLE);
                        Nouka.setText("Voted");
                    }
                });

                DhanerSesh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Votes.this, "You Voted on Dhaner Sesh",Toast.LENGTH_LONG).show();

                        DhanerSeshSum = DhanerSeshSum+1;

                        Nouka.setVisibility(View.INVISIBLE);
                        VoteDoneButton.setVisibility(View.VISIBLE);
                        DhanerSesh.setText("Voted");
                    }
                });


                VoteDoneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        poll = poll +1;

                        if (poll == TotalV && poll >= TotalV){
                            haveVoterButton.setVisibility(View.INVISIBLE);
                        }
                        else {
                            haveVoterButton.setVisibility(View.VISIBLE);
                        }



                        currentVoterpoll.setText("Current Poll: "+poll);


                        EndVoterButton.setVisibility(View.VISIBLE);
                        CheckResultButton.setVisibility(View.VISIBLE);
                        DhanerSesh.setVisibility(View.INVISIBLE);
                        Nouka.setVisibility(View.INVISIBLE);
                        VoteDoneButton.setVisibility(View.INVISIBLE);



                    }
                });


            }
        });



        EndVoterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultTextView.setVisibility(View.VISIBLE);
                haveVoterButton.setVisibility(View.INVISIBLE);
                EndVoterButton.setVisibility(View.INVISIBLE);
                CheckResultButton.setVisibility(View.INVISIBLE);


                String resultText;
                if (DhanerSeshSum>NoukaSum) {

                    resultText = "Dhaner Sesh is Win";
                }
                else if (DhanerSeshSum < NoukaSum) {

                    resultText = "Nouka is Win";
                } else if (DhanerSeshSum == NoukaSum) {

                    resultText = "Draw";
                } else {
                    resultText = "Error!";
                }

                String finalResult = "Total Voter: " + TotalV + "\nTotal Poll: " + poll + "\nNouka: " + NoukaSum + "\nDhaner Sesh: "
                        + DhanerSeshSum;

                resultTextView.setText(finalResult + "\nResult: " + resultText);

                resultTextView.setVisibility(View.VISIBLE);


                if (DhanerSeshSum > NoukaSum) {

                    alertDialog = new AlertDialog.Builder(Votes.this);

                    alertDialog.setTitle("Result!");
                    alertDialog.setMessage("Congratulations!\n" + resultText + "\n" + finalResult);
                    alertDialog.setIcon(R.drawable.dhan);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alert = alertDialog.create();


                    alert.show();


                }
                else if (DhanerSeshSum < NoukaSum) {

                    alertDialog = new AlertDialog.Builder(Votes.this);

                    alertDialog.setTitle("Result!");
                    alertDialog.setMessage("Congratulations!\n" + resultText + "\n" + finalResult);
                    alertDialog.setIcon(R.drawable.nouka);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alert = alertDialog.create();

                    alert.show();

                }else if (DhanerSeshSum == NoukaSum) {

                    alertDialog = new AlertDialog.Builder(Votes.this);

                    alertDialog.setTitle("Result!");
                    alertDialog.setMessage("Congratulations!\nThe Result of the vote is: \n" + resultText + "\n" + finalResult);
                    alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alert = alertDialog.create();


                    alert.show();

                }



            }
        });

        CheckResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String finalResult = "Total Voter: " + TotalV + "\nTotal Poll: " + poll + "\nNouka: " + NoukaSum + "\nDhaner Sesh: "
                        + DhanerSeshSum;
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(finalResult);

                alertDialog = new AlertDialog.Builder(Votes.this);

                alertDialog.setTitle("Check Result!");
                alertDialog.setMessage("The vote is running..... \n" + finalResult);
                alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alert = alertDialog.create();


                alert.show();


            }
        });

    }
}