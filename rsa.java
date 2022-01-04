import java.util.Scanner;

public class rsa
{
    static int gcd(int m, int n)
    {
        while(n != 0)
        {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
    
    public static void main(String [] args)
    {
        int p = 0, q = 0, n = 0, e = 0, d = 0, z = 0, i = 0, j = 0;
        int ascii[] = new int[100];
        int encrypted[] = new int[100];
        int decrypted[] = new int[100];

        Scanner key = new Scanner(System.in);

        System.out.print("Enter the Message to be encrypted : ");
        String message = key.nextLine();

        System.out.println("\nEnter the value of P and Q : "); //large prime numbers
        p = key.nextInt();
        q = key.nextInt();

        n = p * q;
        z = (p - 1) * (q - 1);

        for(i = 2 ; i < z ; i++) //not the factor of phi
            if(gcd(i,z) == 1)
                break;

        e = i; //encryption key or public key

        for(i = 2 ; i < z ; i++)
            if((e*i-1) % z == 0) //d*e % phi == 1
                break;

        d = i; //decryption key or private key

        for(i = 0 ; i < message.length() ; i++)
        {
            char c = message.charAt(i);
            ascii[i] = c - 96; //a=1 b=2 c=3 d=4 e=5 f=6 g=7 h=8 i=9 ...
        }

        for(i = 0 ; i < message.length() ; i++)
        {
            encrypted[i] = 1;

            for(j = 0 ; j < e ; j++)
                encrypted[i] = (encrypted[i] * ascii[i]) % n; //CT = PT * E mod N
        }

        System.out.println("\nEncrypted Message : ");
        for(i = 0 ; i < message.length() ; i++)
        {
            System.out.print(encrypted[i]);
            System.out.print((char)(encrypted[i] + 96));
        }

        for(i = 0 ; i < message.length() ; i++)
        {
            decrypted[i] = 1;

            for(j = 0 ; j < d ; j++)
                decrypted[i] = (decrypted[i] * encrypted[i]) % n; //PT = CT * D mod N
        }

        System.out.println("\n\nDecrypted Message : ");
        for(i = 0 ; i < message.length() ; i++)
            System.out.print((char)(decrypted[i] + 96));

        key.close();
        return;
    }
}