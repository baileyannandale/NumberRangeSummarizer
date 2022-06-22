package com;

public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        NumberRangeSummarizer numberRangeSummarizergen = new NumberRangeSummarizerGen();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        System.out.println(numberRangeSummarizergen.summarizeCollection(numberRangeSummarizergen.collect(input)));
    }
}
