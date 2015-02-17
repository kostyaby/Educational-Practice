import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondSubtask extends Subtask {

    SecondSubtask(String fileName) {
        super(fileName);
    }

    @Override
    public void solveSubtask(List<Juice> juices) {
        final List<String> allComponents = Juice.getAllComponents(juices);
        Thread sortThread = new Thread() {
            public void run() {
                Collections.sort(allComponents, new Comparator<String>() {
                    @Override public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });

            }
        };
        sortThread.start();
        try {
            sortThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problems while joining sortThread!");
        }

        IOUtils.printList(allComponents, fileName);
    }

}
