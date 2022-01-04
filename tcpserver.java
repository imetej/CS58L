import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class tcpserver
{
    public static void main(String [] args)
    {
        try
        {
            ServerSocket s = new ServerSocket(1500);
            System.out.println("Server Ready\nwaiting for connection .....");

            Socket s1 = s.accept();
            DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
            DataInputStream dis= new DataInputStream(s1.getInputStream());

            System.out.println(dis.readUTF());
            String path= dis.readUTF();

            System.out.println("Request Recieved");

            try
            {
                File myFile = new File(path);
                Scanner key = new Scanner(myFile);

                String st = key.nextLine();
                st = "The contents of the file is\n" + st;

                while(key.hasNextLine())
                {
                    st = st + "\n" + key.nextLine();
                }

                dos.writeUTF(st);

                dos.close();
                s1.close();
                s.close();
                key.close();
            }

            catch(FileNotFoundException e)
            {
                System.out.println("ERROR! FILE NOT FOUND");
                dos.writeUTF("ERROR! FILE NOT FOUND");
            }
        }

        catch(IOException e)
        {
            System.out.println("IO : " + e.getMessage());
        }

        finally
        {
            System.out.println("Connection Terminated");
        }
    }
}