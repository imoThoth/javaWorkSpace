package com.example.buttoncounter;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText userInput; //editButtonText;
    private TextView textView; //exampleText;
    private static final String TAG =  "MainActivity";


    //private int numTimesClicked = 0;
    // private Button button; // buttonClicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //bundle = framework used to pass around data
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_clicker);

        userInput = findViewById(R.id.editButtonText);
        Button button = findViewById(R.id.buttonClicker);
        textView = findViewById(R.id.exampleText);
        //textView.setText("") sets the textview to a null
        textView.setMovementMethod(new ScrollingMovementMethod());//allows the text view to scroll
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString(); //
                result += "\n";
                textView.append(result); //adds line of text
                userInput.getText().clear();
                //userInput.setText() set the text input to null
            }
        };
        button.setOnClickListener(ourOnClickListener);//calls the variable ourOnClickListener
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        String savedString = savedInstanceState.getString(userInput.getText().toString());
        textView.setText(savedString);
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString("userText", userInput.toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }
}











//numTimesClicked = numTimesClicked + 1;
//                String result = "The button got tapped " + numTimesClicked + " time\n";
//                if(numTimesClicked != 1){
//                    result += "s";
//                }