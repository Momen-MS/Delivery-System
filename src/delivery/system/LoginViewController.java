/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.system;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Momen Musallam
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField INpustEmail;
    @FXML
    private TextField INputPassword;
    @FXML
    private Button LoginBut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LoginButAC(ActionEvent event) throws SQLException, IOException {
        boolean driverLogin = false;
        int driverId = 0;
        String driverName = "";
        String driverTran = "";
        String Email = INpustEmail.getText();
        String PassWord = INputPassword.getText();
        PassWord = DeliverySystem.hash(PassWord);

        int index = Email.indexOf('@');
        String select = Email.substring(index + 1, index + 2);

        if (select.equalsIgnoreCase("a")) {
            String query = "SELECT email , name , pass FROM `administrators` Where email = '" + Email + "' AND pass= '" + PassWord + "'";
            ResultSet rs = DeliverySystem.statement.executeQuery(query);
            if (rs.next()) {
                AdminViewController.Adminemail = rs.getString("email");
                AdminViewController.AdminName = rs.getString("name");
                AdminViewController.AdminPass = rs.getString("pass");
                Pane root = FXMLLoader.load(getClass().getResource("adminView.fxml"));
                Scene newS = new Scene(root);
                DeliverySystem.primaryStage.setScene(newS);

            } else {
                errorMass();
            }
        } else if (select.equalsIgnoreCase("e")) {
            String qq = "SELECT id , name , email , pass FROM `employees` Where email = '" + Email + "' AND pass= '" + PassWord + "' AND state = 'active'";
            ResultSet rss = DeliverySystem.statement.executeQuery(qq);
            if (rss.next()) {
                EmployeeViewController.empemail = rss.getString("email");
                EmployeeViewController.empename = rss.getString("name");
                EmployeeViewController.empepass = rss.getString("pass");
                EmployeeViewController.EmpID = rss.getInt("id");
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                qq = "INSERT INTO `employees records` (`id`, `name`, `date`) VALUES ('" + rss.getInt("id") + "', '" + rss.getString("name") + "', '" + timestamp + "');";
                DeliverySystem.statement.executeUpdate(qq);
                Pane roott = FXMLLoader.load(getClass().getResource("employeeView.fxml"));
                Scene newSs = new Scene(roott);
                DeliverySystem.primaryStage.setScene(newSs);

            } else {
                errorMass();
            }
        } else if (select.equalsIgnoreCase("d")) {
            String qqr = "SELECT id , name , transportation , email , pass FROM `drivers` Where email = '" + Email + "' AND pass= '" + PassWord + "' AND state = 'active'";
            ResultSet rsss = DeliverySystem.statement.executeQuery(qqr);
            if (rsss.next()) {
                DriverViewController.driEmail = rsss.getString("email");
                DriverViewController.driTran = rsss.getString("transportation");
                DriverViewController.driid = rsss.getString("id");
                DriverViewController.driname = rsss.getString("name");
                DriverViewController.dripass = rsss.getString("pass");
                DriverViewController.LoginDriverID = rsss.getInt("id");
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                driverId = rsss.getInt("id");
                driverName = rsss.getString("name");
                driverTran = rsss.getString("transportation");
                qqr = "INSERT INTO `drivers records` (`id`, `name`, `date`) VALUES ('" + rsss.getInt("id") + "', '" + rsss.getString("name") + "', '" + timestamp + "');";
                DeliverySystem.statement.executeUpdate(qqr);
                driverLogin = true;
                Pane root = FXMLLoader.load(getClass().getResource("DriverView.fxml"));
                Scene newSss = new Scene(root);
                DeliverySystem.primaryStage.setScene(newSss);
            } else {
                errorMass();
            }
        }else{
        errorMass();
        }
        String q = "SELECT * FROM `ready_drivers` WHERE id =" + driverId;
        ResultSet rs = DeliverySystem.statement.executeQuery(q);
        if (!rs.next()) {
            if (driverLogin == true) {
                rs = DeliverySystem.statement.executeQuery("SELECT * FROM `orderss record` WHERE driver_id =" + DriverViewController.LoginDriverID);
                int numOfOrders = 0;
                while (rs.next()) {
                    numOfOrders++;
                }
                DateFormat dff = new SimpleDateFormat("HH:mm:ss");
                Date dateobjj = new Date();
                String time = dff.format(dateobjj);
                String qqr = "INSERT INTO `ready_drivers` (`id`, `name`, `transportaion`, `orders_num`, `waiting_time`, `ready_time`) VALUES"
                        + " ('" + driverId + "', '" + driverName + "', '" + driverTran + "', '" + numOfOrders + "', '0', '" + time + "');";
                DeliverySystem.statement.executeUpdate(qqr);

            }
        }
    }

    public void errorMass() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorect Inputs");
        alert.setHeaderText("Email Or Password Is Incorect");
        alert.setContentText("Please check your Inputs");
        alert.showAndWait();
    }

}
