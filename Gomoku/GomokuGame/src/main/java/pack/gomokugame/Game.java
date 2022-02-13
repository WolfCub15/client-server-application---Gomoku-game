/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.gomokugame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nastya
 */

public class Game extends Thread{
    char[][] field = new char[15][15];
    int currentPlayer = 0;
    char currentSymb;
    int last_x = -10;
    int last_y = -10;
    int last_player = -1;
    boolean player1IsReady = false;
    boolean player2IsReady = false;
    boolean winPlayer1 = false;
    boolean winPlayer2 = false;
    Response toFirstClient = new Response();
    Response toSecondClient = new Response();
    Response fromFirstClient = new Response();
    Response fromSecondClient = new Response();

    
    public Game(){
        for(int i = 0; i < 15;++i){
            for(int j=0; j < 15;++j){
                field[i][j] = '.';
            }
        }
        toFirstClient = null;
        toSecondClient = null;
        fromFirstClient = null;
        fromSecondClient = null;
        
        this.start();
    }
    
    @Override
    public void run(){
        try {
            while(!(player1IsReady == true && player2IsReady == true)){
                System.out.println("Waiting for clients...");
            }
            currentPlayer = 0;
            System.out.println("GomokuGame started!");
                        
            while(winPlayer1 == false && winPlayer2 == false){
                currentSymb = currentPlayer == 0 ? 'O' : 'X';
                
                if (currentPlayer == 0){
                    setToFirstClient(stringResponse(0, "your move"));
                    setToSecondClient(stringResponse(1, "wait for your move"));
                }
                else{
                    setToFirstClient(stringResponse(0, "wait for your move"));
                    setToSecondClient(stringResponse(1, "your move"));
                }
                
                if (currentPlayer == 0){
                    while(getFromFirstClient()== null){
                        System.out.println("Waiting for the 0 player's move...");
                    }
                }
                else{
                    while(getFromSecondClient()== null){
                        System.out.println("Waiting for the 1 player's move...");
                    }
                }
                Response r;
                if (currentPlayer == 0){
                    r = getFromFirstClient();
                    setFromFirstClient(null);
                }
                else{
                    r = getFromSecondClient();
                    setFromSecondClient(null);
                }
                                
                if (r.x > 0 && r.y > 0 && r.x < 15 && r.y < 15){
                    int x = r.x;
                    int y = r.y;

                    if (setValue(currentPlayer, x, y)){
                        if (currentPlayer == 0){
                            if (check(0, currentSymb, x, y)){
                                setWinPlayer1(true);
                            }
                            currentPlayer = 1;
                        }
                        else {
                            if (check(1, currentSymb, x, y)){
                                setWinPlayer2(true);
                            }
                            currentPlayer = 0;
                        }
                    }
                }   
            }
            
            if (isWinPlayer1() == true){
                setToFirstClient(stringResponse(0, "you win"));
                setToSecondClient(stringResponse(1, "you lose"));
                System.out.println("Winner:  0 player");
            }
            else{
                setToFirstClient(stringResponse(0, "you lose"));
                setToSecondClient(stringResponse(1, "you win"));
                System.out.println("Winner:  1 player");
            }
            
            Game.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    synchronized
    public boolean setValue(int player, int x, int y){
        x--;
        y--;
        if (player == 0){
            if(field[x][y] == '.'){
                field[x][y] = 'O';
                last_x = x;
                last_y = y;
                last_player = player;
                return true;
            }
            else return false;
        }
        else {
            if(field[x][y] == '.'){
                field[x][y] = 'X';
                last_x = x;
                last_y = y;
                last_player = player;
                return true;
            }
            else return false;
        }
    }
    
    synchronized 
    public Response getResponse(int id){
        Response r = new Response();
        r.idPlayer = id;
        r.lastPlayer = last_player;
        r.x = last_x;
        r.y = last_y;
        r.changeField = true;
        
        return r;
    }
    
    synchronized 
    public Response stringResponse(int player, String s){
        Response r = new Response();
        r.idPlayer = player;
        r.str = s;
        r.lastPlayer = last_player;
        r.x = last_x;
        r.y = last_y;
        r.changeField = true;
                
        return r;
    }
    
    synchronized 
    public boolean check(int player, char c, int x, int y){
        x--;
        y--;
        int count = 0;
        for (int i = x; i >= 0; --i){
            if (field[i][y] == c) count++;
            else break;
        }
        for (int i = x + 1; i < 15 ; ++i){
            if (field[i][y] == c) count++;
            else break;
        }
        if (count == 5) return true;
        
        count = 0;
        for (int j = y; j >= 0; --j){
            if (field[x][j] == c) count ++;
            else break;
        }
        for (int j = y + 1; j < 15 ; ++j){
            if (field[x][j] == c) count++;
            else break;
        }
        if (count == 5) return true;
        
        count = 0;
        for (int i = x, j = y; i >= 0 && j >= 0; --i, --j){
            if (field[i][j] == c) count++;
            else break;
        }
        for (int i = x + 1, j = y + 1; i < 15 && j < 15; ++i, ++j){
            if (field[i][j] == c) count++;
            else break;
        }
        if (count == 5) return true;
        
        count = 0;
        for (int i = x, j = y; i >= 0 && j <15; --i, ++j){
            if (field[i][j] == c) count++;
            else break;
        }
        for (int i = x + 1, j = y + 1; i < 15 && j >= 0; ++i, --j){
            if (field[i][j] == c) count++;
            else break;
        }
        return 5 == count;
    }

    synchronized 
    public char[][] getField() {
        return field;
    }
    
    synchronized 
    public void setField(char[][] field) {
        this.field = field;
    }
    
    synchronized 
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    synchronized 
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    synchronized
    public Response getToFirstClient() {
        return toFirstClient;
    }

    synchronized
    public void setToFirstClient(Response toFirstClient) {
        this.toFirstClient = toFirstClient;
    }

    synchronized
    public Response getToSecondClient() {
        return toSecondClient;
    }

    synchronized
    public void setToSecondClient(Response toSecondClient) {
        this.toSecondClient = toSecondClient;
    }

    synchronized
    public Response getFromFirstClient() {
        return fromFirstClient;
    }

    synchronized
    public void setFromFirstClient(Response fromFirstClient) {
        this.fromFirstClient = fromFirstClient;
    }

    synchronized
    public Response getFromSecondClient() {
        return fromSecondClient;
    }

    synchronized
    public void setFromSecondClient(Response fromSecondClient) {
        this.fromSecondClient = fromSecondClient;
    }
    
    synchronized
    public int getLast_x() {
        return last_x;
    }

    synchronized
    public void setLast_x(int last_x) {
        this.last_x = last_x;
    }

    synchronized
    public int getLast_y() {
        return last_y;
    }

    synchronized
    public void setLast_y(int last_y) {
        this.last_y = last_y;
    }

    synchronized
    public int getLast_player() {
        return last_player;
    }

    synchronized
    public void setLast_player(int last_player) {
        this.last_player = last_player;
    }

    synchronized
    public boolean isPlayer1IsReady() {
        return player1IsReady;
    }

    synchronized
    public void setPlayer1IsReady(boolean player1IsReady) {
        this.player1IsReady = player1IsReady;
    }

    synchronized
    public boolean isPlayer2IsReady() {
        return player2IsReady;
    }

    synchronized
    public void setPlayer2IsReady(boolean plater2IsReady) {
        this.player2IsReady = plater2IsReady;
    }

    synchronized
    public boolean isWinPlayer1() {
        return winPlayer1;
    }

    synchronized
    public void setWinPlayer1(boolean winPlayer1) {
        this.winPlayer1 = winPlayer1;
    }

    synchronized
    public boolean isWinPlayer2() {
        return winPlayer2;
    }

    synchronized
    public void setWinPlayer2(boolean winPlayer2) {
        this.winPlayer2 = winPlayer2;
    }

}
