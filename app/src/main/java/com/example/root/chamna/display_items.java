package com.example.root.chamna;

import android.content.Context;
import android.database.Cursor;


import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;

import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class display_items extends Fragment {
    View rootView;
    List<item> lstItem;

    public display_items() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  rootView=inflater.inflate(R.layout.display_items,container,false);
        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.recyclerview_items_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getContext(),lstItem);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrv.setAdapter(myAdapter);
        return rootView;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //SQLiteDatabase.CursorFactory = (SQLiteDatabase)  SQLiteDatabase.CursorFactory();
        SQLiteDatabase database;
       // Context ct = getContext();
       // Path dbpath = ct.getDatabasePath("ssales");
        database = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.root.chamna/databases/ssales.db", new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String s, SQLiteQuery sqLiteQuery) {
                return new SQLiteCursor(db,masterQuery, s,sqLiteQuery);
            }
        }, null);


        database.execSQL("CREATE TABLE IF NOT EXISTS items(id int, name text, cat text, des text, price int, comm int, pic text, curr text, reward text, seller text, status text, total text, paymode text, location text, rating text, expiry text)");

        Cursor cursor = database.rawQuery("SELECT * FROM items LIMIT 20", null);
        cursor.moveToFirst();

        Integer id= cursor.getCount();
        Integer c = 0;
        final String[] dbName =new String[id];
        final String[] dbCat =new String[id];
        final String[] dbDes =new String[id];
        final String[] dbPri =new String[id];
        final String[] dbCom =new String[id];
        final String[] dbNet =new String[id];
        final String[] dbPi =new String[id];
        Integer[] dbPic =new Integer[id];

        lstItem = new ArrayList<>();

        for (c=0;c<id;c++){

            String nam= cursor.getString(0);//id
            String cat= cursor.getString(1);//name
            String desc= cursor.getString(2);//cat
            String pric= cursor.getString(3);//description
            String com= cursor.getString(4);//price
            String pi= cursor.getString(5);//bonus or total commision
            String pii= cursor.getString(6);//pic
            String seller= cursor.getString(9);//pic
            Integer coi= R.drawable.logo;

            dbName[c] = nam;
            dbCat[c] = cat;
            dbDes[c] = desc;
            dbPri[c] = pric;
            dbCom[c] = com;
            dbPi[c] = pi;
            dbPic[c] = coi;

            lstItem.add(new item(nam,cat,com,desc,pric,pii,seller,pi));

            cursor.moveToNext();
        }

        database.close();



    }
}
