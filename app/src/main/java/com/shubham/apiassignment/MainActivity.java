package com.shubham.apiassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shubham.apiassignment.adapter.RecyclerViewAdapter;
import com.shubham.apiassignment.data.HttpRequest;
import com.shubham.apiassignment.model.Item;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "httpRequest";
    private ArrayList<Item> itemArrayList ;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        HttpRequest httpRequest= new HttpRequest(MainActivity.this);
        itemArrayList = new ArrayList<>();

        try {
            String s = httpRequest.execute().get();
            Log.d(TAG, "onCreate: " + s );

            if (s != null){
                JSONObject jsonObject = new JSONObject(s);

                Log.d(TAG, "onCreate: " + jsonObject.get("igb_srlord"));
                String resp = String.valueOf(jsonObject.get("igb_srlord"));

                getArrayList(resp);
            }


        } catch (ExecutionException | InterruptedException | JSONException  e) {
            e.printStackTrace();

            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        Log.d(TAG, "onCreate: SIZE" + itemArrayList.size());


    }

    private void getArrayList(String resp) {
        String[] split_column = resp.split("!!");

        for (int i = 1; i<split_column.length; i++) {
            Log.d(TAG, "doInBackground: " + split_column[i] );

            String[] eachValue = split_column[i].split("\\|");
            Item item  = new Item();
            item.setFirmid(eachValue[0]);
            item.setOrderNO(Integer.parseInt(eachValue[1]));
//                SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
//                simpleDateFormat.applyPattern("");
//                String date = eachValue[2];
//                Date.valueOf(date);
            item.setOrderDate(eachValue[2]);
            item.setPartyCode(eachValue[3]);
            item.setProductCode(eachValue[4]);
            item.setQty(Integer.parseInt(eachValue[5]));
            if(eachValue[6].equals("")){
                item.setFree(0);
            }else {
                item.setFree(Integer.parseInt(eachValue[6]));
            }
            item.setRemark(eachValue[7]);
            item.setDeliveryMode(eachValue[8]);
            item.setSalesManCode(Integer.parseInt(eachValue[9]));
            item.setItemsNo(Integer.parseInt(eachValue[10]));
            itemArrayList.add(item);

            Log.d(TAG, "doInBackground: " + item.toString());
        }
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, itemArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        Log.d(TAG, "getArrayList: " + recyclerViewAdapter.getItemCount());

    }
}