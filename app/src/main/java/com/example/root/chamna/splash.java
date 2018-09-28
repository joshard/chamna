package com.example.root.chamna;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Intent;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Bundle;
import android.os.StrictMode;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class splash extends AppCompatActivity {

    String sendaddress = "http://192.168.173.1/s_sales/phpread.php";
    String address = "http://192.168.173.1/s_sales/getAllItems.php";

    InputStream is= null;
    OutputStream os=null;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());



        Button Login = (Button) findViewById(R.id.login);
        Login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                EditText Email = (EditText) findViewById(R.id.number);

// send info to serve and get response!!!
                //save user info from server after


                if (!Email.getText().toString().isEmpty()) {
                    String em = Email.getText().toString();

                    sendData(em,em);

                    //SQLiteDatabase databased = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

                    //databased.execSQL("CREATE TABLE IF NOT EXISTS users (id text,fname text,mobile text,email text,picture text,currency text,acctbal text,status text,lname text,password text,timecheck text, regby text, location text, keywords text)");

                    //insert user data from online server when number submited and is stored.
                   // databased.execSQL("INSERT INTO users VALUES ('1','Emenyu Jude','256782195747','emenyu@serenityug.com','default.jpg','UGX','35000','1','judeallblack','1234','2018:09:09 10:14:00','Admin','lat long location of user','Admin search keywords')");

                    //databased.close();




                } else {
                    Toast.makeText(splash.this, "Please enter Number", Toast.LENGTH_SHORT).show();

                }


            }


        });

    }





        private void sendData(String fnam, String lnam){
            final String fname = fnam;
            final String lname = lnam;

            // Initialize  AsyncLogin() class with email and password
            new AsyncLogin().execute(fname,lname);

        }

        private class AsyncLogin extends AsyncTask<String, String, String>
        {
            ProgressDialog pdLoading = new ProgressDialog(splash.this);
            HttpURLConnection conn;
            URL url = null;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread
                pdLoading.setMessage("\tVerifying, Please wait..");
                pdLoading.setCancelable(false);
                pdLoading.show();

            }
            @Override
            protected String doInBackground(String... params) {
                try {

                    // Enter URL address where your php file resides
                    url = new URL(sendaddress);

                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return "exception";
                }
                try {
                    // Setup HttpURLConnection class to send and receive data from php and mysql
                    conn = (HttpURLConnection)url.openConnection();
                    int READ_TIMEOUT = 600000000; //JUROS
                    conn.setReadTimeout(READ_TIMEOUT );
                    int CONNECTION_TIMEOUT= 100000000; //JUROS
                    conn.setConnectTimeout(CONNECTION_TIMEOUT);
                    conn.setRequestMethod("POST");

                    // setDoInput and setDoOutput method depict handling of both send and receive
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    // Append parameters to URL
                    Uri.Builder builder = new Uri.Builder()
                            .appendQueryParameter("fname", params[0])
                            .appendQueryParameter("lname", params[1]);
                    String query = builder.build().getEncodedQuery();

                    // Open connection for sending data
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();
                    conn.connect();

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return "exception";
                }

                try {

                    int response_code = conn.getResponseCode();

                    // Check if successful connection made
                    if (response_code == HttpURLConnection.HTTP_OK) {

                        // Read data sent from server
                        InputStream input = conn.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        StringBuilder result = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }

                        // Pass data to onPostExecute method
                        return(result.toString());

                    }else{

                        return("unsuccessful");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return "exception";
                } finally {
                    conn.disconnect();
                }


            }

            @Override
            protected void onPostExecute(String result) {

                //this method will be running on UI thread

                pdLoading.dismiss();

                if(result!="")
                {

                    try {
                        JSONArray ja = new JSONArray(result);
                        JSONObject jo= ja.getJSONObject(0);

                        String emailh = ""+jo.getString("email");
                        if(ja.length()>0){

                            SQLiteDatabase database2 = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

                            database2.execSQL("CREATE TABLE IF NOT EXISTS users (id text,fname text,mobile text,email text,picture text,currency text,acctbal text,status text,password text,timecheck text, regby text, location text, keywords text)");
                            database2.execSQL("INSERT INTO users VALUES ('"+jo.getString("id")+"','"+jo.getString("fname")+"','"+jo.getString("mobile")+"','"+jo.getString("email")+"','"+jo.getString("picture")+"','"+jo.getString("currency")+"','"+jo.getString("acctbal")+"','"+jo.getString("status")+"','"+jo.getString("password")+"','"+jo.getString("timecheck")+"','"+jo.getString("regby")+"','"+jo.getString("location")+"','"+jo.getString("keywords")+"')");

                            Toast.makeText(splash.this, "Verification success:"+emailh, Toast.LENGTH_LONG).show();

                            database2.close();








                            try{

                                URL url = new URL(address);
                                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                                con.setRequestMethod("GET");
                                is=new BufferedInputStream(con.getInputStream());

                                //send to php from HttpURLConnection???????????

                            }catch(Exception e){
                                e.printStackTrace();
                                Toast.makeText(splash.this, "Connection to server failed", Toast.LENGTH_SHORT).show();

                            }

                            String[] data;
                            String[] iname;
                            String[] idescrip;
                            String[] icat;
                            String[] ipic;
                            String[] iprice;
                            String[] ireward;
                            String[] icurr;
                            String[] itot;
                            String[] iid;
                            String jurosDB;
                            SQLiteDatabase database = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);


                            database.execSQL("CREATE TABLE IF NOT EXISTS items(id int, name text, cat text, des text, price int, comm int, pic text, curr text, reward text, seller text, status text, total text, paymode text, location text, rating text, expiry text)");
                            try{
                                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                                StringBuilder sb = new StringBuilder();

                                while((line=br.readLine()) != null){
                                    sb.append(line);

                                    JSONArray jaa = new JSONArray(line);
                                    int count=jaa.length();

                                    //populate string array for adapter
                                    data= new String[count];
                                    iname= new String[count];
                                    icat= new String[count];
                                    idescrip= new String[count];
                                    ipic= new String[count];
                                    iprice= new String[count];
                                    ireward= new String[count];
                                    itot= new String[count];
                                    iid= new String[count];




                                    for(int i =0; i<jaa.length();i++){
                                        JSONObject joo= jaa.getJSONObject(i);
                                        database.execSQL("INSERT INTO items VALUES ('"+joo.getString("id")+"','"+joo.getString("iname")+"','"+joo.getString("icat")+"','"+joo.getString("idescrip")+"','"+joo.getString("iprice")+"','"+joo.getString("ireward")+"','"+joo.getString("ipic")+"','"+joo.getString("icurrency")+"','"+joo.getString("ireward")+"','"+joo.getString("iseller")+"','"+joo.getString("istatus")+"','"+joo.getString("itotal")+"','"+joo.getString("paymode")+"','"+joo.getString("ilocation")+"','"+joo.getString("irating")+"','"+joo.getString("iexpiry")+"')");

                                    }
                                    Toast.makeText(splash.this, "Items Updated", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(splash.this,MainActivity.class);
                                    startActivity(intent);
                                    splash.this.finish();
                                    finishAffinity();


                                }


                                is.close();
                                result=sb.toString();


                            }catch(Exception e){
                                e.printStackTrace();
                                Toast.makeText(splash.this, "Unable to update tables", Toast.LENGTH_SHORT).show();

                            }















                        }else{
                            Toast.makeText(splash.this, "Unregistered number: "+emailh, Toast.LENGTH_LONG).show();

                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        Toast.makeText(splash.this, "Unrecongised credentials...", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(splash.this,MainActivity.class);
                        startActivity(intent);
                        splash.this.finish();

                    }


                }else if (result.equalsIgnoreCase("false")){

                    // If username and password does not match display a error message
                    Toast.makeText(splash.this, "Invalid Details", Toast.LENGTH_LONG).show();

                } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                    Toast.makeText(splash.this, "Connection Problem. Try Again", Toast.LENGTH_LONG).show();

                }
            }

        }


    }
