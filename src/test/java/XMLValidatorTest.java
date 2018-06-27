import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class XMLValidatorTest {

    private static XMLValidator xmlValidator = new XMLValidator();

    @Test
    public void validateInvalidXMLTest() {
        Assert.assertFalse(xmlValidator.isValid(getPath("xml/invalid_records.xml"), getPath("records.xsd")));
    }

    @Test
    public void validateValidXMLTest() {
        Assert.assertTrue(xmlValidator.isValid(getPath("xml/valid_records.xml"), getPath("records.xsd")));
    }

    private String getPath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
    }
}