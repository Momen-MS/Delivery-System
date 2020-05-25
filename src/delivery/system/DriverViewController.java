/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.system;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Momen Musallam
 */
public class DriverViewController implements Initializable {

    @FXML
    private TableView<usersClasses.waitList> watingOrdAllordersTable;
    @FXML
    private TableColumn<usersClasses.waitList, Integer> watingOrdIDTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdNameTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdTypeTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdPhoneTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdDateTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdTimeTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdTotalTimeTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdTotalPriceTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdDriverIDTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdEmployeeIDTV;
    @FXML
    private TableColumn<usersClasses.waitList, String> watingOrdAddresTV;
    @FXML
    private Label watingOrdidLB;
    @FXML
    private Label watingOrdNameLB;
    @FXML
    private Label watingOrdLocalTelLB;
    @FXML
    private Label watingOrdEmailLB;
    @FXML
    private Label watingOrdAddress2LB;
    @FXML
    private Label watingOrdProductLB;
    @FXML
    private Label watingOrdPOPLB;
    @FXML
    private Label watingOrdPODLB;
    @FXML
    private TextArea watingOrdNotesTA;
    @FXML
    private Button watingOrdclearBut;
    @FXML
    private Label waitOrdPhoneLB;
    @FXML
    private Tab TODOlIStTap;
    @FXML
    private Button watingOrdDoneBut;
    public static int LoginDriverID ;
    @FXML
    private Tab AllOrdTap;
    @FXML
   private TableView<usersClasses.orderss_record> AllOrdtable;
    @FXML
    private TableColumn<usersClasses.orderss_record, Integer> AllOrdIDTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, Integer> AllOrdIDCustTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, String> AllOrdNameTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, String> AllOrdTypeTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, String> AllOrdPhoneTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, String> AllOrdDateTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, String> AllOrdTotalTimeTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, Double> AllOrdTotalPriceTV;
    @FXML
    private TableColumn<usersClasses.orderss_record, String> AllOrdAddresTV;
    @FXML
    private Label AllOrdEmpIdLB;
    @FXML
    private Label AllOrdEmpNameLB;
    @FXML
    private Label AllOrdEmpLocalTelLB;
    @FXML
    private Label AllOrdEmpEmailLB;
    @FXML
    private Label AllOrddrIDLB;
    @FXML
    private Label AllOrddrNameLB;
    @FXML
    private Label AllOrddrPhoneLB;
    @FXML
    private Label AllOrddrTransLB;
    @FXML
    private Label AllOrddrEmailLB;
    @FXML
    private Label AllOrdCuAddres2LB;
    @FXML
    private Label AllOrdCuProductLB;
    @FXML
    private Label AllOrdCuPOPLB;
    @FXML
    private Label AllOrdCuPODLB;
    @FXML
    private TextArea AllOrdCuNotesTA;
    @FXML
    private Button AllOrdClearBut;
    @FXML
    private Tab EmailReceivedTap;
    @FXML
    private TableView<usersClasses.emails> EmailReceivedTableView;
    @FXML
    private TableColumn<usersClasses.emails, String> EmailReceivedFromTV;
    @FXML
    private TableColumn<usersClasses.emails, String> EmailReceivedTitleTV;
    @FXML
    private TableColumn<usersClasses.emails, Timestamp> EmailReceivedDateTV;
    @FXML
    private Label EmailReceivedTitleLB;
    @FXML
    private Label EmailReceivedFromTitle;
    @FXML
    private Label EmailReceivedDateLB;
    @FXML
    private TextArea EmailReceivedContentTA;
    @FXML
    private Button EmailReceivedDeleteBut;
    @FXML
    private Button EmailReceivedClearBut;
    @FXML
    private Tab newEmailTap;
    @FXML
    private TextField newEmailTitleTF;
    @FXML
    private TextField newEmailToTF;
    @FXML
    private TextArea newEmailContetnTA;
    @FXML
    private Button newEmailClearBut;
    @FXML
    private Button newEmailSendBut;
    @FXML
    private Tab emailSentTap;
    @FXML
     private TableView<usersClasses.emails> emailSentTable;
    @FXML
    private TableColumn<usersClasses.emails, String> emailSentToTV;
    @FXML
    private TableColumn<usersClasses.emails, String> emailSentTitleTV;
    @FXML
    private TableColumn<usersClasses.emails, Timestamp> emailSentDateTV;
    @FXML
    private Label emailSentTitleLB;
    @FXML
    private Label emailSentToLB;
    @FXML
    private Label emailSentDateLB;
    @FXML
    private TextArea emailSentContentLB;
    @FXML
    private Button emailSentDeleteBut;
    @FXML
    private Button emailSentClearBut;
    public static String driEmail ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        watingOrdIDTV.setCellValueFactory(new PropertyValueFactory("id"));
        watingOrdNameTV.setCellValueFactory(new PropertyValueFactory("name"));
        watingOrdTypeTV.setCellValueFactory(new PropertyValueFactory("type"));
        watingOrdPhoneTV.setCellValueFactory(new PropertyValueFactory("contactPhone"));
        watingOrdDateTV.setCellValueFactory(new PropertyValueFactory("date"));
        watingOrdTimeTV.setCellValueFactory(new PropertyValueFactory("time"));
        watingOrdTotalTimeTV.setCellValueFactory(new PropertyValueFactory("totalTime"));
        watingOrdDriverIDTV.setCellValueFactory(new PropertyValueFactory("driverId"));
        watingOrdEmployeeIDTV.setCellValueFactory(new PropertyValueFactory("call_center_emp_id"));
        watingOrdAddresTV.setCellValueFactory(new PropertyValueFactory("addres1"));
        watingOrdTotalPriceTV.setCellValueFactory(new PropertyValueFactory("totalPrice"));

        try {
            showInwaitingOrdersTable();
        } catch (SQLException ex) {
            Logger.getLogger(DriverViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DriverViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        watingOrdAllordersTable.getSelectionModel().selectedItemProperty().addListener(
                event -> {
                    try {
                        showSelectedWitingOrder();
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        
        
        
        
         AllOrdAddresTV.setCellValueFactory(new PropertyValueFactory("addres1"));
            AllOrdIDTV.setCellValueFactory(new PropertyValueFactory("id"));
            AllOrdIDCustTV.setCellValueFactory(new PropertyValueFactory("customer_id"));
            AllOrdNameTV.setCellValueFactory(new PropertyValueFactory("name"));
            AllOrdTypeTV.setCellValueFactory(new PropertyValueFactory("type"));
            AllOrdPhoneTV.setCellValueFactory(new PropertyValueFactory("contactPhone"));
            AllOrdDateTV.setCellValueFactory(new PropertyValueFactory("date"));
            AllOrdTotalTimeTV.setCellValueFactory(new PropertyValueFactory("totalTime"));
            AllOrdTotalPriceTV.setCellValueFactory(new PropertyValueFactory("totalPrice"));
        try {
            showInAllOrdersTable();
        } catch (SQLException ex) {
            Logger.getLogger(DriverViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

            AllOrdtable.getSelectionModel().selectedItemProperty().addListener(
                    event -> {
                        try {
                            showSelectedAllOrder();
                        } catch (SQLException ex) {
                            Logger.getLogger(EmployeeViewController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
             EmailReceivedFromTV.setCellValueFactory(new PropertyValueFactory("from"));
            EmailReceivedTitleTV.setCellValueFactory(new PropertyValueFactory("title"));
            EmailReceivedDateTV.setCellValueFactory(new PropertyValueFactory("date"));
        try {
            showRecivedEmails();
        } catch (SQLException ex) {
            Logger.getLogger(DriverViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
            EmailReceivedTableView.getSelectionModel().selectedItemProperty().addListener(
                    event -> {
                        showSelectedRecivedEmail();
                    });

            emailSentToTV.setCellValueFactory(new PropertyValueFactory("to"));
            emailSentTitleTV.setCellValueFactory(new PropertyValueFactory("title"));
            emailSentDateTV.setCellValueFactory(new PropertyValueFactory("date"));
        try {
            showSentEmails();
        } catch (SQLException ex) {
            Logger.getLogger(DriverViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
            emailSentTable.getSelectionModel().selectedItemProperty().addListener(
                    event -> {
                        showSelectedSentEmail();

                    });
            

    }

    @FXML
    private void watingOrdclearButAC(ActionEvent event) throws SQLException, ParseException {
        cleanWaitingOrders();
    }

    private void showSelectedWitingOrder() throws SQLException {
        usersClasses.waitList order = watingOrdAllordersTable.getSelectionModel().getSelectedItem();
        if (order != null) {
            watingOrdidLB.setText("" + order.getCall_center_emp_id());
            ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `employees` WHERE id =" + order.getCall_center_emp_id());
            while (rs.next()) {
                watingOrdNameLB.setText(rs.getString("name"));
                watingOrdLocalTelLB.setText(rs.getString("local_tel"));
                watingOrdEmailLB.setText(rs.getString("email"));
                waitOrdPhoneLB.setText(rs.getString("phone"));
            }
            watingOrdAddress2LB.setText(order.getAddres2());
            watingOrdProductLB.setText(order.getProduct());
            watingOrdPOPLB.setText("" + order.getPriceOfProduct());
            watingOrdPODLB.setText("" + order.getPriceOfdelivery());
            watingOrdNotesTA.setText(order.getNotes());
        }
    }

    public void showInwaitingOrdersTable() throws SQLException, ParseException {
        watingOrdAllordersTable.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `wait list` WHERE driverId =" + this.LoginDriverID);
        watingOrdAllordersTable.getItems().clear();
        while (rs.next()) {
            usersClasses.waitList order = new usersClasses.waitList();
            order.setId(rs.getInt("id"));
            order.setName(rs.getString("name"));
            order.setType(rs.getString("type"));
            order.setAddres1(rs.getString("addres1"));
            order.setAddres2(rs.getString("addres2"));
            order.setDate(rs.getString("date"));
            order.setTime(rs.getString("time"));
            order.setTotalTime(rs.getString("totalTime"));
            order.setProduct(rs.getString("product"));
            order.setPriceOfProduct(rs.getDouble("priceOfProduct"));
            order.setPriceOfdelivery(rs.getDouble("priceOfdelivery"));
            order.setTotalPrice(rs.getDouble("totalPrice"));
            order.setContactPhone(rs.getString("contactPhone"));
            order.setDp_nmber(rs.getString("dp_nmber"));
            order.setNotes(rs.getString("notes"));
            order.setCall_center_emp_id(rs.getInt("call_center_emp_id"));
            order.setDriverId(rs.getInt("driverId"));
            watingOrdAllordersTable.getItems().add(order);
        }
    }

    public void cleanWaitingOrders() throws SQLException, ParseException {
        watingOrdAllordersTable.getSelectionModel().clearSelection();
        watingOrdidLB.setText("empty");
        watingOrdNameLB.setText("empty");
        watingOrdLocalTelLB.setText("empty");
        watingOrdEmailLB.setText("empty");
        watingOrdAddress2LB.setText("empty");
        watingOrdProductLB.setText("empty");
        watingOrdPODLB.setText("empty");
        watingOrdPOPLB.setText("empty");
        watingOrdNotesTA.setText("empty");
        showInwaitingOrdersTable();

    }

    @FXML
    private void watingOrdDoneButAC(ActionEvent event) throws SQLException, ParseException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sent Delivered Handed");
        alert.setHeaderText("Did you Complete all customer requests ?");
        alert.setContentText("The secret of our success is customer satisfaction");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            usersClasses.waitList order = watingOrdAllordersTable.getSelectionModel().getSelectedItem();
            int customerId = 0;
            ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `customers` WHERE name ='" + order.getName() + "'");
            while (rs.next()) {
                customerId = rs.getInt("id");
            }
            String q = "INSERT INTO `orderss record` (`id`, `customer_id`, `name`, `type`, `addres1`, `addres2`, `date`, `totalTime`,"
                    + " `product`, `priceOfProduct`, `priceOfdelivery`, `totalPrice`, `contactPhone`, `dp_nmber`, `notes`, `driver_id`, `call_center_emp_id`) "
                    + "VALUES (NULL, '" + customerId + "', '" + order.getName() + "', '" + order.getType() + "',"
                    + " '" + order.getAddres1() + "', '" + order.getAddres2() + "', '" + order.getDate() + " "+order.getTime()+"'"
                    + ", '" + order.getTotalTime()+"', '" + order.getProduct() + "', '" + order.getPriceOfProduct() + "', '" + order.getPriceOfdelivery() + "', '" + order.getTotalPrice() + "',"
                    + " '" + order.getContactPhone() + "', '" + order.getDp_nmber() + "', '" + order.getNotes() + "', '" + order.getDriverId() + "', '" + order.getCall_center_emp_id() + "');";

            DeliverySystem.statement.executeUpdate(q);

            
            showInwaitingOrdersTable();

        }

    }

    @FXML
    private void ToDoListTapAC(Event event) throws SQLException, ParseException {
        showInwaitingOrdersTable();
    }

    @FXML
    private void AllOrdClearButAC(ActionEvent event) {
        clearAllOrderTable();
    }

    @FXML
    private void AllOrdTapAC(Event event) throws SQLException {
        showInAllOrdersTable();
    }
 private void showSelectedAllOrder() throws SQLException {
        usersClasses.orderss_record order = AllOrdtable.getSelectionModel().getSelectedItem();
        if (order != null) {
            AllOrdEmpIdLB.setText("" + order.getCall_center_emp_id());
            ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `employees` WHERE id =" + order.getCall_center_emp_id());
            while (rs.next()) {
                AllOrdEmpNameLB.setText(rs.getString("name"));
                AllOrdEmpLocalTelLB.setText(rs.getString("local_tel"));
                AllOrdEmpEmailLB.setText(rs.getString("email"));
            }
            AllOrddrIDLB.setText("" + order.getDriverId());
            rs = DeliverySystem.statement.executeQuery("SELECT * FROM `drivers` WHERE id =" + order.getDriverId());
            while (rs.next()) {
                AllOrddrNameLB.setText(rs.getString("name"));
                AllOrddrTransLB.setText(rs.getString("transportation"));
                AllOrddrPhoneLB.setText(rs.getString("phone"));
                AllOrddrEmailLB.setText(rs.getString("email"));
            }
            AllOrdCuAddres2LB.setText(order.getAddres2());
            AllOrdCuProductLB.setText(order.getProduct());
            AllOrdCuPOPLB.setText("" + order.getPriceOfProduct());
            AllOrdCuPODLB.setText("" + order.getPriceOfdelivery());
            AllOrdCuNotesTA.setText(order.getNotes());
        }
    }

    public void showInAllOrdersTable() throws SQLException {
        AllOrdtable.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `orderss record` WHERE driver_id ="+this.LoginDriverID);
        AllOrdtable.getItems().clear();
        while (rs.next()) {
            usersClasses.orderss_record order = new usersClasses.orderss_record();
            order.setId(rs.getInt("id"));
            order.setName(rs.getString("name"));
            order.setType(rs.getString("type"));
            order.setAddres1(rs.getString("addres1"));
            order.setAddres2(rs.getString("addres2"));
            order.setDate(rs.getString("date"));
            order.setTotalTime(rs.getString("totalTime"));
            order.setProduct(rs.getString("product"));
            order.setPriceOfProduct(rs.getDouble("priceOfProduct"));
            order.setPriceOfdelivery(rs.getDouble("priceOfdelivery"));
            order.setTotalPrice(rs.getDouble("totalPrice"));
            order.setContactPhone(rs.getString("contactPhone"));
            order.setDp_nmber(rs.getString("dp_nmber"));
            order.setNotes(rs.getString("notes"));
            order.setCall_center_emp_id(rs.getInt("call_center_emp_id"));
            order.setDriverId(rs.getInt("driver_id"));
            AllOrdtable.getItems().add(order);
        }
    }

    public void clearAllOrderTable() {
        AllOrdEmpIdLB.setText("empty");
        AllOrdEmpNameLB.setText("empty");
        AllOrdEmpLocalTelLB.setText("empty");
        AllOrdEmpEmailLB.setText("empty");
        AllOrddrIDLB.setText("empty");
        AllOrddrNameLB.setText("empty");
        AllOrddrTransLB.setText("empty");
        AllOrddrPhoneLB.setText("empty");
        AllOrddrEmailLB.setText("empty");
        AllOrdCuAddres2LB.setText("empty");
        AllOrdCuProductLB.setText("empty");
        AllOrdCuPOPLB.setText("empty");
        AllOrdCuPODLB.setText("empty");
        AllOrdCuNotesTA.setText("empty");
        AllOrdtable.getSelectionModel().clearSelection();

    }

     @FXML
    private void EmailReceivedDeletebutAC(ActionEvent event) throws SQLException {
        
    }

    @FXML
    private void EmailReceivedClearButAC(ActionEvent event) {
        clearReceidEmaisls();
    }

    @FXML
    private void EmailReceivedTapAC(Event event) {
    }

    @FXML
    private void newEmailClearButAC(ActionEvent event) {
         newEmailToTF.setText("");
        newEmailContetnTA.setText("");
        newEmailTitleTF.setText("");

    }

    @FXML
    private void newEmailSendButAC(ActionEvent event) throws SQLException {
        String emailTo = newEmailToTF.getText();
        String contentOfEmails = newEmailContetnTA.getText();
        String title = newEmailTitleTF.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Send Email");
        alert.setHeaderText("Are You Sure ?");
        alert.setContentText("In this case the Email will Send To " + emailTo + " ..... ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String q = "INSERT INTO `emails` (`id`, `from`, `to`, `title`, `date`, `Contents`) VALUES"
                    + " (NULL, '"+this.driEmail+"', '"+emailTo+"', '"+title+"','"+timestamp+"', '"+contentOfEmails+"');";
             DeliverySystem.statement.executeUpdate(q);
        }
        newEmailToTF.setText("");
        newEmailContetnTA.setText("");
        newEmailTitleTF.setText("");
    }

    @FXML
    private void emailSentDeleteButAC(ActionEvent event) throws SQLException {
      
    }

    @FXML
    private void emailSentClearButAC(ActionEvent event) {
        clearSentsEmaisls();
    }

    @FXML
    private void emailSentTapAC(Event event) throws SQLException {
        showSentEmails();

    }

    public void showRecivedEmails() throws SQLException {
        EmailReceivedTableView.getSelectionModel().clearSelection();
        String query = "SELECT * FROM `emails`WHERE `emails`.`to` ='" + this.driEmail + "'";
        ResultSet rs = DeliverySystem.statement.executeQuery(query);
        EmailReceivedTableView.getItems().clear();
        while (rs.next()) {
            usersClasses.emails email = new usersClasses.emails();
            email.setId(rs.getInt("id"));
            email.setTitle(rs.getString("title"));
            email.setDate(rs.getTimestamp("date"));
            email.setFrom(rs.getString("from"));
            email.setContents(rs.getString("Contents"));
            email.setTo(rs.getString("to"));
            EmailReceivedTableView.getItems().add(email);
        }
    }

    private void showSelectedRecivedEmail() {
        usersClasses.emails email = EmailReceivedTableView.getSelectionModel().getSelectedItem();
        if (email != null) {
            EmailReceivedTitleLB.setText(String.valueOf(email.getTitle()));
            EmailReceivedFromTitle.setText(String.valueOf(email.getFrom()));
            EmailReceivedDateLB.setText(String.valueOf(email.getDate()));
            EmailReceivedContentTA.setText(String.valueOf(email.getContents()));

        }
    }

    public void showSentEmails() throws SQLException {
        emailSentTable.getSelectionModel().clearSelection();
        String query = "SELECT * FROM `emails` WHERE `emails`.`from` ='" + this.driEmail + "'";
        emailSentTable.getItems().clear();
        ResultSet rs = DeliverySystem.statement.executeQuery(query);
        while (rs.next()) {
            usersClasses.emails email = new usersClasses.emails();
            email.setId(rs.getInt("id"));
            email.setTitle(rs.getString("title"));
            email.setDate(rs.getTimestamp("date"));
            email.setFrom(rs.getString("from"));
            email.setContents(rs.getString("Contents"));
            email.setTo(rs.getString("to"));
            emailSentTable.getItems().add(email);

        }
    }

    private void showSelectedSentEmail() {
        usersClasses.emails email = emailSentTable.getSelectionModel().getSelectedItem();
        if (email != null) {
            emailSentTitleLB.setText(String.valueOf(email.getTitle()));
            emailSentToLB.setText(String.valueOf(email.getTo()));
            emailSentDateLB.setText(String.valueOf(email.getDate()));
            emailSentContentLB.setText(String.valueOf(email.getContents()));
        }
    }

    public void clearReceidEmaisls() {
        EmailReceivedTableView.getSelectionModel().clearSelection();
        EmailReceivedTitleLB.setText("empty");
        EmailReceivedFromTitle.setText("empty");
        EmailReceivedDateLB.setText("empty");
        EmailReceivedContentTA.setText("empty");

    }

    public void clearSentsEmaisls() {
        emailSentTable.getSelectionModel().clearSelection();
        emailSentTitleLB.setText("empty");
        emailSentToLB.setText("empty");
        emailSentDateLB.setText("empty");
        emailSentContentLB.setText("empty");
    }
}
