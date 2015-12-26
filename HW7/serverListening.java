import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by yue on 3/22/2015.
 */
public class serverListening implements Runnable {
    private ServerSocket s;
    private ArrayList<Socket> incoming;
    private int ipPort;
    private ChatFrame cf;

    public serverListening(int ipPort, ArrayList<Socket> incoming, ChatFrame cf){
        this.ipPort = ipPort;
        this.incoming = incoming;
        this.cf = cf;
    }

    @Override
    public void run() {
        // listening requires from client all the time
        try{
            s = new ServerSocket(ipPort);
        }
        catch(IOException e) {}

        while(!cf.closeServer){
            try{
                Socket server = s.accept();
                incoming.add(server);
                Runnable r = new ServerIO(server, cf.serverStatus, cf);
                Thread t = new Thread(r);
                t.start();
                cf.serverStatus++;
            }
            catch(IOException e) {}
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
