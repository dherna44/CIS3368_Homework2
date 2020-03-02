package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Student Database");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    //Code given in class to connect to AWS Database:
    final String hostname = "hw2-database.c705kd7ezyfn.us-east-1.rds.amazonaws.com";
    final String dbName = "hw2database";
    final String port = "3306";
    final String userName = "dherna44";
    final String password = "whwi189h$1!qy";
    final String AWS_URL = "jdbc:mysql://"+ hostname + ":"+port+"/"+dbName+"?user="
            +userName+"&password="+password;

    //Reference code that I found of how to connect to a database:
    private static Connection cnctn = null;
    private static Statement stmnt = null;
    private static ResultSet result = null;
    private static String url = "hw2-database.c705kd7ezyfn.us-east-1.rds.amazonaws.com";
    private static String user = "dherna44",pass = "whwi189h$1!qy";




    public static void main(String[] args) {
        launch(args);

        //Try/Catch statement to connect to database:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnctn = (Connection) DriverManager.getConnection(url, user, pass);
            stmnt = (Statement) cnctn.createStatement();
            result = stmnt.executeQuery("select *from student_table");

            while (result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                System.out.println(id + "" + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
