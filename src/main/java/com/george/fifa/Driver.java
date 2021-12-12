package com.george.fifa;

import com.george.fifa.database.StatementFactory;
import com.george.fifa.fileio.FileStream;
import com.george.fifa.fileio.MyFileReader;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) {
//        try {
//            PreparedStatement dropStatement = StatementFactory.getDropStatement();
//            PreparedStatement createStatement = StatementFactory.getCreateStatement();
//            dropStatement.execute();
//            createStatement.execute();
//            StatementFactory.closeStatements();
//        } catch (IOException|SQLException e) {
//            e.printStackTrace();
//        }
        Queue<String> players = new LinkedList<String>();
        MyFileReader reader = new MyFileReader(players, "players_22.csv");
        reader.run();
        System.out.println(reader.getQueue());
    }
}
