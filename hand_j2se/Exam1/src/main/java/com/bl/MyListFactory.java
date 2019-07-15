package com.bl;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListFactory implements AbstractListFactory{
    @Override
    public ArrayList generateList() {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<50;i++) {
            int num = (int)(Math.random()*100);
            list.add(num);
            int tem = num/10;
            if(map.containsKey(tem)){
                map.get(tem).add(num);
            }
            else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(num);
                map.put(tem,l);
            }
        }
        return list;
    }

    @Override
    public void sortList() {

    }
}
