package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shravan
 * http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/
 */
public class WordLadder2 {

    public static void main(String args[]) {
        String start = "hit";
        String end = "cog";
        List<Vertex> dictionary = new ArrayList<Vertex>();

        dictionary.add(new Vertex("hit"));
        dictionary.add(new Vertex("hot"));
        dictionary.add(new Vertex("dot"));
        dictionary.add(new Vertex("dog"));
        dictionary.add(new Vertex("lot"));
        dictionary.add(new Vertex("log"));
        dictionary.add(new Vertex("cog"));


        List<ArrayList<String>> res = allsahortestPath(start, end, dictionary);
        System.out.print(res.toString());
    }

    private static List<ArrayList<String>> allsahortestPath(String start, String end, List<Vertex> dictionary) {
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
        List<ArrayList<String>> listres = new ArrayList<ArrayList<String>>();
        outerloop:

        while (!qpath.isEmpty()) {
            int p = qpath.remove();

            for (int i = 0; i < dictionary.size(); i++) {
                if (graph[p][i] == 1 && dictionary.get(i).isWasVisited() == false) {
                    if (!dictionary.get(i).getLabel().equalsIgnoreCase(end)) {
                        dictionary.get(i).setWasVisited(true);
                        dictionary.get(i).setPrevious(dictionary.get(p));
                        dictionary.get(i).setCount(dictionary.get(p).getCount() + 1);
                        qpath.add(i);
                    } else {
                        ArrayList<String> res = new ArrayList<String>();
                        WordLadder2.Vertex pre = dictionary.get(p);
                        while (pre != null) {
                            res.add(0, pre.getLabel());
                            pre = pre.getPrevious();
                        }
                        res.add(end);
                        listres.add(res);
                    }
                }
            }

        }
        return listres;
    }

    static class Vertex {
        public String label;
        public boolean wasVisited;
        public int count;
        public Vertex previous;


        public Vertex(String lab) {
            label = lab;
            wasVisited = false;
        }

        public Vertex getPrevious() {
            return previous;
        }

        public void setPrevious(Vertex previous) {
            this.previous = previous;
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
