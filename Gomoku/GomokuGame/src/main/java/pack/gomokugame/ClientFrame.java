/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.gomokugame;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nastya
 */
public class ClientFrame extends javax.swing.JFrame {

    /** 
     * Creates new form ClientFrame
     */
    Thread thread;
    int port = 1515;
    InetAddress host;
    Socket cs;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    
    int idPlayer;
    
    com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    

    public ClientFrame() {
        initComponents();
        
        ConnectButton.addActionListener(e -> connect());
        
        
        //для каждой кнопки вызывается отправка с ее координатами - номерами кнопки
        
        button_10_1.addActionListener(e -> set_10_1());
        button_10_10.addActionListener(e -> set_10_10());
        button_10_11.addActionListener(e -> set_10_11());
        button_10_12.addActionListener(e -> set_10_12());
        button_10_13.addActionListener(e -> set_10_13());
        button_10_14.addActionListener(e -> set_10_14());
        button_10_15.addActionListener(e -> set_10_15());
        button_10_2.addActionListener(e -> set_10_2());
        button_10_3.addActionListener(e -> set_10_3());
        button_10_4.addActionListener(e -> set_10_4());
        button_10_5.addActionListener(e -> set_10_5());
        button_10_6.addActionListener(e -> set_10_6());
        button_10_7.addActionListener(e -> set_10_7());
        button_10_8.addActionListener(e -> set_10_8());
        button_10_9.addActionListener(e -> set_10_9());
        
        button_11_1.addActionListener(e -> set_11_1());
        button_11_10.addActionListener(e -> set_11_10());
        button_11_11.addActionListener(e -> set_11_11());
        button_11_12.addActionListener(e -> set_11_12());
        button_11_13.addActionListener(e -> set_11_13());
        button_11_14.addActionListener(e -> set_11_14());
        button_11_15.addActionListener(e -> set_11_15());
        button_11_2.addActionListener(e -> set_11_2());
        button_11_3.addActionListener(e -> set_11_3());
        button_11_4.addActionListener(e -> set_11_4());
        button_11_5.addActionListener(e -> set_11_5());
        button_11_6.addActionListener(e -> set_11_6());
        button_11_7.addActionListener(e -> set_11_7());
        button_11_8.addActionListener(e -> set_11_8());
        button_11_9.addActionListener(e -> set_11_9());
        
        button_12_1.addActionListener(e -> set_12_1());
        button_12_10.addActionListener(e -> set_12_10());
        button_12_11.addActionListener(e -> set_12_11());
        button_12_12.addActionListener(e -> set_12_12());
        button_12_13.addActionListener(e -> set_12_13());
        button_12_14.addActionListener(e -> set_12_14());
        button_12_15.addActionListener(e -> set_12_15());
        button_12_2.addActionListener(e -> set_12_2());
        button_12_3.addActionListener(e -> set_12_3());
        button_12_4.addActionListener(e -> set_12_4());
        button_12_5.addActionListener(e -> set_12_5());
        button_12_6.addActionListener(e -> set_12_6());
        button_12_7.addActionListener(e -> set_12_7());
        button_12_8.addActionListener(e -> set_12_8());
        button_12_9.addActionListener(e -> set_12_9());
        
        button_13_1.addActionListener(e -> set_13_1());
        button_13_10.addActionListener(e -> set_13_10());
        button_13_11.addActionListener(e -> set_13_11());
        button_13_12.addActionListener(e -> set_13_12());
        button_13_13.addActionListener(e -> set_13_13());
        button_13_14.addActionListener(e -> set_13_14());
        button_13_15.addActionListener(e -> set_13_15());
        button_13_2.addActionListener(e -> set_13_2());
        button_13_3.addActionListener(e -> set_13_3());
        button_13_4.addActionListener(e -> set_13_4());
        button_13_5.addActionListener(e -> set_13_5());
        button_13_6.addActionListener(e -> set_13_6());
        button_13_7.addActionListener(e -> set_13_7());
        button_13_8.addActionListener(e -> set_13_8());
        button_13_9.addActionListener(e -> set_13_9());
        
        button_14_1.addActionListener(e -> set_14_1());
        button_14_10.addActionListener(e -> set_14_10());
        button_14_11.addActionListener(e -> set_14_11());
        button_14_12.addActionListener(e -> set_14_12());
        button_14_13.addActionListener(e -> set_14_13());
        button_14_14.addActionListener(e -> set_14_14());
        button_14_15.addActionListener(e -> set_14_15());
        button_14_2.addActionListener(e -> set_14_2());
        button_14_3.addActionListener(e -> set_14_3());
        button_14_4.addActionListener(e -> set_14_4());
        button_14_5.addActionListener(e -> set_14_5());
        button_14_6.addActionListener(e -> set_14_6());
        button_14_7.addActionListener(e -> set_14_7());
        button_14_8.addActionListener(e -> set_14_8());
        button_14_9.addActionListener(e -> set_14_9());
        
        button_15_1.addActionListener(e -> set_15_1());
        button_15_10.addActionListener(e -> set_15_10());
        button_15_11.addActionListener(e -> set_15_11());
        button_15_12.addActionListener(e -> set_15_2());
        button_15_13.addActionListener(e -> set_15_13());
        button_15_14.addActionListener(e -> set_15_14());
        button_15_15.addActionListener(e -> set_15_15());
        button_15_2.addActionListener(e -> set_15_2());
        button_15_3.addActionListener(e -> set_15_3());
        button_15_4.addActionListener(e -> set_15_4());
        button_15_5.addActionListener(e -> set_15_5());
        button_15_6.addActionListener(e -> set_15_6());
        button_15_7.addActionListener(e -> set_15_7());
        button_15_8.addActionListener(e -> set_15_8());
        button_15_9.addActionListener(e -> set_15_9());
        
        button_1_1.addActionListener(e -> set_1_1());
        button_1_10.addActionListener(e -> set_1_10());
        button_1_11.addActionListener(e -> set_1_11());
        button_1_12.addActionListener(e -> set_1_12());
        button_1_13.addActionListener(e -> set_1_13());
        button_1_14.addActionListener(e -> set_1_14());
        button_1_15.addActionListener(e -> set_1_15());
        button_1_2.addActionListener(e -> set_1_2());
        button_1_3.addActionListener(e -> set_1_3());
        button_1_4.addActionListener(e -> set_1_4());
        button_1_5.addActionListener(e -> set_1_5());
        button_1_6.addActionListener(e -> set_1_6());
        button_1_7.addActionListener(e -> set_1_7());
        button_1_8.addActionListener(e -> set_1_8());
        button_1_9.addActionListener(e -> set_1_9());
        
        button_2_1.addActionListener(e -> set_2_1());
        button_2_10.addActionListener(e -> set_2_10());
        button_2_11.addActionListener(e -> set_2_11());
        button_2_12.addActionListener(e -> set_2_12());
        button_2_13.addActionListener(e -> set_2_13());
        button_2_14.addActionListener(e -> set_2_14());
        button_2_15.addActionListener(e -> set_2_15());
        button_2_2.addActionListener(e -> set_2_2());
        button_2_3.addActionListener(e -> set_2_3());
        button_2_4.addActionListener(e -> set_2_4());
        button_2_5.addActionListener(e -> set_2_5());
        button_2_6.addActionListener(e -> set_2_6());
        button_2_7.addActionListener(e -> set_2_7());
        button_2_8.addActionListener(e -> set_2_8());
        button_2_9.addActionListener(e -> set_2_9());
        
        button_3_1.addActionListener(e -> set_3_1());
        button_3_10.addActionListener(e -> set_3_10());
        button_3_11.addActionListener(e -> set_3_11());
        button_3_12.addActionListener(e -> set_3_12());
        button_3_13.addActionListener(e -> set_3_13());
        button_3_14.addActionListener(e -> set_3_14());
        button_3_15.addActionListener(e -> set_3_15());
        button_3_2.addActionListener(e -> set_3_2());
        button_3_3.addActionListener(e -> set_3_3());
        button_3_4.addActionListener(e -> set_3_4());
        button_3_5.addActionListener(e -> set_3_5());
        button_3_6.addActionListener(e -> set_3_6());
        button_3_7.addActionListener(e -> set_3_7());
        button_3_8.addActionListener(e -> set_3_8());
        button_3_9.addActionListener(e -> set_3_9());
        
        button_4_1.addActionListener(e -> set_4_1());
        button_4_10.addActionListener(e -> set_4_10());
        button_4_11.addActionListener(e -> set_4_11());
        button_4_12.addActionListener(e -> set_4_12());
        button_4_13.addActionListener(e -> set_4_13());
        button_4_14.addActionListener(e -> set_4_14());
        button_4_15.addActionListener(e -> set_4_15());
        button_4_2.addActionListener(e -> set_4_2());
        button_4_3.addActionListener(e -> set_4_3());
        button_4_4.addActionListener(e -> set_4_4());
        button_4_5.addActionListener(e -> set_4_5());
        button_4_6.addActionListener(e -> set_4_6());
        button_4_7.addActionListener(e -> set_4_7());
        button_4_8.addActionListener(e -> set_4_8());
        button_4_9.addActionListener(e -> set_4_9());
        
        button_5_1.addActionListener(e -> set_5_1());
        button_5_10.addActionListener(e -> set_5_10());
        button_5_11.addActionListener(e -> set_5_11());
        button_5_12.addActionListener(e -> set_5_12());
        button_5_13.addActionListener(e -> set_5_13());
        button_5_14.addActionListener(e -> set_5_14());
        button_5_15.addActionListener(e -> set_5_15());
        button_5_2.addActionListener(e -> set_5_2());
        button_5_3.addActionListener(e -> set_5_3());
        button_5_4.addActionListener(e -> set_5_4());
        button_5_5.addActionListener(e -> set_5_5());
        button_5_6.addActionListener(e -> set_5_6());
        button_5_7.addActionListener(e -> set_5_7());
        button_5_8.addActionListener(e -> set_5_8());
        button_5_9.addActionListener(e -> set_5_9());
        
        button_6_1.addActionListener(e -> set_6_1());
        button_6_10.addActionListener(e -> set_6_10());
        button_6_11.addActionListener(e -> set_6_11());
        button_6_12.addActionListener(e -> set_6_12());
        button_6_13.addActionListener(e -> set_6_13());
        button_6_14.addActionListener(e -> set_6_14());
        button_6_15.addActionListener(e -> set_6_15());
        button_6_2.addActionListener(e -> set_6_2());
        button_6_3.addActionListener(e -> set_6_3());
        button_6_4.addActionListener(e -> set_6_4());
        button_6_5.addActionListener(e -> set_6_5());
        button_6_6.addActionListener(e -> set_6_6());
        button_6_7.addActionListener(e -> set_6_7());
        button_6_8.addActionListener(e -> set_6_8());
        button_6_9.addActionListener(e -> set_6_9());
        
        button_7_1.addActionListener(e -> set_7_1());
        button_7_10.addActionListener(e -> set_7_10());
        button_7_11.addActionListener(e -> set_7_11());
        button_7_12.addActionListener(e -> set_7_12());
        button_7_13.addActionListener(e -> set_7_13());
        button_7_14.addActionListener(e -> set_7_14());
        button_7_15.addActionListener(e -> set_7_15());
        button_7_2.addActionListener(e -> set_7_2());
        button_7_3.addActionListener(e -> set_7_3());
        button_7_4.addActionListener(e -> set_7_4());
        button_7_5.addActionListener(e -> set_7_5());
        button_7_6.addActionListener(e -> set_7_6());
        button_7_7.addActionListener(e -> set_7_7());
        button_7_8.addActionListener(e -> set_7_8());
        button_7_9.addActionListener(e -> set_7_9());
        
        button_8_1.addActionListener(e -> set_8_1());
        button_8_10.addActionListener(e -> set_8_10());
        button_8_11.addActionListener(e -> set_8_11());
        button_8_12.addActionListener(e -> set_8_12());
        button_8_13.addActionListener(e -> set_8_13());
        button_8_14.addActionListener(e -> set_8_14());
        button_8_15.addActionListener(e -> set_8_15());
        button_8_2.addActionListener(e -> set_8_2());
        button_8_3.addActionListener(e -> set_8_3());
        button_8_4.addActionListener(e -> set_8_4());
        button_8_5.addActionListener(e -> set_8_5());
        button_8_6.addActionListener(e -> set_8_6());
        button_8_7.addActionListener(e -> set_8_7());
        button_8_8.addActionListener(e -> set_8_8());
        button_8_9.addActionListener(e -> set_8_9());
        
        button_9_1.addActionListener(e -> set_9_1());
        button_9_10.addActionListener(e -> set_9_10());
        button_9_11.addActionListener(e -> set_9_11());
        button_9_12.addActionListener(e -> set_9_12());
        button_9_13.addActionListener(e -> set_9_13());
        button_9_14.addActionListener(e -> set_9_14());
        button_9_15.addActionListener(e -> set_9_15());
        button_9_2.addActionListener(e -> set_9_2());
        button_9_3.addActionListener(e -> set_9_3());
        button_9_4.addActionListener(e -> set_9_4());
        button_9_5.addActionListener(e -> set_9_5());
        button_9_6.addActionListener(e -> set_9_6());
        button_9_7.addActionListener(e -> set_9_7());
        button_9_8.addActionListener(e -> set_9_8());
        button_9_9.addActionListener(e -> set_9_9());
    }
    
    public void connect() {
        try {
            try {
                host = InetAddress.getLocalHost();
            } catch (IOException ex) {
                Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            cs = new Socket(host, port);
            os = cs.getOutputStream();
            dos = new DataOutputStream(os);
            thread = new Thread(){
                @Override
                public void run() {
                    try {
                        is = cs.getInputStream();
                        dis = new DataInputStream(is);
                        while (true) {
                            String obj = dis.readUTF();
                            Response r = gson.fromJson(obj, Response.class);
                            if (r.getId == 1){
                                idPlayer = r.idPlayer;
                                if (idPlayer == 0 ){
                                    ColorLabel.setForeground(Color.red);
                                }
                                else{
                                    ColorLabel.setForeground(Color.yellow);
                                }
                            }
                            System.out.println("Received: " + obj);
                            System.out.println("ID Player:  " + idPlayer);
                                                       
                            if (r.changeField == true && r.x > 0 && r.y > 0){
                                fillField(r.lastPlayer , r.x, r.y);
                            }
                            
                            if (null != r.str)switch (r.str) {
                                case "you win":
                                    //javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), "YOU WIN :)");
                                    NextTextPanel.setText("YOU WIN :) ");
                                    return;
                                case "you lose":
                                    //javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), "YOU LOSE :(");
                                    NextTextPanel.setText("YOU LOSE :( ");
                                    return;
                                case "your move":
                                    NextTextPanel.setText("Your move");
                                    break;
                                case "wait for your move":
                                    NextTextPanel.setText("Wait for your move");
                                    break;
                                default:
                                    break;
                            }
                            
                        }
                    } catch (IOException ex) { 
                        Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   
            };
            thread.start();
        } catch (IOException ex) { 
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void send(String s){
        try {
            Response r = new Response();
            r.setIdPlayer(idPlayer);
            String[] split_msg = s.split(" ");
            System.out.println(split_msg[0]);
            System.out.println(split_msg[1]);

            String str = split_msg[0] + ' ' + split_msg[1];
            r.setStr(str);
            
            String r_input = gson.toJson(r);
            dos.writeUTF(r_input);
            System.out.println("send from client:  " + r.str);
        } catch (IOException ex) { 
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
    
    
    void fillField(int player, int x, int y){
        System.out.println("color button");

        if (x == 1 && y == 1){
            
            if (player == 0){
                button_1_1.setBackground(Color.red);
            }
            else {
                button_1_1.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 2){
            if (player == 0){
                button_1_2.setBackground(Color.red);
            }
            else {
                button_1_2.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 3){
            if (player == 0){
                button_1_3.setBackground(Color.red);
            }
            else {
                button_1_3.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 4){
            if (player == 0){
                button_1_4.setBackground(Color.red);
            }
            else {
                button_1_4.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 5){
            if (player == 0){
                button_1_5.setBackground(Color.red);
            }
            else {
                button_1_5.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 6){
            if (player == 0){
                button_1_6.setBackground(Color.red);
            }
            else {
                button_1_6.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 7){
            if (player == 0){
                button_1_7.setBackground(Color.red);
            }
            else {
                button_1_7.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 8){
            if (player == 0){
                button_1_8.setBackground(Color.red);
            }
            else {
                button_1_8.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 9){
            if (player == 0){
                button_1_9.setBackground(Color.red);
            }
            else {
                button_1_9.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 10){
            if (player == 0){
                button_1_10.setBackground(Color.red);
            }
            else {
                button_1_10.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 11){
            if (player == 0){
                button_1_11.setBackground(Color.red);
            }
            else {
                button_1_11.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 12){
            if (player == 0){
                button_1_12.setBackground(Color.red);
            }
            else {
                button_1_12.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 13){
            if (player == 0){
                button_1_13.setBackground(Color.red);
            }
            else {
                button_1_13.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 14){
            if (player == 0){
                button_1_14.setBackground(Color.red);
            }
            else {
                button_1_14.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 15){
            if (player == 0){
                button_1_15.setBackground(Color.red);
            }
            else {
                button_1_15.setBackground(Color.yellow);
            }
        }//2
        else if (x == 2 && y == 1){
            if (player == 0){
                button_2_1.setBackground(Color.red);
            }
            else {
                button_2_1.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 2){
            if (player == 0){
                button_2_2.setBackground(Color.red);
            }
            else {
                button_2_2.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 3){
            if (player == 0){
                button_2_3.setBackground(Color.red);
            }
            else {
                button_2_3.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 4){
            if (player == 0){
                button_2_4.setBackground(Color.red);
            }
            else {
                button_2_4.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 5){
            if (player == 0){
                button_2_5.setBackground(Color.red);
            }
            else {
                button_2_5.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 6){
            if (player == 0){
                button_2_6.setBackground(Color.red);
            }
            else {
                button_2_6.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 7){
            if (player == 0){
                button_2_7.setBackground(Color.red);
            }
            else {
                button_2_7.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 8){
            if (player == 0){
                button_2_8.setBackground(Color.red);
            }
            else {
                button_2_8.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 9){
            if (player == 0){
                button_2_9.setBackground(Color.red);
            }
            else {
                button_2_9.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 10){
            if (player == 0){
                button_2_10.setBackground(Color.red);
            }
            else {
                button_2_10.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 11){
            if (player == 0){
                button_2_11.setBackground(Color.red);
            }
            else {
                button_2_11.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 12){
            if (player == 0){
                button_2_12.setBackground(Color.red);
            }
            else {
                button_2_12.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 13){
            if (player == 0){
                button_2_13.setBackground(Color.red);
            }
            else {
                button_2_13.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 14){
            if (player == 0){
                button_2_14.setBackground(Color.red);
            }
            else {
                button_2_14.setBackground(Color.yellow);
            }
        }
        else if (x == 2 && y == 15){
            if (player == 0){
                button_2_15.setBackground(Color.red);
            }
            else {
                button_2_15.setBackground(Color.yellow);
            }
        }//3
        else if (x == 3 && y == 1){
            if (player == 0){
                button_3_1.setBackground(Color.red);
            }
            else {
                button_3_1.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 2){
            if (player == 0){
                button_3_2.setBackground(Color.red);
            }
            else {
                button_3_2.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 3){
            if (player == 0){
                button_3_3.setBackground(Color.red);
            }
            else {
                button_3_3.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 4){
            if (player == 0){
                button_3_4.setBackground(Color.red);
            }
            else {
                button_3_4.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 5){
            if (player == 0){
                button_3_5.setBackground(Color.red);
            }
            else {
                button_3_5.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 6){
            if (player == 0){
                button_3_6.setBackground(Color.red);
            }
            else {
                button_3_6.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 7){
            if (player == 0){
                button_3_7.setBackground(Color.red);
            }
            else {
                button_3_7.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 8){
            if (player == 0){
                button_3_8.setBackground(Color.red);
            }
            else {
                button_3_8.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 9){
            if (player == 0){
                button_3_9.setBackground(Color.red);
            }
            else {
                button_3_9.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 10){
            if (player == 0){
                button_3_10.setBackground(Color.red);
            }
            else {
                button_3_10.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 11){
            if (player == 0){
                button_3_11.setBackground(Color.red);
            }
            else {
                button_3_11.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 12){
            if (player == 0){
                button_3_12.setBackground(Color.red);
            }
            else {
                button_3_12.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 13){
            if (player == 0){
                button_3_13.setBackground(Color.red);
            }
            else {
                button_3_13.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 14){
            if (player == 0){
                button_3_14.setBackground(Color.red);
            }
            else {
                button_3_14.setBackground(Color.yellow);
            }
        }
        else if (x == 3 && y == 15){
            if (player == 0){
                button_3_15.setBackground(Color.red);
            }
            else {
                button_3_15.setBackground(Color.yellow);
            }
        }//4
        else if (x == 4 && y == 1){
            if (player == 0){
                button_4_1.setBackground(Color.red);
            }
            else {
                button_4_1.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 2){
            if (player == 0){
                button_4_2.setBackground(Color.red);
            }
            else {
                button_4_2.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 3){
            if (player == 0){
                button_4_3.setBackground(Color.red);
            }
            else {
                button_4_3.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 4){
            if (player == 0){
                button_4_4.setBackground(Color.red);
            }
            else {
                button_4_4.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 5){
            if (player == 0){
                button_4_5.setBackground(Color.red);
            }
            else {
                button_4_5.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 6){
            if (player == 0){
                button_4_6.setBackground(Color.red);
            }
            else {
                button_4_6.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 7){
            if (player == 0){
                button_4_7.setBackground(Color.red);
            }
            else {
                button_4_7.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 8){
            if (player == 0){
                button_4_8.setBackground(Color.red);
            }
            else {
                button_4_8.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 9){
            if (player == 0){
                button_4_9.setBackground(Color.red);
            }
            else {
                button_4_9.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 10){
            if (player == 0){
                button_4_10.setBackground(Color.red);
            }
            else {
                button_4_10.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 11){
            if (player == 0){
                button_4_11.setBackground(Color.red);
            }
            else {
                button_4_11.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 12){
            if (player == 0){
                button_4_12.setBackground(Color.red);
            }
            else {
                button_4_12.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 13){
            if (player == 0){
                button_4_13.setBackground(Color.red);
            }
            else {
                button_4_13.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 14){
            if (player == 0){
                button_4_14.setBackground(Color.red);
            }
            else {
                button_4_14.setBackground(Color.yellow);
            }
        }
        else if (x == 4 && y == 15){
            if (player == 0){
                button_4_15.setBackground(Color.red);
            }
            else {
                button_4_15.setBackground(Color.yellow);
            }
        }//5
        else if (x == 5 && y == 1){
            if (player == 0){
                button_5_1.setBackground(Color.red);
            }
            else {
                button_5_1.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 2){
            if (player == 0){
                button_5_2.setBackground(Color.red);
            }
            else {
                button_5_2.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 3){
            if (player == 0){
                button_5_3.setBackground(Color.red);
            }
            else {
                button_5_3.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 4){
            if (player == 0){
                button_5_4.setBackground(Color.red);
            }
            else {
                button_5_4.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 5){
            if (player == 0){
                button_5_5.setBackground(Color.red);
            }
            else {
                button_5_5.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 6){
            if (player == 0){
                button_5_6.setBackground(Color.red);
            }
            else {
                button_5_6.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 7){
            if (player == 0){
                button_5_7.setBackground(Color.red);
            }
            else {
                button_5_7.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 8){
            if (player == 0){
                button_5_8.setBackground(Color.red);
            }
            else {
                button_5_8.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 9){
            if (player == 0){
                button_5_9.setBackground(Color.red);
            }
            else {
                button_5_9.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 10){
            if (player == 0){
                button_5_10.setBackground(Color.red);
            }
            else {
                button_5_10.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 11){
            if (player == 0){
                button_5_11.setBackground(Color.red);
            }
            else {
                button_5_11.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 12){
            if (player == 0){
                button_5_12.setBackground(Color.red);
            }
            else {
                button_5_12.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 13){
            if (player == 0){
                button_5_13.setBackground(Color.red);
            }
            else {
                button_5_13.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 14){
            if (player == 0){
                button_5_14.setBackground(Color.red);
            }
            else {
                button_5_14.setBackground(Color.yellow);
            }
        }
        else if (x == 5 && y == 15){
            if (player == 0){
                button_5_15.setBackground(Color.red);
            }
            else {
                button_5_15.setBackground(Color.yellow);
            }
        }//6
        else if (x == 6 && y == 1){
            if (player == 0){
                button_6_1.setBackground(Color.red);
            }
            else {
                button_6_1.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 2){
            if (player == 0){
                button_6_2.setBackground(Color.red);
            }
            else {
                button_6_2.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 3){
            if (player == 0){
                button_6_3.setBackground(Color.red);
            }
            else {
                button_6_3.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 4){
            if (player == 0){
                button_6_4.setBackground(Color.red);
            }
            else {
                button_6_4.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 5){
            if (player == 0){
                button_6_5.setBackground(Color.red);
            }
            else {
                button_6_5.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 6){
            if (player == 0){
                button_6_6.setBackground(Color.red);
            }
            else {
                button_6_6.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 7){
            if (player == 0){
                button_6_7.setBackground(Color.red);
            }
            else {
                button_6_7.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 8){
            if (player == 0){
                button_6_8.setBackground(Color.red);
            }
            else {
                button_6_8.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 9){
            if (player == 0){
                button_6_9.setBackground(Color.red);
            }
            else {
                button_6_9.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 10){
            if (player == 0){
                button_6_10.setBackground(Color.red);
            }
            else {
                button_6_10.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 11){
            if (player == 0){
                button_6_11.setBackground(Color.red);
            }
            else {
                button_6_11.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 12){
            if (player == 0){
                button_6_12.setBackground(Color.red);
            }
            else {
                button_6_12.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 13){
            if (player == 0){
                button_6_13.setBackground(Color.red);
            }
            else {
                button_6_13.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 14){
            if (player == 0){
                button_6_14.setBackground(Color.red);
            }
            else {
                button_6_14.setBackground(Color.yellow);
            }
        }
        else if (x == 6 && y == 15){
            if (player == 0){
                button_6_15.setBackground(Color.red);
            }
            else {
                button_6_15.setBackground(Color.yellow);
            }
        }//7
        else if (x == 7 && y == 1){
            if (player == 0){
                button_7_1.setBackground(Color.red);
            }
            else {
                button_7_1.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 2){
            if (player == 0){
                button_7_2.setBackground(Color.red);
            }
            else {
                button_7_2.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 3){
            if (player == 0){
                button_7_3.setBackground(Color.red);
            }
            else {
                button_7_3.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 4){
            if (player == 0){
                button_7_4.setBackground(Color.red);
            }
            else {
                button_7_4.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 5){
            if (player == 0){
                button_7_5.setBackground(Color.red);
            }
            else {
                button_7_5.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 6){
            if (player == 0){
                button_7_6.setBackground(Color.red);
            }
            else {
                button_7_6.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 7){
            if (player == 0){
                button_7_7.setBackground(Color.red);
            }
            else {
                button_7_7.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 8){
            if (player == 0){
                button_7_8.setBackground(Color.red);
            }
            else {
                button_7_8.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 9){
            if (player == 0){
                button_7_9.setBackground(Color.red);
            }
            else {
                button_7_9.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 10){
            if (player == 0){
                button_7_10.setBackground(Color.red);
            }
            else {
                button_7_10.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 11){
            if (player == 0){
                button_7_11.setBackground(Color.red);
            }
            else {
                button_7_11.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 12){
            if (player == 0){
                button_7_12.setBackground(Color.red);
            }
            else {
                button_7_12.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 13){
            if (player == 0){
                button_7_13.setBackground(Color.red);
            }
            else {
                button_7_13.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 14){
            if (player == 0){
                button_7_14.setBackground(Color.red);
            }
            else {
                button_7_14.setBackground(Color.yellow);
            }
        }
        else if (x == 7 && y == 15){
            if (player == 0){
                button_7_15.setBackground(Color.red);
            }
            else {
                button_7_15.setBackground(Color.yellow);
            }
        }//8
        else if (x == 8 && y == 1){
            if (player == 0){
                button_8_1.setBackground(Color.red);
            }
            else {
                button_8_1.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 2){
            if (player == 0){
                button_8_2.setBackground(Color.red);
            }
            else {
                button_8_2.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 3){
            if (player == 0){
                button_8_3.setBackground(Color.red);
            }
            else {
                button_8_3.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 4){
            if (player == 0){
                button_8_4.setBackground(Color.red);
            }
            else {
                button_8_4.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 5){
            if (player == 0){
                button_8_5.setBackground(Color.red);
            }
            else {
                button_8_5.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 6){
            if (player == 0){
                button_8_6.setBackground(Color.red);
            }
            else {
                button_8_6.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 7){
            if (player == 0){
                button_8_7.setBackground(Color.red);
            }
            else {
                button_8_7.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 8){
            if (player == 0){
                button_8_8.setBackground(Color.red);
            }
            else {
                button_8_8.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 9){
            if (player == 0){
                button_8_9.setBackground(Color.red);
            }
            else {
                button_8_9.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 10){
            if (player == 0){
                button_8_10.setBackground(Color.red);
            }
            else {
                button_8_10.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 11){
            if (player == 0){
                button_8_11.setBackground(Color.red);
            }
            else {
                button_8_11.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 12){
            if (player == 0){
                button_8_12.setBackground(Color.red);
            }
            else {
                button_8_12.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 13){
            if (player == 0){
                button_8_13.setBackground(Color.red);
            }
            else {
                button_8_13.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 14){
            if (player == 0){
                button_8_14.setBackground(Color.red);
            }
            else {
                button_8_14.setBackground(Color.yellow);
            }
        }
        else if (x == 8 && y == 15){
            if (player == 0){
                button_8_15.setBackground(Color.red);
            }
            else {
                button_8_15.setBackground(Color.yellow);
            }
        }//9
        else if (x == 9 && y == 1){
            if (player == 0){
                button_9_1.setBackground(Color.red);
            }
            else {
                button_9_1.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 2){
            if (player == 0){
                button_9_2.setBackground(Color.red);
            }
            else {
                button_9_2.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 3){
            if (player == 0){
                button_9_3.setBackground(Color.red);
            }
            else {
                button_9_3.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 4){
            if (player == 0){
                button_9_4.setBackground(Color.red);
            }
            else {
                button_9_4.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 5){
            if (player == 0){
                button_9_5.setBackground(Color.red);
            }
            else {
                button_9_5.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 6){
            if (player == 0){
                button_9_6.setBackground(Color.red);
            }
            else {
                button_9_6.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 7){
            if (player == 0){
                button_9_7.setBackground(Color.red);
            }
            else {
                button_9_7.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 8){
            if (player == 0){
                button_9_8.setBackground(Color.red);
            }
            else {
                button_9_8.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 9){
            if (player == 0){
                button_9_9.setBackground(Color.red);
            }
            else {
                button_9_9.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 10){
            if (player == 0){
                button_9_10.setBackground(Color.red);
            }
            else {
                button_9_10.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 11){
            if (player == 0){
                button_9_11.setBackground(Color.red);
            }
            else {
                button_9_11.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 12){
            if (player == 0){
                button_9_12.setBackground(Color.red);
            }
            else {
                button_9_12.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 13){
            if (player == 0){
                button_9_13.setBackground(Color.red);
            }
            else {
                button_9_13.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 14){
            if (player == 0){
                button_9_14.setBackground(Color.red);
            }
            else {
                button_9_14.setBackground(Color.yellow);
            }
        }
        else if (x == 9 && y == 15){
            if (player == 0){
                button_9_15.setBackground(Color.red);
            }
            else {
                button_9_15.setBackground(Color.yellow);
            }
        }//10
        else if (x == 10 && y == 1){
            if (player == 0){
                button_10_1.setBackground(Color.red);
            }
            else {
                button_10_1.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 2){
            if (player == 0){
                button_10_2.setBackground(Color.red);
            }
            else {
                button_10_2.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 3){
            if (player == 0){
                button_10_3.setBackground(Color.red);
            }
            else {
                button_10_3.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 4){
            if (player == 0){
                button_10_4.setBackground(Color.red);
            }
            else {
                button_10_4.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 5){
            if (player == 0){
                button_10_5.setBackground(Color.red);
            }
            else {
                button_10_5.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 6){
            if (player == 0){
                button_10_6.setBackground(Color.red);
            }
            else {
                button_10_6.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 7){
            if (player == 0){
                button_10_7.setBackground(Color.red);
            }
            else {
                button_10_7.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 8){
            if (player == 0){
                button_10_8.setBackground(Color.red);
            }
            else {
                button_10_8.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 9){
            if (player == 0){
                button_10_9.setBackground(Color.red);
            }
            else {
                button_10_9.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 10){
            if (player == 0){
                button_10_10.setBackground(Color.red);
            }
            else {
                button_10_10.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 11){
            if (player == 0){
                button_10_11.setBackground(Color.red);
            }
            else {
                button_10_11.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 12){
            if (player == 0){
                button_10_12.setBackground(Color.red);
            }
            else {
                button_10_12.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 13){
            if (player == 0){
                button_10_13.setBackground(Color.red);
            }
            else {
                button_10_13.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 14){
            if (player == 0){
                button_10_14.setBackground(Color.red);
            }
            else {
                button_10_14.setBackground(Color.yellow);
            }
        }
        else if (x == 10 && y == 15){
            if (player == 0){
                button_10_15.setBackground(Color.red);
            }
            else {
                button_10_15.setBackground(Color.yellow);
            }
        }
        //11
        else if (x == 11 && y == 1){
            if (player == 0){
                button_11_1.setBackground(Color.red);
            }
            else {
                button_11_1.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 2){
            if (player == 0){
                button_11_2.setBackground(Color.red);
            }
            else {
                button_11_2.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 3){
            if (player == 0){
                button_11_3.setBackground(Color.red);
            }
            else {
                button_11_3.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 4){
            if (player == 0){
                button_11_4.setBackground(Color.red);
            }
            else {
                button_11_4.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 5){
            if (player == 0){
                button_11_5.setBackground(Color.red);
            }
            else {
                button_11_5.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 6){
            if (player == 0){
                button_11_6.setBackground(Color.red);
            }
            else {
                button_11_6.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 7){
            if (player == 0){
                button_11_7.setBackground(Color.red);
            }
            else {
                button_11_7.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 8){
            if (player == 0){
                button_11_8.setBackground(Color.red);
            }
            else {
                button_11_8.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 9){
            if (player == 0){
                button_11_9.setBackground(Color.red);
            }
            else {
                button_11_9.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 10){
            if (player == 0){
                button_11_10.setBackground(Color.red);
            }
            else {
                button_11_10.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 11){
            if (player == 0){
                button_11_11.setBackground(Color.red);
            }
            else {
                button_11_11.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 12){
            if (player == 0){
                button_11_12.setBackground(Color.red);
            }
            else {
                button_11_12.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 13){
            if (player == 0){
                button_11_13.setBackground(Color.red);
            }
            else {
                button_11_13.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 14){
            if (player == 0){
                button_11_14.setBackground(Color.red);
            }
            else {
                button_11_14.setBackground(Color.yellow);
            }
        }
        else if (x == 11 && y == 15){
            if (player == 0){
                button_11_15.setBackground(Color.red);
            }
            else {
                button_11_15.setBackground(Color.yellow);
            }
        }//12
        else if (x == 12 && y == 1){
            if (player == 0){
                button_12_1.setBackground(Color.red);
            }
            else {
                button_12_1.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 2){
            if (player == 0){
                button_12_2.setBackground(Color.red);
            }
            else {
                button_12_2.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 3){
            if (player == 0){
                button_12_3.setBackground(Color.red);
            }
            else {
                button_12_3.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 4){
            if (player == 0){
                button_12_4.setBackground(Color.red);
            }
            else {
                button_12_4.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 5){
            if (player == 0){
                button_12_5.setBackground(Color.red);
            }
            else {
                button_12_5.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 6){
            if (player == 0){
                button_12_6.setBackground(Color.red);
            }
            else {
                button_12_6.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 7){
            if (player == 0){
                button_12_7.setBackground(Color.red);
            }
            else {
                button_12_7.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 8){
            if (player == 0){
                button_12_8.setBackground(Color.red);
            }
            else {
                button_12_8.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 9){
            if (player == 0){
                button_12_9.setBackground(Color.red);
            }
            else {
                button_12_9.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 10){
            if (player == 0){
                button_12_10.setBackground(Color.red);
            }
            else {
                button_12_10.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 11){
            if (player == 0){
                button_12_11.setBackground(Color.red);
            }
            else {
                button_12_11.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 12){
            if (player == 0){
                button_12_12.setBackground(Color.red);
            }
            else {
                button_12_12.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 13){
            if (player == 0){
                button_12_13.setBackground(Color.red);
            }
            else {
                button_12_13.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 14){
            if (player == 0){
                button_12_14.setBackground(Color.red);
            }
            else {
                button_12_14.setBackground(Color.yellow);
            }
        }
        else if (x == 12 && y == 15){
            if (player == 0){
                button_12_15.setBackground(Color.red);
            }
            else {
                button_12_15.setBackground(Color.yellow);
            }
        }//13
        else if (x == 13 && y == 1){
            if (player == 0){
                button_13_1.setBackground(Color.red);
            }
            else {
                button_13_1.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 2){
            if (player == 0){
                button_13_2.setBackground(Color.red);
            }
            else {
                button_13_2.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 3){
            if (player == 0){
                button_13_3.setBackground(Color.red);
            }
            else {
                button_13_3.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 4){
            if (player == 0){
                button_13_4.setBackground(Color.red);
            }
            else {
                button_13_4.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 5){
            if (player == 0){
                button_13_5.setBackground(Color.red);
            }
            else {
                button_13_5.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 6){
            if (player == 0){
                button_13_6.setBackground(Color.red);
            }
            else {
                button_13_6.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 7){
            if (player == 0){
                button_13_7.setBackground(Color.red);
            }
            else {
                button_13_7.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 8){
            if (player == 0){
                button_13_8.setBackground(Color.red);
            }
            else {
                button_13_8.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 9){
            if (player == 0){
                button_13_9.setBackground(Color.red);
            }
            else {
                button_13_9.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 10){
            if (player == 0){
                button_13_10.setBackground(Color.red);
            }
            else {
                button_13_10.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 11){
            if (player == 0){
                button_13_11.setBackground(Color.red);
            }
            else {
                button_13_11.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 12){
            if (player == 0){
                button_13_12.setBackground(Color.red);
            }
            else {
                button_13_12.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 13){
            if (player == 0){
                button_13_13.setBackground(Color.red);
            }
            else {
                button_13_13.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 14){
            if (player == 0){
                button_13_14.setBackground(Color.red);
            }
            else {
                button_13_14.setBackground(Color.yellow);
            }
        }
        else if (x == 13 && y == 15){
            if (player == 0){
                button_13_15.setBackground(Color.red);
            }
            else {
                button_13_15.setBackground(Color.yellow);
            }
        }//14
        else if (x == 14 && y == 1){
            if (player == 0){
                button_14_1.setBackground(Color.red);
            }
            else {
                button_14_1.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 2){
            if (player == 0){
                button_14_2.setBackground(Color.red);
            }
            else {
                button_14_2.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 3){
            if (player == 0){
                button_14_3.setBackground(Color.red);
            }
            else {
                button_14_3.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 4){
            if (player == 0){
                button_14_4.setBackground(Color.red);
            }
            else {
                button_14_4.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 5){
            if (player == 0){
                button_14_5.setBackground(Color.red);
            }
            else {
                button_14_5.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 6){
            if (player == 0){
                button_14_6.setBackground(Color.red);
            }
            else {
                button_14_6.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 7){
            if (player == 0){
                button_14_7.setBackground(Color.red);
            }
            else {
                button_14_7.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 8){
            if (player == 0){
                button_14_8.setBackground(Color.red);
            }
            else {
                button_14_8.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 9){
            if (player == 0){
                button_14_9.setBackground(Color.red);
            }
            else {
                button_14_9.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 10){
            if (player == 0){
                button_14_10.setBackground(Color.red);
            }
            else {
                button_14_10.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 11){
            if (player == 0){
                button_14_11.setBackground(Color.red);
            }
            else {
                button_14_11.setBackground(Color.yellow);
            }
        }
        else if (x == 1 && y == 12){
            if (player == 0){
                button_14_12.setBackground(Color.red);
            }
            else {
                button_14_12.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 13){
            if (player == 0){
                button_14_13.setBackground(Color.red);
            }
            else {
                button_14_13.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 14){
            if (player == 0){
                button_14_14.setBackground(Color.red);
            }
            else {
                button_14_14.setBackground(Color.yellow);
            }
        }
        else if (x == 14 && y == 15){
            if (player == 0){
                button_14_15.setBackground(Color.red);
            }
            else {
                button_14_15.setBackground(Color.yellow);
            }
        }//15
        else if (x == 15 && y == 1){
            if (player == 0){
                button_15_1.setBackground(Color.red);
            }
            else {
                button_15_1.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 2){
            if (player == 0){
                button_15_2.setBackground(Color.red);
            }
            else {
                button_15_2.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 3){
            if (player == 0){
                button_15_3.setBackground(Color.red);
            }
            else {
                button_15_3.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 4){
            if (player == 0){
                button_15_4.setBackground(Color.red);
            }
            else {
                button_15_4.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 5){
            if (player == 0){
                button_15_5.setBackground(Color.red);
            }
            else {
                button_15_5.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 6){
            if (player == 0){
                button_15_6.setBackground(Color.red);
            }
            else {
                button_15_6.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 7){
            if (player == 0){
                button_15_7.setBackground(Color.red);
            }
            else {
                button_15_7.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 8){
            if (player == 0){
                button_15_8.setBackground(Color.red);
            }
            else {
                button_15_8.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 9){
            if (player == 0){
                button_15_9.setBackground(Color.red);
            }
            else {
                button_15_9.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 10){
            if (player == 0){
                button_15_10.setBackground(Color.red);
            }
            else {
                button_15_10.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 11){
            if (player == 0){
                button_15_11.setBackground(Color.red);
            }
            else {
                button_15_11.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 12){
            if (player == 0){
                button_15_12.setBackground(Color.red);
            }
            else {
                button_15_12.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 13){
            if (player == 0){
                button_15_13.setBackground(Color.red);
            }
            else {
                button_5_13.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 14){
            if (player == 0){
                button_15_14.setBackground(Color.red);
            }
            else {
                button_15_14.setBackground(Color.yellow);
            }
        }
        else if (x == 15 && y == 15){
            if (player == 0){
                button_15_15.setBackground(Color.red);
            }
            else {
                button_15_15.setBackground(Color.yellow);
            }
        }
        
    }

    
    //1
    void set_1_1(){
        String input = "1 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_2(){
        String input = "1 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_3(){
        String input = "1 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_4(){
        String input = "1 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_5(){
        String input = "1 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_6(){
        String input = "1 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_7(){
        String input = "1 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_8(){
        String input = "1 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_9(){
        String input = "1 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_10(){
        String input = "1 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_11(){
        String input = "1 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_12(){
        String input = "1 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_1_13(){
        String input = "1 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_1_14(){
        String input = "1 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_1_15(){
        String input = "1 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //2
    void set_2_1(){
        String input = "2 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_2(){
        String input = "2 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_3(){
        String input = "2 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_4(){
        String input = "2 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_5(){
        String input = "2 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_6(){
        String input = "2 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_7(){
        String input = "2 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_8(){
        String input = "2 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_9(){
        String input = "2 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_10(){
        String input = "2 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_11(){
        String input = "2 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_12(){
        String input = "2 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_2_13(){
        String input = "2 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_2_14(){
        String input = "2 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_2_15(){
        String input = "2 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //3
    void set_3_1(){
        String input = "3 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_2(){
        String input = "3 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_3(){
        String input = "3 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_4(){
        String input = "3 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_5(){
        String input = "3 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_6(){
        String input = "3 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_7(){
        String input = "3 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_8(){
        String input = "3 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_9(){
        String input = "3 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_10(){
        String input = "3 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_11(){
        String input = "3 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_12(){
        String input = "3 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_3_13(){
        String input = "3 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_3_14(){
        String input = "3 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_3_15(){
        String input = "3 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //4
    void set_4_1(){
        String input = "4 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_2(){
        String input = "4 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_3(){
        String input = "4 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_4(){
        String input = "4 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_5(){
        String input = "4 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_6(){
        String input = "4 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_7(){
        String input = "4 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_8(){
        String input = "4 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_9(){
        String input = "4 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_10(){
        String input = "4 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_11(){
        String input = "4 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_12(){
        String input = "4 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_4_13(){
        String input = "4 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_4_14(){
        String input = "4 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_4_15(){
        String input = "4 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //5
    void set_5_1(){
        String input = "5 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_2(){
        String input = "5 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_3(){
        String input = "5 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_4(){
        String input = "5 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_5(){
        String input = "5 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_6(){
        String input = "5 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_7(){
        String input = "5 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_8(){
        String input = "5 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_9(){
        String input = "5 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_10(){
        String input = "5 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_11(){
        String input = "5 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_12(){
        String input = "5 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_5_13(){
        String input = "5 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_5_14(){
        String input = "5 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_5_15(){
        String input = "5 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //6
    void set_6_1(){
        String input = "6 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_2(){
        String input = "6 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_3(){
        String input = "6 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_4(){
        String input = "6 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_5(){
        String input = "6 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_6(){
        String input = "6 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_7(){
        String input = "6 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_8(){
        String input = "6 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_9(){
        String input = "6 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_10(){
        String input = "6 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_11(){
        String input = "6 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_12(){
        String input = "6 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_6_13(){
        String input = "6 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_6_14(){
        String input = "6 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_6_15(){
        String input = "6 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //7
    void set_7_1(){
        String input = "7 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_2(){
        String input = "7 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_3(){
        String input = "7 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_4(){
        String input = "7 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_5(){
        String input = "7 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_6(){
        String input = "7 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_7(){
        String input = "7 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_8(){
        String input = "7 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_9(){
        String input = "7 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_10(){
        String input = "7 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_11(){
        String input = "7 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_12(){
        String input = "7 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_7_13(){
        String input = "7 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_7_14(){
        String input = "7 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_7_15(){
        String input = "7 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //8
    void set_8_1(){
        String input = "8 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_2(){
        String input = "8 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_3(){
        String input = "8 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_4(){
        String input = "8 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_5(){
        String input = "8 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_6(){
        String input = "8 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_7(){
        String input = "8 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_8(){
        String input = "8 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_9(){
        String input = "8 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_10(){
        String input = "8 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_11(){
        String input = "8 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_12(){
        String input = "8 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_8_13(){
        String input = "8 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_8_14(){
        String input = "8 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_8_15(){
        String input = "8 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //9
    void set_9_1(){
        String input = "9 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_2(){
        String input = "9 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_3(){
        String input = "9 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_4(){
        String input = "9 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_5(){
        String input = "9 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_6(){
        String input = "9 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_7(){
        String input = "9 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_8(){
        String input = "9 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_9(){
        String input = "9 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_10(){
        String input = "9 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_11(){
        String input = "9 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_12(){
        String input = "9 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_9_13(){
        String input = "9 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_9_14(){
        String input = "9 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_9_15(){
        String input = "9 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
   
    //10
    void set_10_1(){
        String input = "10 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_2(){
        String input = "10 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_3(){
        String input = "10 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_4(){
        String input = "10 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_5(){
        String input = "10 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_6(){
        String input = "10 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_7(){
        String input = "10 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_8(){
        String input = "10 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_9(){
        String input = "10 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_10(){
        String input = "10 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_11(){
        String input = "10 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_12(){
        String input = "10 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_10_13(){
        String input = "10 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_10_14(){
        String input = "10 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_10_15(){
        String input = "10 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //11
    void set_11_1(){
        String input = "11 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_2(){
        String input = "11 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_3(){
        String input = "11 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_4(){
        String input = "11 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_5(){
        String input = "11 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_6(){
        String input = "11 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_7(){
        String input = "11 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_8(){
        String input = "11 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_9(){
        String input = "11 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_10(){
        String input = "11 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_11(){
        String input = "11 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_12(){
        String input = "11 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_11_13(){
        String input = "11 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_11_14(){
        String input = "11 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_11_15(){
        String input = "11 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //12
    void set_12_1(){
        String input = "12 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_2(){
        String input = "12 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_3(){
        String input = "12 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_4(){
        String input = "12 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_5(){
        String input = "12 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_6(){
        String input = "12 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_7(){
        String input = "12 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_8(){
        String input = "12 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_9(){
        String input = "12 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_10(){
        String input = "12 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_11(){
        String input = "12 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_12(){
        String input = "12 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_12_13(){
        String input = "12 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_12_14(){
        String input = "12 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_12_15(){
        String input = "12 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //13
    void set_13_1(){
        String input = "13 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_2(){
        String input = "13 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_3(){
        String input = "13 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_4(){
        String input = "13 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_5(){
        String input = "13 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_6(){
        String input = "13 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_7(){
        String input = "13 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_8(){
        String input = "13 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_9(){
        String input = "13 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_10(){
        String input = "13 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_11(){
        String input = "13 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_12(){
        String input = "13 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_13_13(){
        String input = "13 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_13_14(){
        String input = "13 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_13_15(){
        String input = "13 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //14
    void set_14_1(){
        String input = "14 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_2(){
        String input = "14 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_3(){
        String input = "14 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_4(){
        String input = "14 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_5(){
        String input = "14 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_6(){
        String input = "14 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_7(){
        String input = "14 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_8(){
        String input = "14 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_9(){
        String input = "14 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_10(){
        String input = "14 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_11(){
        String input = "14 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_12(){
        String input = "14 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_14_13(){
        String input = "14 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_14_14(){
        String input = "14 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_14_15(){
        String input = "14 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    //15
    void set_15_1(){
        String input = "15 1";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_2(){
        String input = "15 2";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_3(){
        String input = "15 3";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_4(){
        String input = "15 4";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_5(){
        String input = "15 5";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_6(){
        String input = "15 6";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_7(){
        String input = "15 7";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_8(){
        String input = "15 8";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_9(){
        String input = "15 9";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_10(){
        String input = "15 10";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_11(){
        String input = "15 11";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_12(){
        String input = "15 12";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    void set_15_13(){
        String input = "15 13";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_15_14(){
        String input = "15 14";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    void set_15_15(){
        String input = "15 15";
        String s = gson.toJson(input, String.class);
        send(s);
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        InfoPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ColorLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        NextTextPanel = new javax.swing.JTextPane();
        ConnectButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        button_1_3 = new javax.swing.JButton();
        button_1_2 = new javax.swing.JButton();
        button_1_4 = new javax.swing.JButton();
        button_1_5 = new javax.swing.JButton();
        button_1_1 = new javax.swing.JButton();
        button_2_1 = new javax.swing.JButton();
        button_1_6 = new javax.swing.JButton();
        button_2_4 = new javax.swing.JButton();
        button_2_6 = new javax.swing.JButton();
        button_2_3 = new javax.swing.JButton();
        button_2_5 = new javax.swing.JButton();
        button_2_2 = new javax.swing.JButton();
        button_1_7 = new javax.swing.JButton();
        button_1_8 = new javax.swing.JButton();
        button_1_9 = new javax.swing.JButton();
        button_3_2 = new javax.swing.JButton();
        button_3_4 = new javax.swing.JButton();
        button_3_5 = new javax.swing.JButton();
        button_2_8 = new javax.swing.JButton();
        button_1_10 = new javax.swing.JButton();
        button_2_10 = new javax.swing.JButton();
        button_3_6 = new javax.swing.JButton();
        button_3_1 = new javax.swing.JButton();
        button_3_3 = new javax.swing.JButton();
        button_2_7 = new javax.swing.JButton();
        button_3_7 = new javax.swing.JButton();
        button_2_9 = new javax.swing.JButton();
        button_4_3 = new javax.swing.JButton();
        button_1_12 = new javax.swing.JButton();
        button_4_1 = new javax.swing.JButton();
        button_1_11 = new javax.swing.JButton();
        button_5_1 = new javax.swing.JButton();
        button_4_2 = new javax.swing.JButton();
        button_4_4 = new javax.swing.JButton();
        button_4_5 = new javax.swing.JButton();
        button_4_6 = new javax.swing.JButton();
        button_4_7 = new javax.swing.JButton();
        button_3_8 = new javax.swing.JButton();
        button_3_9 = new javax.swing.JButton();
        button_3_10 = new javax.swing.JButton();
        button_4_8 = new javax.swing.JButton();
        button_4_10 = new javax.swing.JButton();
        button_4_9 = new javax.swing.JButton();
        button_2_11 = new javax.swing.JButton();
        button_2_12 = new javax.swing.JButton();
        button_1_13 = new javax.swing.JButton();
        button_1_14 = new javax.swing.JButton();
        button_1_15 = new javax.swing.JButton();
        button_2_13 = new javax.swing.JButton();
        button_3_11 = new javax.swing.JButton();
        button_3_12 = new javax.swing.JButton();
        button_2_14 = new javax.swing.JButton();
        button_2_15 = new javax.swing.JButton();
        button_3_13 = new javax.swing.JButton();
        button_3_14 = new javax.swing.JButton();
        button_3_15 = new javax.swing.JButton();
        button_6_1 = new javax.swing.JButton();
        button_5_3 = new javax.swing.JButton();
        button_4_15 = new javax.swing.JButton();
        button_7_1 = new javax.swing.JButton();
        button_8_1 = new javax.swing.JButton();
        button_10_1 = new javax.swing.JButton();
        button_6_2 = new javax.swing.JButton();
        button_7_2 = new javax.swing.JButton();
        button_8_2 = new javax.swing.JButton();
        button_5_2 = new javax.swing.JButton();
        button_10_2 = new javax.swing.JButton();
        button_4_14 = new javax.swing.JButton();
        button_4_13 = new javax.swing.JButton();
        button_4_12 = new javax.swing.JButton();
        button_4_11 = new javax.swing.JButton();
        button_5_4 = new javax.swing.JButton();
        button_5_5 = new javax.swing.JButton();
        button_5_6 = new javax.swing.JButton();
        button_5_7 = new javax.swing.JButton();
        button_5_8 = new javax.swing.JButton();
        button_11_1 = new javax.swing.JButton();
        button_12_1 = new javax.swing.JButton();
        button_11_2 = new javax.swing.JButton();
        button_6_3 = new javax.swing.JButton();
        button_13_1 = new javax.swing.JButton();
        button_14_1 = new javax.swing.JButton();
        button_15_1 = new javax.swing.JButton();
        button_15_2 = new javax.swing.JButton();
        button_15_3 = new javax.swing.JButton();
        button_15_4 = new javax.swing.JButton();
        button_13_2 = new javax.swing.JButton();
        button_12_2 = new javax.swing.JButton();
        button_14_4 = new javax.swing.JButton();
        button_15_5 = new javax.swing.JButton();
        button_7_3 = new javax.swing.JButton();
        button_14_3 = new javax.swing.JButton();
        button_14_5 = new javax.swing.JButton();
        button_11_3 = new javax.swing.JButton();
        button_15_6 = new javax.swing.JButton();
        button_14_6 = new javax.swing.JButton();
        button_14_7 = new javax.swing.JButton();
        button_13_3 = new javax.swing.JButton();
        button_12_3 = new javax.swing.JButton();
        button_10_3 = new javax.swing.JButton();
        button_15_7 = new javax.swing.JButton();
        button_15_8 = new javax.swing.JButton();
        button_14_2 = new javax.swing.JButton();
        button_14_8 = new javax.swing.JButton();
        button_15_9 = new javax.swing.JButton();
        button_15_12 = new javax.swing.JButton();
        button_15_10 = new javax.swing.JButton();
        button_14_9 = new javax.swing.JButton();
        button_15_11 = new javax.swing.JButton();
        button_14_10 = new javax.swing.JButton();
        button_14_11 = new javax.swing.JButton();
        button_14_12 = new javax.swing.JButton();
        button_10_8 = new javax.swing.JButton();
        button_15_14 = new javax.swing.JButton();
        button_15_15 = new javax.swing.JButton();
        button_15_13 = new javax.swing.JButton();
        button_8_13 = new javax.swing.JButton();
        button_11_15 = new javax.swing.JButton();
        button_8_3 = new javax.swing.JButton();
        button_14_14 = new javax.swing.JButton();
        button_13_10 = new javax.swing.JButton();
        button_14_15 = new javax.swing.JButton();
        button_13_15 = new javax.swing.JButton();
        button_12_15 = new javax.swing.JButton();
        button_5_12 = new javax.swing.JButton();
        button_14_13 = new javax.swing.JButton();
        button_5_9 = new javax.swing.JButton();
        button_13_14 = new javax.swing.JButton();
        button_12_14 = new javax.swing.JButton();
        button_5_11 = new javax.swing.JButton();
        button_5_15 = new javax.swing.JButton();
        button_13_13 = new javax.swing.JButton();
        button_13_12 = new javax.swing.JButton();
        button_13_11 = new javax.swing.JButton();
        button_12_13 = new javax.swing.JButton();
        button_11_14 = new javax.swing.JButton();
        button_12_12 = new javax.swing.JButton();
        button_11_13 = new javax.swing.JButton();
        button_10_14 = new javax.swing.JButton();
        button_7_13 = new javax.swing.JButton();
        button_10_15 = new javax.swing.JButton();
        button_10_12 = new javax.swing.JButton();
        button_11_11 = new javax.swing.JButton();
        button_11_12 = new javax.swing.JButton();
        button_13_4 = new javax.swing.JButton();
        button_12_4 = new javax.swing.JButton();
        button_13_5 = new javax.swing.JButton();
        button_10_13 = new javax.swing.JButton();
        button_8_14 = new javax.swing.JButton();
        button_13_6 = new javax.swing.JButton();
        button_7_14 = new javax.swing.JButton();
        button_7_11 = new javax.swing.JButton();
        button_13_7 = new javax.swing.JButton();
        button_13_8 = new javax.swing.JButton();
        button_13_9 = new javax.swing.JButton();
        button_12_11 = new javax.swing.JButton();
        button_5_14 = new javax.swing.JButton();
        button_5_13 = new javax.swing.JButton();
        button_6_13 = new javax.swing.JButton();
        button_6_6 = new javax.swing.JButton();
        button_5_10 = new javax.swing.JButton();
        button_6_10 = new javax.swing.JButton();
        button_6_9 = new javax.swing.JButton();
        button_6_8 = new javax.swing.JButton();
        button_6_7 = new javax.swing.JButton();
        button_6_11 = new javax.swing.JButton();
        button_9_9 = new javax.swing.JButton();
        button_10_11 = new javax.swing.JButton();
        button_9_10 = new javax.swing.JButton();
        button_9_11 = new javax.swing.JButton();
        button_9_12 = new javax.swing.JButton();
        button_8_12 = new javax.swing.JButton();
        button_7_12 = new javax.swing.JButton();
        button_6_12 = new javax.swing.JButton();
        button_6_5 = new javax.swing.JButton();
        button_11_8 = new javax.swing.JButton();
        button_11_9 = new javax.swing.JButton();
        button_10_10 = new javax.swing.JButton();
        button_9_8 = new javax.swing.JButton();
        button_12_9 = new javax.swing.JButton();
        button_11_10 = new javax.swing.JButton();
        button_12_7 = new javax.swing.JButton();
        button_12_8 = new javax.swing.JButton();
        button_11_6 = new javax.swing.JButton();
        button_11_7 = new javax.swing.JButton();
        button_10_9 = new javax.swing.JButton();
        button_12_6 = new javax.swing.JButton();
        button_12_5 = new javax.swing.JButton();
        button_11_5 = new javax.swing.JButton();
        button_11_4 = new javax.swing.JButton();
        button_9_1 = new javax.swing.JButton();
        button_12_10 = new javax.swing.JButton();
        button_9_2 = new javax.swing.JButton();
        button_10_7 = new javax.swing.JButton();
        button_8_6 = new javax.swing.JButton();
        button_10_6 = new javax.swing.JButton();
        button_9_7 = new javax.swing.JButton();
        button_8_11 = new javax.swing.JButton();
        button_6_14 = new javax.swing.JButton();
        button_8_4 = new javax.swing.JButton();
        button_6_4 = new javax.swing.JButton();
        button_7_4 = new javax.swing.JButton();
        button_8_10 = new javax.swing.JButton();
        button_7_10 = new javax.swing.JButton();
        button_7_9 = new javax.swing.JButton();
        button_9_3 = new javax.swing.JButton();
        button_9_5 = new javax.swing.JButton();
        button_7_6 = new javax.swing.JButton();
        button_7_7 = new javax.swing.JButton();
        button_7_5 = new javax.swing.JButton();
        button_8_5 = new javax.swing.JButton();
        button_7_8 = new javax.swing.JButton();
        button_9_4 = new javax.swing.JButton();
        button_10_4 = new javax.swing.JButton();
        button_10_5 = new javax.swing.JButton();
        button_9_6 = new javax.swing.JButton();
        button_8_8 = new javax.swing.JButton();
        button_8_9 = new javax.swing.JButton();
        button_8_7 = new javax.swing.JButton();
        button_9_14 = new javax.swing.JButton();
        button_9_15 = new javax.swing.JButton();
        button_9_13 = new javax.swing.JButton();
        button_8_15 = new javax.swing.JButton();
        button_7_15 = new javax.swing.JButton();
        button_6_15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InfoPanel.setBackground(new java.awt.Color(51, 51, 255));
        InfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Information");

        ColorLabel.setBackground(new java.awt.Color(255, 51, 51));
        ColorLabel.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        ColorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ColorLabel.setText("My colour");

        jScrollPane3.setViewportView(NextTextPanel);

        ConnectButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ConnectButton.setText("Connect");

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(ConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        button_1_3.setBackground(new java.awt.Color(0, 0, 0));
        button_1_3.setForeground(new java.awt.Color(153, 153, 255));

        button_1_2.setBackground(new java.awt.Color(0, 0, 0));
        button_1_2.setForeground(new java.awt.Color(153, 153, 255));

        button_1_4.setBackground(new java.awt.Color(0, 0, 0));
        button_1_4.setForeground(new java.awt.Color(153, 153, 255));

        button_1_5.setBackground(new java.awt.Color(0, 0, 0));
        button_1_5.setForeground(new java.awt.Color(153, 153, 255));

        button_1_1.setBackground(new java.awt.Color(0, 0, 0));
        button_1_1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        button_1_1.setForeground(new java.awt.Color(153, 153, 255));

        button_2_1.setBackground(new java.awt.Color(0, 0, 0));
        button_2_1.setForeground(new java.awt.Color(153, 153, 255));

        button_1_6.setBackground(new java.awt.Color(0, 0, 0));
        button_1_6.setForeground(new java.awt.Color(153, 153, 255));

        button_2_4.setBackground(new java.awt.Color(0, 0, 0));
        button_2_4.setForeground(new java.awt.Color(153, 153, 255));

        button_2_6.setBackground(new java.awt.Color(0, 0, 0));
        button_2_6.setForeground(new java.awt.Color(153, 153, 255));

        button_2_3.setBackground(new java.awt.Color(0, 0, 0));
        button_2_3.setForeground(new java.awt.Color(153, 153, 255));

        button_2_5.setBackground(new java.awt.Color(0, 0, 0));
        button_2_5.setForeground(new java.awt.Color(153, 153, 255));

        button_2_2.setBackground(new java.awt.Color(0, 0, 0));
        button_2_2.setForeground(new java.awt.Color(153, 153, 255));

        button_1_7.setBackground(new java.awt.Color(0, 0, 0));
        button_1_7.setForeground(new java.awt.Color(153, 153, 255));

        button_1_8.setBackground(new java.awt.Color(0, 0, 0));
        button_1_8.setForeground(new java.awt.Color(153, 153, 255));

        button_1_9.setBackground(new java.awt.Color(0, 0, 0));
        button_1_9.setForeground(new java.awt.Color(153, 153, 255));

        button_3_2.setBackground(new java.awt.Color(0, 0, 0));
        button_3_2.setForeground(new java.awt.Color(153, 153, 255));

        button_3_4.setBackground(new java.awt.Color(0, 0, 0));
        button_3_4.setForeground(new java.awt.Color(153, 153, 255));

        button_3_5.setBackground(new java.awt.Color(0, 0, 0));
        button_3_5.setForeground(new java.awt.Color(153, 153, 255));

        button_2_8.setBackground(new java.awt.Color(0, 0, 0));
        button_2_8.setForeground(new java.awt.Color(153, 153, 255));

        button_1_10.setBackground(new java.awt.Color(0, 0, 0));
        button_1_10.setForeground(new java.awt.Color(153, 153, 255));

        button_2_10.setBackground(new java.awt.Color(0, 0, 0));
        button_2_10.setForeground(new java.awt.Color(153, 153, 255));

        button_3_6.setBackground(new java.awt.Color(0, 0, 0));
        button_3_6.setForeground(new java.awt.Color(153, 153, 255));

        button_3_1.setBackground(new java.awt.Color(0, 0, 0));
        button_3_1.setForeground(new java.awt.Color(153, 153, 255));

        button_3_3.setBackground(new java.awt.Color(0, 0, 0));
        button_3_3.setForeground(new java.awt.Color(153, 153, 255));

        button_2_7.setBackground(new java.awt.Color(0, 0, 0));
        button_2_7.setForeground(new java.awt.Color(153, 153, 255));

        button_3_7.setBackground(new java.awt.Color(0, 0, 0));
        button_3_7.setForeground(new java.awt.Color(153, 153, 255));

        button_2_9.setBackground(new java.awt.Color(0, 0, 0));
        button_2_9.setForeground(new java.awt.Color(153, 153, 255));

        button_4_3.setBackground(new java.awt.Color(0, 0, 0));
        button_4_3.setForeground(new java.awt.Color(153, 153, 255));

        button_1_12.setBackground(new java.awt.Color(0, 0, 0));
        button_1_12.setForeground(new java.awt.Color(153, 153, 255));

        button_4_1.setBackground(new java.awt.Color(0, 0, 0));
        button_4_1.setForeground(new java.awt.Color(153, 153, 255));

        button_1_11.setBackground(new java.awt.Color(0, 0, 0));
        button_1_11.setForeground(new java.awt.Color(153, 153, 255));

        button_5_1.setBackground(new java.awt.Color(0, 0, 0));
        button_5_1.setForeground(new java.awt.Color(153, 153, 255));
        button_5_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5_1ActionPerformed(evt);
            }
        });

        button_4_2.setBackground(new java.awt.Color(0, 0, 0));
        button_4_2.setForeground(new java.awt.Color(153, 153, 255));

        button_4_4.setBackground(new java.awt.Color(0, 0, 0));
        button_4_4.setForeground(new java.awt.Color(153, 153, 255));

        button_4_5.setBackground(new java.awt.Color(0, 0, 0));
        button_4_5.setForeground(new java.awt.Color(153, 153, 255));
        button_4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4_5ActionPerformed(evt);
            }
        });

        button_4_6.setBackground(new java.awt.Color(0, 0, 0));
        button_4_6.setForeground(new java.awt.Color(153, 153, 255));

        button_4_7.setBackground(new java.awt.Color(0, 0, 0));
        button_4_7.setForeground(new java.awt.Color(153, 153, 255));

        button_3_8.setBackground(new java.awt.Color(0, 0, 0));
        button_3_8.setForeground(new java.awt.Color(153, 153, 255));

        button_3_9.setBackground(new java.awt.Color(0, 0, 0));
        button_3_9.setForeground(new java.awt.Color(153, 153, 255));

        button_3_10.setBackground(new java.awt.Color(0, 0, 0));
        button_3_10.setForeground(new java.awt.Color(153, 153, 255));

        button_4_8.setBackground(new java.awt.Color(0, 0, 0));
        button_4_8.setForeground(new java.awt.Color(153, 153, 255));

        button_4_10.setBackground(new java.awt.Color(0, 0, 0));
        button_4_10.setForeground(new java.awt.Color(153, 153, 255));

        button_4_9.setBackground(new java.awt.Color(0, 0, 0));
        button_4_9.setForeground(new java.awt.Color(153, 153, 255));

        button_2_11.setBackground(new java.awt.Color(0, 0, 0));
        button_2_11.setForeground(new java.awt.Color(153, 153, 255));

        button_2_12.setBackground(new java.awt.Color(0, 0, 0));
        button_2_12.setForeground(new java.awt.Color(153, 153, 255));

        button_1_13.setBackground(new java.awt.Color(0, 0, 0));
        button_1_13.setForeground(new java.awt.Color(153, 153, 255));

        button_1_14.setBackground(new java.awt.Color(0, 0, 0));
        button_1_14.setForeground(new java.awt.Color(153, 153, 255));

        button_1_15.setBackground(new java.awt.Color(0, 0, 0));
        button_1_15.setForeground(new java.awt.Color(153, 153, 255));

        button_2_13.setBackground(new java.awt.Color(0, 0, 0));
        button_2_13.setForeground(new java.awt.Color(153, 153, 255));

        button_3_11.setBackground(new java.awt.Color(0, 0, 0));
        button_3_11.setForeground(new java.awt.Color(153, 153, 255));

        button_3_12.setBackground(new java.awt.Color(0, 0, 0));
        button_3_12.setForeground(new java.awt.Color(153, 153, 255));

        button_2_14.setBackground(new java.awt.Color(0, 0, 0));
        button_2_14.setForeground(new java.awt.Color(153, 153, 255));
        button_2_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2_14ActionPerformed(evt);
            }
        });

        button_2_15.setBackground(new java.awt.Color(0, 0, 0));
        button_2_15.setForeground(new java.awt.Color(153, 153, 255));

        button_3_13.setBackground(new java.awt.Color(0, 0, 0));
        button_3_13.setForeground(new java.awt.Color(153, 153, 255));

        button_3_14.setBackground(new java.awt.Color(0, 0, 0));
        button_3_14.setForeground(new java.awt.Color(153, 153, 255));

        button_3_15.setBackground(new java.awt.Color(0, 0, 0));
        button_3_15.setForeground(new java.awt.Color(153, 153, 255));

        button_6_1.setBackground(new java.awt.Color(0, 0, 0));
        button_6_1.setForeground(new java.awt.Color(153, 153, 255));

        button_5_3.setBackground(new java.awt.Color(0, 0, 0));
        button_5_3.setForeground(new java.awt.Color(153, 153, 255));

        button_4_15.setBackground(new java.awt.Color(0, 0, 0));
        button_4_15.setForeground(new java.awt.Color(153, 153, 255));

        button_7_1.setBackground(new java.awt.Color(0, 0, 0));
        button_7_1.setForeground(new java.awt.Color(153, 153, 255));

        button_8_1.setBackground(new java.awt.Color(0, 0, 0));
        button_8_1.setForeground(new java.awt.Color(153, 153, 255));
        button_8_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8_1ActionPerformed(evt);
            }
        });

        button_10_1.setBackground(new java.awt.Color(0, 0, 0));
        button_10_1.setForeground(new java.awt.Color(153, 153, 255));

        button_6_2.setBackground(new java.awt.Color(0, 0, 0));
        button_6_2.setForeground(new java.awt.Color(153, 153, 255));

        button_7_2.setBackground(new java.awt.Color(0, 0, 0));
        button_7_2.setForeground(new java.awt.Color(153, 153, 255));

        button_8_2.setBackground(new java.awt.Color(0, 0, 0));
        button_8_2.setForeground(new java.awt.Color(153, 153, 255));

        button_5_2.setBackground(new java.awt.Color(0, 0, 0));
        button_5_2.setForeground(new java.awt.Color(153, 153, 255));

        button_10_2.setBackground(new java.awt.Color(0, 0, 0));
        button_10_2.setForeground(new java.awt.Color(153, 153, 255));

        button_4_14.setBackground(new java.awt.Color(0, 0, 0));
        button_4_14.setForeground(new java.awt.Color(153, 153, 255));

        button_4_13.setBackground(new java.awt.Color(0, 0, 0));
        button_4_13.setForeground(new java.awt.Color(153, 153, 255));

        button_4_12.setBackground(new java.awt.Color(0, 0, 0));
        button_4_12.setForeground(new java.awt.Color(153, 153, 255));

        button_4_11.setBackground(new java.awt.Color(0, 0, 0));
        button_4_11.setForeground(new java.awt.Color(153, 153, 255));

        button_5_4.setBackground(new java.awt.Color(0, 0, 0));
        button_5_4.setForeground(new java.awt.Color(153, 153, 255));

        button_5_5.setBackground(new java.awt.Color(0, 0, 0));
        button_5_5.setForeground(new java.awt.Color(153, 153, 255));

        button_5_6.setBackground(new java.awt.Color(0, 0, 0));
        button_5_6.setForeground(new java.awt.Color(153, 153, 255));

        button_5_7.setBackground(new java.awt.Color(0, 0, 0));
        button_5_7.setForeground(new java.awt.Color(153, 153, 255));

        button_5_8.setBackground(new java.awt.Color(0, 0, 0));
        button_5_8.setForeground(new java.awt.Color(153, 153, 255));

        button_11_1.setBackground(new java.awt.Color(0, 0, 0));
        button_11_1.setForeground(new java.awt.Color(153, 153, 255));

        button_12_1.setBackground(new java.awt.Color(0, 0, 0));
        button_12_1.setForeground(new java.awt.Color(153, 153, 255));

        button_11_2.setBackground(new java.awt.Color(0, 0, 0));
        button_11_2.setForeground(new java.awt.Color(153, 153, 255));

        button_6_3.setBackground(new java.awt.Color(0, 0, 0));
        button_6_3.setForeground(new java.awt.Color(153, 153, 255));

        button_13_1.setBackground(new java.awt.Color(0, 0, 0));
        button_13_1.setForeground(new java.awt.Color(153, 153, 255));

        button_14_1.setBackground(new java.awt.Color(0, 0, 0));
        button_14_1.setForeground(new java.awt.Color(153, 153, 255));

        button_15_1.setBackground(new java.awt.Color(0, 0, 0));
        button_15_1.setForeground(new java.awt.Color(153, 153, 255));

        button_15_2.setBackground(new java.awt.Color(0, 0, 0));
        button_15_2.setForeground(new java.awt.Color(153, 153, 255));

        button_15_3.setBackground(new java.awt.Color(0, 0, 0));
        button_15_3.setForeground(new java.awt.Color(153, 153, 255));

        button_15_4.setBackground(new java.awt.Color(0, 0, 0));
        button_15_4.setForeground(new java.awt.Color(153, 153, 255));

        button_13_2.setBackground(new java.awt.Color(0, 0, 0));
        button_13_2.setForeground(new java.awt.Color(153, 153, 255));

        button_12_2.setBackground(new java.awt.Color(0, 0, 0));
        button_12_2.setForeground(new java.awt.Color(153, 153, 255));

        button_14_4.setBackground(new java.awt.Color(0, 0, 0));
        button_14_4.setForeground(new java.awt.Color(153, 153, 255));

        button_15_5.setBackground(new java.awt.Color(0, 0, 0));
        button_15_5.setForeground(new java.awt.Color(153, 153, 255));

        button_7_3.setBackground(new java.awt.Color(0, 0, 0));
        button_7_3.setForeground(new java.awt.Color(153, 153, 255));

        button_14_3.setBackground(new java.awt.Color(0, 0, 0));
        button_14_3.setForeground(new java.awt.Color(153, 153, 255));

        button_14_5.setBackground(new java.awt.Color(0, 0, 0));
        button_14_5.setForeground(new java.awt.Color(153, 153, 255));

        button_11_3.setBackground(new java.awt.Color(0, 0, 0));
        button_11_3.setForeground(new java.awt.Color(153, 153, 255));

        button_15_6.setBackground(new java.awt.Color(0, 0, 0));
        button_15_6.setForeground(new java.awt.Color(153, 153, 255));

        button_14_6.setBackground(new java.awt.Color(0, 0, 0));
        button_14_6.setForeground(new java.awt.Color(153, 153, 255));

        button_14_7.setBackground(new java.awt.Color(0, 0, 0));
        button_14_7.setForeground(new java.awt.Color(153, 153, 255));

        button_13_3.setBackground(new java.awt.Color(0, 0, 0));
        button_13_3.setForeground(new java.awt.Color(153, 153, 255));

        button_12_3.setBackground(new java.awt.Color(0, 0, 0));
        button_12_3.setForeground(new java.awt.Color(153, 153, 255));
        button_12_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12_3ActionPerformed(evt);
            }
        });

        button_10_3.setBackground(new java.awt.Color(0, 0, 0));
        button_10_3.setForeground(new java.awt.Color(153, 153, 255));

        button_15_7.setBackground(new java.awt.Color(0, 0, 0));
        button_15_7.setForeground(new java.awt.Color(153, 153, 255));

        button_15_8.setBackground(new java.awt.Color(0, 0, 0));
        button_15_8.setForeground(new java.awt.Color(153, 153, 255));

        button_14_2.setBackground(new java.awt.Color(0, 0, 0));
        button_14_2.setForeground(new java.awt.Color(153, 153, 255));

        button_14_8.setBackground(new java.awt.Color(0, 0, 0));
        button_14_8.setForeground(new java.awt.Color(153, 153, 255));

        button_15_9.setBackground(new java.awt.Color(0, 0, 0));
        button_15_9.setForeground(new java.awt.Color(153, 153, 255));

        button_15_12.setBackground(new java.awt.Color(0, 0, 0));
        button_15_12.setForeground(new java.awt.Color(153, 153, 255));

        button_15_10.setBackground(new java.awt.Color(0, 0, 0));
        button_15_10.setForeground(new java.awt.Color(153, 153, 255));

        button_14_9.setBackground(new java.awt.Color(0, 0, 0));
        button_14_9.setForeground(new java.awt.Color(153, 153, 255));

        button_15_11.setBackground(new java.awt.Color(0, 0, 0));
        button_15_11.setForeground(new java.awt.Color(153, 153, 255));

        button_14_10.setBackground(new java.awt.Color(0, 0, 0));
        button_14_10.setForeground(new java.awt.Color(153, 153, 255));

        button_14_11.setBackground(new java.awt.Color(0, 0, 0));
        button_14_11.setForeground(new java.awt.Color(153, 153, 255));

        button_14_12.setBackground(new java.awt.Color(0, 0, 0));
        button_14_12.setForeground(new java.awt.Color(153, 153, 255));

        button_10_8.setBackground(new java.awt.Color(0, 0, 0));
        button_10_8.setForeground(new java.awt.Color(153, 153, 255));

        button_15_14.setBackground(new java.awt.Color(0, 0, 0));
        button_15_14.setForeground(new java.awt.Color(153, 153, 255));

        button_15_15.setBackground(new java.awt.Color(0, 0, 0));
        button_15_15.setForeground(new java.awt.Color(153, 153, 255));

        button_15_13.setBackground(new java.awt.Color(0, 0, 0));
        button_15_13.setForeground(new java.awt.Color(153, 153, 255));

        button_8_13.setBackground(new java.awt.Color(0, 0, 0));
        button_8_13.setForeground(new java.awt.Color(153, 153, 255));

        button_11_15.setBackground(new java.awt.Color(0, 0, 0));
        button_11_15.setForeground(new java.awt.Color(153, 153, 255));

        button_8_3.setBackground(new java.awt.Color(0, 0, 0));
        button_8_3.setForeground(new java.awt.Color(153, 153, 255));

        button_14_14.setBackground(new java.awt.Color(0, 0, 0));
        button_14_14.setForeground(new java.awt.Color(153, 153, 255));

        button_13_10.setBackground(new java.awt.Color(0, 0, 0));
        button_13_10.setForeground(new java.awt.Color(153, 153, 255));

        button_14_15.setBackground(new java.awt.Color(0, 0, 0));
        button_14_15.setForeground(new java.awt.Color(153, 153, 255));

        button_13_15.setBackground(new java.awt.Color(0, 0, 0));
        button_13_15.setForeground(new java.awt.Color(153, 153, 255));

        button_12_15.setBackground(new java.awt.Color(0, 0, 0));
        button_12_15.setForeground(new java.awt.Color(153, 153, 255));

        button_5_12.setBackground(new java.awt.Color(0, 0, 0));
        button_5_12.setForeground(new java.awt.Color(153, 153, 255));

        button_14_13.setBackground(new java.awt.Color(0, 0, 0));
        button_14_13.setForeground(new java.awt.Color(153, 153, 255));

        button_5_9.setBackground(new java.awt.Color(0, 0, 0));
        button_5_9.setForeground(new java.awt.Color(153, 153, 255));

        button_13_14.setBackground(new java.awt.Color(0, 0, 0));
        button_13_14.setForeground(new java.awt.Color(153, 153, 255));

        button_12_14.setBackground(new java.awt.Color(0, 0, 0));
        button_12_14.setForeground(new java.awt.Color(153, 153, 255));

        button_5_11.setBackground(new java.awt.Color(0, 0, 0));
        button_5_11.setForeground(new java.awt.Color(153, 153, 255));

        button_5_15.setBackground(new java.awt.Color(0, 0, 0));
        button_5_15.setForeground(new java.awt.Color(153, 153, 255));

        button_13_13.setBackground(new java.awt.Color(0, 0, 0));
        button_13_13.setForeground(new java.awt.Color(153, 153, 255));

        button_13_12.setBackground(new java.awt.Color(0, 0, 0));
        button_13_12.setForeground(new java.awt.Color(153, 153, 255));

        button_13_11.setBackground(new java.awt.Color(0, 0, 0));
        button_13_11.setForeground(new java.awt.Color(153, 153, 255));

        button_12_13.setBackground(new java.awt.Color(0, 0, 0));
        button_12_13.setForeground(new java.awt.Color(153, 153, 255));

        button_11_14.setBackground(new java.awt.Color(0, 0, 0));
        button_11_14.setForeground(new java.awt.Color(153, 153, 255));

        button_12_12.setBackground(new java.awt.Color(0, 0, 0));
        button_12_12.setForeground(new java.awt.Color(153, 153, 255));

        button_11_13.setBackground(new java.awt.Color(0, 0, 0));
        button_11_13.setForeground(new java.awt.Color(153, 153, 255));

        button_10_14.setBackground(new java.awt.Color(0, 0, 0));
        button_10_14.setForeground(new java.awt.Color(153, 153, 255));

        button_7_13.setBackground(new java.awt.Color(0, 0, 0));
        button_7_13.setForeground(new java.awt.Color(153, 153, 255));

        button_10_15.setBackground(new java.awt.Color(0, 0, 0));
        button_10_15.setForeground(new java.awt.Color(153, 153, 255));

        button_10_12.setBackground(new java.awt.Color(0, 0, 0));
        button_10_12.setForeground(new java.awt.Color(153, 153, 255));

        button_11_11.setBackground(new java.awt.Color(0, 0, 0));
        button_11_11.setForeground(new java.awt.Color(153, 153, 255));

        button_11_12.setBackground(new java.awt.Color(0, 0, 0));
        button_11_12.setForeground(new java.awt.Color(153, 153, 255));

        button_13_4.setBackground(new java.awt.Color(0, 0, 0));
        button_13_4.setForeground(new java.awt.Color(153, 153, 255));

        button_12_4.setBackground(new java.awt.Color(0, 0, 0));
        button_12_4.setForeground(new java.awt.Color(153, 153, 255));

        button_13_5.setBackground(new java.awt.Color(0, 0, 0));
        button_13_5.setForeground(new java.awt.Color(153, 153, 255));

        button_10_13.setBackground(new java.awt.Color(0, 0, 0));
        button_10_13.setForeground(new java.awt.Color(153, 153, 255));

        button_8_14.setBackground(new java.awt.Color(0, 0, 0));
        button_8_14.setForeground(new java.awt.Color(153, 153, 255));

        button_13_6.setBackground(new java.awt.Color(0, 0, 0));
        button_13_6.setForeground(new java.awt.Color(153, 153, 255));

        button_7_14.setBackground(new java.awt.Color(0, 0, 0));
        button_7_14.setForeground(new java.awt.Color(153, 153, 255));

        button_7_11.setBackground(new java.awt.Color(0, 0, 0));
        button_7_11.setForeground(new java.awt.Color(153, 153, 255));

        button_13_7.setBackground(new java.awt.Color(0, 0, 0));
        button_13_7.setForeground(new java.awt.Color(153, 153, 255));

        button_13_8.setBackground(new java.awt.Color(0, 0, 0));
        button_13_8.setForeground(new java.awt.Color(153, 153, 255));

        button_13_9.setBackground(new java.awt.Color(0, 0, 0));
        button_13_9.setForeground(new java.awt.Color(153, 153, 255));

        button_12_11.setBackground(new java.awt.Color(0, 0, 0));
        button_12_11.setForeground(new java.awt.Color(153, 153, 255));

        button_5_14.setBackground(new java.awt.Color(0, 0, 0));
        button_5_14.setForeground(new java.awt.Color(153, 153, 255));

        button_5_13.setBackground(new java.awt.Color(0, 0, 0));
        button_5_13.setForeground(new java.awt.Color(153, 153, 255));

        button_6_13.setBackground(new java.awt.Color(0, 0, 0));
        button_6_13.setForeground(new java.awt.Color(153, 153, 255));

        button_6_6.setBackground(new java.awt.Color(0, 0, 0));
        button_6_6.setForeground(new java.awt.Color(153, 153, 255));

        button_5_10.setBackground(new java.awt.Color(0, 0, 0));
        button_5_10.setForeground(new java.awt.Color(153, 153, 255));

        button_6_10.setBackground(new java.awt.Color(0, 0, 0));
        button_6_10.setForeground(new java.awt.Color(153, 153, 255));

        button_6_9.setBackground(new java.awt.Color(0, 0, 0));
        button_6_9.setForeground(new java.awt.Color(153, 153, 255));

        button_6_8.setBackground(new java.awt.Color(0, 0, 0));
        button_6_8.setForeground(new java.awt.Color(153, 153, 255));

        button_6_7.setBackground(new java.awt.Color(0, 0, 0));
        button_6_7.setForeground(new java.awt.Color(153, 153, 255));

        button_6_11.setBackground(new java.awt.Color(0, 0, 0));
        button_6_11.setForeground(new java.awt.Color(153, 153, 255));

        button_9_9.setBackground(new java.awt.Color(0, 0, 0));
        button_9_9.setForeground(new java.awt.Color(153, 153, 255));

        button_10_11.setBackground(new java.awt.Color(0, 0, 0));
        button_10_11.setForeground(new java.awt.Color(153, 153, 255));

        button_9_10.setBackground(new java.awt.Color(0, 0, 0));
        button_9_10.setForeground(new java.awt.Color(153, 153, 255));

        button_9_11.setBackground(new java.awt.Color(0, 0, 0));
        button_9_11.setForeground(new java.awt.Color(153, 153, 255));

        button_9_12.setBackground(new java.awt.Color(0, 0, 0));
        button_9_12.setForeground(new java.awt.Color(153, 153, 255));

        button_8_12.setBackground(new java.awt.Color(0, 0, 0));
        button_8_12.setForeground(new java.awt.Color(153, 153, 255));

        button_7_12.setBackground(new java.awt.Color(0, 0, 0));
        button_7_12.setForeground(new java.awt.Color(153, 153, 255));

        button_6_12.setBackground(new java.awt.Color(0, 0, 0));
        button_6_12.setForeground(new java.awt.Color(153, 153, 255));

        button_6_5.setBackground(new java.awt.Color(0, 0, 0));
        button_6_5.setForeground(new java.awt.Color(153, 153, 255));

        button_11_8.setBackground(new java.awt.Color(0, 0, 0));
        button_11_8.setForeground(new java.awt.Color(153, 153, 255));

        button_11_9.setBackground(new java.awt.Color(0, 0, 0));
        button_11_9.setForeground(new java.awt.Color(153, 153, 255));

        button_10_10.setBackground(new java.awt.Color(0, 0, 0));
        button_10_10.setForeground(new java.awt.Color(153, 153, 255));

        button_9_8.setBackground(new java.awt.Color(0, 0, 0));
        button_9_8.setForeground(new java.awt.Color(153, 153, 255));

        button_12_9.setBackground(new java.awt.Color(0, 0, 0));
        button_12_9.setForeground(new java.awt.Color(153, 153, 255));

        button_11_10.setBackground(new java.awt.Color(0, 0, 0));
        button_11_10.setForeground(new java.awt.Color(153, 153, 255));

        button_12_7.setBackground(new java.awt.Color(0, 0, 0));
        button_12_7.setForeground(new java.awt.Color(153, 153, 255));

        button_12_8.setBackground(new java.awt.Color(0, 0, 0));
        button_12_8.setForeground(new java.awt.Color(153, 153, 255));

        button_11_6.setBackground(new java.awt.Color(0, 0, 0));
        button_11_6.setForeground(new java.awt.Color(153, 153, 255));

        button_11_7.setBackground(new java.awt.Color(0, 0, 0));
        button_11_7.setForeground(new java.awt.Color(153, 153, 255));

        button_10_9.setBackground(new java.awt.Color(0, 0, 0));
        button_10_9.setForeground(new java.awt.Color(153, 153, 255));

        button_12_6.setBackground(new java.awt.Color(0, 0, 0));
        button_12_6.setForeground(new java.awt.Color(153, 153, 255));
        button_12_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12_6ActionPerformed(evt);
            }
        });

        button_12_5.setBackground(new java.awt.Color(0, 0, 0));
        button_12_5.setForeground(new java.awt.Color(153, 153, 255));

        button_11_5.setBackground(new java.awt.Color(0, 0, 0));
        button_11_5.setForeground(new java.awt.Color(153, 153, 255));

        button_11_4.setBackground(new java.awt.Color(0, 0, 0));
        button_11_4.setForeground(new java.awt.Color(153, 153, 255));

        button_9_1.setBackground(new java.awt.Color(0, 0, 0));
        button_9_1.setForeground(new java.awt.Color(153, 153, 255));

        button_12_10.setBackground(new java.awt.Color(0, 0, 0));
        button_12_10.setForeground(new java.awt.Color(153, 153, 255));

        button_9_2.setBackground(new java.awt.Color(0, 0, 0));
        button_9_2.setForeground(new java.awt.Color(153, 153, 255));

        button_10_7.setBackground(new java.awt.Color(0, 0, 0));
        button_10_7.setForeground(new java.awt.Color(153, 153, 255));

        button_8_6.setBackground(new java.awt.Color(0, 0, 0));
        button_8_6.setForeground(new java.awt.Color(153, 153, 255));

        button_10_6.setBackground(new java.awt.Color(0, 0, 0));
        button_10_6.setForeground(new java.awt.Color(153, 153, 255));

        button_9_7.setBackground(new java.awt.Color(0, 0, 0));
        button_9_7.setForeground(new java.awt.Color(153, 153, 255));

        button_8_11.setBackground(new java.awt.Color(0, 0, 0));
        button_8_11.setForeground(new java.awt.Color(153, 153, 255));

        button_6_14.setBackground(new java.awt.Color(0, 0, 0));
        button_6_14.setForeground(new java.awt.Color(153, 153, 255));

        button_8_4.setBackground(new java.awt.Color(0, 0, 0));
        button_8_4.setForeground(new java.awt.Color(153, 153, 255));

        button_6_4.setBackground(new java.awt.Color(0, 0, 0));
        button_6_4.setForeground(new java.awt.Color(153, 153, 255));

        button_7_4.setBackground(new java.awt.Color(0, 0, 0));
        button_7_4.setForeground(new java.awt.Color(153, 153, 255));

        button_8_10.setBackground(new java.awt.Color(0, 0, 0));
        button_8_10.setForeground(new java.awt.Color(153, 153, 255));

        button_7_10.setBackground(new java.awt.Color(0, 0, 0));
        button_7_10.setForeground(new java.awt.Color(153, 153, 255));

        button_7_9.setBackground(new java.awt.Color(0, 0, 0));
        button_7_9.setForeground(new java.awt.Color(153, 153, 255));

        button_9_3.setBackground(new java.awt.Color(0, 0, 0));
        button_9_3.setForeground(new java.awt.Color(153, 153, 255));

        button_9_5.setBackground(new java.awt.Color(0, 0, 0));
        button_9_5.setForeground(new java.awt.Color(153, 153, 255));

        button_7_6.setBackground(new java.awt.Color(0, 0, 0));
        button_7_6.setForeground(new java.awt.Color(153, 153, 255));

        button_7_7.setBackground(new java.awt.Color(0, 0, 0));
        button_7_7.setForeground(new java.awt.Color(153, 153, 255));

        button_7_5.setBackground(new java.awt.Color(0, 0, 0));
        button_7_5.setForeground(new java.awt.Color(153, 153, 255));

        button_8_5.setBackground(new java.awt.Color(0, 0, 0));
        button_8_5.setForeground(new java.awt.Color(153, 153, 255));

        button_7_8.setBackground(new java.awt.Color(0, 0, 0));
        button_7_8.setForeground(new java.awt.Color(153, 153, 255));

        button_9_4.setBackground(new java.awt.Color(0, 0, 0));
        button_9_4.setForeground(new java.awt.Color(153, 153, 255));

        button_10_4.setBackground(new java.awt.Color(0, 0, 0));
        button_10_4.setForeground(new java.awt.Color(153, 153, 255));

        button_10_5.setBackground(new java.awt.Color(0, 0, 0));
        button_10_5.setForeground(new java.awt.Color(153, 153, 255));

        button_9_6.setBackground(new java.awt.Color(0, 0, 0));
        button_9_6.setForeground(new java.awt.Color(153, 153, 255));

        button_8_8.setBackground(new java.awt.Color(0, 0, 0));
        button_8_8.setForeground(new java.awt.Color(153, 153, 255));

        button_8_9.setBackground(new java.awt.Color(0, 0, 0));
        button_8_9.setForeground(new java.awt.Color(153, 153, 255));

        button_8_7.setBackground(new java.awt.Color(0, 0, 0));
        button_8_7.setForeground(new java.awt.Color(153, 153, 255));

        button_9_14.setBackground(new java.awt.Color(0, 0, 0));
        button_9_14.setForeground(new java.awt.Color(153, 153, 255));

        button_9_15.setBackground(new java.awt.Color(0, 0, 0));
        button_9_15.setForeground(new java.awt.Color(153, 153, 255));

        button_9_13.setBackground(new java.awt.Color(0, 0, 0));
        button_9_13.setForeground(new java.awt.Color(153, 153, 255));

        button_8_15.setBackground(new java.awt.Color(0, 0, 0));
        button_8_15.setForeground(new java.awt.Color(153, 153, 255));

        button_7_15.setBackground(new java.awt.Color(0, 0, 0));
        button_7_15.setForeground(new java.awt.Color(153, 153, 255));

        button_6_15.setBackground(new java.awt.Color(0, 0, 0));
        button_6_15.setForeground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_10_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_11_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_12_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_13_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_14_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_15_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_9_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_1_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_2_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_5_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_5_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_3_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_4_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_4_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_4_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_10_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_10_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_10_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_13_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_13_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_14_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_14_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_14_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_14_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_13_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_13_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_13_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_12_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_12_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_11_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_11_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_11_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_11_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_12_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_12_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(button_8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_8_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_8_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(button_6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button_6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(button_7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button_7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(button_7_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_7_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(button_6_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_6_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_8_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_7_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_15_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_15_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_1_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_2_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_3_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_4_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_4_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_4_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_4_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_4_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_5_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_5_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_5_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_5_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_5_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_5_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_4_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_5_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button_6_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_6_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(button_6_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button_6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_6_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(button_6_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_7_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button_7_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_7_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_7_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_7_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_7_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(button_7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button_8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_8_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_8_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_8_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_8_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_8_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(button_8_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button_8_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_8_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_8_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_8_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_8_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button_9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_9_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button_9_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(button_9_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_9_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_9_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button_9_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_9_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(button_10_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_10_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button_10_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_10_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_11_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_11_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button_11_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_11_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_11_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_11_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_11_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_11_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(button_12_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button_12_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button_12_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button_12_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button_12_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button_12_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(button_12_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_12_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(button_13_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button_13_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(button_14_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_14_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(button_15_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_15_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(button_14_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(button_13_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(button_12_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(button_11_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(button_10_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_2_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_2_14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_2_14ActionPerformed

    private void button_5_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_5_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_5_1ActionPerformed

    private void button_8_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_8_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_8_1ActionPerformed

    private void button_4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_4_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_4_5ActionPerformed

    private void button_12_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_12_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_12_3ActionPerformed

    private void button_12_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_12_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_12_6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ColorLabel;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JTextPane NextTextPanel;
    private javax.swing.JButton button_10_1;
    private javax.swing.JButton button_10_10;
    private javax.swing.JButton button_10_11;
    private javax.swing.JButton button_10_12;
    private javax.swing.JButton button_10_13;
    private javax.swing.JButton button_10_14;
    private javax.swing.JButton button_10_15;
    private javax.swing.JButton button_10_2;
    private javax.swing.JButton button_10_3;
    private javax.swing.JButton button_10_4;
    private javax.swing.JButton button_10_5;
    private javax.swing.JButton button_10_6;
    private javax.swing.JButton button_10_7;
    private javax.swing.JButton button_10_8;
    private javax.swing.JButton button_10_9;
    private javax.swing.JButton button_11_1;
    private javax.swing.JButton button_11_10;
    private javax.swing.JButton button_11_11;
    private javax.swing.JButton button_11_12;
    private javax.swing.JButton button_11_13;
    private javax.swing.JButton button_11_14;
    private javax.swing.JButton button_11_15;
    private javax.swing.JButton button_11_2;
    private javax.swing.JButton button_11_3;
    private javax.swing.JButton button_11_4;
    private javax.swing.JButton button_11_5;
    private javax.swing.JButton button_11_6;
    private javax.swing.JButton button_11_7;
    private javax.swing.JButton button_11_8;
    private javax.swing.JButton button_11_9;
    private javax.swing.JButton button_12_1;
    private javax.swing.JButton button_12_10;
    private javax.swing.JButton button_12_11;
    private javax.swing.JButton button_12_12;
    private javax.swing.JButton button_12_13;
    private javax.swing.JButton button_12_14;
    private javax.swing.JButton button_12_15;
    private javax.swing.JButton button_12_2;
    private javax.swing.JButton button_12_3;
    private javax.swing.JButton button_12_4;
    private javax.swing.JButton button_12_5;
    private javax.swing.JButton button_12_6;
    private javax.swing.JButton button_12_7;
    private javax.swing.JButton button_12_8;
    private javax.swing.JButton button_12_9;
    private javax.swing.JButton button_13_1;
    private javax.swing.JButton button_13_10;
    private javax.swing.JButton button_13_11;
    private javax.swing.JButton button_13_12;
    private javax.swing.JButton button_13_13;
    private javax.swing.JButton button_13_14;
    private javax.swing.JButton button_13_15;
    private javax.swing.JButton button_13_2;
    private javax.swing.JButton button_13_3;
    private javax.swing.JButton button_13_4;
    private javax.swing.JButton button_13_5;
    private javax.swing.JButton button_13_6;
    private javax.swing.JButton button_13_7;
    private javax.swing.JButton button_13_8;
    private javax.swing.JButton button_13_9;
    private javax.swing.JButton button_14_1;
    private javax.swing.JButton button_14_10;
    private javax.swing.JButton button_14_11;
    private javax.swing.JButton button_14_12;
    private javax.swing.JButton button_14_13;
    private javax.swing.JButton button_14_14;
    private javax.swing.JButton button_14_15;
    private javax.swing.JButton button_14_2;
    private javax.swing.JButton button_14_3;
    private javax.swing.JButton button_14_4;
    private javax.swing.JButton button_14_5;
    private javax.swing.JButton button_14_6;
    private javax.swing.JButton button_14_7;
    private javax.swing.JButton button_14_8;
    private javax.swing.JButton button_14_9;
    private javax.swing.JButton button_15_1;
    private javax.swing.JButton button_15_10;
    private javax.swing.JButton button_15_11;
    private javax.swing.JButton button_15_12;
    private javax.swing.JButton button_15_13;
    private javax.swing.JButton button_15_14;
    private javax.swing.JButton button_15_15;
    private javax.swing.JButton button_15_2;
    private javax.swing.JButton button_15_3;
    private javax.swing.JButton button_15_4;
    private javax.swing.JButton button_15_5;
    private javax.swing.JButton button_15_6;
    private javax.swing.JButton button_15_7;
    private javax.swing.JButton button_15_8;
    private javax.swing.JButton button_15_9;
    private javax.swing.JButton button_1_1;
    private javax.swing.JButton button_1_10;
    private javax.swing.JButton button_1_11;
    private javax.swing.JButton button_1_12;
    private javax.swing.JButton button_1_13;
    private javax.swing.JButton button_1_14;
    private javax.swing.JButton button_1_15;
    private javax.swing.JButton button_1_2;
    private javax.swing.JButton button_1_3;
    private javax.swing.JButton button_1_4;
    private javax.swing.JButton button_1_5;
    private javax.swing.JButton button_1_6;
    private javax.swing.JButton button_1_7;
    private javax.swing.JButton button_1_8;
    private javax.swing.JButton button_1_9;
    private javax.swing.JButton button_2_1;
    private javax.swing.JButton button_2_10;
    private javax.swing.JButton button_2_11;
    private javax.swing.JButton button_2_12;
    private javax.swing.JButton button_2_13;
    private javax.swing.JButton button_2_14;
    private javax.swing.JButton button_2_15;
    private javax.swing.JButton button_2_2;
    private javax.swing.JButton button_2_3;
    private javax.swing.JButton button_2_4;
    private javax.swing.JButton button_2_5;
    private javax.swing.JButton button_2_6;
    private javax.swing.JButton button_2_7;
    private javax.swing.JButton button_2_8;
    private javax.swing.JButton button_2_9;
    private javax.swing.JButton button_3_1;
    private javax.swing.JButton button_3_10;
    private javax.swing.JButton button_3_11;
    private javax.swing.JButton button_3_12;
    private javax.swing.JButton button_3_13;
    private javax.swing.JButton button_3_14;
    private javax.swing.JButton button_3_15;
    private javax.swing.JButton button_3_2;
    private javax.swing.JButton button_3_3;
    private javax.swing.JButton button_3_4;
    private javax.swing.JButton button_3_5;
    private javax.swing.JButton button_3_6;
    private javax.swing.JButton button_3_7;
    private javax.swing.JButton button_3_8;
    private javax.swing.JButton button_3_9;
    private javax.swing.JButton button_4_1;
    private javax.swing.JButton button_4_10;
    private javax.swing.JButton button_4_11;
    private javax.swing.JButton button_4_12;
    private javax.swing.JButton button_4_13;
    private javax.swing.JButton button_4_14;
    private javax.swing.JButton button_4_15;
    private javax.swing.JButton button_4_2;
    private javax.swing.JButton button_4_3;
    private javax.swing.JButton button_4_4;
    private javax.swing.JButton button_4_5;
    private javax.swing.JButton button_4_6;
    private javax.swing.JButton button_4_7;
    private javax.swing.JButton button_4_8;
    private javax.swing.JButton button_4_9;
    private javax.swing.JButton button_5_1;
    private javax.swing.JButton button_5_10;
    private javax.swing.JButton button_5_11;
    private javax.swing.JButton button_5_12;
    private javax.swing.JButton button_5_13;
    private javax.swing.JButton button_5_14;
    private javax.swing.JButton button_5_15;
    private javax.swing.JButton button_5_2;
    private javax.swing.JButton button_5_3;
    private javax.swing.JButton button_5_4;
    private javax.swing.JButton button_5_5;
    private javax.swing.JButton button_5_6;
    private javax.swing.JButton button_5_7;
    private javax.swing.JButton button_5_8;
    private javax.swing.JButton button_5_9;
    private javax.swing.JButton button_6_1;
    private javax.swing.JButton button_6_10;
    private javax.swing.JButton button_6_11;
    private javax.swing.JButton button_6_12;
    private javax.swing.JButton button_6_13;
    private javax.swing.JButton button_6_14;
    private javax.swing.JButton button_6_15;
    private javax.swing.JButton button_6_2;
    private javax.swing.JButton button_6_3;
    private javax.swing.JButton button_6_4;
    private javax.swing.JButton button_6_5;
    private javax.swing.JButton button_6_6;
    private javax.swing.JButton button_6_7;
    private javax.swing.JButton button_6_8;
    private javax.swing.JButton button_6_9;
    private javax.swing.JButton button_7_1;
    private javax.swing.JButton button_7_10;
    private javax.swing.JButton button_7_11;
    private javax.swing.JButton button_7_12;
    private javax.swing.JButton button_7_13;
    private javax.swing.JButton button_7_14;
    private javax.swing.JButton button_7_15;
    private javax.swing.JButton button_7_2;
    private javax.swing.JButton button_7_3;
    private javax.swing.JButton button_7_4;
    private javax.swing.JButton button_7_5;
    private javax.swing.JButton button_7_6;
    private javax.swing.JButton button_7_7;
    private javax.swing.JButton button_7_8;
    private javax.swing.JButton button_7_9;
    private javax.swing.JButton button_8_1;
    private javax.swing.JButton button_8_10;
    private javax.swing.JButton button_8_11;
    private javax.swing.JButton button_8_12;
    private javax.swing.JButton button_8_13;
    private javax.swing.JButton button_8_14;
    private javax.swing.JButton button_8_15;
    private javax.swing.JButton button_8_2;
    private javax.swing.JButton button_8_3;
    private javax.swing.JButton button_8_4;
    private javax.swing.JButton button_8_5;
    private javax.swing.JButton button_8_6;
    private javax.swing.JButton button_8_7;
    private javax.swing.JButton button_8_8;
    private javax.swing.JButton button_8_9;
    private javax.swing.JButton button_9_1;
    private javax.swing.JButton button_9_10;
    private javax.swing.JButton button_9_11;
    private javax.swing.JButton button_9_12;
    private javax.swing.JButton button_9_13;
    private javax.swing.JButton button_9_14;
    private javax.swing.JButton button_9_15;
    private javax.swing.JButton button_9_2;
    private javax.swing.JButton button_9_3;
    private javax.swing.JButton button_9_4;
    private javax.swing.JButton button_9_5;
    private javax.swing.JButton button_9_6;
    private javax.swing.JButton button_9_7;
    private javax.swing.JButton button_9_8;
    private javax.swing.JButton button_9_9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
