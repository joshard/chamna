package com.example.root.chamna;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class comission extends Fragment {
    View rootView;
    List<item> lstItem;

    public comission() {

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


        database.execSQL("CREATE TABLE IF NOT EXISTS orders(id text, itemid text, buyerid text, shareid text, shareamt text, buyerRegId text,"+" buyerRegAmt text, shareRegId text, shareRegAmt text, status text, lastAct text, lastActBy text, lastActTime text, pic text, delLoc text, delMode text, payMode text, itemName text, bonus text, seller text)");
        //databased.execSQL("INSERT INTO orders VALUES ('"+id+"','"+id+"','"+buyerid+"','None','0','"+buyerregid+"','"+bonus+"'"+",'None','None','1','Placed Order','"+buyerid+"','Transaction Time','"+Pic+"','Location Pending','Delivery Mode Pending','Cash ON Delivery','"+name+"','"+bonus+"','"+seller+"')");

        Cursor cursor = database.rawQuery("SELECT * FROM orders LIMIT 20", null);
        cursor.moveToFirst();

        Integer id= cursor.getCount();
        Integer c = 0;


        lstItem = new ArrayList<>();

        for (c=0;c<id;c++){

            String nam= cursor.getString(17);//id
            String cat= cursor.getString(19);//name
            String desc= cursor.getString(2);//cat
            String pric= cursor.getString(3);//description
            String com= cursor.getString(4);//price
            String pi= cursor.getString(5);//bonus or total commision
            String pii= cursor.getString(15);//pic
            String seller= cursor.getString(9);//pic
            String bonu = cursor.getString(18);



            lstItem.add(new item(nam,cat,com,"My Number: "+desc,"Shared To: "+pric,pii,seller,bonu));

            cursor.moveToNext();
        }

        database.close();



    }
}
