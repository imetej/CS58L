import java.util.Scanner;

public class Crc
{
    public static int k;

    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        Crc ob = new Crc();
        String code, copy, received, remainder, zero = "0000000000000000"; // n - k = 17 - 1 = 16 => 16-bits

        System.out.print("Enter message : ");
        code = key.nextLine();

        k = code.length();
        copy = code;
        code += zero; // codeword = dataword + zero , n = k + 16
        code = ob.divide(code);
        System.out.println("Message = " + copy);
        copy = copy.substring(0,k) + code.substring(k); // append check-bits to dataword to get codeword
        System.out.print("CRC = ");
        System.out.println(code.substring(k));
        System.out.println("transmitted frame is " + copy);

        System.out.print("Enter received data : ");
        received = key.nextLine();

        remainder = ob.divide(received).substring(k);

        if(zero.equals(remainder)) // last 16 bits must be zero --> syndrome-bits
            System.out.println("No Error");

        else
        {
            System.out.println("Error");
            String rem[] = remainder.split("");
            for(int i = 0 ; i < 16 ; i++)
            {
                if(Integer.parseInt(rem[i]) == 1)
                {
                    System.out.println("--> At Position " + (k+i+1));
                }

            }
        }  

        key.close();
    }

    public String divide(String s)
    {
        char x;
        String divisor = "10001000000100001"; // length = 17 => n - k + 1 = k + 16 - k + 1 = 16 + 1
        for(int i = 0 ; i < k ; i++)
        {
            x = s.charAt(i);
            for(int j = 0 ; j < 17 ; j++)
            {
                if(x == '1') // if(x == '0') => divisor is 00000000000000000
                {
                    if(s.charAt(i+j) != divisor.charAt(j))
                        s = s.substring(0,i+j) + "1" + s.substring(i+j+1); // 0 + 1 = 1 , 1 + 0 = 1

                    else
                        s = s.substring(0,i+j) + "0" + s.substring(i+j+1); // 0 + 0 = 0 , 1 + 1 = 0
                        
                }                                         
            }
        }
        return s;
    }
}