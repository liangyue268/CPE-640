import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yue on 3/20/2015.
 */
public class Chat {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ChatFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ChatFrame extends JFrame {
    private ButtonGroup group;
    private JButton b1, b2;
    private JLabel l1;
    private JTextField t2, txtIp, textPort;
    private JTextArea t1;
    final int WIDTH = 640, HEIGHT = 480;
    private ServerSocket s;
    private Socket sc, incoming;
    private Scanner in;
    private PrintWriter out;

    ChatFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Simple TCP Chat Application");

        JPanel top1 = new JPanel();
        top1.setLayout(new GridLayout(1, 3));
        group = new ButtonGroup();
        final JRadioButton serverButton = new JRadioButton("Host the chat", true);
        final JRadioButton clientButton = new JRadioButton("Join the chat", false);
        group.add(serverButton);
        group.add(clientButton);
        serverButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (serverButton.isSelected()) {
                    try {
                        InetAddress address = InetAddress.getLocalHost();
                        txtIp.setText(address.getHostAddress());
                    } catch (IOException ex) {
                    }
                } else {
                    txtIp.setText("");
                }
            }
        });

        txtIp = new JTextField("127.0.0.1");
        top1.add(serverButton);
        top1.add(clientButton);
        top1.add(txtIp);

        JPanel top2 = new JPanel();
        top2.setLayout(new GridLayout(1, 4));
        textPort = new JTextField("8189");
        b1 = new JButton("Connect/Start");
        b2 = new JButton("Disconnect");
        b2.setEnabled(false);
        l1 = new JLabel("Status: Disconnected");
        top2.add(textPort);
        top2.add(b1);
        top2.add(b2);
        top2.add(l1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverButton.setEnabled(false);
                clientButton.setEnabled(false);
                b1.setEnabled(false);
                b2.setEnabled(true);
                if (serverButton.isSelected()) {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //InetAddress address = InetAddress.getLocalHost();
                                //txtIp.setText(address.getHostAddress());
                                //System.out.print(Integer.parseInt(textPort.getText()));

                                s = new ServerSocket(Integer.parseInt(textPort.getText()));
                                incoming = s.accept();
                                InputStream inStream = incoming.getInputStream();
                                OutputStream outStream = incoming.getOutputStream();

                                in = new Scanner(inStream);
                                out = new PrintWriter(outStream, true);
                                l1.setText("Status: Connected");
                                t1.append("Hello! Enter BYE to exit.\n");
                                boolean done = false;
                                while (!done && in.hasNextLine()) {
                                    String line = in.nextLine();
                                    t1.append("Client: " + line + '\n');
                                    if (line.trim().equals("BYE"))
                                        done = true;
                                }
                                l1.setText("Status: Disconnected");
                                closeServer();
                                b2.setEnabled(false);
                                b1.setEnabled(true);
                                serverButton.setEnabled(true);
                                clientButton.setEnabled(true);
                            } catch (IOException e) {
                            }
                        }
                    });
                    t.start();
                } else {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                sc = new Socket(txtIp.getText(), Integer.parseInt(textPort.getText()));
                                InputStream inStream = sc.getInputStream();
                                OutputStream outStream = sc.getOutputStream();

                                in = new Scanner(inStream);
                                out = new PrintWriter(outStream, true);
                                l1.setText("Status: Connected");
                                t1.append("Hello! Enter BYE to exit.\n");
                            }
                            catch (IOException ex) {}

                            boolean done = false;
                            while (!done && in.hasNextLine()) {
                                String line = in.nextLine();
                                t1.append("Server: " + line + "\n");
                                if (line.trim().equals("BYE"))
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
                if (serverButton.isSelected()) {
                    closeServer();
                } else {
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
                if (l1.getText() == "Status: Connected") {
                    if (serverButton.isSelected()) {
                        String line = t2.getText();
                        out.println(line);
                        t1.append("Server: " + line + "\n");
                        if (line.trim().equals("BYE"))
                            closeServer();
                    } else {
                        String line = t2.getText();
                        out.println(line);
                        t1.append("Client: " + line + "\n");
                        if (line.trim().equals("BYE"))
                            closeClient();
                    }
                }
                else{
                    t2.setText("cannot send text, please check connection!");
                }
            }
        });
        //JScrollPane down = new JScrollPane(t2);
        //JPanel down = new JPanel();
        //down.add(t2 = new JTextField());

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(t2, BorderLayout.SOUTH);
    }

    private void closeServer() {
        try {
            s.close();
            incoming.close();
        } catch (IOException e) {
        }
    }

    private void closeClient() {
        try {
            sc.close();
        } catch (IOException e) {
        }
    }
}