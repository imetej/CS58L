import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class udpclient
{
      public static void main(String [] args)
      {
            DatagramSocket aSocket = null;
            int clientPort = 998;

            try
            {
                  aSocket = new DatagramSocket(clientPort);
                  byte [] buf = new byte[1000];
                  byte [] buf1 = new byte[1000];

                  DatagramPacket data = new DatagramPacket(buf,buf.length);
                  String conf = "connected to client";
                  buf1 = conf.getBytes();

                  DatagramPacket data1 = new DatagramPacket(buf1,buf1.length,InetAddress.getLocalHost(),999);
                  aSocket.send(data1);
                  System.out.println("connected to server");
                  aSocket.receive(data);

                  byte [] msg = new byte[1000];
                  msg = data.getData();

                  System.out.println("\nmessage : ");
                  System.out.println(new String(msg,0,data.getLength()));
            }

            catch(SocketException e)
            {
                  System.out.println("Socket : " + e.getMessage());
            }
            catch(IOException e)
            {
                  System.out.println("IO : " + e.getMessage());
            }

            finally
            {
                  if(aSocket != null)
                        aSocket.close();
            }
      }
}