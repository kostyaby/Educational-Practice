import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IOUtils {

    public static List<Juice> inputData(String fileName)  {
        try (Scanner in = new Scanner(new File(fileName))) {
            List<Juice> juices = new ArrayList<>();
            StringTokenizer buffer;

            while (in.hasNextLine()) {
                buffer = new StringTokenizer(in.nextLine());
                Juice juice = new Juice();
                while (buffer.hasMoreTokens()) {
                    String component = buffer.nextToken();
                    juice.addComponent(component);
                }
                juices.add(juice);
            }

            return juices;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("There's no input file and "
                    + "the program is unable to continue running without it!");
        }
    }

    public static void printList(List list, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(new File(fileName))) {
            for (Object object : list) {
                printWriter.println(object);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("A fact, that there's no file to write in doesn't seem "
                    + "unusual to me, though Java throws an exception for some reason.");
        }
    }

    public static void printInteger(Integer integer, String fileName) {
        List<Integer> buffer = new ArrayList<>();
        buffer.add(integer);
        printList(buffer, fileName);
    }

}
