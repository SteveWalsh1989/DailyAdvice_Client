import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  Head First Java - Networking and threads
 *
 * Basic advice client
 *
 * Will check for message from server to display message
 */

public class DailyAdviceClient {

    /**
     *  Go
     *
     * Initiates connection to server on port 5000
     *
     * Receives Message from server and displays to console
     *
     */
    public void go(){

        try {

            // Creates new socket on local host at port number 5000

            Socket s = new Socket("127.0.0.1", 5000);

            // creates new streamReader to get information from socket
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());

            // chain buffered reader to streamReader from the socket
            BufferedReader reader = new BufferedReader(streamReader);

            // stores message from server
            String advice = reader.readLine();

            // print message to console
            System.out.println("Today you should " + advice);

            // close all streams
            reader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
