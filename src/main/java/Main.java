public class Main {

    public static void main(String[] args) {
        if (!new ArgumentsValidator().isValid(args)) {
            throw new IllegalArgumentException("Please, specify 2 file paths! First has to lead to an xml file, and the second one to an xsd file...");
        }

        final String xmlFile = args[0];
        final String schemaFile = args[1];

        printValidation(xmlFile, schemaFile);
        printOccurrences(xmlFile);
    }

    private static void printOccurrences(String xmlFile) {
        XMLElementsCounter elementsCounter = new XMLElementsCounter();
        elementsCounter.count(xmlFile);
        new XMLElementsPrinter(elementsCounter.getNodeNameToOccurrencesNumber()).print();
    }

    private static void printValidation(String xmlFile, String schemaFile) {
        new XMLValidatorPrinter().print(new XMLValidator().isValid(xmlFile, schemaFile));
    }
}
