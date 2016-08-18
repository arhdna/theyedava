package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shravan
 * http://www.programcreek.com/2012/12/leetcode-word-ladder/
 */
public class WordLadder1 {

    public static void main(String args[]) {
        String start = "cat";
        String end = "dog";
        List<Vertex> dictionary = new ArrayList<Vertex>();

        dictionary.add(new Vertex("cat"));
        dictionary.add(new Vertex("bat"));
        dictionary.add(new Vertex("cot"));
        dictionary.add(new Vertex("cog"));
        dictionary.add(new Vertex("cow"));
        dictionary.add(new Vertex("rat"));
        dictionary.add(new Vertex("but"));
        dictionary.add(new Vertex("cut"));
        dictionary.add(new Vertex("dog"));
        dictionary.add(new Vertex("web"));

        int length = shortestPath(start, end, dictionary);
        System.out.print(length);
    }

    private static int shortestPath(String start, String end, List<Vertex> dictionary) {
        //construct Graph
        int[][] graph = new int[dictionary.size()][dictionary.size()];
        for (int i = 0; i < dictionary.size(); i++) {
            for (int j = 0; j < dictionary.size(); j++) {
                graph[i][j] = -1;
                if (i == j) continue;
                if (dictionary.get(i).getLabel().length() == dictionary.get(i).getLabel().length()) {
                    char[] c1 = dictionary.get(i).getLabel().toCharArray();
                    char[] c2 = dictionary.get(j).getLabel().toCharArray();
                    int match = 0;
                    for (int k = 0; k < c1.length; k++) {
                        if (c1[k] == c2[k]) {
                            match++;
                        }
                    }
                    if (match >= 2)
                        graph[i][j] = 1;
                }
            }
        }

        // check the shortest path
        Queue<Integer> qpath = new LinkedList();
        qpath.add(0);
        dictionary.get(0).setWasVisited(true);
        dictionary.get(0).setCount(1);
        int count = -1;
        outerloop:

        while (!qpath.isEmpty()) {
            int p = qpath.remove();

            for (int i = 0; i < dictionary.size(); i++) {
                if (graph[p][i] == 1 && dictionary.get(i).isWasVisited() == false) {
                    if (!dictionary.get(i).getLabel().equalsIgnoreCase(end)) {
                        dictionary.get(i).setWasVisited(true);
                        dictionary.get(i).setCount(dictionary.get(p).getCount() + 1);
                        qpath.add(i);
                    } else {
                        count = dictionary.get(p).getCount() + 1;
                        break outerloop;
                    }
                }
            }

        }
        return count;
    }

    static class Vertex {
        public String label;
        public boolean wasVisited;
        public int count;


        public Vertex(String lab) {
            label = lab;
            wasVisited = false;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public boolean isWasVisited() {
            return wasVisited;
        }

        public void setWasVisited(boolean wasVisited) {
            this.wasVisited = wasVisited;
        }
    }

}
