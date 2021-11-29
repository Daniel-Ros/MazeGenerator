import java.util.ArrayList;

public class Node {
    private int id , group,rank;


    private ArrayList<Integer> edges;

    public Node(int id){
        this.id = id;
        this.group = id;
        this.rank = 0;

        edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getRank() {
        return rank;
    }

    public void addRank(){
        this.rank++;
    }

    public void addEdge(Edge e){
        edges.add(e.g2);
    }

    public boolean hasEdge(int e){
        return edges.contains(e);
    }

}
