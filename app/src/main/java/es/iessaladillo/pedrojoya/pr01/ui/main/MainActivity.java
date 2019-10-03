package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;
import es.iessaladillo.pedrojoya.pr01.utils.SoftInputUtils;

public class MainActivity extends AppCompatActivity {
    private Button btnReset;
    private Button btnCalculate;
    private TextView lblResult;
    private TextView lblWeight;
    private TextView lblHeight;
    private EditText txtWeight;
    private EditText txtHeight;
    private ImageView image;
    private BmiCalculator BC = new BmiCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setupViews();
        // TODO
    }

    private void setupViews(){
        /*Capture of ID*/
        btnReset = ActivityCompat.requireViewById(this,R.id.btnReset);
        btnCalculate = ActivityCompat.requireViewById(this,R.id.btnCalculate);
        lblResult = ActivityCompat.requireViewById(this,R.id.lblResult);
        lblWeight = ActivityCompat.requireViewById(this,R.id.lblWeight);
        lblHeight = ActivityCompat.requireViewById(this,R.id.lblHeight);
        txtWeight = ActivityCompat.requireViewById(this, R.id.txtWeight);
        txtHeight = ActivityCompat.requireViewById(this, R.id.txtHeight);

        /*Events*/
        image = ActivityCompat.requireViewById(this, R.id.imgBmi);
        image.setImageResource(R.drawable.bmi);
        /*Events of the buttons*/
        btnReset.setOnClickListener( view -> resetValues());
        btnCalculate.setOnClickListener( v -> resultBMI());
    }

    private void resetValues() {
        txtHeight.setText(getString(R.string.emplyField));
        txtWeight.setText(getString(R.string.emplyField));
        lblResult.setText(getString(R.string.emplyField));
        image.setImageResource(R.drawable.bmi);
    }

    private void resultBMI(){
        float resultBMI;
        /*Validation of the fields and show his appropriate errors*/
        if(validateDate()){
            resultBMI = BC.calculateBmi(Float.parseFloat(String.valueOf(txtWeight.getText())), Float.parseFloat(String.valueOf(txtHeight.getText())));
            lblResult.setText(getString(R.string.main_bmi, resultBMI,selectedImgAndPutText(resultBMI)));
        }
    }

    private boolean validateDate(){
        if(txtWeight.getText().toString().equals("") || txtWeight.getText().toString().equals(" ") || Float.parseFloat(txtWeight.getText().toString()) <= 0){
            txtWeight.setError(getString(R.string.main_invalid_weight));
            return false;
        }else if(txtHeight.getText().toString().equals("") || txtHeight.getText().toString().equals(" ") || Float.parseFloat(txtHeight.getText().toString()) <= 0 ) {
            txtHeight.setError(getString(R.string.main_invalid_height));
            return false;
        }else{
            /*Close the keyboard of the screen*/
            SoftInputUtils.hideKeyboard(btnCalculate);
            return true;
        }
    }

    private String selectedImgAndPutText(float result) {
        String message = "";
        switch (BC.getBmiClasification(result)){
            case LOW_WEIGHT:
                message = getString(R.string.lowWeight);
                image.setImageResource(R.drawable.underweight);
                break;
            case NORMAL_WEIGHT:
                message = getString(R.string.normalWeight);
                image.setImageResource(R.drawable.normal_weight);
                break;
            case OVERWWEIGHT:
                message = getString(R.string.main_overweight);
                image.setImageResource(R.drawable.overweight);
                break;
            case OBESITY_GRADE_1:
                message = getString(R.string.obesity);
                image.setImageResource(R.drawable.obesity1);
                break;
            case OBESITY_GRADE_2:
                message = getString(R.string.obesity2);
                image.setImageResource(R.drawable.obesity2);
                break;
            case OBESITY_GRADE_3:
                message = getString(R.string.obesity3);
                image.setImageResource(R.drawable.obesity3);
                break;
        }
        return message;
    }

    // TODO

}
