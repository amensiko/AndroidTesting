package com.insrcd.androidtesting;

import android.app.Instrumentation;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ashaw on 10/1/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;


    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mInstrumentation = getInstrumentation();
        mMainActivity =  getActivity();
    }


    public void testClearButton(){
        /*TextView txtView = (TextView) mActivity.findViewById(R.id.txt_calc);
          mActivity.onCreate(Bundle.EMPTY, null);
          mActivity = getActivity();
          Button plusButton = (Button) mActivity.findViewById(R.id.btn_plus); // grab the + button
          assertTrue(plusButton.hasOnClickListeners());
          plusButton.callOnClick();
          assertEquals(txtView.getText().toString(), "+");*/

        /*Button clearButton = (Button) mActivity.findViewById(R.id.btn_clear);
          assertTrue(clearButton.hasOnClickListeners());
          clearButton.callOnClick();
          assertEquals(txtView.getText().toString(), "");*/


        mMainActivity =  getActivity();

        TextView txtView = (TextView) mMainActivity.findViewById(R.id.txt_calc);

        Button clearBtn = (Button) mMainActivity.findViewById(R.id.btn_clear);

        assertTrue(clearBtn.hasOnClickListeners());

        TouchUtils.clickView(MainActivityTest.this, clearBtn);

        assertEquals(txtView.getText().toString(), "");

    }
}
