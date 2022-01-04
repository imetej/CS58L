import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class tcpclient
{
    public static void main(String [] args)
    {
        try
        {
            Scanner key = new Scanner(System.in);

            Socket s = new Socket("127.0.0.1",1500);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF("connected to 127.0.0.1\n");

            System.out.println("\nEnter the full path of file to be displayed : \n");
            String path = key.nextLine();

            dos.writeUTF(path);

            System.out.println(new String(dis.readUTF()));

            dis.close();
            dos.close();
            s.close();
            key.close();
        }

        catch(IOException e)
        {
            System.out.println("IO : " + e.getMessage());
        }
    }
}