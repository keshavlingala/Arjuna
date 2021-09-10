import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class SimpleChemicalEquationParser {
    // Counts of elements on each side
    private Map<String, Integer> left;
    private Map<String, Integer> right;

    public SimpleChemicalEquationParser(String eqn) {
        this.left = new HashMap<>();
        this.right = new HashMap<>();
        parse(eqn);
    }

    public static void main(String[] args) {
        // Collect all command line arguments into one equation
        String eqn = "6H2O+6CO2=6O2+C6H12O6";
        SimpleChemicalEquationParser parser = new SimpleChemicalEquationParser(eqn);
        System.out.println(parser.isSimpleBalanced());
    }

    public boolean isBalanced() {
        return left.equals(right);
    }

    public boolean isSimpleBalanced() {
        return leftCount() == rightCount();
    }

    public int leftCount() {
        return left.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int rightCount() {
        return right.values().stream().mapToInt(Integer::intValue).sum();
    }

    private void parse(String eqn) {
        String[] sides = eqn.split("=");
        if (sides.length != 2) {
            throw new RuntimeException("Check your equation. There should be exactly one -> symbol somewhere");
        }
        parseSide(sides[0], this.left);
        parseSide(sides[1], this.right);
    }

    private void parseSide(String side, Map<String, Integer> counter) {
        String[] molecules = side.split("\\+");
        for (String molecule : molecules) {
            parseMolecule(molecule, counter);
        }
    }

    private void parseMolecule(String molecule, Map<String, Integer> counter) {
        molecule = molecule.trim();
        Matcher matcher = Pattern.compile("([a-zA-Z]+)\\s*([0-9]*)").matcher(molecule);
        int multiplier = 1;
        int endIndex = 0;
        while (matcher.find()) {
            String separator = molecule.substring(endIndex, matcher.start()).trim();
            if (!separator.isEmpty()) {
                // Check if there is a premultiplier before the first element
                if (endIndex == 0) {
                    String multiplierString = molecule.substring(0, matcher.start()).trim();
                    try {
                        multiplier = Integer.parseInt(multiplierString);
                    } catch (NumberFormatException nfe) {
                        throw new RuntimeException("Invalid prefix \"" + multiplierString +
                                "\" to molecule \"" + molecule.substring(matcher.start()) + "\"");
                    }
                } else {
                    throw new RuntimeException("Nonsensical characters \"" + separator +
                            "\" in molecule \"" + molecule + "\"");
                }
            }
            parseElement(multiplier, matcher.group(1), matcher.group(2), counter);
            endIndex = matcher.end();
        }
        if (endIndex != molecule.length()) {
            throw new RuntimeException("Invalid end to side: \"" + molecule.substring(endIndex) + "\"");
        }
    }

    private void parseElement(int multiplier, String element, String atoms, Map<String, Integer> counter) {
        if (!atoms.isEmpty())
            multiplier *= Integer.parseInt(atoms);
        if (counter.containsKey(element))
            multiplier += counter.get(element);
        counter.put(element, multiplier);
    }
}