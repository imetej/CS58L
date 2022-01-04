import java.util.Scanner;

public class Leaky
{
    public static void main(String [] args)
	{
        Scanner key = new Scanner(System.in);
        int bucket = 0, n, outputRate, bucketSize, i;

        System.out.print("\nEnter number of packets : ");
        n = key.nextInt();

		int packet[] = new int[n];

        System.out.print("\nEnter the output rate of the bucket : ");
        outputRate = key.nextInt();

        System.out.print("\nEnter the bucket size : ");
        bucketSize = key.nextInt();

        System.out.println("\nEnter the size of arriving packets :");
        for(i = 0 ; i < n ; i++)
		packet[i] = key.nextInt();

        System.out.println("\nSec\tPacket Size\tBucket Size\tStatus\t\tPacket Sent");
        System.out.println("----------------------------------------------------------------------");
        for(i = 0 ; i < n ; i++)
        {
            System.out.print(i+1 + "\t" + packet[i] + "\t");

            if(bucket + packet[i] <= bucketSize)
            {
                bucket += packet[i];
                System.out.println("\t" + bucket + "\t\tAccept\t" + "\t" + min(bucket, outputRate) + "\n");
                bucket = sub(bucket, outputRate);
            }

            else
            {
				System.out.println("\t" + bucket + "\t\tReject\t" + (bucket + packet[i] - bucketSize) + "\t" + min(bucketSize, outputRate) + "\n");
                bucket = bucketSize;
                bucket = sub(bucket, outputRate);
            }
        }

        while(bucket != 0)
        {
            System.out.print(++i + "\t 0 \t" + "\t" + bucket + "\t\tAccept\t" + "\t" + min(bucket, outputRate) + "\n");
            bucket = sub(bucket, outputRate);
        }

		key.close();
    }

    static int min(int a, int b)
	{
        return (a < b) ? a : b;
    }

    static int sub(int a, int b)
	{
        return ((a-b) > 0) ? (a - b) : 0;
    }
}

/*

4

7

8

5
7
8
3

Sec     Packet Size     Bucket Size     Status          Packet Sent
----------------------------------------------------------------------
1       5               5               Accept          5

2       7               7               Accept          7

3       8               8               Accept          7

4       3               4               Accept          4

*/