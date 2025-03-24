package com.swirepay.inventory.inventoryapp.screens.home.product;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.swirepay.inventory.inventoryapp.MyApplication;
import com.swirepay.inventory.inventoryapp.R;
import com.swirepay.inventory.inventoryapp.model.ProductItem;
import com.swirepay.inventory.inventoryapp.screens.home.HomeActivity;
import com.swirepay.inventory.inventoryapp.service.DatabaseHelper;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        inflateXMLView();
    }


    private void inflateXMLView(){
        TextInputEditText itemIdTextInputEditText = findViewById(R.id.item_id);
        TextInputEditText itemNameTextInputEditText = findViewById(R.id.name);
        TextInputEditText quantityTextInputEditText = findViewById(R.id.item_quantity);
        TextInputEditText priceTextInputEditText = findViewById(R.id.item_price);
        TextInputEditText totalTextInputEditText = findViewById(R.id.total);

        Button btnAddItem = findViewById(R.id.add);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            MyApplication myApplication = MyApplication.getInstance();
           myApplication.mPoductItemList.add(new ProductItem(itemIdTextInputEditText.getText().toString(), itemNameTextInputEditText.getText().toString(), quantityTextInputEditText.getText().toString(), priceTextInputEditText.getText().toString(), totalTextInputEditText.getText().toString()));


            // save data to database
            DatabaseHelper databaseHelper = new DatabaseHelper(AddProductActivity.this);
            databaseHelper.addItem(new ProductItem(itemIdTextInputEditText.getText().toString(), itemNameTextInputEditText.getText().toString(), quantityTextInputEditText.getText().toString(), priceTextInputEditText.getText().toString(), totalTextInputEditText.getText().toString()));

            Intent intent = new Intent(AddProductActivity.this, HomeActivity.class);
            startActivity(intent);

            }
        });

        priceTextInputEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0) {
                    double price = Double.parseDouble(s.toString());
                    double quantity = Double.parseDouble(quantityTextInputEditText.getText().toString());
                    double total = price * quantity;
                    Log.d(AddProductActivity.class.getSimpleName(),""+total);
                    totalTextInputEditText.setText(""+total);





                }}



        });






    }
}