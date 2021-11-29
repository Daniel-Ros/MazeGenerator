import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Ex3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        int n = 150;
        int m = 150;
        Graph g =  new Graph(n,m);

        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setTitle("Maze generator - Daniel Rosenberg");
        frame.add(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Edge> edges = getRandomizedEdgeList(n,m);

        for (Edge e: edges) {
            int g1 = g.find(e.g1);
            int g2 = g.find(e.g2);
            if(g1 != g2){
                g.union(g1,g2);
                g.addEdge(e);
                frame.repaint();
                try {
                    Thread.sleep(1);
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        }
    }

    static private ArrayList<Edge> getRandomizedEdgeList(int m,int n){
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j != n-1)
                    edges.add(new Edge(i*m + j,i*m + j + 1));
                if(i != m-1)
                    edges.add(new Edge(i*m + j,(i+1)*m + j));
            }
        }

        Collections.shuffle(edges);
        return edges;
    }
}

