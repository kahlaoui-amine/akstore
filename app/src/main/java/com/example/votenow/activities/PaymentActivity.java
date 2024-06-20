package com.example.votenow.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.example.votenow.R;
import com.example.votenow.databinding.ActivityPaymentBinding;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Toast;

import com.example.votenow.adapters.CartAdapter;
import com.example.votenow.model.Product;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.model.Item;
import com.hishd.tinycart.util.TinyCartHelper;
import java.util.ArrayList;
import java.util.Map;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;
    ProgressDialog CODp;

    double total;
    String orderCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        orderCode = getIntent().getStringExtra("orderCode");
        total = getIntent().getDoubleExtra("total", 1);

        binding.COD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processCOD();
            }
        });

        binding.Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processCard();
            }
        });




        binding.order.setText("Your Order Number is: " + orderCode);

        getSupportActionBar().setTitle("Payment Method");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    void processCOD(){
        new AlertDialog.Builder(this)
                .setTitle("Cash on Delivery")
                .setCancelable(false)
                .setMessage("Your products will be shipped within 24 hours. " +
                        "You can pay  " + total + " to the courier when you recieve the products at your doorstep.")
                .setPositiveButton("Confirm Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PaymentActivity.this,HomeActivity.class);
                        Toast.makeText(PaymentActivity.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                        intent.putExtra("check","placed");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .show();
    }
    void processCard(){
        new AlertDialog.Builder(this)
                .setTitle("Paying With Card")
                .setCancelable(false)
                .setMessage("Place your payment of  " + total + " through Cash to 01608504435 within 2 hours with this Order no. Your products will then be shipped within 24 hours. " +
                        "If you do not pay within 2 hours, your order will be cancelled.")
                .setPositiveButton("Confirm Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PaymentActivity.this,HomeActivity.class);
                        Toast.makeText(PaymentActivity.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                        intent.putExtra("check","placed");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).
                show();
    }


    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}