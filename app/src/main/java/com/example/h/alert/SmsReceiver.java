package com.example.h.alert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by h on 2/10/2015.
 */
public class SmsReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "SMSReactor";

    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    private String yourNumber = "7407461154";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i("my broadcast","works");
        if (intent.getAction().equals(ACTION))
        {

            StringBuilder sb = new StringBuilder();

            Bundle bundle = intent.getExtras();
            if (bundle != null)
            {
                Object[] pduObj = (Object[]) bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[pduObj.length];
                String message;

                for(int i=0;i<pduObj.length;i++)
                {
                    messages[i]=SmsMessage.createFromPdu((byte[])pduObj[i]);
                }

                for (SmsMessage currentMessage : messages)
                {
                    sb.append("SMS Received From: ");

                    sb.append(currentMessage.getDisplayOriginatingAddress());
                    sb.append("\nMessage : ");

                    sb.append(currentMessage.getDisplayMessageBody());
                }

                //checking for the number
                if (messages.length > -1) {
                    String no = messages[0].getDisplayOriginatingAddress();
                    Log.v("MySMS", no);
                    if (no != null && no.trim().equals(yourNumber)) {

                        //starting main activity
                        Intent i = new Intent(context, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                        message = messages[0].getDisplayMessageBody();
                        MainActivity.setSms(message);
                    }}

            }


            Log.i(LOG_TAG, "[SMSApp] onReceive: " + sb);
           /* Show the Notification containing the Message. */
            Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
        }

        // Display the SMS as Toast.
        Toast.makeText(context, "Sms recieved", Toast.LENGTH_SHORT).show();

    }

}
