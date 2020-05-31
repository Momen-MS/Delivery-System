/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void start(Stage primaryStage) throws IOException, FileNotFoundException, SQLException {

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
        primaryStage.setOnCloseRequest(e -> {
            try {
                WriteToLogTile();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DeliverySystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DeliverySystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Pane root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        WriteToLogTile();
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
        
        String[][] drivers = new String [100][2];
        int numofdriver = 0 ; 
         rs = DeliverySystem.statement.executeQuery("SELECT * FROM `ready_drivers`");
        for (int i = 0; rs.next(); i++) {
             usersClasses.ready_drivers redyDriver = new usersClasses.ready_drivers();
            redyDriver.setId(rs.getInt("id"));
            redyDriver.setWaiting_time(rs.getString("ready_time"));
                drivers[i][0] = ""+redyDriver.getId();
                drivers[i][1] = redyDriver.getWaiting_time();
                numofdriver++;
        }
        for (int i = 0; i < numofdriver; i++) {
            String q = "UPDATE `ready_drivers` SET waiting_time = '"+getTotalTime(drivers[i][1])+"' WHERE id ='"+drivers[i][0]+"';";
            statement.executeUpdate(q);
        }

    }

    public void WriteToLogTile() throws FileNotFoundException, SQLException{
        File file = new File("LogFile.txt");
        PrintWriter output = new PrintWriter(file);
        ResultSet rs = DeliverySystem.statement.executeQuery("Select * From employees");
        output.print("Employees :\n");
        output.print("========================================================\n");
        while (rs.next()) {
            output.print("ID:"+rs.getInt("id")+" | "+"Name:"+rs.getString("name")+" | "+"Phone:"+rs.getString("phone")+
                    " | "+"Salary:"+rs.getDouble("salary")+" | "+"Email:"+rs.getString("email")+" | "+"Local_Tel:"+rs.getString("local_tel")+" | "+"DOB:"+rs.getString("dob")+
                    " | "+"Stat:"+rs.getString("state")+"\n");
        }
         output.print("========================================================\n");
        output.print("Drivers :\n");
        output.print("========================================================\n");
        rs = DeliverySystem.statement.executeQuery("Select * From drivers");
        while (rs.next()) {
            output.print("Id:"+rs.getInt("id")+" | "+"Name:"+rs.getString("name")+" | "+"Phone:"+rs.getString("phone")+
                    " | "+"Salary:"+rs.getDouble("salary")+" | "+"Email"+rs.getString("email")+" | "+"Transportation"+rs.getString("transportation")+" | "+"DOB:"+rs.getString("dob")+
                    " | "+"Stat :"+rs.getString("state")+"\n");
        }
         output.print("========================================================\n");
        output.print("Customers :\n");
        output.print("========================================================\n");
        rs = DeliverySystem.statement.executeQuery("Select * From customers");
        while (rs.next()) {
            output.print("Id"+rs.getInt("id")+" | "+"Name"+rs.getString("name")+" | "+"Phone :"+rs.getString("phone")+
                    " | "+"Adders 1"+rs.getString("addres1")+" | "+"Addres 2"+rs.getString("addres2")+" | "+"Last Oreder :"+rs.getString("lastOrder")+
                    " | "+"Number Of Orders"+rs.getInt("numberOfOrdes")+" | "+"Dp_number :"+rs.getString("dp_number")+"\n");
        }
         output.print("========================================================\n");
        output.print("Orders :\n");
        output.print("========================================================\n");
        rs = DeliverySystem.statement.executeQuery("SELECT * FROM `orderss record`");
        while (rs.next()) {
            output.print("Id :"+rs.getInt("id")+" | "+"Customer ID :"+rs.getInt("customer_id")+" | "+"Name :"+rs.getString("name")+" | "+"Phone :"+rs.getString("contactPhone")+
                     " | "+"Type:"+rs.getString("type")+ " | "+"Date :"+rs.getString("date")+ " | "+"Total Time :"+rs.getString("totalTime")
                    + " | "+"Product :"+rs.getString("product")+" | "+"Price Of Product :"+rs.getDouble("priceOfProduct")+" | "+"Price Of Delivery :"+rs.getDouble("priceOfdelivery")+
                    " | "+"Total Price :"+rs.getDouble("totalPrice")+" | "+"Notes :"+rs.getString("notes")+" | "+
                   "Driver ID :"+rs.getInt("driver_id")+" | "+"Cal Csenter Emp ID :"+rs.getInt("call_center_emp_id")+" | "+
                    " | "+"Addres 1 :"+rs.getString("addres1")+" | "+"Addres 2 :"+rs.getString("addres2")+" | "+
                    " | "+"Dp_number"+rs.getString("dp_nmber")+"\n");
        }
        output.close();
        File file2 = new File("Employee & Drives Attend Record.txt");
        PrintWriter output2 = new PrintWriter(file2);
         output2.print("Employees :\n");
        output2.print("========================================================\n");
        rs = DeliverySystem.statement.executeQuery("Select * From `employees records`");
        while (rs.next()) {
           output2.print("ID :"+rs.getInt("id")+" | "+" Name :"+rs.getString("name")+" | "+"Date :"+rs.getTimestamp("date")+"\n");
        }
         output2.print("========================================================\n");
         output2.print("Drivers :\n");
        output2.print("========================================================\n");
        rs = DeliverySystem.statement.executeQuery("Select * From `drivers records`");
        while (rs.next()) {
           output2.print("ID :"+rs.getInt("id")+" | "+" Name :"+rs.getString("name")+" | "+"Date :"+rs.getTimestamp("date")+"\n");
        }
 
        output2.close();


    }
}
