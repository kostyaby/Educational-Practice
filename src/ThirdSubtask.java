import java.util.List;

public class ThirdSubtask extends Subtask {

    ThirdSubtask(String fileName) {
        super(fileName);
    }

    @Override
    public void solveSubtask(List<Juice> juices) {
        List<Juice> uniqueJuices = Juice.getUniqueJuices(juices);
        Graph graph = new Graph(uniqueJuices.size());
        for (int i = 0; i < uniqueJuices.size(); i++) {
            for (int j = 0; j < uniqueJuices.size(); j++) {
                if (i != j && uniqueJuices.get(i).isSubsetOf(uniqueJuices.get(j))) {
                    graph.addArc(i, j);
                }
            }
        }
        List< List<Integer> > paths = graph.minimalPathCover();
        IOUtils.printInteger(paths.size(), fileName);
    }
}
