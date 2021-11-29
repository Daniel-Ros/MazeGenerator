import javax.swing.JPanel;
import java.awt.*;

public class Graph extends JPanel{
    Node [][] nodes;

    public Graph(int n,int m) {
        nodes = new Node[n][m];
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node(i*m + j);
                System.out.println(i*m + j);
            }
        }

        Edge e = new Edge(n*m-1 ,n*m);
        addEdge(e);
    }

    public void paint(Graphics g){
        int h =this.getHeight();
        int sizey = this.getHeight() / (nodes.length + 2);
        int sizex = this.getWidth() / (nodes[0].length + 2);
        int offsetx = sizex;
        int offsety = sizey;
        g.drawLine(0 + offsetx,0 + offsety,(nodes.length) * sizex + offsetx,0+ offsety);
        g.drawLine(0 + offsetx,sizey + offsety,0 + offsetx,(nodes.length)*sizey + offsety);
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                Node n = getNodeFromIndex(i*nodes.length + j);
                if(!n.hasEdge((i+1)*nodes.length + j))
                    g.drawLine(j * sizex + offsetx,(i +1)*sizey+ offsety,(j+1) * sizex+ offsetx,(i +1) *sizey+ offsety);
                if(!n.hasEdge(i*nodes.length + j+1))
                    g.drawLine((j+1) *sizex+ offsetx,i*sizey+ offsety,(j+1) * sizex+ offsetx,(i +1) *sizey+ offsety);
                //g.drawChars(String.valueOf(n.getId()).toCharArray(),0,String.valueOf(n.getId()).length(),j *sizex + offsetx+sizex/2,(i )*sizey+ offsety+sizey/2);
            }
        }
    }

    public void union(int g1 , int g2){
        Node n1 = getNodeFromIndex(find(g1));
        Node n2 = getNodeFromIndex(find(g2));

        if(n1.getRank() == n2.getRank()){
            n2.setGroup(n1.getId());
            n1.addRank();
        }else if(n1.getRank() < n2.getRank()){
            n1.setGroup(n2.getId());
        }else {
            n2.setGroup(n1.getId());
        }

    }

    public int find(int id){
        Node n  = getNodeFromIndex(id);
        if(n.getId() != n.getGroup()){
            int p = find(n.getGroup());
            n.setGroup(p);;
            return p;
        }else{
            return n.getId();
        }
    }

    public void addEdge(Edge e){
        Node n = getNodeFromIndex(e.g1);
        n.addEdge(e);
    }

    private Node getNodeFromIndex(int x){
        int i = x % nodes[0].length;
        int j = (x - i) / nodes.length;

        return nodes[j][i];
    }

}
