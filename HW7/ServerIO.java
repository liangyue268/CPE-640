import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * Created by yue on 3/22/2015.
 */
public class ServerIO implements Runnable {
    private Socket server;
    private int connectionNumber;
    private ChatFrame cf;

    public ServerIO(Socket server, int serverStatus, ChatFrame cf){
        this.server = server;
        this.connectionNumber = serverStatus;
        this.cf = cf;
    }

    @Override
    public void run() {
        try{
            InputStream inStream = server.getInputStream();
            OutputStream outStream = server.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream,true);

            boolean done = false;
            while(!done && in.hasNextLine()){
                String line = in.nextLine();
                cf.appendText("C" + connectionNumber + ": " + line + "\n");
                if(line.trim().equals("BYE"))
                    done = true;
            }
            cf.serverStatus--;
        }
        catch (IOException e) {}
    }
}
