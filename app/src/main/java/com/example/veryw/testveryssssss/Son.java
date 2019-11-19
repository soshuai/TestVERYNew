package com.example.veryw.testveryssssss;

import java.io.Serializable;

/**
 * Created by veryw on 2019-11-01
 */
public class Son  implements Serializable {
    String name;
    Father father;

    public Son() {}

    public Son(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", father=" + father +
                '}';
    }
}
