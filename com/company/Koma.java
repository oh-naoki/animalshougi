package com.company;

/**
 * Created by oobayashinaoki on 2016/04/15.
 */
public class Koma {
    private String _name;
    private int[][] _move_area;
    private int _has_player;

    public void setName(String name){
        this._name = name;
    }

    public String getName(){
        return this._name;
    }

    public void setMoveArea(int[][] move_area){
        this._move_area = move_area;
    }

    public int[][] getMoveArea() {
        return this._move_area;
    }

    public int get_has_player(){
        return this._has_player;
    }
}
