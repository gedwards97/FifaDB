package com.george.fifa.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Queue;

public class MyFileReader implements Runnable{
    private final Queue<String> queue;
    private final Path inputFile;
    // Indecies of desired features
    private final int[] featureIndicies = {2, 4, 5, 6, 8, 13, 22};

    public MyFileReader(Queue<String> queue, String inputFile) {
        this.queue = queue;
        this.inputFile = Path.of(inputFile);
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new FileReader(String.valueOf(inputFile)))) {
            String fileLine;
            while ((fileLine = in.readLine()) != null) {
                String[] features = fileLine.split(",");
                StringBuilder returnFeatures = new StringBuilder();
                for (int index: featureIndicies) {
                    returnFeatures.append(features[index] + ",");
                }
                queue.add(returnFeatures.toString());
            }
            // Remove column names
            queue.poll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Queue<String> getQueue() {
        return queue;
    }
}
