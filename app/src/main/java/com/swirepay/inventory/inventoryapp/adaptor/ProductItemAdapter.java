package com.swirepay.inventory.inventoryapp.adaptor;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.swirepay.inventory.inventoryapp.R;
import com.swirepay.inventory.inventoryapp.model.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class ProductItemAdapter extends  RecyclerView.Adapter<ProductItemAdapter.ViewHolder> {
    private List<ProductItem> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
            mTextView.findViewById(R.id.item_name);
        }
    }

    public ProductItemAdapter(List<ProductItem>  myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ProductItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductItem productItem = mDataset.get(position);
        holder.mTextView.setText("Name: " + productItem.getName().toString()+ "  Quantity: " + productItem.getQty().toString() +  " Price: " +productItem.getPrice().toString());
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
