package com.example.root.chamna;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Item_activity extends AppCompatActivity {
private TextView tvtitle,tvdetails,tvbonus,tvprice,tvcategory;
private ImageView img;
private Button popOrderbtn,share;
String name,Pic,id,Details,price,bonus,seller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_activity);
        tvtitle = (TextView)findViewById(R.id.txtcat);
        tvdetails=(TextView)findViewById(R.id.txtdetails);
        tvprice = (TextView)findViewById(R.id.tvprice);
        tvbonus=(TextView)findViewById(R.id.tvbonus);
        tvcategory=(TextView)findViewById(R.id.txtcategory) ;
        img=(ImageView)findViewById(R.id.itemthumbnail);
        popOrderbtn=(Button)findViewById(R.id.order_id);
        share=(Button)findViewById(R.id.sharebtn);
        //receiving data
        Intent intent = getIntent();

        id=intent.getExtras().getString("ItemTitle");
        Pic=intent.getExtras().getString("Pic");
        Details=intent.getExtras().getString("Details");
        name=intent.getExtras().getString("Name");
        price=intent.getExtras().getString("Price");
        bonus=intent.getExtras().getString("Bonus");
        seller=intent.getExtras().getString("Seller");
        //int image =intent.getExtras().getInt("Thumbnail");
        ///setting values
        tvtitle.setText(name);
        tvprice.setText(price+"UGX");
        tvbonus.setText(bonus+"UGX");
        tvdetails.setText(Details);


        Bitmap dbimg = ImageUtils.convert(Pic);
        img.setImageBitmap(dbimg);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShareDialog();
            }
        });




  popOrderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });



    }
    public void openDialog(){

/*
        order_pop order_pop = new order_pop();
        order_pop.show(getSupportFragmentManager(),"order Now");
        */

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Item_activity.this);
        View mView = getLayoutInflater().inflate(R.layout.order_dialogue, null);
        final EditText Email = (EditText) mView.findViewById(R.id.amount);
        final EditText Pass = (EditText) mView.findViewById(R.id.details);
        Email.setText(name+" "+price+"UGX");
        Pass.setText(bonus+"UGX Bonus");

        Button Orderbtn = (Button) mView.findViewById(R.id.send_to_cart);



        Orderbtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0) {
// name,Pic,id,Details,price,bonus,seller;
                String buyerid ="";
                String buyerregid="";
                if(!Email.getText().toString().isEmpty() && !Pass.getText().toString().isEmpty())
                {

                    SQLiteDatabase database2 = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

                    database2.execSQL("CREATE TABLE IF NOT EXISTS users (id text,fname text,mobile text,email text,picture text,currency text,acctbal text,status text,password text,timecheck text, regby text, location text, keywords text)");

                    Cursor cursor = database2.rawQuery("SELECT * FROM users LIMIT 1", null);
                    cursor.moveToFirst();

                    Integer id= cursor.getCount();
                    Integer c = 0;

                    for (c=0;c<id;c++) {

                        buyerid = cursor.getString(2);//id
                        buyerregid = cursor.getString(10);//name
                    }



                                                    // name,Pic,id,Details,price,bonus,seller;
                    SQLiteDatabase databased = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

                    databased.execSQL("CREATE TABLE IF NOT EXISTS orders(id text, itemid text, buyerid text, shareid text, shareamt text, buyerRegId text,"+" buyerRegAmt text, shareRegId text, shareRegAmt text, status text, lastAct text, lastActBy text, lastActTime text, pic text,"+" delLoc text, delMode text, payMode text, itemName text, bonus text, seller text)");
                    databased.execSQL("INSERT INTO orders VALUES ('"+id+"','"+id+"','"+buyerid+"','None','0','"+buyerregid+"','"+bonus+"'"+",'None','None','1','Placed Order','"+buyerid+"','Transaction Time','"+Pic+"','Location Pending','Delivery Mode Pending','Cash ON Delivery','"+name+"','"+bonus+"','"+seller+"')");

                    Toast.makeText(Item_activity.this, name+": Order Sent to Seller",Toast.LENGTH_SHORT).show();

                    database2.close();



                    databased.close();

                    Intent intent = new Intent(Item_activity.this,MainActivity.class);
                    startActivity(intent);
                    Item_activity.this.finish();
                    finishAffinity();
                }else{
                    Toast.makeText(Item_activity.this, "Please fill empty fields",Toast.LENGTH_SHORT).show();

                }





            }


        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }



    public void openShareDialog(){

/*
        order_pop order_pop = new order_pop();
        order_pop.show(getSupportFragmentManager(),"order Now");
        */

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Item_activity.this);
        View mView = getLayoutInflater().inflate(R.layout.share_dialogue, null);
        final EditText Email = (EditText) mView.findViewById(R.id.amount);

        Button Orderbtn = (Button) mView.findViewById(R.id.send_to_cart);



        Orderbtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0) {
// name,Pic,id,Details,price,bonus,seller;
                String buyerid =Email.getText().toString(); //number of current user (sharer)
                String buyerregid="";
                String shareid=""; //num
                String shareReg="";
                if(!Email.getText().toString().isEmpty())
                {

                    SQLiteDatabase database2 = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

                    database2.execSQL("CREATE TABLE IF NOT EXISTS users (id text,fname text,mobile text,email text,picture text,currency text,acctbal text,status text,password text,timecheck text, regby text, location text, keywords text)");

                    Cursor cursor = database2.rawQuery("SELECT * FROM users LIMIT 1", null);
                    cursor.moveToFirst();

                    Integer id= cursor.getCount();
                    Integer c = 0;

                    for (c=0;c<id;c++) {

                        shareid = cursor.getString(2);//id
                        shareReg = cursor.getString(10);//name
                    }



                    // name,Pic,id,Details,price,bonus,seller;
                    SQLiteDatabase databased = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

                    databased.execSQL("CREATE TABLE IF NOT EXISTS orders(id text, itemid text, buyerid text, shareid text, shareamt text, buyerRegId text,"+" buyerRegAmt text, shareRegId text, shareRegAmt text, status text, lastAct text, lastActBy text, lastActTime text, pic text,"+" delLoc text, delMode text, payMode text, itemName text, bonus text, seller text)");
                    databased.execSQL("INSERT INTO orders VALUES ('"+id+"','"+id+"','"+buyerid+"','"+shareid+"','"+bonus+"','Pending','NONE'"+",'"+shareReg+"','"+bonus+"','0','Shared','"+shareid+"','Transaction Time','"+Pic+"','Location Pending','Delivery Mode Pending','Cash ON Delivery','"+name+"','"+bonus+"','"+seller+"')");

                    Toast.makeText(Item_activity.this, name+" shared to "+buyerid,Toast.LENGTH_SHORT).show();

                    database2.close();



                    databased.close();

                    Intent intent = new Intent(Item_activity.this,MainActivity.class);
                    startActivity(intent);
                    Item_activity.this.finish();
                    finishAffinity();
                }else{
                    Toast.makeText(Item_activity.this, "Please fill empty fields",Toast.LENGTH_SHORT).show();

                }





            }


        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }
}
