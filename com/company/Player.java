package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by oobayashinaoki on 2016/04/17.
 */
public class Player {
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;

    private int _player_no;

    public void play(){
        //盤面情報を取得し、自プレイヤーの１コマだけランダム抽出
        //抽出したコマをランダムに移動方向を決定
        //盤面に１度だけ置けるまで繰り返す
        Board my_board = new Board();
        Koma[][] current_board = my_board.showBoard();
        ArrayList<Cordinate> my_koma_list = searchMyKoma(current_board);

        boolean res = false;
        do{
            Collections.shuffle(my_koma_list);
            Cordinate pick_cordinate = my_koma_list.get(0);
            //ピックアップする座標のコマを取得
            Koma target_koma = current_board[pick_cordinate.x][pick_cordinate.y];
            //コマの動作範囲を確認しランダムに行動先を決定
            Cordinate move_cordinate = this.decideMove(target_koma.getMoveArea());
            //自ごまのあるマスには置けない
            if(current_board[pick_cordinate.x + move_cordinate.x][pick_cordinate.y + move_cordinate.y].get_has_player() == this._player_no){
                continue;//もう一度選び直し
            }
            res = my_board.moveKoma(pick_cordinate.x, pick_cordinate.y, move_cordinate.x, move_cordinate.y);
        }while(res != true);
    }

    private ArrayList<Cordinate> searchMyKoma(Koma[][] board){
        ArrayList<Cordinate> cordinate = new ArrayList<Cordinate>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j].get_has_player() ==  this._player_no){
                    cordinate.add(new Cordinate(i, j));
                }
            }
        }
        return cordinate;
    }

    private Cordinate decideMove(int[][] move_area){
        ArrayList<Cordinate> cordinate = new ArrayList<Cordinate>();
        for(int i=0; i<move_area.length; i++){
            for(int j=0; j< move_area[0].length; j++){
                if(move_area[i][j] == 1){
                    cordinate.add(new Cordinate(i, j));
                }
            }
        }
        Collections.shuffle(cordinate);
        return cordinate.get(0);
    }

    class Cordinate{
        int x;
        int y;
        public Cordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
