package com.yctech.ycclistview;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    MyArrayAdapte arrayAdapter;
    ListView listView;
    LayoutInflater layoutInflater;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        listView = (ListView) findViewById(R.id.lv);
        arrayAdapter = new MyArrayAdapte(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (position) {
                    case 0:
                        fragmentTransaction.replace(R.id.fl, new Fragment1());
                        break;
                    case 1:
                        fragmentTransaction.replace(R.id.fl, new Fragment2());
                }

                fragmentTransaction.commit();
            }
        });
        layoutInflater = getLayoutInflater();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl, new Fragment1());
        fragmentTransaction.commit();

    }
    class MyArrayAdapte extends ArrayAdapter<String>{

        public MyArrayAdapte(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           // return super.getView(position, convertView, parent);
            //return arrayList.get(position);
            return layoutInflater.inflate(R.layout.layout,null);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
