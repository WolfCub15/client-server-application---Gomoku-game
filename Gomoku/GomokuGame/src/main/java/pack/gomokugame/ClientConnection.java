/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package pack.gomokugame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 *
 * @author Nastya
 */
public class ClientConnection extends Thread {
    DataInputStream dis;
    DataOutputStream dos;
    Socket cs;
    int currPlayer = 0;
    char currSymb;
    Game game;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

        
    public ClientConnection (Socket cs, Game game, int playerNumber) {
        try {
            this.cs = cs;
            this.currPlayer = playerNumber;
            this.game = game;
            if (playerNumber == 0) {
                currSymb = 'O';
            } else {
                currSymb = 'X';
            }

            dis = new DataInputStream( cs.getInputStream());
            dos = new DataOutputStream( cs.getOutputStream());
            sendId(playerNumber);
            
            this.start();
        } catch(IOException e){System.out.println("Connection:"+e.getMessage());
        }
    }
    
    @Override
    public void run() { 
        try {
            dis = new DataInputStream(cs.getInputStream());
            try {
                if (currPlayer == 0){
                    game.setPlayer1IsReady(true);
                }
                else {
                    game.setPlayer2IsReady(true);
                }
                
                try {
                    while (game.isWinPlayer1() == false && game.isWinPlayer2() == false){
                        
                        if (currPlayer == 0){
                            while(game.getToFirstClient() == null){
                                System.out.println("Wait  0 player");
                            } 
                        }
                        else {
                            while(game.getToSecondClient() == null){
                                System.out.println("Wait  1 player");
                            }         
                        }

                        Response r;
                        if (currPlayer == 0){
                            r = game.getToFirstClient();
                            send(r);
                            game.setToFirstClient(null);
                        }
                        else{
                            r = game.getToSecondClient();
                            send(r);
                            game.setToSecondClient(null);
                        }

                        if (r.str.equals("wait for your move")){
                            ClientConnection.sleep(100);
                            continue;
                        }
                        if ("you win".equals(r.str) || "you lose".equals(r.str)){
                            ClientConnection.sleep(100);
                            return;
                        }

                        String obj = dis.readUTF();
                        Response inputR = gson.fromJson(obj,Response.class);

                        String coord;
                        coord = inputR.str.substring(1, inputR.str.length() - 1);

                        String[] split_msg = coord.split(" ");
                        System.out.println("Coord: " + coord);
                        System.out.println("Response from client : " + obj);

                        inputR.x = Integer.parseInt(split_msg[0]);
                        inputR.y = Integer.parseInt(split_msg[1]);
                        
                        if (currPlayer == 0) {
                            game.setFromFirstClient(inputR);
                        } 
                        else {
                            game.setFromSecondClient(inputR);
                        }
                    }

                    Response responseToClient;
                    if (currPlayer == 0){
                        while(game.getToFirstClient() == null){
                            System.out.println("Wait 0...");
                        }
                        responseToClient = game.getToFirstClient();
                    }
                    else{
                        while(game.getToSecondClient() == null){
                            System.out.println("Wait 1...");
                        }
                        responseToClient = game.getToSecondClient();
                    }
                    send(responseToClient);
                } 
                catch (IOException ex) { 
                    Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            catch (InterruptedException ex) {
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void sendId(int numb){
        try {
            Response r = new Response();
            r.setIdPlayer(numb);
            r.setGetId(1);
            
            String msg = gson.toJson(r);
            dos.writeUTF(msg);
            System.out.println("server send id number  " + numb);
        } catch (IOException ex) { 
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(Response data){
        try {
            Response r = new Response();
            r.x = data.x + 1;
            r.y = data.y + 1;
            r.changeField = true;
            r.lastPlayer = data.lastPlayer;
            r.str = data.str;
            String write_str = gson.toJson(r);
            dos.writeUTF(write_str);
            System.out.println("server send response");
        } catch (IOException ex) { 
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
