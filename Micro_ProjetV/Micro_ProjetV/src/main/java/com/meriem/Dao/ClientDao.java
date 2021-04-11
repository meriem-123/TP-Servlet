package com.meriem.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.meriem.Models.Client;

public class ClientDao {
	
	public int registerClient(Client client) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO client" +
            "  (id, Email, Nom, Prenom, Adresse, CodePostal, Ville, Tel, MotPasse) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/micro-projetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "justpass");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getNom());
            preparedStatement.setString(4, client.getPrenom());
            preparedStatement.setString(5, client.getAdresse());
            preparedStatement.setInt(6, client.getCodePostal());
            preparedStatement.setString(7, client.getVille());
            preparedStatement.setInt(8, client.getTel());
            preparedStatement.setString(9, client.getMotPasse());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sequel exception
            printSQLException(e);
        }
        return result;
    }
	
	 public boolean validate(Client client) throws ClassNotFoundException {
	        boolean status = false;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/micro-projetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "justpass");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from client where Email = ? and MotPasse = ? ")) {
	            preparedStatement.setString(1, client.getEmail());
	            preparedStatement.setString(2, client.getMotPasse());

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            status = rs.next();

	        } catch (SQLException e) {
	            // process sequel exception
	            printSQLException(e);
	        }
	        return status;
	    }

	 public String checkName(String email) throws ClassNotFoundException {
		 String name = "";
		 
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/micro-projetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "justpass");

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select Nom from client where Email = ? ")) {
		            preparedStatement.setString(1, email);

		            System.out.println(preparedStatement);
		            ResultSet rs = preparedStatement.executeQuery();
		            while(rs.next()){
		            	name = rs.getString("Nom");
		            }

		        } catch (SQLException e) {
		            // process sequel exception
		            printSQLException(e);
		        }
		 
		 return name;
	 }
	 
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
