package com.example.android.sunshine.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
        //Log.e(LOG_TAG, "YOYO onCReate");
    }

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        //Log.e(LOG_TAG, "YOYO onPAuse");

    }

    @Override
    public void onStop() {
        super.onStop();  // Always call the superclass method first
        //Log.e(LOG_TAG, "YOyo onStop");

    }
    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        //Log.e(LOG_TAG, "YOYO onResume");

    }
    @Override
    public void onStart() {
        super.onStart();  // Always call the superclass method first
        //Log.e(LOG_TAG, "YOYO onSTart");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass method first
        //sLog.e(LOG_TAG, "YOYO onDEstroy");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    private void openPreferedLocationInMap(){
        String location = Utility.getPreferredLocation(this);
        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q",location)
                .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        try
        {
            startActivity(intent);
        }
        catch(ActivityNotFoundException ex)
        {
            try
            {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoLocation.toString()));
                startActivity(unrestrictedIntent);
            }
            catch(ActivityNotFoundException innerEx)
            {
                Toast.makeText(this, "Please install a maps application", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //startActivity(new Intent(this,SettingsActivity.class));
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_location) {

            openPreferedLocationInMap();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}
