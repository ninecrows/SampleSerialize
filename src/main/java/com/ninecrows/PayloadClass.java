package com.ninecrows;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PayloadClass {
    private String foo = "Unknown";
    private float[] values;
    private Map<String, String> translator = new HashMap<String, String>();
    private MoreStuff stuff = new MoreStuff("More Values", new float[20]);
    private Map<String, MoreStuff> stuffMap = new HashMap<String, MoreStuff>();

    PayloadClass() {
        values = new float[10];
        for (int ct = 0; ct < 10; ct++) {
            values[ct] = ct * 2.0f;
        }

        translator.put("A1", "Z1");
        translator.put("B1", "Y1");
        translator.put("C1", "X1");

        stuffMap.put("First", new MoreStuff("First!", new float[]{1.0f, 2.0f, 3.0f}));
        stuffMap.put("Second", new MoreStuff("Second!", new float[]{2.0f, 2.0f, 3.0f}));
        stuffMap.put("Third", new MoreStuff("Third!", new float[]{3.0f, 2.0f, 3.0f}));
        stuffMap.put("Fourth", new MoreStuff("Fourth!", new float[]{4.0f, 2.0f, 3.0f}));
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String newFoo) {
        foo = newFoo;
    }

    public float[] getValues() {
        return values;
    }

    public void setValue(float[] newValues) {
        values = newValues;
    }

    public Map<String, String> getTranslator() {
        return translator;
    }

    public void setTranslator(Map<String, String> newTranslator) {
        translator = newTranslator;
    }

    public MoreStuff getMoreStuff() {
        return stuff;
    }

    public void setMoreStuff(MoreStuff newStuff) {
        stuff = newStuff;
    }

    public Map<String, MoreStuff> getStuffMap() {
        return stuffMap;
    }

    public void setStufMap(Map<String, MoreStuff> newStuff) {
        stuffMap = newStuff;
    }

    /**
     * Class used to hold map payloads in our test map.
     */
    static class MoreStuff {
        private String identity;
        private float[] values;
        private transient String junk = "Not interesting";

        public MoreStuff() {

        }

        public MoreStuff(String myIdentity,
                         float[] myValues) {
            identity = myIdentity;
            values = myValues;
        }

        public String getIdentity() {
            return identity;
        }

        public float[] getValues() {
            return values;
        }

        public void nosetIdentity(String newIdentity) {
            identity = newIdentity;
        }

        public void nosetValues(float[] newValues) {
            values = newValues;
        }
    }
}
