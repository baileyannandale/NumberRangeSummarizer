package com;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Bailey
 *
 */

public class NumberRangeSummarizerGen implements NumberRangeSummarizer {

    /**
    * Collect method which splits the string, and adds the elements to
    * a list.
    */
    public Collection<Integer> collect(String input) {
        String[] tokens = input.split(",");
        Collection<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            list.add(Integer.parseInt(tokens[i]));
        }
        return list;
    }

    /**
    * Summarize method which takes the list and creates a summarized
    * string of the number ranges, and returns a reduced form of the
    * summarized number ranges.
    */
    public String summarizeCollection(Collection<Integer> input) {

        ArrayList<Integer> list = new ArrayList<>(input);
        int currentNumber = 0;
        int nextNumber = 0;
        String str = list.get(0).toString() + "";

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size()) {
                break;
            }
            currentNumber = list.get(i);
            nextNumber = list.get(i + 1);
            if (currentNumber + 1 == nextNumber) {
                str +=  "-" + list.get(i + 1);
            } else {
                str +=  "," + list.get(i + 1);
            }
        }

        return reduce(str);
    }

    /**
    * Reduce method which reduces the summarized number range.
    * i.e. 3-4-5 becomes 3-5.
    */
    private String reduce(String str) {
        String[] list = str.split(",");
        String finalList = "";

        for (int i = 0; i < list.length; i++) {
            String[] temp = list[i].split("-");
            if (temp.length > 1) {
                finalList += temp[0] + "-" + temp[temp.length - 1] + ",";
            } else {
                finalList += temp[0] + ",";
            }
        }
        finalList = finalList.substring(0, finalList.length() - 1);
        return finalList;
    }
}
