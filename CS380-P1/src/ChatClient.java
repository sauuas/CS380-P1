/**
 * Derek Sauri project 1
 * Chat Client
 */
import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",38001)){
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String stIn = "";
            String stOut;

            //first pass in case name is in use
            stOut = br.readLine();
            dataOut.writeUTF(stOut);
            stIn = dataIn.readUTF();
            System.out.println(stIn);
            if(!(stIn.equals("Name in use"))){
                //loops until exit
                while(!(stIn.equals("exit"))){
                    stOut = br.readLine();
                    dataOut.writeUTF(stOut);
                    stIn = dataIn.readUTF();
                    System.out.println(stIn);
                }
            }
        }catch(Exception e){

        }
    }
}
