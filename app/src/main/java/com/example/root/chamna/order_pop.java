package com.example.root.chamna;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class order_pop extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();



        View view = inflater.inflate(R.layout.order_dialogue,null);
        builder.setView(view)
                .setTitle("Place Order")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Add To Cart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //order or = new order();
// send order details bulungi
                        SQLiteDatabase database;
                        // Context ct = getContext();
                        // Path dbpath = ct.getDatabasePath("ssales");
                        database = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.root.chamna/databases/ssales.db", new SQLiteDatabase.CursorFactory() {
                            @Override
                            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String s, SQLiteQuery sqLiteQuery) {
                                return new SQLiteCursor(db,masterQuery, s,sqLiteQuery);
                            }
                        }, null);


                        database.execSQL("CREATE TABLE IF NOT EXISTS orders(id text, itemid text, buyerid text, shareid text, shareamt text, buyerRegId text," +
                                " buyerRegAmt text, shareRegId text, shareRegAmt text, status text, lastAct text, lastActBy text, lastActTime text, pic text," +
                                " delLoc text, delMode text, payMode text, itemName text, bonus text, seller text)");
                      //  database.execSQL("INSERT INTO items VALUES ('"+joo.getString("id")+"','"+joo.getString("iname")+"','"+joo.getString("icat")+"','"+joo.getString("idescrip")+"','"+joo.getString("iprice")+"','"+joo.getString("ireward")+"','"+joo.getString("ipic")+"','"+joo.getString("icurrency")+"','"+joo.getString("ireward")+"','"+joo.getString("iseller")+"','"+joo.getString("istatus")+"','"+joo.getString("itotal")+"','"+joo.getString("paymode")+"','"+joo.getString("ilocation")+"','"+joo.getString("irating")+"','"+joo.getString("iexpiry")+"')");



                        //Order or = new order(String itemid, String buyerid, String shareid, String buyreg, String sharereg,String lastact, String lastactby, String pic, String name, String bonustot) {

                        }
                });
        return builder.create();
    }
}
