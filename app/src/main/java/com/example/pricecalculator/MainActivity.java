package com.example.pricecalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox fish;
    private CheckBox crayFish;
    private CheckBox lobster;
    private EditText fishQty;
    private EditText crayFishQty;
    private EditText lobsterQty;
    private Button calculate;
    private TextView printStatement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fish = findViewById(R.id.number1);
        fishQty = findViewById(R.id.number1q);
        crayFish = findViewById(R.id.number2);
        crayFishQty = findViewById(R.id.number2q);
        lobster = findViewById(R.id.number3);
        lobsterQty = findViewById(R.id.number3q);
        calculate = findViewById(R.id.calculate);
        printStatement = findViewById(R.id.total);

        //We need to be able to detect click action on the 'CAlCULATE' button
        // by setting onClick Listener on it
        calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String fishQuantity = "";
        String crayfishQuantity = "";
        String lobsterQuantity = "";

        //This block checks whether or not fish checbox is checked
        if (fish.isChecked()) {
            fishQuantity = fishQty.getText().toString();
        }
        //This block checks whether or not crayfish checbox is checked
        if (crayFish.isChecked()) {
            crayfishQuantity = crayFishQty.getText().toString();
        }
        //This block checks whether or not lobster checbox is checked
        if (lobster.isChecked()) {
            lobsterQuantity = lobsterQty.getText().toString();
        }

        if (fishQuantity.equals("")){
            fishQuantity = "0";
        }
        if (crayfishQuantity.equals("")){
            crayfishQuantity = "0";
        }
        if (lobsterQuantity.equals("")){
            lobsterQuantity = "0";
        }

        int fishPrice = Integer.valueOf(fishQuantity) * 500;
        int crayfishPrice = Integer.valueOf(crayfishQuantity) * 700;
        //This is a log to catch a lobsterQuantity bug
        Log.i("LOBSTER_QUANTITY", "Lobster quantity: " + lobsterQuantity);
        int lobsterPrice = Integer.valueOf(lobsterQuantity) * 1500;

        //The value of lobsterQuantity will affect the price, we need to know the cause.
        Log.i("LOBSTER_PRICE_VALUE", "Lobster price: " + lobsterPrice);
        //This variable printStatement changes its text content to show the below newly assigned texts
        printStatement.setText("Fish: $" + fishPrice + "\n "
                + "Crayfish: $" + crayfishPrice  + "\n "
                + "Lobster: $" + lobsterPrice
        );
        Toast.makeText(this, "Lobster Price: " + lobsterPrice, Toast.LENGTH_SHORT).show();
    }
}