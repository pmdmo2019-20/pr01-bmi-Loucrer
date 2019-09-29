package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Scanner;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;

public class MainActivity extends AppCompatActivity {
    private Button btnReset;
    private Button btnCalculate;
    private TextView lblmessage;
    private TextView lblWeight;
    private TextView lblHeight;
    private EditText txtWeight;
    private EditText txtHeight;
    private BmiCalculator BC = new BmiCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setupViews();
        // TODO
    }

    private void setupViews(){
        btnReset = ActivityCompat.requireViewById(this,R.id.btnReset);
        btnCalculate = ActivityCompat.requireViewById(this,R.id.btnCalculate);

        lblmessage = ActivityCompat.requireViewById(this,R.id.lblResult);
        lblWeight = ActivityCompat.requireViewById(this,R.id.lblWeight);
        lblHeight = ActivityCompat.requireViewById(this,R.id.lblHeight);

        txtWeight = ActivityCompat.requireViewById(this, R.id.txtWeight);
        txtHeight = ActivityCompat.requireViewById(this, R.id.txtHeight);

        btnReset.setOnClickListener( view -> {
            lblWeight.setText("");
            lblHeight.setText("");
            lblmessage.setText("");
        });

        btnCalculate.setOnClickListener( v -> lblmessage.setText(resultBMI()));
    }

    private String resultBMI(){
        String message = "";
        float result;

        if(txtWeight.getText().equals("0") || txtWeight.getText().equals("") || txtWeight.getText().equals(" ")){
            txtWeight.setError("Invalid Weight");

        }else if(txtHeight.getText().equals("0") || txtHeight.getText().equals("") || txtHeight.getText().equals(" ")) {
            txtHeight.setError("Invalid Height");

        }else {
            result = BC.calculateBmi(Float.parseFloat(String.valueOf(txtWeight.getText())), Float.parseFloat(String.valueOf(txtHeight.getText())));
            message = "BMI: " + result + " " + BC.getBmiClasification(result);
        }
        return message;
    }
    // TODO

}
