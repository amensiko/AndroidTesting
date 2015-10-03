package com.insrcd.androidtesting;

import android.test.AndroidTestCase;

import com.insrcd.androidtesting.math.MathParser;

/**
 * Created by anastasia on 01/10/2015.
 */
public class MathParserTest extends AndroidTestCase {
    public void testParse() {
        MathParser parser = new MathParser("5+5");

        assertEquals(parser.parse(), 10.0d);

        parser = new MathParser("2 + 5 * 5");

        assertEquals(parser.parse(), 27.0d);
    }

    public void testBrokenMathParser() {
        MathParser parser = new MathParser("5+5");

        assertEquals(parser.parse(), 10.0d);

        parser = new MathParser("2 + 5 * 5");

        assertEquals(parser.parse(), 27.0d);
    }
}
