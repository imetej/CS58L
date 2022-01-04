import java.util.Scanner;
 
public class BellmanFord
{
    private int distances[];
    private int numberOfVertices;
    public static final int INFINITY = 9999;
 
    public BellmanFord(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        distances = new int[numberOfVertices + 1];
    }
 
    public void BellmanFordEvaluation(int source, int adjacencyMatrix[][])
    {
        for(int node = 1; node <= numberOfVertices; node++)
        {
            distances[node] = INFINITY;
        }
        distances[source] = 0;

        for(int node = 1 ; node <= numberOfVertices - 1 ; node++) // (number of vertices - 1) times
        {
            for(int start = 1 ; start <= numberOfVertices ; start++)
            {
                for(int end = 1 ; end <= numberOfVertices ; end++)
                {
                    if(adjacencyMatrix[start][end] != INFINITY)
                    {
                        if(distances[start] + adjacencyMatrix[start][end] < distances[end])
                            distances[end] = distances[start] + adjacencyMatrix[start][end];
                    }
                }
            }
        }
 
        for(int start = 1 ; start <= numberOfVertices ; start++)
        {
            for(int end = 1 ; end <= numberOfVertices ; end++)
            {
                if(adjacencyMatrix[start][end] != INFINITY)
                {
                    if(distances[start] + adjacencyMatrix[start][end] < distances[end])
                        System.out.println("\nThe Graph contains negative edge cycle\n");
                }
            }
        }
 
        for(int vertex = 1 ; vertex <= numberOfVertices ; vertex++)
        {
            System.out.println("Distance from source " + source + " to vertex " + vertex + " is " + distances[vertex]);
        }
    }
 
    public static void main(String [] args)
    {
        int numberOfVertices = 0;
        int source;
        Scanner key = new Scanner(System.in);
 
        System.out.print("Enter the number of vertices : ");
        numberOfVertices = key.nextInt();
 
        int adjacencyMatrix[][] = new int[numberOfVertices + 1][numberOfVertices + 1];
        System.out.println("Enter the adjacency matrix :");
        for(int start = 1 ; start <= numberOfVertices ; start++)
        {
            for(int end = 1 ; end <= numberOfVertices ; end++)
            {
                adjacencyMatrix[start][end] = key.nextInt();
 	            if(start == end)
                {
                    adjacencyMatrix[start][end] = 0;
                    continue;
                }
                if(adjacencyMatrix[start][end] == 0)
                {
                    adjacencyMatrix[start][end] = INFINITY;
                }
            }
        }
 
        System.out.print("Enter the source vertex : ");
        source = key.nextInt();
 
        BellmanFord bellmanford = new BellmanFord(numberOfVertices);
        bellmanford.BellmanFordEvaluation(source, adjacencyMatrix);
        key.close();	
    }
}

/*
5

1

0       6       7       0       0 
0       0       8       -4      5
0       0       0       9       -3
2       0       0       0       7
0       -2      0       0       0

0       2       7       -2      4
*/

/*
3

1

0       2       0
0       0       3
-7      0       0

-4      0       3
*/

/*
6

1

0       4       0       0       -1      0
0       0       -1      0       -2      0
0       0       0       0       0       0
0       0       0       0       0       0
0       0       0       -5      0       3
0       0       0       0       0       0

0       4       3       -6      -1      2
*/