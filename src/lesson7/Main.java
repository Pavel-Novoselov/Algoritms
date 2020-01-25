package lesson7;

public class Main {
    public static void main(String[] args) {

        Graph g2 = new Graph(10);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(0,4);
        g2.addEdge(1,5);
        g2.addEdge(2,3);
        g2.addEdge(2,6);
        g2.addEdge(3,9);
        g2.addEdge(4,5);
        g2.addEdge(4,7);
     
        g2.addEdge(6,8);
        g2.addEdge(7,9);
        System.out.println("Перебор в ширину");
        g2.bfs();
        System.out.println();
        System.out.println("Поиск в ширину - от 0 до ...");
        g2.bfsSearch( 8);
        System.out.println();

    }

}
