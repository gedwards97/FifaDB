package com.george.fifa.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementFactory {
    private static PreparedStatement createStatement = null;
    private static PreparedStatement dropStatement = null;
    private static PreparedStatement insertStatement = null;

    public static PreparedStatement getDropStatement() throws SQLException, IOException {
        if (dropStatement == null) {
            dropStatement = ConnectionFactory.getConnection()
                    .prepareStatement("DROP TABLE IF EXISTS players;");
        }
        return dropStatement;
    }

    public static PreparedStatement getCreateStatement() throws SQLException, IOException {
        if (createStatement == null) {
            createStatement = ConnectionFactory.getConnection()
                    .prepareStatement("CREATE TABLE players (" +
                            "id int PRIMARY KEY," +
                            "name VARCHAR(30)," +
                            "age int ," +
                            "nationality VARCHAR(20)," +
                            "club VARCHAR(20)," +
                            "rating int ," +
                            "value int ," +
                            "position VARCHAR(4));");
        }
        return createStatement;
    }

    public static PreparedStatement getInsertStatement() throws SQLException, IOException {
        return insertStatement;
    }

    public static void closeStatements() throws SQLException, IOException{
        if(createStatement != null) createStatement.close();
        if(dropStatement != null) dropStatement.close();
        if(insertStatement != null) insertStatement.close();
    }
}