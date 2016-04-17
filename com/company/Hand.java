package com.company;

import java.util.ArrayList;

/**
 * Created by oobayashinaoki on 2016/04/15.
 */
public class Hand {
    private ArrayList<Koma> _komaList;

    public void addKoma(Koma koma){
        this._komaList.add(koma);
    }

    public Koma getKoma(String name){
        //koma.name = nameのコマを返す
        Koma koma = new Koma();
        return koma;
    }
}
