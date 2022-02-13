/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.gomokugame;

/**
 *
 * @author Nastya
 */
public class Response {
    int idPlayer = 0;
    String str = "";
    int x = -1;
    int y = -1;
    int getId = 0;
    int lastPlayer;
    boolean changeField = false;
    boolean isStart = false;


    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGetId() {
        return getId;
    }

    public void setGetId(int getId) {
        this.getId = getId;
    }

    public int getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(int lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public boolean isChangeField() {
        return changeField;
    }

    public void setChangeField(boolean changeField) {
        this.changeField = changeField;
    }

}
