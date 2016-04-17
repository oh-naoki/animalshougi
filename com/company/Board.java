package com.company;

//相手のコマを取るルール排除
public class Board {

    public final static int BOARD_WIDTH = 3;
    public final static int BOARD_HEIGHT = 4;

    private Koma[][] _board;

    public Board(){

    }

    private static void initBorad(Board board){
        for(int i=0; i<BOARD_WIDTH; i++){
            for(int j=0; j<BOARD_HEIGHT; j++){
                _board[i][j] = null;
            }
        }
    }

    /**
     * 指定された座標にコマを置く。
     * @param koma
     * @param x
     * @param y
     * @return 置ければ true
     */
    public boolean putKoma(Koma koma, int x, int y){
        if(this.judge(x, y)){
            this._board[x][y] = koma;
            return true;
        }
        return false;
    }

    /**
     * 指定した座標のコマを相対位置分だけ動かす
     * 指定するコマはプレイヤーが自らのコマを選択する前提
     * @param x
     * @param y
     * @param dx
     * @param dy
     * @return
     */
    public boolean moveKoma(int x, int y, int dx, int dy){
        Koma target_koma = this.pickKoma(x, y);
        return putKoma(target_koma, x+dx, y+dy);
    }

    /**
     * プレイヤーの思考用に盤面のクローンを返す
     * @return
     */
    public Koma[][] showBoard(){
        //boardのクローンをリターン(不正操作防止)
        return _board.clone();
    }

    /**
     * 指定した座標のコマを取る
     * @param x
     * @param y
     * @return Koma
     */
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
