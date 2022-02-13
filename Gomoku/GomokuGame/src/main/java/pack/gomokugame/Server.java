/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.gomokugame;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nastya
 */
public class Server extends Thread{
    int port = 1515;
    InetAddress host;
    Game game = new Game();

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getHost() {
        return host;
    }

    public void setHost(InetAddress host) {
        this.host = host;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    public Server() {
        try {
            host = InetAddress.getLocalHost();
        } catch (IOException ex) { 
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ServerSocket ss = new ServerSocket(port, 0, host);
            System.out.println("Server started!");
            
            int player_count = 0;
            
            while (true) {
                if (player_count > 1){
                    System.out.println("Two players are already connected!");
                    break;
                }
                Socket cs = ss.accept(); 
                ClientConnection c = new ClientConnection(cs, game, player_count);
                player_count++;
                
                System.out.println("Client connected!");
            }
        } catch (IOException ex) { 
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Server();
    }
}
