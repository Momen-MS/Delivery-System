/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.system;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author momen-ms
 */
public class DeliverySystem extends Application {

    public static Statement statement;
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {

        try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection
                    = DriverManager.
                            getConnection("jdbc:mysql://localhost:3306/deliverySystem?serverTimezone=UTC",
                                    "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Pane root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Delivery System");
        primaryStage.setScene(scene);
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static String hash(String pass) {

        String passwordToHash = pass;
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static String getTotalTime(String time1) throws ParseException {
        DateFormat dff = new SimpleDateFormat("HH:mm:ss");
        Date dateobjj = new Date();
        String time2 = dff.format(dateobjj);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        String x = String.valueOf(difference / 60000);
        return x;
    }

    public static void updateDatabaseTime() throws SQLException, ParseException {
        String[][] customer = new String [100][2];
        int numofOreder = 0 ; 
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `wait list`");
        for (int i = 0; rs.next(); i++) {
             usersClasses.waitList order = new usersClasses.waitList();
            order.setId(rs.getInt("id"));
            order.setTime(rs.getString("time"));
                customer[i][0] = ""+order.getId();
                customer[i][1] = order.getTime();
                numofOreder++;
        }
        for (int i = 0; i < numofOreder; i++) {
            String q = "UPDATE `wait list` SET totalTime = '"+getTotalTime(customer[i][1])+"' WHERE id ='"+customer[i][0]+"';";
            statement.executeUpdate(q);
        }

    }

}
