package rocks.zipcode.io.collections;

import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class PowerSet<TypeOfSet> {
    protected final Set<TypeOfSet> originalSet;

    public PowerSet(TypeOfSet[] originalSet) {
        this.originalSet = new HashSet<>(Arrays.asList(originalSet));
    }

    /**
     * @return the powerset of `originalSet`
     */
    public Set<Set<TypeOfSet>> permute() {
        return getPowerSetOfArray((TypeOfSet[]) originalSet.toArray()); // turn set into an array because my powerset algorithm requires an indexed data structure
    }

    @SuppressWarnings("Duplicates")
    private Set<Set<TypeOfSet>> getPowerSetOfArray(TypeOfSet[] set) {
        int setSize = set.length;
        int powSetSize = (int) Math.pow(2, setSize);
        Set<Set<TypeOfSet>> powerSet = new HashSet<>(powSetSize);
        int counter, index;
        Set<TypeOfSet> subSet;
        for (counter = 0; counter < powSetSize; counter++) {
            subSet = new HashSet<>(setSize);
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
     * @return `originalSet`
     */
    public Set<TypeOfSet> getOriginalSet() {
        return originalSet;
    }
}
