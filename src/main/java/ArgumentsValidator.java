import org.apache.commons.lang3.StringUtils;

public class ArgumentsValidator {

    public boolean isValid(String[] args) {
        return StringUtils.isNotBlank(args[0]) && StringUtils.isNotBlank(args[1]);
    }
}
