package com.george.fifa.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileStream {
    public static List<String> dataStream() {
        List<String> players = null;
        try {
            players = Files
                    .lines(Path.of("players_22.csv"))
                    .map(s -> s.split(",")[0] + s.split(",")[1])
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
