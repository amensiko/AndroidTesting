package com.insrcd.androidtesting;

import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

/**
 * Created by ashaw on 10/1/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2 {
    private MainActivity mActivity;


    public MainActivityTest(){
        super(MainActivity.class); ;

        mActivity = (MainActivity) getActivity();

    }



    public void testPlusButton(){
        mActivity.onCreate(Bundle.EMPTY, null);

        Button plusButton = (Button) mActivity.findViewById(R.id.btn_plus); // grab the + button

        assertTrue(plusButton.hasOnClickListeners());

        plusButton.callOnClick();
    }
}
