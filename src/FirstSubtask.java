import java.util.List;

public class FirstSubtask extends Subtask {

    FirstSubtask(String fileName) {
        super(fileName);
    }

    @Override
    public void solveSubtask(List<Juice> juices) {
        IOUtils.printList(Juice.getAllComponents(juices), fileName);
    }
}
