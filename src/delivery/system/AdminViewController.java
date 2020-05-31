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
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author momen-ms
 */
public class AdminViewController implements Initializable {

    @FXML
    private Tab employeesTabPane;
    @FXML
    private Tab empAllTabPane;
    @FXML
    private TableView<usersClasses.employees> EmpAllTableView;
    @FXML
    private TableColumn<usersClasses.employees, Integer> empAllTvId;
    @FXML
    private TableColumn<usersClasses.employees, String> empAllTvName;
    @FXML
    private TableColumn<usersClasses.employees, String> empAllTvLocal_tel;
    @FXML
    private TableColumn<usersClasses.employees, String> empAllTvPhone;
    @FXML
    private TableColumn<usersClasses.employees, String> empAllTvState;
    @FXML
    private TextField empAllNameTF;
    @FXML
    private TextField empAllPhoneTF;
    @FXML
    private TextField empAllEmailTF;
    @FXML
    private TextField empAllLocalTelTF;
    @FXML
    private TextField empAllSalaryTF;
    @FXML
    private RadioButton empAllAvtiveRA;
    @FXML
    private ToggleGroup empstate;
    @FXML
    private RadioButton empAllinaciveRA;
    @FXML
    private Button empAllUpdateButton;
    @FXML
    private Button empAllDeleteButton;
    @FXML
    private Button empAllClearButton;
    @FXML
    private Tab empAddTabPane;
    @FXML
    private TextField empAddIdTF;
    @FXML
    private TextField empAddNameTF;
    @FXML
    private TextField empAddPhoneTF;
    @FXML
    private TextField empAddEmailTF;
    @FXML
    private TextField empaddLocalTelTF;
    @FXML
    private TextField empAddSalaryTF;
    @FXML
    private ToggleGroup empAddstate;
    @FXML
    private RadioButton empaddInavtiveRA;
    @FXML
    private Button empAddAddButton;
    @FXML
    private Button empAddClearButtone;
    @FXML
    private DatePicker empAllDofInput;
    @FXML
    private DatePicker empAddDobInput;
    @FXML
    private PasswordField empAddPassTF;
    public static String Instate;
    @FXML
    private RadioButton empaddActiveRA;
    @FXML
    private Tab driverTAB;
    @FXML
    private Tab driAllTap;
    @FXML
    private TableView<usersClasses.drivers> DriAllTableView;
    @FXML
    private TableColumn<usersClasses.drivers, Integer> driAllidTV;
    @FXML
    private TableColumn<usersClasses.drivers, String> driAllNameTV;
    @FXML
    private TableColumn<usersClasses.drivers, String> driAllPhoneTV;
    @FXML
    private TableColumn<usersClasses.drivers, String> driAllTransTV;
    @FXML
    private TableColumn<usersClasses.drivers, String> driAllStateTV;
    @FXML
    private TextField driUpNameTF;
    @FXML
    private TextField driUpPhoneTF;
    @FXML
    private TextField driUpEmailTF;
    @FXML
    private TextField driUpTras;
    @FXML
    private TextField DriUpSalaryTF;
    @FXML
    private ToggleGroup driUpstate;
    @FXML
    private Button driUpdateBut;
    @FXML
    private Button driDeleteBut;
    @FXML
    private Button driAllClearBut;
    @FXML
    private DatePicker driUPDoBTF;
    @FXML
    private RadioButton driUpActiveRa;
    @FXML
    private RadioButton driUpInactiveRa;
    @FXML
    private TextField driAddIdTF;
    @FXML
    private TextField driAddNameTF;
    @FXML
    private TextField driAddPhoneTF;
    @FXML
    private TextField DriAddEmailTF;
    @FXML
    private TextField driAddPassTF;
    @FXML
    private TextField driAddTrancTF;
    @FXML
    private TextField driAddSalaryTF;
    @FXML
    private RadioButton driAddActiveRa;
    @FXML
    private ToggleGroup driAddstate;
    @FXML
    private RadioButton driAddInactiveRa;
    @FXML
    private DatePicker driAddDobTF;
    @FXML
    private Button driAddAddBut;
    @FXML
    private Button driAddClearBut;
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
    private Button watingOrdDeleteBut;
    @FXML
    private Button watingOrdclearBut;
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
    private Button AllOrdDeleteBut;
    @FXML
    private Button AllOrdClearBut;
    @FXML
    private Tab EmpRocordTap;
    @FXML
    private TableView<usersClasses.employees_records> EmpRocordTable;
    @FXML
    private TableColumn<usersClasses.employees_records, Integer> EmpRocordIdTV;
    @FXML
    private TableColumn<usersClasses.employees_records, String> EmpRocordNameTV;
    @FXML
    private TableColumn<usersClasses.employees_records, Timestamp> EmpRocordDateTV;
    @FXML
    private TextField EmpRocordsearchTF;
    @FXML
    private Tab DrivRecordTap;
    @FXML
    private TableView<usersClasses.drivers_records> DrivRecordTable;
    @FXML
    private TableColumn<usersClasses.drivers_records, Integer> driverRecordIdTV;
    @FXML
    private TableColumn<usersClasses.drivers_records, String> driverRecordNameID;
    @FXML
    private TableColumn<usersClasses.drivers_records, Timestamp> driverRecordDateTV;
    @FXML
    private TextField driverRecordSearchTF;
    private ArrayList<usersClasses.employees_records> AllempRec;
    private ArrayList<usersClasses.drivers_records> AlldrivRec;
    @FXML
    private Button EmpRocordClearBut;
    @FXML
    private Button driverRecordClearBut;
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

    public static String Adminemail;
    public static String AdminName;
    public static String AdminPass;
    @FXML
    private Tab profileTap;
    @FXML
    private Label profileName;
    @FXML
    private Label profileEmail;
    @FXML
    private PasswordField profileoldpass;
    @FXML
    private PasswordField profileNewPass;
    @FXML
    private Button profileSetPassBut;
    @FXML
    private Button profileLogOutBut;
    @FXML
    private Tab CustomerTap;
    @FXML
    private TableView<usersClasses.Customers> CustomrtTableVirew;
    @FXML
    private TableColumn<usersClasses.Customers, String> CustomerViewIdTV;
    @FXML
    private TableColumn<usersClasses.Customers, String> CustomerViewNamTV;
    @FXML
    private TableColumn<usersClasses.Customers, Integer> CustomerViewNumberOOTV;
    @FXML
    private TableColumn<usersClasses.Customers, String> CustomerViewLasOrdTV;
    @FXML
    private TextField CustomerViewSearchTF;
    @FXML
    private TextField CustomerViewnameTF;
    @FXML
    private TextField CustomerViewPhoneTF;
    @FXML
    private TextField CustomerViewAddres1TF;
    @FXML
    private TextField CustomerViewAddres2TF;
    @FXML
    private TextField CustomerViewDPNumTF;
    @FXML
    private Button CustomerViewUpdateBut;
    @FXML
    private Button CustomerViewDeleteBut;
    @FXML
    private Button CustomerViewClearBut;
    @FXML
    private Button CustomerViewClearShearchBut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            empAllTvId.setCellValueFactory(new PropertyValueFactory("id"));
            empAllTvName.setCellValueFactory(new PropertyValueFactory("name"));
            empAllTvLocal_tel.setCellValueFactory(new PropertyValueFactory("local_tel"));
            empAllTvPhone.setCellValueFactory(new PropertyValueFactory("phone"));
            empAllTvState.setCellValueFactory(new PropertyValueFactory("state"));
            EmpAllTableView.getSelectionModel().selectedItemProperty().addListener(
                    event -> showSelectedEmployee());
            showInTable();
            driAllidTV.setCellValueFactory(new PropertyValueFactory("id"));
            driAllNameTV.setCellValueFactory(new PropertyValueFactory("name"));
            driAllPhoneTV.setCellValueFactory(new PropertyValueFactory("phone"));
            driAllTransTV.setCellValueFactory(new PropertyValueFactory("transportation"));
            driAllStateTV.setCellValueFactory(new PropertyValueFactory("state"));
            DriAllTableView.getSelectionModel().selectedItemProperty().addListener(
                    event -> showSelectedDriver());

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

            EmpRocordIdTV.setCellValueFactory(new PropertyValueFactory("id"));
            EmpRocordNameTV.setCellValueFactory(new PropertyValueFactory("name"));
            EmpRocordDateTV.setCellValueFactory(new PropertyValueFactory("date"));
            showEmpRecprd();
            driverRecordIdTV.setCellValueFactory(new PropertyValueFactory("id"));
            driverRecordNameID.setCellValueFactory(new PropertyValueFactory("name"));
            driverRecordDateTV.setCellValueFactory(new PropertyValueFactory("date"));
            showDriRecprd();

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

            CustomerViewIdTV.setCellValueFactory(new PropertyValueFactory("id"));
            CustomerViewNamTV.setCellValueFactory(new PropertyValueFactory("name"));
            CustomerViewNumberOOTV.setCellValueFactory(new PropertyValueFactory("numberOfOrdes"));
            CustomerViewLasOrdTV.setCellValueFactory(new PropertyValueFactory("lastOrder"));
            showInCusomerTable();
            CustomrtTableVirew.getSelectionModel().selectedItemProperty().addListener(
                    event -> {
                        showSelectedCustomer();
                    });
            
           
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void empAllAvtiveRaAC(ActionEvent event) {
        this.Instate = "active";
    }

    @FXML
    private void empAllUpdateButtonAC(ActionEvent event) throws SQLException {
        usersClasses.employees employee = EmpAllTableView.getSelectionModel().getSelectedItem();
        if (employee != null) {
            int IdToUpdate = employee.getId();
            String newName = empAllNameTF.getText();
            String newPhone = empAllPhoneTF.getText();
            String newTel = empAllLocalTelTF.getText();
            String newEmail = empAllEmailTF.getText();
            String newSallary = empAllSalaryTF.getText();
            String newDob = empAllDofInput.getValue().toString();
            String q = "UPDATE employees SET name ='" + newName + "', phone ='" + newPhone + "', email ='" + newEmail + "', dob ='" + newDob + "', local_tel ='" + newTel + "', salary ='" + newSallary + "', state ='" + this.Instate + "' WHERE id ='" + IdToUpdate + "';";
            DeliverySystem.statement.executeUpdate(q);
            empAllNameTF.setText("");
            empAllPhoneTF.setText("");
            empAllLocalTelTF.setText("");
            empAllEmailTF.setText("");
            empAllSalaryTF.setText("");
            empAllDofInput.setValue(null);
            empstate.selectToggle(null);
            showInTable();
        }
    }

    @FXML
    private void empAllDeleteButtonAC(ActionEvent event) throws SQLException {
        usersClasses.employees employee = EmpAllTableView.getSelectionModel().getSelectedItem();
        if (employee != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Employee");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the employee will deleted from database..... ");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int IdToDelete = employee.getId();
                String q = "DELETE FROM `employees` WHERE `employees`.`id` =" + IdToDelete;
                DeliverySystem.statement.executeUpdate(q);
                empAllNameTF.setText("");
                empAllPhoneTF.setText("");
                empAllLocalTelTF.setText("");
                empAllEmailTF.setText("");
                empAllSalaryTF.setText("");
                empAllDofInput.setValue(null);
                empstate.selectToggle(null);
                showInTable();
            } else {

            }
        }
    }

    @FXML
    private void empAllClearButtonAC(ActionEvent event) throws SQLException {
        empAllNameTF.setText("");
        empAllPhoneTF.setText("");
        empAllLocalTelTF.setText("");
        empAllEmailTF.setText("");
        empAllSalaryTF.setText("");
        empAllDofInput.setValue(null);
        empstate.selectToggle(null);
        showInTable();

    }

    @FXML
    private void empAddAddButtonAC(ActionEvent event) throws SQLException {
        Integer InId = Integer.parseInt(empAddIdTF.getText());
        String InName = empAddNameTF.getText();
        String Inphone = empAddPhoneTF.getText();
        String InLocalTel = empaddLocalTelTF.getText();
        String InEmail = empAddEmailTF.getText();
        String InDob = empAddDobInput.getValue().toString();
        double Insallay = Double.parseDouble(empAddSalaryTF.getText());
        String InPass = empAddPassTF.getText();
        InPass = DeliverySystem.hash(InPass);
        String q = "INSERT INTO `employees` (`id`, `name`, `phone`, `email`, `pass`, `dob`, `local_tel`, `salary`, `state`) VALUES ('" + InId + "','" + InName + "', '" + Inphone + "', '" + InEmail + "', '" + InPass + "', '" + InDob + "', '" + InLocalTel + "', '" + Insallay + "', '" + this.Instate + "');";
        DeliverySystem.statement.executeUpdate(q);

    }

    @FXML
    private void empAddClearButtonAC(ActionEvent event) {
        empAddIdTF.setText("");
        empAddNameTF.setText("");
        empAddPhoneTF.setText("");
        empAddPassTF.setText("");
        empaddLocalTelTF.setText("");
        empAddSalaryTF.setText("");
        empAddEmailTF.setText("");
        empAddDobInput.setValue(null);
        empAddstate.selectToggle(null);

    }

    @FXML
    private void empAllTabPaneAC(Event event) throws SQLException {
        showInTable();

    }

    private void showSelectedEmployee() {
        usersClasses.employees employee = EmpAllTableView.getSelectionModel().getSelectedItem();
        if (employee != null) {
            empAllNameTF.setText(String.valueOf(employee.getName()));
            empAllPhoneTF.setText(String.valueOf(employee.getPhone()));
            empAllLocalTelTF.setText(String.valueOf(employee.getLocal_tel()));
            empAllEmailTF.setText(String.valueOf(employee.getEmail()));
            empAllSalaryTF.setText(String.valueOf(employee.getSalary()));
            if (String.valueOf(employee.getState()).equalsIgnoreCase("active")) {
                empstate.selectToggle(empAllAvtiveRA);
                this.Instate = "active";
            } else {
                empstate.selectToggle(empAllinaciveRA);
                this.Instate = "inactive";
            }
            empAllDofInput.setValue(LocalDate.parse(employee.getDob()));
        }
    }

    @FXML
    private void empAddActiveRaAC(ActionEvent event) {
        this.Instate = "active";
    }

    @FXML
    private void empAllInactivRaAC(ActionEvent event) {
        this.Instate = "inactive";
    }

    @FXML
    private void empAllInvtiveRaAC(ActionEvent event) {
        this.Instate = "inactive";

    }

    public void showInTable() throws SQLException {
        EmpAllTableView.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("Select * From employees");
        EmpAllTableView.getItems().clear();
        while (rs.next()) {
            usersClasses.employees employee = new usersClasses.employees();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setPhone(rs.getString("phone"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setEmail(rs.getString("email"));
            employee.setLocal_tel(rs.getString("local_tel"));
            employee.setDob(rs.getString("dob"));
            employee.setState(rs.getString("state"));
            EmpAllTableView.getItems().add(employee);
        }
    }

    @FXML
    private void driUpActiveRaAC(ActionEvent event) {
        this.Instate = "active";
    }

    @FXML
    private void driUpInactiveRaAC(ActionEvent event) {
        this.Instate = "inactive";
    }

    @FXML
    private void driUpdateButAC(ActionEvent event) throws SQLException {
        usersClasses.drivers driver = DriAllTableView.getSelectionModel().getSelectedItem();
        if (driver != null) {
            int IdToUpdate = driver.getId();
            String newName = driUpNameTF.getText();
            String newPhone = driUpPhoneTF.getText();
            String newTrans = driUpTras.getText();
            String newEmail = driUpEmailTF.getText();
            String newSallary = DriUpSalaryTF.getText();
            String newDob = driUPDoBTF.getValue().toString();
            String q = "UPDATE drivers SET name ='" + newName + "', phone ='" + newPhone + "', email ='" + newEmail + "',transportation ='" + newTrans + "', dob ='" + newDob + "', salary ='" + newSallary + "', state ='" + this.Instate + "' WHERE id ='" + IdToUpdate + "';";
            DeliverySystem.statement.executeUpdate(q);
            driUpNameTF.setText("");
            driUpPhoneTF.setText("");
            driUpEmailTF.setText("");
            driUpTras.setText("");
            DriUpSalaryTF.setText("");
            driUPDoBTF.setValue(null);
            driUpstate.selectToggle(null);
            showInDriverTable();

        }

    }

    @FXML
    private void dirDeleteButAC(ActionEvent event) throws SQLException {
        usersClasses.drivers driver = DriAllTableView.getSelectionModel().getSelectedItem();
        if (driver != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Driver");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the Driver will deleted from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int IdToDelete = driver.getId();
                String q = "DELETE FROM drivers WHERE id =" + IdToDelete;
                DeliverySystem.statement.executeUpdate(q);
                driUpNameTF.setText("");
                driUpPhoneTF.setText("");
                driUpEmailTF.setText("");
                driUpTras.setText("");
                DriUpSalaryTF.setText("");
                driUPDoBTF.setValue(null);
                driUpstate.selectToggle(null);
                showInDriverTable();
            } else {

            }
        }

    }

    @FXML
    private void driAllClearButAC(ActionEvent event) throws SQLException {
        driUpNameTF.setText("");
        driUpPhoneTF.setText("");
        driUpEmailTF.setText("");
        driUpTras.setText("");
        DriUpSalaryTF.setText("");
        driUPDoBTF.setValue(null);
        driUpstate.selectToggle(null);
        showInDriverTable();

    }

    @FXML
    private void driAllTapAC(Event event) throws SQLException {
        showInDriverTable();
    }

    @FXML
    private void driAddActiveRaAC(ActionEvent event) {
        this.Instate = "active";
    }

    @FXML
    private void driAddInactiveRaAC(ActionEvent event) {
        this.Instate = "inactive";
    }

    @FXML
    private void driAddAddButAction(ActionEvent event) throws SQLException {
        Integer InId = Integer.parseInt(driAddIdTF.getText());
        String InName = driAddNameTF.getText();
        String Inphone = driAddPhoneTF.getText();
        String Intranse = driAddTrancTF.getText();
        String InEmail = DriAddEmailTF.getText();
        String InDob = driAddDobTF.getValue().toString();
        double Insallay = Double.parseDouble(driAddSalaryTF.getText());
        String InPass = driAddPassTF.getText();
        InPass = DeliverySystem.hash(InPass);
        String q = "INSERT INTO `drivers` (`id`, `name`, `phone`, `email`, `pass`, `transportation`, `dob`,`salary`, `state`) VALUES ('" + InId + "','" + InName + "', '" + Inphone + "', '" + InEmail + "', '" + InPass + "', '" + Intranse + "', '" + InDob + "','" + Insallay + "', '" + this.Instate + "');";
        DeliverySystem.statement.executeUpdate(q);
        driAddIdTF.setText("");
        driAddNameTF.setText("");
        driAddPassTF.setText("");
        driAddPhoneTF.setText("");
        DriAddEmailTF.setText("");
        driAddSalaryTF.setText("");
        driAddTrancTF.setText("");
        driAddDobTF.setValue(null);
        driAddstate.selectToggle(null);
    }

    @FXML
    private void driAddClearButAction(ActionEvent event) {
        driAddIdTF.setText("");
        driAddNameTF.setText("");
        driAddPassTF.setText("");
        driAddPhoneTF.setText("");
        DriAddEmailTF.setText("");
        driAddSalaryTF.setText("");
        driAddTrancTF.setText("");
        driAddDobTF.setValue(null);
        driAddstate.selectToggle(null);

    }

    public void showInDriverTable() throws SQLException {
        DriAllTableView.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `drivers`");
        DriAllTableView.getItems().clear();
        while (rs.next()) {
            usersClasses.drivers driver = new usersClasses.drivers();
            driver.setId(rs.getInt("id"));
            driver.setName(rs.getString("name"));
            driver.setPhone(rs.getString("phone"));
            driver.setSalary(rs.getDouble("salary"));
            driver.setEmail(rs.getString("email"));
            driver.setTransportation(rs.getString("transportation"));
            driver.setDob(rs.getString("dob"));
            driver.setState(rs.getString("state"));
            DriAllTableView.getItems().add(driver);
        }
    }

    private void showSelectedDriver() {
        usersClasses.drivers driver = DriAllTableView.getSelectionModel().getSelectedItem();
        if (driver != null) {
            driUpNameTF.setText(String.valueOf(driver.getName()));
            driUpPhoneTF.setText(String.valueOf(driver.getPhone()));
            driUpTras.setText(String.valueOf(driver.getTransportation()));
            driUpEmailTF.setText(String.valueOf(driver.getEmail()));
            DriUpSalaryTF.setText(String.valueOf(driver.getSalary()));
            if (String.valueOf(driver.getState()).equalsIgnoreCase("active")) {
                driUpstate.selectToggle(driUpActiveRa);
                this.Instate = "active";
            } else {
                driUpstate.selectToggle(driUpInactiveRa);
                this.Instate = "inactive";
            }
            driUPDoBTF.setValue(LocalDate.parse(driver.getDob()));
        }
    }

    @FXML
    private void watingOrdDeleteButAC(ActionEvent event) throws SQLException, ParseException {
        usersClasses.waitList order = watingOrdAllordersTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Order");
        alert.setHeaderText("Are You Sure ? ");
        alert.setContentText("In this case the order will deleted from database..... ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int IdToDelete = order.getId();
            String q = "DELETE FROM `wait list` WHERE `wait list`.`id` =" + IdToDelete;
            DeliverySystem.statement.executeUpdate(q);
            cleanWaitingOrders();
        }
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
        DeliverySystem.updateDatabaseTime();
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
    private void AllOrdDeleteButAC(ActionEvent event) throws SQLException {
        usersClasses.orderss_record order = AllOrdtable.getSelectionModel().getSelectedItem();
        if (order != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Order");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the order will deleted from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int IdToDelete = order.getId();
                String q = "DELETE FROM `orderss record` WHERE `orderss record`.`id` =" + IdToDelete;
                DeliverySystem.statement.executeUpdate(q);
                clearAllOrderTable();
                showInAllOrdersTable();
            }
        }
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
    private void DrivRecordTapAC(Event event) throws SQLException {
        showDriRecprd();
    }

    @FXML
    private void EmpRocordTap(Event event) throws SQLException {
        showEmpRecprd();
    }

    public void showEmpRecprd() throws SQLException {
        AllempRec = new ArrayList<usersClasses.employees_records>();
        EmpRocordTable.getSelectionModel().clearSelection();
        String query = "SELECT * FROM `employees records`";
        EmpRocordTable.getItems().clear();
        ResultSet rs = DeliverySystem.statement.executeQuery(query);
        while (rs.next()) {
            usersClasses.employees_records emp = new usersClasses.employees_records();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDate(rs.getTimestamp("date"));
            EmpRocordTable.getItems().add(emp);
            AllempRec.add(emp);
        }

    }

    public void showDriRecprd() throws SQLException {
        AlldrivRec = new ArrayList<usersClasses.drivers_records>();
        DrivRecordTable.getSelectionModel().clearSelection();
        String query = "SELECT * FROM `drivers records`";
        DrivRecordTable.getItems().clear();
        ResultSet rs = DeliverySystem.statement.executeQuery(query);
        while (rs.next()) {
            usersClasses.drivers_records dri = new usersClasses.drivers_records();
            dri.setId(rs.getInt("id"));
            dri.setName(rs.getString("name"));
            dri.setDate(rs.getTimestamp("date"));
            DrivRecordTable.getItems().add(dri);
            AlldrivRec.add(dri);
        }
    }

    @FXML
    private void EmpRocordSearchTFAC(KeyEvent event) throws SQLException {
        String input = EmpRocordsearchTF.getText();
        if (!input.equalsIgnoreCase(null)) {
            EmpRocordTable.getItems().clear();
            for (int i = 0; i < AllempRec.size(); i++) {
                if (input.equalsIgnoreCase(AllempRec.get(i).getName())) {
                    EmpRocordTable.getItems().add(AllempRec.get(i));
                }
            }
        } else {
            showEmpRecprd();
        }

    }

    @FXML
    private void EmpRocordClearButAC(ActionEvent event) throws SQLException {
        EmpRocordsearchTF.setText("");
        showEmpRecprd();
    }

    @FXML
    private void driverRecordSearchTFAC(KeyEvent event) throws SQLException {
        String input = driverRecordSearchTF.getText();
        if (!input.equalsIgnoreCase(null)) {
            DrivRecordTable.getItems().clear();
            for (int i = 0; i < AlldrivRec.size(); i++) {
                if (input.equalsIgnoreCase(AlldrivRec.get(i).getName())) {
                    DrivRecordTable.getItems().add(AlldrivRec.get(i));
                }
            }
        } else {
            showDriRecprd();
        }

    }

    @FXML
    private void driverRecordClearButAC(ActionEvent event) throws SQLException {
        driverRecordSearchTF.setText("");
        showDriRecprd();
    }

    @FXML
    private void EmailReceivedDeletebutAC(ActionEvent event) throws SQLException {
        usersClasses.emails email = EmailReceivedTableView.getSelectionModel().getSelectedItem();
        if (email != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Email");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the Email will deleted from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int IdToDelete = email.getId();
                String q = "DELETE FROM emails WHERE id =" + IdToDelete;
                DeliverySystem.statement.executeUpdate(q);
                showRecivedEmails();
            }
        }
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
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Send Email");
        alert.setHeaderText("Are You Sure ?");
        alert.setContentText("In this case the Email will Send To " + emailTo + " ..... ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String q = "INSERT INTO `emails` (`id`, `from`, `to`, `title`, `date`, `Contents`) VALUES"
                    + " (NULL, '" + this.Adminemail + "', '" + emailTo + "', '" + title + "','" + timestamp + "', '" + contentOfEmails + "');";
            DeliverySystem.statement.executeUpdate(q);
        }
        newEmailToTF.setText("");
        newEmailContetnTA.setText("");
        newEmailTitleTF.setText("");
    }

    @FXML
    private void emailSentDeleteButAC(ActionEvent event) throws SQLException {
        usersClasses.emails email = emailSentTable.getSelectionModel().getSelectedItem();
        if (email != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Email");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the Email will deleted from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int IdToDelete = email.getId();
                String q = "DELETE FROM emails WHERE id =" + IdToDelete;
                DeliverySystem.statement.executeUpdate(q);
                showSentEmails();
            }
        }
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
        String query = "SELECT * FROM `emails`WHERE `emails`.`to` ='" + this.Adminemail + "'";
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
        String query = "SELECT * FROM `emails` WHERE `emails`.`from` ='" + this.Adminemail + "'";
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

    @FXML
    private void profileSetPassButAc(ActionEvent event) throws SQLException {
        if (DeliverySystem.hash(profileoldpass.getText()).equals(this.AdminPass)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Change Password");
            alert.setHeaderText("Are You Sure You Want To Cahnge Password ? ");
            alert.setContentText("In this case the password will changed from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                String newPass = DeliverySystem.hash(profileNewPass.getText());
                this.AdminPass = newPass;
                String query = "UPDATE `administrators` SET `pass` = '" + newPass + "' WHERE `administrators`.`email` = '" + this.Adminemail + "'";
                DeliverySystem.statement.executeUpdate(query);
                Alert a = new Alert(AlertType.INFORMATION);
                a.setTitle("Information Dialog");
                a.setHeaderText(null);
                a.setContentText("The Password Is Changed Successfully");
                a.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorect Inputs");
            alert.setHeaderText(" Password Is Incorect");
            alert.setContentText("Please check your Inputs");
            alert.showAndWait();
        }
    }

    @FXML
    private void profileLogOutButAC(ActionEvent event) throws IOException {
        this.AdminName = null;
        this.AdminPass = null;
        this.Adminemail = null;
        Pane root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene newS = new Scene(root);
        DeliverySystem.primaryStage.setScene(newS);
    }

    @FXML
    private void profileTapAC(Event event) {
        profileName.setText(this.AdminName);
        profileEmail.setText(this.Adminemail);
    }

    @FXML
    private void CustomerViewSearchTFAC(KeyEvent event) throws SQLException {
      CustomrtTableVirew.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `customers` WHERE name LIKE '%"+CustomerViewSearchTF.getText()+"%'");
        CustomrtTableVirew.getItems().clear();
        while (rs.next()) {
            usersClasses.Customers cu = new usersClasses.Customers();
            cu.setId(rs.getInt("id"));
            cu.setName(rs.getString("name"));
            cu.setPhone(rs.getString("phone"));
            cu.setLastOrder(rs.getString("lastOrder"));
            cu.setAddres1(rs.getString("addres1"));
            cu.setAddres2(rs.getString("addres2"));
            cu.setNumberOfOrdes(rs.getInt("numberOfOrdes"));
            cu.setDp_number(rs.getString("dp_number"));
            CustomrtTableVirew.getItems().add(cu);
        }  

    }

    @FXML
    private void CustomerViewUpdateButAC(ActionEvent event) throws SQLException {
         usersClasses.Customers cu = CustomrtTableVirew.getSelectionModel().getSelectedItem();
         if (cu != null) {
            int IdToUpdate = cu.getId();
            String newName = CustomerViewnameTF.getText();
            String newPhone = CustomerViewPhoneTF.getText();
            String Addres1 = CustomerViewAddres1TF.getText();
            String Addres2 = CustomerViewAddres2TF.getText();
            String dp_new = CustomerViewDPNumTF.getText();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("update Customer");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the Customer will updated from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
            String q = "UPDATE `customers` SET `name` = '"+newName+"', `phone` = '"+newPhone+"', `addres1` = '"+Addres1+"',"
                    + " `addres2` = '"+Addres2+"', `dp_number` = '"+dp_new+"' WHERE `customers`.`id` = "+IdToUpdate;
            DeliverySystem.statement.executeUpdate(q); 
            CustomerViewAddres1TF.setText("");
            CustomerViewAddres2TF.setText("");
            CustomerViewnameTF.setText("");
            CustomerViewPhoneTF.setText("");
            CustomerViewDPNumTF.setText("");
             showInCusomerTable();
            }
         } 
    }

    @FXML
    private void CustomerViewDeleteButAC(ActionEvent event) throws SQLException {
         usersClasses.Customers cu = CustomrtTableVirew.getSelectionModel().getSelectedItem();
        if (cu != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Customer");
            alert.setHeaderText("Are You Sure ? ");
            alert.setContentText("In this case the Customer will deleted from database..... ");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int IdToDelete = cu.getId();
                String q = "DELETE FROM customers WHERE id =" + IdToDelete;
                DeliverySystem.statement.executeUpdate(q);
                showInCusomerTable();
            }    
        }
    }

    @FXML
    private void CustomerViewClearButAC(ActionEvent event) throws SQLException {
            CustomerViewAddres1TF.setText("");
            CustomerViewAddres2TF.setText("");
            CustomerViewnameTF.setText("");
            CustomerViewPhoneTF.setText("");
            CustomerViewDPNumTF.setText("");
            showInCusomerTable();
    }

    @FXML
    private void CustomerTapAC(Event event) throws SQLException {
        showInCusomerTable();
    }

    public void showInCusomerTable() throws SQLException {
        CustomrtTableVirew.getSelectionModel().clearSelection();
        ResultSet rs = DeliverySystem.statement.executeQuery("SELECT * FROM `customers`");
        CustomrtTableVirew.getItems().clear();
        while (rs.next()) {
            usersClasses.Customers cu = new usersClasses.Customers();
            cu.setId(rs.getInt("id"));
            cu.setName(rs.getString("name"));
            cu.setPhone(rs.getString("phone"));
            cu.setLastOrder(rs.getString("lastOrder"));
            cu.setAddres1(rs.getString("addres1"));
            cu.setAddres2(rs.getString("addres2"));
            cu.setNumberOfOrdes(rs.getInt("numberOfOrdes"));
            cu.setDp_number(rs.getString("dp_number"));
            CustomrtTableVirew.getItems().add(cu);
        }
    }
    private void showSelectedCustomer() {
        usersClasses.Customers cu = CustomrtTableVirew.getSelectionModel().getSelectedItem();
        if (cu != null){
            CustomerViewAddres1TF.setText(String.valueOf(cu.getAddres1()));
            CustomerViewAddres2TF.setText(String.valueOf(cu.getAddres2()));
            CustomerViewnameTF.setText(String.valueOf(cu.getName()));
            CustomerViewPhoneTF.setText(String.valueOf(cu.getPhone()));
            CustomerViewDPNumTF.setText(String.valueOf(cu.getDp_number()));
        }
    }

    @FXML
    private void CustomerViewClearShearchButAC(ActionEvent event) throws SQLException {
        CustomerViewSearchTF.setText("");
        showInCusomerTable();
    }

}
