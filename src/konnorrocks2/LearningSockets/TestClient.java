package konnorrocks2.LearningSockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by konnor on 8/11/14.
 */
public class TestClient
{
    static String username;
    static BufferedReader input;
    static PrintWriter out;
    static JTextArea messageArea;
    static JTextField sendMessageArea;
    static JButton sendButton;
    public TestClient()
    {
        JFrame frame = new JFrame();
        messageArea = new JTextArea();
        frame.setLayout(new GridLayout());
        frame.setTitle("Messenger");
        frame.setSize(700,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        messageArea.setEditable(false);
        sendMessageArea = new JTextField("");
        sendMessageArea.setEditable(true);
        sendMessageArea.setSize(100,100);
        sendMessageArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessageArea.setEditable(true);
                out.println(username + ":" + sendMessageArea.getText());
                sendMessageArea.setText("");
            }
        });
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessageArea.setEditable(true);
                out.println(username + ":" + sendMessageArea.getText());
                sendMessageArea.setText("");
            }
        });
        frame.add(messageArea);
        frame.add(sendMessageArea);
        frame.add(sendButton);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException
    {
        username = JOptionPane.showInputDialog("Enter a Username!!");
        new TestClient();
        while(true) {
            //connect to the server address entered
            Socket s = new Socket("konnorsservers.ddns.net", 3767);
            input =
                    new BufferedReader(new InputStreamReader(s.getInputStream()));
            out =
                    new PrintWriter(s.getOutputStream(), true);
            messageArea.setText(messageArea.getText() + input.readLine() + "\n");
        }
    }
}