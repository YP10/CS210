/*
 * Copyright 2023 Marc Liberatore.
 */

package comparators;

import java.util.Comparator;

/**
 * A comparator to determine which of two WebPageRecords represents a longer web
 * page. The page with the larger `length` attribute is comes before the other.
 * If there is a tie, break it using the length of the first line -- again,
 * larger comes first. If there is still a tie, break it by comparing which URL
 * comes lexicographically first. Any remaining ties mean the two WebPageRecords
 * should be considered equal.
 */
public class LargestPageComparator implements Comparator<WebPageRecord> {
    @Override
    public int compare(WebPageRecord x, WebPageRecord y) {
        int compLength=Integer.compare(y.length,x.length);
        if(compLength==0){
            int compFirstLine=Integer.compare(y.firstLine.length(),x.firstLine.length());
            if(compFirstLine==0){
                return x.URL.compareTo(y.URL);
            }
            return compFirstLine;
        }
        return compLength;
        // PART 3 Comparators
        // TASK: Implement the compare method to compare two WebPageRecord
        // objects. First, compare their lengths, then compare the lengths of
        // their first lines, and finally compare their URLs as a tiebreaker.
        // Ensure the comparisons follow the specified priority order.
    }
}