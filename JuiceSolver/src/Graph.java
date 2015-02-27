import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    private int numberOfVerteces;
    private List< List<Integer> > adjacencyLists;
    private int[] takenBy;
    private int[] whichIsTaken;
    private boolean[] isUsed;

    public Graph(int numberOfVerteces) {
        this.numberOfVerteces = numberOfVerteces;
        this.adjacencyLists = new ArrayList<>();

        for (int i = 0; i < numberOfVerteces; i++) {
            this.adjacencyLists.add(new ArrayList<Integer>());
        }

        takenBy = new int[numberOfVerteces];
        whichIsTaken = new int[numberOfVerteces];
        isUsed = new boolean[numberOfVerteces];
    }

    public void addArc(int u, int v) {
        adjacencyLists.get(u).add(v);
    }

    public List< List<Integer> > minimalPathCover() {
        kuhnAlgorithm();
        List< List<Integer> > paths = new ArrayList<>();
        for (int v = 0; v < numberOfVerteces; v++) {
            if (takenBy[v] == -1) {
                List<Integer> path = new ArrayList<>();
                int u = v;
                do {
                    path.add(u);
                    u = whichIsTaken[u];
                } while (u != -1);
                paths.add(path);
            }
        }
        return paths;
    }

    private boolean dfs(int v) {
        if (v == -1) {
            return true;
        }
        if (isUsed[v]) {
            return false;
        }
        isUsed[v] = true;
        for (int u : adjacencyLists.get(v)) {
            if (dfs(takenBy[u])) {
                whichIsTaken[v] = u;
                takenBy[u] = v;
                return true;
            }
        }
        return false;
    }

    private void kuhnAlgorithm() {
        Arrays.fill(takenBy, -1);
        Arrays.fill(whichIsTaken, -1);
        for (int v = 0; v < numberOfVerteces; v++) {
            Arrays.fill(isUsed, false);
            dfs(v);
        }
    }

}
