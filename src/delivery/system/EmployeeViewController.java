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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author momen-ms
 */
public class EmployeeViewController implements Initializable {

    @FXML
    private Tab makeOrdTap;
    @FXML
    private TextField makeOrdTypeTF;
    @FXML
    private TextField makeOrdAddres1;
    @FXML
    private TextField makeOrdAddres2TF;
    @FXML
    private TextField makeOrdProductTF;
    @FXML
    private TextField makeOrdPriceOfPTF;
    @FXML
    private TextField makeOrdPricrOdDTF;
    @FXML
    private TextField makeOrdTotalPTF;
    @FXML
    private TextField makeOrdDepNumberTF;
    @FXML
    private TextField makeOrdContactPhoneTF;
    @FXML
    private TextArea makeOrdNotesTF;
    @FXML
    private TableView<usersClasses.ready_drivers> makeOrdReadyDriversTable;
    @FXML
    private TableColumn<usersClasses.ready_drivers, Integer> makeOrdreadTVId;
    @FXML
    private TableColumn<usersClasses.ready_drivers, String> makeOrdreadTVName;
    @FXML
    private TableColumn<usersClasses.ready_drivers, String> makeOrdreadTVWaiting;
    @FXML
    private TableColumn<usersClasses.ready_drivers, String> makeOrdreadTVTrans;
    @FXML
    private Button makeOrdRefreshDLBut;
    @FXML
    private Button makeOrdMakeOrdBut;
    @FXML
    private Button makeOrdClearBut;
    @FXML
    private TextField makeOrdNameTF;
    @FXML
    private TableView<usersClasses.Customers> makeOrdViewCustTable;
    @FXML
    private TableColumn<usersClasses.Customers, Integer> makeOrdViewIDTV;
    @FXML
    private TableColumn<usersClasses.Customers, String> makeOrdViewNameTV;
    @FXML
    private TableColumn<usersClasses.Customers, Integer> makeOrdViewOrdNumTV;

    private static int DriverID;
    public static int EmpID ;
    private ArrayList<usersClasses.Customers> AllCustomer;
    @FXML
    private Tab watingOrdTap;
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
    private Label watingOrdDrIdLB;
    @FXML
    private Label watingOrdDrNameLB;
    @FXML
    private Label watingOrdDrPhone;
    @FXML
    private Label watingOrdDrTranLB;
    @FXML
    private Label watingOrdDrEmailLB;
    @FXML
    private Label watingOrdProductLB;
    @FXML
    private Label watingOrdPOPLB;
    @FXML
    private Label watingOrdPODLB;
    @FXML
    private TextArea watingOrdNotesTA;
    @FXML
    private Button watingOrdDeleteBut;
    @FXML
    private Button watingOrdclearBut;
    @FXML
    private Label watingOrdAddress2LB;
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
    public static String empemail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            makeOrdreadTVId.setCellValueFactory(new PropertyValueFactory("id"));
            makeOrdreadTVName.setCellValueFactory(new PropertyValueFactory("name"));
            makeOrdreadTVWaiting.setCellValueFactory(new PropertyValueFactory("waiting_time"));
            makeOrdreadTVTrans.setCellValueFactory(new PropertyValueFactory("transportaion"));
            makeOrdReadyDriversTable.getSelectionModel().selectedItemProperty().addListener(
                    event -> showSelectedDriver());

            makeOrdViewIDTV.setCellValueFactory(new PropertyValueFactory("id"));
            makeOrdViewNameTV.setCellValueFactory(new PropertyValueFactory("name"));
            makeOrdViewOrdNumTV.setCellValueFactory(new PropertyValueFactory("numberOfOrdes"));

            makeOrdViewCustTable.getSelectionModel().selectedItemProperty().addListener(
                    event -> showSelectedCustomer());

            AllCustomer = new ArrayList<usersClasses.Customers>();
            ResultSet cus = DeliverySystem.statement.executeQuery("SELECT * FROM `customers`");
//            makeOrdReadyDriversTable.getItems().clear();
            while (cus.next()) {
                usersClasses.Customers customer = new usersClasses.Customers();
                customer.setId(cus.getInt("id"));
                customer.setName(cus.getString("name"));
                customer.setPhone(cus.getString("phone"));
                customer.setAddres1(cus.getString("addres1"));
                customer.setAddres2(cus.getString("addres2"));
                customer.setDp_number(cus.getString("dp_number"));
                customer.setNumberOfOrdes(cus.getInt("numberOfOrdes"));
                AllCustomer.add(customer);
            }
            showInRedyDriverTable();

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

            showInwaitingOrdersTable();
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
            showInAllOrdersTable();

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
            showRecivedEmails();
            EmailReceivedTableView.getSelectionModel().selectedItemProperty().addListener(
                    event -> {
                        showSelectedRecivedEmail();
                    });

            emailSentToTV.setCellValueFactory(new PropertyValueFactory("to"));
            emailSentTitleTV.setCellValueFactory(new PropertyValueFactory("title"));
            emailSentDateTV.setCellValueFactory(new PropertyValueFactory("date"));
            showSentEmails();
            emailSentTable.getSelectionModel().selectedItemProperty().addListener(
                    event -> {
                        showSelectedSentEmail();

                    });

        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void makeOrdTotalPTfAC(MouseEvent event) throws SQLException {
        double x = Double.parseDouble(makeOrdPriceOfPTF.getText());
        double y = Double.parseDouble(makeOrdPricrOdDTF.getText()) + x;
        makeOrdTotalPTF.setText("" + y);
    }

    @FXML
    private void makeOrdRefreshDLButAC(ActionEvent event) throws SQLException {
        showInRedyDriverTable();
    }

    @FXML
    private void makeOrdMakeOrdButAC(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Make Order");
        alert.setHeaderText("Do You Want To Start This Order ? ");
        alert.setContentText("2 min and  Driver will Start Moving ..... ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            String name = makeOrdNameTF.getText();
            String type = makeOrdTypeTF.getText();
            String Addres1 = makeOrdAddres1.getText();
            String Addres2 = makeOrdAddres2TF.getText();
            String product = makeOrdProductTF.getText();
            double priceOfproduct = Double.parseDouble(makeOrdPriceOfPTF.getText());
            double priceOfdelivery = Double.parseDouble(makeOrdPricrOdDTF.getText());
            double totalPrice = Double.parseDouble(makeOrdTotalPTF.getText());
            String dpt_num = makeOrdDepNumberTF.getText();
            String phone = makeOrdContactPhoneTF.getText();
            String notes = makeOrdNotesTF.getText();
            Timestamp now = new Timestamp(System.currentTimeMillis());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dateobj = new Date();
            String date = df.format(dateobj);

            DateFormat dff = new SimpleDateFormat("HH:mm:ss");
            Date dateobjj = new Date();
            String time = dff.format(dateobjj);
            if (makeOrdViewCustTable.getItems().isEmpty()) {
                //add new customer 
                String query = "INSERT INTO `customers` (`id`, `name`, `phone`, `addres1`, `addres2`, `lastOrder`, `numberOfOrdes`, `dp_number`)  VALUES "
                        + "( NULL ,'" + name + "', '" + phone + "', '" + Addres1 + "','" + Addres2 + "','" + now.toString() + "', '16' , '" + dpt_num + "')";
                DeliverySystem.statement.executeUpdate(query);
                String q = "INSERT INTO `wait list` (`id`, `name`, `type`, `addres1`, `addres2`, `date`, `time`, `totalTime`, `product`, `priceOfProduct`, `priceOfdelivery`, `totalPrice`, `contactPhone`, `call_center_emp_id`, `driverId`, `dp_nmber`, `notes`) "
                        + "VALUES(NULL, '" + name + "', '" + type + "', '" + Addres1 + "', '" + Addres2 + "', '" + date + "', '" + time + "', '0', '" + product + "', '" + priceOfproduct + "', '" + priceOfdelivery + "', '" + totalPrice + "', '" + phone + "', '"+this.EmpID+"', '" + this.DriverID + "', '" + dpt_num + "', '" + notes + "');";
                DeliverySystem.statement.executeUpdate(q);
                q = "DELETE FROM `ready_drivers` WHERE `ready_drivers`.`id` ="+this.DriverID;
                DeliverySystem.statement.executeUpdate(q);
            } else if (makeOrdViewCustTable.getSelectionModel().getSelectedItem().equals(null) || !makeOrdViewCustTable.getSelectionModel().getSelectedItem().equals(null)) {
                String q = "INSERT INTO `wait list` (`id`, `name`, `type`, `addres1`, `addres2`, `date`, `time`, `totalTime`, `product`, `priceOfProduct`, `priceOfdelivery`, `totalPrice`, `contactPhone`, `call_center_emp_id`, `driverId`, `dp_nmber`, `notes`) "
                        + "VALUES(NULL, '" + name + "', '" + type + "', '" + Addres1 + "', '" + Addres2 + "', '" + date + "', '" + time + "', '0', '" + product + "', '" + priceOfproduct + "', '" + priceOfdelivery + "', '" + totalPrice + "', '" + phone + "', '"+this.EmpID+"', '" + this.DriverID + "', '" + dpt_num + "', '" + notes + "');";
                DeliverySystem.statement.executeUpdate(q);
                 q = "DELETE FROM `ready_drivers` WHERE `ready_drivers`.`id` ="+this.DriverID;
                DeliverySystem.statement.executeUpdate(q);
            }
            clearMakeOrder();
        }
    }

    @FXML
    private void makeOrdClearButAC(ActionEvent event) throws SQLException {
        clearMakeOrder();

    }

    @FXML
    private void makeOrdTapAC(Event event) throws SQLException {
        showInRedyDriverTable();
    }

    @FXML
    private void makeOrdNameTFAC(KeyEvent event) {
        String input = makeOrdNameTF.getText();
        makeOrdViewCustTable.getItems().clear();
        for (int i = 0; i < AllCustomer.size(); i++) {
            if (input.equalsIgnoreCase(AllCustomer.get(i).getName())) {
                makeOrdViewCustTable.getItems().add(AllCustomer.get(i));
                break;
            }
        }
    }

    private void showSelectedDriver() {
        usersClasses.ready_drivers driver = makeOrdReadyDriversTable.getSelectionModel().getSelectedItem();
        if (driver != null) {
            this.DriverID = driver.getId();
        }
    }

    private void showSelectedCustomer() {
        usersClasses.Customers customer = makeOrdViewCustTable.getSelectionModel().getSelectedItem();
        if (customer != null) {
            makeOrdAddres1.setText(customer.getAddres1());
            makeOrdAddres2TF.setText(customer.getAddres2());
            makeOrdDepNumberTF.setText(customer.getDp_number());
            makeOrdContactPhoneTF.setText(customer.getPhone());

        }
    }

    public void showInRedyDriverTable() throws SQLException {
        makeOrdReadyDriversTable.getSelectionModel().clearSelection();
        makeOrdReadyDriversTable.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `ready_drivers`");
        makeOrdReadyDriversTable.getItems().clear();
        while (rs.next()) {
            usersClasses.ready_drivers driver = new usersClasses.ready_drivers();
            driver.setId(rs.getInt("id"));
            driver.setName(rs.getString("name"));
            driver.setTransportaion(rs.getString("transportaion"));
            driver.setWaiting_time(rs.getString("waiting_time"));
            makeOrdReadyDriversTable.getItems().add(driver);
        }
    }

    public void clearMakeOrder() throws SQLException {

        makeOrdAddres1.setText("");
        makeOrdAddres2TF.setText("");
        makeOrdContactPhoneTF.setText("");
        makeOrdDepNumberTF.setText("");
        makeOrdNameTF.setText("");
        makeOrdNotesTF.setText("");
        makeOrdPriceOfPTF.setText("");
        makeOrdPricrOdDTF.setText("");
        makeOrdProductTF.setText("");
        makeOrdTotalPTF.setText("");
        makeOrdTypeTF.setText("");
        showInRedyDriverTable();
        makeOrdViewCustTable.getItems().clear();

    }

    @FXML
    private void watingOrdDeleteButAC(ActionEvent event) throws SQLException, ParseException {
      
    }

    @FXML
    private void watingOrdclearButAC(ActionEvent event) throws SQLException, ParseException {
        cleanWaitingOrders();

    }

    @FXML
    private void watingOrdTapAC(Event event) throws SQLException, ParseException {
        showInwaitingOrdersTable();
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
            }
            watingOrdDrIdLB.setText("" + order.getDriverId());
            rs = DeliverySystem.statement.executeQuery("SELECT * FROM `drivers` WHERE id =" + order.getDriverId());
            while (rs.next()) {
                watingOrdDrNameLB.setText(rs.getString("name"));
                watingOrdDrTranLB.setText(rs.getString("transportation"));
                watingOrdDrPhone.setText(rs.getString("phone"));
                watingOrdDrEmailLB.setText(rs.getString("email"));
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
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `wait list`");
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
        watingOrdDrIdLB.setText("empty");
        watingOrdDrNameLB.setText("empty");
        watingOrdDrEmailLB.setText("empty");
        watingOrdDrTranLB.setText("empty");
        watingOrdDrPhone.setText("empty");
        watingOrdAddress2LB.setText("empty");
        watingOrdProductLB.setText("empty");
        watingOrdPODLB.setText("empty");
        watingOrdPOPLB.setText("empty");
        watingOrdNotesTA.setText("empty");
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
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `orderss record`");
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
                    + " (NULL, '"+this.empemail+"', '"+emailTo+"', '"+title+"','"+timestamp+"', '"+contentOfEmails+"');";
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
        String query = "SELECT * FROM `emails`WHERE `emails`.`to` ='" + this.empemail + "'";
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
        String query = "SELECT * FROM `emails` WHERE `emails`.`from` ='" + this.empemail + "'";
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

