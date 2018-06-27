import java.util.Comparator;
import java.util.Map;

public class XMLElementsPrinter {
    private Map<String, Integer> nodeNameToOccurrencesNumber;

    public XMLElementsPrinter(Map<String, Integer> nodeNameToOccurrencesNumber) {
        this.nodeNameToOccurrencesNumber = nodeNameToOccurrencesNumber;
    }

    public void print() {
        System.out.println("\n\n----XML elements across occurrences table----\n");
        int amountOfCharactersInTheLongestKey = nodeNameToOccurrencesNumber.keySet().stream().max(Comparator.comparingInt(String::length)).get().length();
        nodeNameToOccurrencesNumber.forEach((k, v) -> System.out.printf("%-" + amountOfCharactersInTheLongestKey + "s element occurred %-3s times \n", k, v));
    }
}
