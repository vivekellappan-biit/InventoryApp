package com.swirepay.inventory.inventoryapp.screens.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.swirepay.inventory.inventoryapp.MyApplication;
import com.swirepay.inventory.inventoryapp.R;
import com.swirepay.inventory.inventoryapp.adaptor.ProductItemAdapter;
import com.swirepay.inventory.inventoryapp.model.ProductItem;
import com.swirepay.inventory.inventoryapp.screens.home.product.AddProductActivity;
import com.swirepay.inventory.inventoryapp.service.DatabaseHelper;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;

    private RecyclerView listView;


    @Override
    protected void onStart() {
        super.onStart();
        showListItem();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inflateXMLView();
    }



    private void inflateXMLView(){
        listView = findViewById(R.id.list);
        floatingActionButton = findViewById(R.id.new_product_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddProductActivity.class);
                startActivity(intent);

            }
        });

        showListItem();
    }

    private void showListItem() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(layoutManager);
        ProductItemAdapter adapter = new ProductItemAdapter(MyApplication.getInstance().mPoductItemList);
        listView.setAdapter(adapter);
    }

    private void getItemFromDatabase(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<ProductItem> itemList = databaseHelper.getAllItems();
        MyApplication.getInstance().mPoductItemList.addAll(itemList);
       // load list view
       showListItem();
    }
}