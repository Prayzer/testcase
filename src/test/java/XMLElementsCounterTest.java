import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class XMLElementsCounterTest {
    private XMLElementsCounter counter = new XMLElementsCounter();
    private Map<String, Integer> referenceElementsOccurrences = new LinkedHashMap<>();

    @Before
    public void init() {
        referenceElementsOccurrences.put("root", 1);
        referenceElementsOccurrences.put("records", 1);
        referenceElementsOccurrences.put("record", 2);
        referenceElementsOccurrences.put("jobTitle", 2);
        referenceElementsOccurrences.put("name", 2);
        referenceElementsOccurrences.put("surname", 2);
        referenceElementsOccurrences.put("year", 1);
    }

    @Test
    public void countTest() {
        counter.count(getPath("xml/valid_records.xml"));
        Map<String, Integer> actualElements = counter.getNodeNameToOccurrencesNumber();
        assertTrue(isEquals(actualElements, referenceElementsOccurrences));
    }

    private static boolean isEquals(Map<String, Integer> left, Map<String, Integer> right) {
        Iterator<Map.Entry<String, Integer>> leftItr = left.entrySet().iterator();
        Iterator<Map.Entry<String, Integer>> rightItr = right.entrySet().iterator();

        while (leftItr.hasNext() && rightItr.hasNext()) {
            Map.Entry<String, Integer> leftEntry = leftItr.next();
            Map.Entry<String, Integer> rightEntry = rightItr.next();

            if (!leftEntry.equals(rightEntry))
                return false;
        }
        return true;
    }

    private String getPath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
    }
}
