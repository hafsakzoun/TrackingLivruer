//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


package ma.fstt.trackingl;


import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Livreur;
import ma.fstt.model.LivreurDAO;
import org.w3c.dom.events.MouseEvent;



public class HelloController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField tele;
    @FXML
    private TextField veh;
    @FXML
    private TableView<Livreur> mytable;
    @FXML
    private TableColumn<Livreur, Long> col_id;
    @FXML
    private TableColumn<Livreur, String> col_nom;
    @FXML
    private TableColumn<Livreur, String> col_tele;
    @FXML
    private TableColumn<Livreur, String> col_veh;
    private MouseEvent event;


    public HelloController() {
    }


    @FXML
    void RemoveLiv() throws SQLException {
        this.RemoveLiv((MouseEvent)null);
    }


    @FXML
    void RemoveLiv(MouseEvent event) throws SQLException {
        this.event = event;
        int selectedId = this.mytable.getSelectionModel().getSelectedIndex();
        LivreurDAO livreurDAO = new LivreurDAO();


        try {
            livreurDAO.delete((Livreur)this.mytable.getItems().get(selectedId));
            this.mytable.getItems().remove(selectedId);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }




    @FXML
    protected void onSaveButtonClick() {
        try {
            LivreurDAO livreurDAO = new LivreurDAO();
            Livreur liv = new Livreur(0L, this.nom.getText(), this.tele.getText(), this.veh.getText());
            livreurDAO.save(liv);
            this.UpdateTable();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }


    public void UpdateTable() {
        this.col_id.setCellValueFactory(new PropertyValueFactory("id_livreur"));
        this.col_nom.setCellValueFactory(new PropertyValueFactory("nom"));
        this.col_tele.setCellValueFactory(new PropertyValueFactory("telephone"));
        this.col_veh.setCellValueFactory(new PropertyValueFactory("vehicule"));
        this.mytable.setItems(getDataLivreurs());
    }


    public static ObservableList<Livreur> getDataLivreurs() {
        LivreurDAO livreurDAO = null;
        ObservableList<Livreur> listfx = FXCollections.observableArrayList();


        try {
            livreurDAO = new LivreurDAO();
            Iterator var2 = livreurDAO.getAll().iterator();


            while(var2.hasNext()) {
                Livreur ettemp = (Livreur)var2.next();
                listfx.add(ettemp);
            }


            return listfx;
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        this.UpdateTable();
    }

    public void editLiv(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        int selectedIndex = mytable.getSelectionModel().getSelectedIndex();
        mytable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Populate the text fields with the values of the selected element
                nom.setText(newValue.getNom());
                tele.setText(newValue.getTelephone());
                veh.setText(newValue.getVehicule());
            } else {
                // Clear the text fields if no element is selected
                nom.clear();
                tele.clear();
                veh.clear();
            }
        });
        if (selectedIndex != -1) {
            Livreur livreurToEdit = mytable.getSelectionModel().getSelectedItem();
            String updatedNom = nom.getText();
            String updatedTele = tele.getText();
            String updatedVeh = veh.getText();

            // Update the selected Livreur object with the new values
            livreurToEdit.setNom(updatedNom);
            livreurToEdit.setTelephone(updatedTele);
            livreurToEdit.setVehicule(updatedVeh);

            // Update the Livreur object in the database
            LivreurDAO livreurDAO = new LivreurDAO();
            try {
                livreurDAO.update(livreurToEdit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Update the TableView with the updated Livreur object
            mytable.getItems().set(selectedIndex, livreurToEdit);

            // Clear the text fields
            nom.clear();
            tele.clear();
            veh.clear();
        }
    }


    public void RemovePro(javafx.scene.input.MouseEvent mouseEvent) {
    }

    public void editPro(javafx.scene.input.MouseEvent mouseEvent) {
    }
}
