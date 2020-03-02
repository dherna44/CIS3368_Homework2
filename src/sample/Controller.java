package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //FXML to use the added objects in the user interface:
    @FXML
    private TextField filterField;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> Name;
    @FXML
    private TableColumn<Student, String> ID;
    @FXML
    private TableColumn<Student, String> Age;
    @FXML
    private TableColumn<Student, String> Major;
    @FXML
    private TableColumn<Student, String> GPA;

    //To create ObservableList to store the student data:
    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        //Assigns the created student variables to their respective column in the TableView:
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        Major.setCellValueFactory(new PropertyValueFactory<>("Major"));
        GPA.setCellValueFactory(new PropertyValueFactory<>("GPA"));

        //Creates new students based on Student class attributes:
        Student student1 = new Student("Carlos Meyer", 1001, 20, "Biology", 3.45);
        Student student2 = new Student("Michael Chase", 1002, 25, "Business", 3.24);
        Student student3 = new Student("Alice Wonder", 1003, 22, "Arts", 3.11);
        Student student4 = new Student("Charles Johnson", 1004, 35, "Math", 3.67);
        Student student5 = new Student("Rebecca Hart", 1005, 30, "Biology", 3.01);
        Student student6 = new Student("Sharone Smith", 1006, 21, "Math", 3.89);
        Student student7 = new Student("Tracy Matthews", 1007, 20, "Engineering", 3.78);
        Student student8 = new Student("Bobby Lee", 1008, 23, "Business", 2.87);
        Student student9 = new Student("Gwen Rogers", 1009, 26, "Math", 2.95);
        Student student10 = new Student("Alexander Wittington", 1010, 28, "Computer Science", 3.99);
        Student student11 = new Student("Jose Lopez", 1011, 21, "Arts", 3.63);
        //Takes students that were created above and inserts them into the studentList:
        studentList.addAll(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11);

        //ObservableList used inside of FilteredList:
        FilteredList<Student> filteredStudents = new FilteredList<>(studentList, b -> true);
                //Adds Change listener to the "Filter Search Bar":
                filterField.textProperty().addListener((observable, oldVal, newVal) -> {
                    filteredStudents.setPredicate(student -> {

                    /*If-Else statements to take what is typed in "Filter Search Bar" and start filtering through the
                    student list:  */

                    //If nothing is typed in the search bar, the full student list will display:
                    if (newVal == null || newVal.isEmpty()) {
                        return true;
                    }

                    //Gets whatever is typed in the search bar:
                    String lowerCaseFilter = newVal.toLowerCase();

                    //Compares user entered "Name" and compares it to student list and filters list if it finds a match:
                    if (student.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }

                    //Compares user entered "Major" and compares it to student list and filters list if it finds a match:
                    else if (student.getMajor().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }

                    //Compares user entered "Age" and compares it to student list and filters list if it finds a match:
                    else if (String.valueOf(student.getAge()).indexOf(lowerCaseFilter) != -1){
                        return true;
                    }

                    //Compares user entered "ID" and compares it to student list and filters list if it finds a match:
                    else if (String.valueOf(student.getID()).indexOf(lowerCaseFilter) != -1){
                        return true;
                    }

                    //Compares user entered "GPA" and compares it to student list and filters list if it finds a match:
                    else if (String.valueOf(student.getGPA()).indexOf(lowerCaseFilter) != -1)
                        return true;
                        //If the user search input matches nothing in the student list, then "No Content in Table" will display:
                        else
                            return false;
                    });

                });

        //Puts FilteredList into SortedList:
        SortedList<Student> sortedStudents = new SortedList<>(filteredStudents);
        //Binds the TableView and SortedList comparators to filter the table:
        sortedStudents.comparatorProperty().bind(tableView.comparatorProperty());
        //Updates filtered info on table:
        tableView.setItems(sortedStudents);
    }
}
