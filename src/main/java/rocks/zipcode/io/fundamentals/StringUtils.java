package rocks.zipcode.io.fundamentals;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        int[] range = new int[string.length()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }

        List<List<Integer>> powerSetOfRange = getPowerSetOfIntArray(range);

        List<String> allCasingsList = new ArrayList<>(powerSetOfRange.size());

        for (List<Integer> subset : powerSetOfRange) {
            allCasingsList.add(upperCaseIndices(string, subset.toArray(new Integer[0])));
        }

        return allCasingsList;
    }

    static List<List<Integer>> getPowerSetOfIntArray(int[] set) {
        int setSize = set.length;
        int powSetSize = (int) Math.pow(2, setSize);
        List<List<Integer>> powerSet = new ArrayList<>(powSetSize);
        int counter, index;
        List<Integer> subSet;
        for (counter = 0; counter < powSetSize; counter++) {
            subSet = new ArrayList<>(setSize);
            for (index = 0; index < setSize; index++) {
                // Check if the bit at specified index in the counter is set. If set then add the element at that index in the set to the subSet
                if ((counter & (1 << index)) > 0) {
                    subSet.add(set[index]);
                }
            }
            powerSet.add(subSet);
        }
        return powerSet;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (Integer index : indices) {
            stringBuilder.setCharAt(index, Character.toUpperCase(stringBuilder.charAt(index)));
        }
        return stringBuilder.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {
        return new StringBuilder(stringToBeManipulated).insert(index, valueToBeInserted).toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {
        return stringToBeManipulated.substring(0, index) + replacementValue + stringToBeManipulated.substring(index + 1);
    }
}