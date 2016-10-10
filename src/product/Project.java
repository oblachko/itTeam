package product;

// Created by Ponomarenko Oleh on 06.10.2016.

import java.util.HashMap;

public class Project {

    HashMap<Code, Integer> codeList;


    public Project() {
        this.codeList = new HashMap<>();
    }

    public HashMap<Code, Integer> getCodeList() {
        return codeList;
    }

    public void setCodeList(HashMap<Code, Integer> codeList) {
        this.codeList = codeList;
    }
}
