package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterationActivity extends AppCompatActivity {
    EditText nameTF,contactTF,addressTF;
    Spinner genderSpinner,bloodTypeSpinner;
    String username,contact,address, gender,blood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        setTitle("Registeration");

        initializationFields();

    }

    void initializationFields(){
        // initialization of fields
        nameTF = (EditText) findViewById(R.id.nameTF);
        contactTF = (EditText) findViewById(R.id.contactTF);
        addressTF = (EditText) findViewById(R.id.addressTF);
        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        bloodTypeSpinner = (Spinner) findViewById(R.id.bloodTypeSpinner);
    }

    public void clearFunction(View view){
        nameTF.setText("");
        contactTF.setText("");
        addressTF.setText("");
        genderSpinner.setSelection(0,true);
        bloodTypeSpinner.setSelection(0,true);
    }

    public void registerFunction(View view){
        username = String.valueOf(nameTF.getText());
        contact = String.valueOf(contactTF.getText());
        address = String.valueOf(addressTF.getText());
        gender = String.valueOf(genderSpinner.getSelectedItem());
        blood = String.valueOf(bloodTypeSpinner.getSelectedItem());

        System.out.println(gender + "\t"+ blood);

        if(validate()) {

            Intent i = new Intent(RegisterationActivity.this, RegisterationSuccess.class);
            i.putExtra("name", username);
            i.putExtra("contact", contact);
            i.putExtra("address", address);
            i.putExtra("gender", gender);
            i.putExtra("blood", blood);
            this.startActivity(i);
        }
    }

    boolean validate(){
        boolean res = true;
        if(username.equals("")){
            res = false;
            Toast.makeText(getApplicationContext(), "Name field cannot be empty", Toast.LENGTH_LONG).show();
        }

        if(gender.equals("Select Gender")){
            res = false;
            Toast.makeText(getApplicationContext(), "Please Select Gender", Toast.LENGTH_LONG).show();
        }

        if(blood.equals("Select Blood Type")){
            res = false;
            Toast.makeText(getApplicationContext(), "Please Select Blood Type", Toast.LENGTH_LONG).show();
        }

        if(contact.equals("")){
            res = false;
            Toast.makeText(getApplicationContext(), "Contact field cannot be empty", Toast.LENGTH_LONG).show();
        }
        if(address.equals("")){
            res = false;
            Toast.makeText(getApplicationContext(), "Address field cannot be empty", Toast.LENGTH_LONG).show();
        }

        return res;
    }
}