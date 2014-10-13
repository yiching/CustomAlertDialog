package com.example.customalertdialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

    private Button m_button;
    private Dialog m_dialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m_button = (Button)findViewById(R.id.button1);
        m_button.setOnClickListener(listener);
    }
    
    private OnClickListener listener = new OnClickListener() {
        
        @Override
        public void onClick(View v) {
            
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.listview_layout, null);
            ListView listview = (ListView)view.findViewById(R.id.listView1);
            
            String[] string = {"item","time"};
            int[] ids = {R.id.textView1, R.id.textView2};
            
            SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, getData(), R.layout.list_item_layout, string, ids);
            listview.setAdapter(adapter);
            
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setNeutralButton("ok", oklistener);
            builder.setView(view);
            
            m_dialog = builder.create();
            m_dialog.setTitle("List Dialog");
            m_dialog.show();
        }
    };
    
    
    private DialogInterface.OnClickListener oklistener = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            m_dialog.dismiss();
            
        }
    };
    
    private List<HashMap<String, Object>> getData() {  
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();  
        HashMap<String, Object> map = null;  
        for (int i = 1; i <= 40; i++) {  
            map = new HashMap<String, Object>();  
            map.put("item", "item" + i);  
            map.put("time", i);  
            list.add(map);  
        }  
        return list;  
    }  
    
}
