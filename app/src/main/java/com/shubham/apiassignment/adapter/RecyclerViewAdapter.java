package com.shubham.apiassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.apiassignment.R;
import com.shubham.apiassignment.model.Item;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<Item> list;
    private ViewHolder hol;

    public RecyclerViewAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context)
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Item item = list.get(position);
        holder.firmId.setText(item.getFirmid());
        holder.orderDate.setText(item.getOrderDate());
        holder.orderId.setText(String.valueOf(item.getOrderNO()));
        holder.partyCode.setText(item.getPartyCode());
        holder.prdCode.setText(item.getProductCode());
        holder.qty.setText(String.valueOf(item.getQty()));
        holder.free.setText(String.valueOf(item.getFree()));
        holder.remark.setText(item.getRemark());
        holder.deliverMode.setText(item.getDeliveryMode());
        holder.salesManCode.setText(String.valueOf(item.getSalesManCode()));
        holder.itemsNo.setText(String.valueOf(item.getItemsNo()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firmId;
        public TextView orderId;
        public TextView orderDate;
        public TextView partyCode;
        public TextView prdCode;
        public TextView qty;
        public TextView free;
        public TextView remark;
        public TextView deliverMode;
        public TextView salesManCode;
        public TextView itemsNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firmId = itemView.findViewById(R.id.firmId);
            orderId = itemView.findViewById(R.id.orderID);
            orderDate = itemView.findViewById(R.id.orderDate);
            partyCode = itemView.findViewById(R.id.partyCode);
            prdCode = itemView.findViewById(R.id.prdCode);
            qty = itemView.findViewById(R.id.qty);
            free = itemView.findViewById(R.id.free);
            remark = itemView.findViewById(R.id.remark);
            deliverMode = itemView.findViewById(R.id.deliveryMode);
            salesManCode = itemView.findViewById(R.id.salesManCode);
            itemsNo = itemView.findViewById(R.id.itemsNo);


        }
    }
}
