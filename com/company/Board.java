package com.company;

//相手のコマを取るルール排除
public class Board {
    private Koma[][] _board;

    public boolean putKoma(Koma koma, int x, int y){
        if(this.judge(x, y)){
            this._board[x][y] = koma;
            return true;
        }
        return false;
    }

    public boolean moveKoma(int x, int y, int dx, int dy){
        Koma target_koma = this.pickKoma(x, y);
        return putKoma(target_koma, x+dx, y+dy);
    }

    public Koma[][] showBoard(){
        //boardのクローンをリターン(不正操作防止)
        return _board.clone();
    }

    public Koma pickKoma(int x, int y){
        return this._board[x][y];
    }

    /**
     * 引数の座標にコマを置けるか判断する
     * @return boolean
     */
    public boolean judge(int x, int y){
        if(this._board[x][y] != null){
            return false;
        }
        return true;
    }
}
