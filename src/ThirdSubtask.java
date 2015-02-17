import java.util.ArrayList;
import java.util.List;

public class ThirdSubtask extends Subtask {

    ThirdSubtask(String fileName) {
        super(fileName);
    }

    @Override
    public void solveSubtask(List<Juice> juices) {
        List<Juice> uniqueJuices = Juice.getUniqueJuices(juices);
        List< List<Integer> > graph = new ArrayList<>();
        for (int i = 0; i < uniqueJuices.size(); i++) {
            graph.add(new ArrayList<Integer>());
            for (int j = 0; j < uniqueJuices.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (uniqueJuices.get(i).isSubsetOf(uniqueJuices.get(j))) {
                    graph.get(i).add(j);
                }
            }
        }
        List< List<Integer> > paths = new Graph(graph).minimalPathCover();
        IOUtils.printInteger(paths.size(), fileName);
    }
}
