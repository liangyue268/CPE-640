import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yue on 3/20/2015.
 */
public class Chat {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame1 = new ChatFrame();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);

                JFrame frame2 = new ChatFrame();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setVisible(true);

                JFrame frame3 = new ChatFrame();
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setVisible(true);
            }
        });
    }
}

class ChatFrame extends JFrame {
    private ButtonGroup group;
    private JButton b1, b2;
    private JLabel l1;
    private JTextField t2, txtIp, TxtPort;
    private JTextArea t1;
    final int WIDTH = 640, HEIGHT = 480;
    public boolean closeServer;
    private Socket sc;
    private Scanner in;
    private PrintWriter out;
    private ArrayList<Socket> incoming = new ArrayList<Socket>();
    public int serverStatus = 0;

    ChatFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Simple TCP Chat Application");

        JPanel top1 = new JPanel();
        top1.setLayout(new GridLayout(1, 3));
        group = new ButtonGroup();
        final JRadioButton serverButton = new JRadioButton("Host the chat", true);
        final JRadioButton clientButton = new JRadioButton("Join the chat", false);
        group.add(serverButton); group.add(clientButton);
        serverButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(serverButton.isSelected()){
                    try{
                        InetAddress address = InetAddress.getLocalHost();
                        txtIp.setText(address.getHostAddress());
                        l1.setText("Status: " + serverStatus);
                    }
                    catch(IOException ex) {}
                }
                else{
                    txtIp.setText("");
                    l1.setText("Status: Disconnected");
                }
            }
        });

        txtIp = new JTextField();
        top1.add(serverButton);
        top1.add(clientButton);
        top1.add(txtIp);

        JPanel top2 = new JPanel();
        top2.setLayout(new GridLayout(1,4));
        TxtPort = new JTextField("8189");
        b1 = new JButton("Connect/Start");
        b2 = new JButton("Disconnect");
        b2.setEnabled(false);
        l1 = new JLabel("Status: " + serverStatus);
        top2.add(TxtPort);
        top2.add(b1);
        top2.add(b2);
        top2.add(l1);
        final ChatFrame cf = this;
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverButton.setEnabled(false);
                clientButton.setEnabled(false);
                b1.setEnabled(false);
                b2.setEnabled(true);
                if(serverButton.isSelected()){
                    Runnable r = new serverListening(Integer.parseInt(TxtPort.getText()), incoming, cf);
                    Thread tt = new Thread(r);
                    tt.start();

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while(true){
                                cf.labelText("Status: " + cf.serverStatus);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    });
                    t.start();
                }
                else{
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                sc = new Socket(txtIp.getText(), Integer.parseInt(TxtPort.getText()));
                                InputStream inStream = sc.getInputStream();
                                OutputStream outStream = sc.getOutputStream();

                                in = new Scanner(inStream);
                                out = new PrintWriter(outStream, true);
                                l1.setText("Status: Connected");
                                t1.append("Hello! Enter BYE to exit.\n");
                            }
                            catch (IOException ex) {}

                            boolean done = false;
                            while(!done && in.hasNextLine()){
                                String line = in.nextLine();
                                t1.append("Server: " + line + "\n");
                                if(line.trim().equals("BYE"))
                                    done = true;
                            }
                            l1.setText("Status: Disconnected");
                            closeClient();
                            b2.setEnabled(false);
                            b1.setEnabled(true);
                            serverButton.setEnabled(true);
                            clientButton.setEnabled(true);
                        }
                    });
                    t.start();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(serverButton.isSelected()){
                    closeServer();
                }
                else {
                    closeClient();
                }
            }
        });

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(2, 1));
        top.add(top1);
        top.add(top2);

        t1 = new JTextArea(8, 50);
        t1.setLineWrap(true);
        t1.setEditable(false);
        JScrollPane center = new JScrollPane(t1);


        t2 = new JTextField();
        t2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(serverButton.isSelected()) {
                    if (l1.getText() != "Status: 0") {
                        //out.println(t2.getText());
                        for (Socket s : incoming) {
                            try {
                                InputStream inStream = s.getInputStream();
                                OutputStream outStream = s.getOutputStream();
                                Scanner in = new Scanner(inStream);
                                PrintWriter out = new PrintWriter(outStream, true);

                                out.println(t2.getText());
                            }
                            catch (IOException ex) {}
                        }
                        t1.append("Server: " + t2.getText() + "\n");
                    }
                }
                else{
                    if(l1.getText() != "Status: Disconnected"){
                        out.println(t2.getText());
                        t1.append("Client: " + t2.getText() + "\n");
                    }
                }
            }
        });

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(t2, BorderLayout.SOUTH);
    }

    private void closeServer() {
        closeServer = true;
    }

    private void closeClient() {
        try{
            sc.close();
        }
        catch(IOException e) {}
    }

    public void appendText(String text){
        t1.append(text);
    }

    public void labelText(String text){
        l1.setText(text);
    }
}