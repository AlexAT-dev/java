package com.example.lab10;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private Button AddButton;
    @FXML private TextField TxFldAdd_Surname;
    @FXML private TextField TxFldAdd_Name;
    @FXML private DatePicker DtPckAdd_Birthday;
    @FXML private TextField TxFldAdd_Phone;
    @FXML private TextField TxFldAdd_Visited;

    @FXML private Button EditButton;
    @FXML private ComboBox EditComboBox;
    @FXML private TextField TxFldEdit_Surname;
    @FXML private TextField TxFldEdit_Name;
    @FXML private DatePicker DtPckEdit_Birthday;
    @FXML private TextField TxFldEdit_Phone;
    @FXML private TextField TxFldEdit_Visited;

    @FXML private ComboBox DeleteComboBox;

    @FXML private TableView<Patient> Table;
    @FXML private TableColumn<Patient, String> ColumnID;
    @FXML private TableColumn<Patient, String> ColumnSurname;
    @FXML private TableColumn<Patient, String> ColumnName;
    @FXML private TableColumn<Patient, String> ColumnBirthday;
    @FXML private TableColumn<Patient, String> ColumnPhone;
    @FXML private TableColumn<Patient, String> ColumnVisited;

    @FXML private RadioButton RdBtnSurname;
    @FXML private RadioButton RdBtnName;
    @FXML private TextField TxFldSearch;

    @Override public void initialize(URL url, ResourceBundle resourceBundle)  {
        ColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColumnBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        ColumnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ColumnVisited.setCellValueFactory(new PropertyValueFactory<>("visited"));

        try {
            UpdateAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void SetAlert(Alert.AlertType type, String title, String content)
    {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void UpdateAll()  throws SQLException {
        LoadComboBox();
        UpdateTable();
    }

    public void FillTable(ResultSet results) throws SQLException{
        while (results.next()) {
            int id  = results.getInt(1);
            String surname = results.getString(2);
            String name = results.getString(3);
            Date date = results.getDate(4);
            String phone = results.getString(5);
            int visited = results.getInt(6);

            Table.getItems().add(new Patient(id, surname, name, date, phone, visited));
        }
    }

    public void UpdateTable() throws SQLException {
        Table.getItems().clear();

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT";
        ResultSet results = stat.executeQuery(sql);
        FillTable(results);

    }

    public int AutoIncrement() throws SQLException {
        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT MAX(id) FROM PATIENT";
        ResultSet results = stat.executeQuery(sql);

        if(results.next())
        {
            return results.getInt(1) + 1;
        }

        return 1;
    }

    public void LoadComboBox() throws SQLException {
        EditComboBox.getItems().clear();
        DeleteComboBox.getItems().clear();

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT";
        ResultSet results = stat.executeQuery(sql);

        while(results.next()){
            int id = results.getInt(1);
            String surname = results.getString(2);
            String name = results.getString(3);
            EditComboBox.getItems().add(id + " " + surname + " " + name);
            DeleteComboBox.getItems().add(id + " " + surname + " " + name);
        }

    }

    @FXML
    public void EditComboBoxAction() throws SQLException {
        if(EditComboBox.getValue() == null) return;

        int index = Integer.parseInt(EditComboBox.getValue().toString().split(" ")[0]);

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT WHERE ID = " + index;
        ResultSet results = stat.executeQuery(sql);

        if(results.next()) {
            String surname = results.getString(2);
            String name = results.getString(3);
            Date date = results.getDate(4);
            String phone = results.getString(5);
            int visited = results.getInt(6);

            TxFldEdit_Surname.setText(surname);
            TxFldEdit_Name.setText(name);
            if(date != null) DtPckEdit_Birthday.setValue(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            TxFldEdit_Phone.setText(phone);
            TxFldEdit_Visited.setText(Integer.toString(visited));
        }


    }

    @FXML
    public void AddButtonAction() {
        try {
            int id = AutoIncrement();
            String surname = TxFldAdd_Surname.getText();
            String name = TxFldAdd_Name.getText();
            Date birthday;
            String phone = TxFldAdd_Phone.getText();
            int visited;

            if(surname.isEmpty()) throw new Exception("Text Field 'Surname' is null!");
            if(name.isEmpty()) throw new Exception("Text Field 'Name' is null!");
            if(DtPckAdd_Birthday.getValue() == null) throw new Exception("DatePicker is null!");
            if(phone.isEmpty()) throw new Exception("Text Field 'Phone' is null!");
            if(phone.charAt(0) != '+') throw new Exception("Phone number should starts with +.");
            if(phone.length() < 10) throw new Exception("Too few numbers!");
            if(phone.length() > 13) throw new Exception("Too many numbers!");

            if(TxFldAdd_Visited.getText().isEmpty()) throw new Exception("Text Field 'Visited count' is null!");
            birthday = Date.from(DtPckAdd_Birthday.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());


            visited = Integer.parseInt(TxFldAdd_Visited.getText());

            if(visited < 0) throw new Exception("Count of visit can't be lower than zero!");

            String str = new SimpleDateFormat("dd-MM-yyyy").format(birthday);

            Statement stat = HelloApplication.conn.createStatement();
            String sql = "INSERT INTO PATIENT(id, surname, name, birthday, phone, visited) VALUES("+id+", '"+surname+"', '"+name+"', '" + str + "', '"+phone+"', "+visited+")";
            stat.executeUpdate(sql);


            SetAlert(Alert.AlertType.INFORMATION, "Added!", "New information added!");

            TxFldAdd_Surname.setText("");
            TxFldAdd_Name.setText("");
            DtPckAdd_Birthday.setValue(null);
            TxFldAdd_Phone.setText("");
            TxFldAdd_Visited.setText("");

            UpdateAll();

        }
        catch (NumberFormatException exception)
        {
            SetAlert(Alert.AlertType.ERROR, "ERROR!", "Input number!");
        }
        catch (Exception exception)
        {
            SetAlert(Alert.AlertType.ERROR, "ERROR!", exception.getMessage());
        }

    }

    @FXML
    public void EditButtonAction() {
        try {
            if(EditComboBox.getValue() == null) throw new Exception("Selected Patient is null!");

            int id = Integer.parseInt(EditComboBox.getValue().toString().split(" ")[0]);
            String surname = TxFldEdit_Surname.getText();
            String name = TxFldEdit_Name.getText();
            Date birthday;
            String phone = TxFldEdit_Phone.getText();
            int visited;

            if(surname.isEmpty()) throw new Exception("Text Field 'Surname' is null!");
            if(name.isEmpty()) throw new Exception("Text Field 'Name' is null!");
            if(DtPckEdit_Birthday.getValue() == null) throw new Exception("DatePicker is null!");
            if(phone.isEmpty()) throw new Exception("Text Field 'Phone' is null!");
            if(phone.charAt(0) != '+') throw new Exception("Phone number should starts with +.");
            if(phone.length() < 10) throw new Exception("Too few numbers!");
            if(phone.length() > 13) throw new Exception("Too many numbers!");

            if(TxFldEdit_Visited.getText().isEmpty()) throw new Exception("Text Field 'Visited count' is null!");
            birthday = Date.from(DtPckEdit_Birthday.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());


            visited = Integer.parseInt(TxFldEdit_Visited.getText());

            if(visited < 0) throw new Exception("Count of visit can't be lower than zero!");

            String str = new SimpleDateFormat("dd-MM-yyyy").format(birthday);

            Statement stat = HelloApplication.conn.createStatement();
            String sql = "UPDATE PATIENT SET surname = '" + surname + "', name = '" +name+ "' , birthday = '" +str+"', phone = '" + phone + "', visited = " + visited + " where id = " +id;
            stat.executeUpdate(sql);



            SetAlert(Alert.AlertType.INFORMATION, "Edited!", "Information edited!");
            EditComboBox.setValue(null);
            TxFldEdit_Surname.setText("");
            TxFldEdit_Name.setText("");
            DtPckEdit_Birthday.setValue(null);
            TxFldEdit_Phone.setText("");
            TxFldEdit_Visited.setText("");

            UpdateAll();

        }
        catch (NumberFormatException exception)
        {
            SetAlert(Alert.AlertType.ERROR, "ERROR!", "Input number!");
        }
        catch (Exception exception)
        {
            SetAlert(Alert.AlertType.ERROR, "ERROR!", exception.getMessage());
        }

    }
    @FXML
    public void DeleteButtonAction() {
        try {
            if(DeleteComboBox.getValue() == null) throw new Exception("Selected Patient is null!");
            int id = Integer.parseInt(DeleteComboBox.getValue().toString().split(" ")[0]);

            Statement stat = HelloApplication.conn.createStatement();
            String sql = "DELETE FROM PATIENT WHERE id = " +id;
            stat.executeUpdate(sql);

            SetAlert(Alert.AlertType.INFORMATION, "Deleted!", "Information deleted!");
            UpdateAll();

        }
        catch (Exception exception)
        {
            SetAlert(Alert.AlertType.ERROR, "ERROR!", exception.getMessage());
        }
    }

    public void SearchButtonClick() {
        try {
            Table.getItems().clear();

            String key = TxFldSearch.getText();
            if(key.isEmpty()) throw new Exception("Search field is null!");

            String searchField = (RdBtnName.isSelected() ? "name" : "surname" );

            Statement stat = HelloApplication.conn.createStatement();
            String sql = "SELECT * FROM PATIENT WHERE " +searchField+ " LIKE '" + key + "%'";
            ResultSet results = stat.executeQuery(sql);
            FillTable(results);
        }
        catch (Exception exception)
        {
            SetAlert(Alert.AlertType.ERROR, "ERROR!", exception.getMessage());
        }
    }

    public void SortButtonClick() throws SQLException {
        Table.getItems().clear();

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT ORDER BY visited DESC";
        ResultSet results = stat.executeQuery(sql);
        FillTable(results);
    }

    public void Sort2ButtonClick() throws SQLException {
        Table.getItems().clear();

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT ORDER BY name ASC, surname ASC";
        ResultSet results = stat.executeQuery(sql);
        FillTable(results);
    }

    public void NotVisited() throws SQLException {
        Table.getItems().clear();

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT WHERE visited = 0";
        ResultSet results = stat.executeQuery(sql);
        FillTable(results);
    }

    public void BirthdayToday() throws SQLException {
        Table.getItems().clear();

        Statement stat = HelloApplication.conn.createStatement();
        String sql = "SELECT * FROM PATIENT WHERE to_char(birthday, 'DD.MM') = to_char(sysdate, 'DD.MM')";
        ResultSet results = stat.executeQuery(sql);
        FillTable(results);
    }

}