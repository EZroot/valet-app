package com.genoa.recyclenearby;

import android.app.Application;
import android.telephony.SmsManager;

public class SmsSingleton
{
    SmsManager smgr;
    private static SmsSingleton Instance = null;

    private SmsSingleton(){};

    public static SmsSingleton getInstance()
    {
        if(Instance==null)
        {
            Instance = new SmsSingleton();
        }
        return Instance;
    }

    public void SendText(String text, String number)
    {
        smgr.sendTextMessage(number, null, text, null, null);
    }
}
