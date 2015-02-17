import java.util.ArrayList;
import java.util.List;

public class JuiceSolver {

    private List<Subtask> subtasks = new ArrayList<>();

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }

    public void solveSubtasks(final List<Juice> juices) {
        List<Thread> threads = new ArrayList<>();
        for (final Subtask subtask : subtasks) {
            threads.add( new Thread() {
                public void run() {
                    subtask.solveSubtask(juices);
//                    if (subtask.fileName.equals("juice1.out")) {
//                        try {
//                            sleep(4000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                    System.err.println(subtask.fileName + " is written!");
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Something went wrong while joining threads!");
            }
        }
    }

}
