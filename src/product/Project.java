package product;

// Created by Ponomarenko Oleh on 06.10.2016.

import java.util.HashMap;
import java.util.Map;

public class Project {

    Map<Code, Integer> codeList = new HashMap<>();


    public Project() {
    }

    public Project(HashMap<Code, Integer> codeList) {
        this.codeList = codeList;
    }
}
