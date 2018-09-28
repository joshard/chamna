package com.example.root.chamna;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

       //check sqlite DB
        SQLiteDatabase database2 = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);

        database2.execSQL("CREATE TABLE IF NOT EXISTS users (id text,fname text,mobile text,email text,picture text,currency text,acctbal text,status text,password text,timecheck text, regby text, location text, keywords text)");

        Cursor cursor = database2.rawQuery("SELECT * FROM users LIMIT 2", null);
        cursor.moveToFirst();

        Integer id= cursor.getCount();
        Integer c = 0;

        database2.close();

        if(id>c){
         //   Toast.makeText(MainActivity.this, "Welcome "+cursor.getString(1), Toast.LENGTH_LONG).show();
  }
        else if (id==c){
            //
            Intent i=new Intent(MainActivity.this,splash.class);
            startActivity(i);
            finishAffinity();

        }



























        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_view_list_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_monetization_on_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account_circle_black_24dp);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    display_items tab1 = new display_items();
                    return tab1;
                case 1:
                    comission tab2 = new comission();
                    return tab2;
                case 2:
                    shop_cart tab3 = new shop_cart();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

//delete after use!!!!
    private void getItemz() {
        // TODO Auto-generated method stub
        SQLiteDatabase database = openOrCreateDatabase("ssales.db", MODE_PRIVATE, null);



        database.execSQL("CREATE TABLE IF NOT EXISTS items(id int, name text, cat text, des text, price int, comm int, pic text)");

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

        if(c<id){
            for (c=0;c<id;c++){

                String nam= cursor.getString(1);//name
                String cat= cursor.getString(2);//cat
                String desc= cursor.getString(3);//descrip
                String pric= cursor.getString(4);//price
                String com= cursor.getString(5);//comm
                String pi= cursor.getString(6);//pic
                Integer coi= R.drawable.logo;

                dbName[c] = nam;
                dbCat[c] = cat;
                dbDes[c] = desc;
                dbPri[c] = pric;
                dbCom[c] = com;
                dbPi[c] = pi;
                dbPic[c] = coi;

                cursor.moveToNext();
            }

        }



        database.close();



    }
}
