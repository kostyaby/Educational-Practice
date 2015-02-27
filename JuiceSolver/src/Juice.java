import java.util.List;
import java.util.ArrayList;

public class Juice {

    private List<String> components = new ArrayList<>();

    public Juice() {}

    public Juice(Juice another) {
        components = new ArrayList<>(another.components);
    }

    public void addComponent(String String) {
        components.add(String);
    }

    public boolean containsComponent(String component) {
        return components.contains(component);
    }

    public boolean isSubsetOf(Juice another) {
        for (String component : components) {
            if (!another.containsComponent(component)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getAllComponents(List<Juice> juices) {
        List<String> allComponents = new ArrayList<>();
        for (Juice juice : juices) {
            for (String component : juice.components) {
                if (!allComponents.contains(component)) {
                    allComponents.add(component);
                }
            }
        }
        return allComponents;
    }

    public static List<Juice> getUniqueJuices(List<Juice> juices) {
        List<Juice> uniqueJuices = new ArrayList<>();
        for (Juice juice : juices) {
            if (!uniqueJuices.contains(juice)) {
                uniqueJuices.add(new Juice(juice));
            }
        }
        return uniqueJuices;
    }

    @Override
    public String toString() {
        StringBuilder resultingStringBuilder = new StringBuilder();
        for (String component : components) {
            resultingStringBuilder.append(component);
            resultingStringBuilder.append(' ');
        }
        return resultingStringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Juice another = (Juice) obj;
        return another.isSubsetOf(this) && this.isSubsetOf(another);
    }

}
