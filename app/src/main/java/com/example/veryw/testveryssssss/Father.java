package com.example.veryw.testveryssssss;

import java.io.Serializable;

/**
 * Created by veryw on 2019-11-01
 */
public class Father implements Serializable {
    int old;

    public Father(int old) {
        this.old = old;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return "Father{" +
                "old=" + old +
                '}';
    }

}
