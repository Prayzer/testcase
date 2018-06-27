import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArgumentsValidatorTest {
    private ArgumentsValidator argumentsValidator = new ArgumentsValidator();

    @Test
    public void isValidWithDoubleEmptyArgsTest() {
        String[] args = {"", ""};
        assertFalse(argumentsValidator.isValid(args));
    }

    @Test
    public void isValidWithOneEmptyArgTest() {
        String[] args = {"xml/invalid_records.xml", ""};
        assertFalse(argumentsValidator.isValid(args));
    }

    @Test
    public void isValidWithValidArgsTest() {
        String[] args = {"xml/invalid_records.xml", "records.xsd"};
        assertTrue(argumentsValidator.isValid(args));
    }

}
