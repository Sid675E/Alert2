package com.example.h.alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button click;
    AlertDialog.Builder alertDialogBuilder1,alertDialogBuilder2,alertDialogBuilder3;
    AlertDialog alertDialog1,alertDialog2,alertDialog3;
    static String SmsBody1;
    //String SmsBody;
    TextView txtView ;

    public static void setSms(String SmsBody){
        SmsBody1=SmsBody;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.text_id);

        txtView.setText(SmsBody1);

        Toast.makeText(getApplicationContext(), "App opens", Toast.LENGTH_SHORT).show();

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();

        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        am.setStreamVolume(AudioManager.STREAM_NOTIFICATION,am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION),0);


            click = (Button) findViewById(R.id.click);

            // when the button is clicked Dialog Box appears
            click.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // --- find the text view --


                    // -- change text size --
                    txtView.setTextSize(24);

                    alertDialogBuilder1 = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder1.setMessage(R.string.decision1);
                    alertDialogBuilder1.setPositiveButton(R.string.positive_button,
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    box2();
                                }
                            });
                    alertDialogBuilder1.setNegativeButton(R.string.negative_button,
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    box2();
                                }
                            });

                    alertDialog1 = alertDialogBuilder1.create();
                    alertDialog1.show();

                }
            });

        }

    public void box2()
    {
        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        alertDialogBuilder2 = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder2.setMessage(R.string.decision2);
        alertDialogBuilder2.setPositiveButton(R.string.positive_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        box3();
                    }
                });
        alertDialogBuilder2.setNegativeButton(R.string.negative_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        box3();
                    }
                });

        alertDialog2 = alertDialogBuilder2.create();
        alertDialog2.show();
    }

    public void box3(){
        alertDialogBuilder3 = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder3.setMessage(R.string.decision3);
        alertDialogBuilder3.setPositiveButton(R.string.positive_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        alertDialogBuilder3.setNegativeButton(R.string.negative_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });


        alertDialog3 = alertDialogBuilder3.create();
        alertDialog3.show();
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
}
