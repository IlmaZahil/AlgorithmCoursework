package cw.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static int [][] graph;
    public static void main(String[] args){
        graph = fileReading();
        mainMenu();
    }
    private static void mainMenu() {
        // Main Menu where the menu is displayed and stopwatch starts and displays the max flow

        System.out.println();
        if (graph != null) {
            // Displays results
            System.out.println("- - - Adjacent Matrix for a given Graph - - -\n");
            displayGraph(graph);
            System.out.println();
            System.out.println("Maximum flow : " + MaxFlow.fordFulkerson(graph, 0, graph.length - 1));
        }
    }
    private static int[][] fileReading() {
        // Reading the data from the text file, NOTE that the path to the text file has to given correctly
        ArrayList<String> dataInput = new ArrayList<>();
        System.out.println("Getting data from the file...");
        try {
            File myObj = new File("benchmarks/ladder_5.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataInput.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("There was an Issue, File not found!");
        }
        if (dataInput.size() != 0) {
            return generatingGraph(dataInput);
        } else {
            return null;
        }
    }
    public static int[][] generatingGraph(ArrayList<String> inputData){
        // Generating the graph matrix
        int graph_size = Integer.parseInt(inputData.get(0).trim());
        int[][] graph = new int[graph_size][graph_size];
        System.out.println("Making an Adjacent Matrix . . .");
        for (int row = 0; row < graph_size; row++) {
            for (int column = 0; column < graph_size; column++) {
                graph[row][column] = 0;
            }
        }
        for (int item = 1; item < inputData.size(); item++) {
            String[] split_item = inputData.get(item).split(" ");
            int x = Integer.parseInt(split_item[0].trim());
            int y = Integer.parseInt(split_item[1].trim());
            int value = Integer.parseInt(split_item[2].trim());
            addEdge(x, y, value, graph);
        }
        return graph;
    }
    private static void addEdge(int x, int y, int capacity, int[][] graph) {
        // adding edge
        graph[x][y] = capacity;
    }

    public static void displayGraph(int[][] graph){
        // Displaying the graph
        int num_of_edges = 0;
        for (int[] data_row : graph) {
            for (int index = 0; index< graph.length; index++) {
                if(data_row[index] > 0){
                    num_of_edges++;
                }
                System.out.print(data_row[index] + " ");
            }
            System.out.println();
        }
        System.out.println("\nTotal Nodes present : " + graph.length );
        System.out.println("Total Edges present : " + num_of_edges );
        System.out.println("The Source Node : 0 ");
        System.out.println("The Target Node : " + (graph.length - 1));
    }
}


//References :
// https://www.w3schools.com/java/java_files_read.asp
// https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
