import java.util.List;

public class JuiceSolverDemo {

    final private static String INPUT_FILE = "juice.in";
    final private static String FIRST_SUBTASK_OUTPUT_FILE = "juice1.out";
    final private static String SECOND_SUBTASK_OUTPUT_FILE = "juice2.out";
    final private static String THIRD_SUBTASK_OUTPUT_FILE = "juice3.out";

    public static void main(String[] args) {
        JuiceSolver juiceSolver = new JuiceSolver();
        final List<Juice> juices = IOUtils.inputData(INPUT_FILE);
        juiceSolver.addSubtask(new FirstSubtask(FIRST_SUBTASK_OUTPUT_FILE));
        juiceSolver.addSubtask(new SecondSubtask(SECOND_SUBTASK_OUTPUT_FILE));
        juiceSolver.addSubtask(new ThirdSubtask(THIRD_SUBTASK_OUTPUT_FILE));
        juiceSolver.solveSubtasks(juices);
        System.err.println("I'm printed right after all the subtasks were solved!");
    }

}
