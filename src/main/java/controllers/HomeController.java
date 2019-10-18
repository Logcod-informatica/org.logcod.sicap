package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.Associate;
import repository.RepositoryAssociate;
import screens.ModelAndView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane screenHome;
    @FXML
    private TableView<Associate> tableView;
    @FXML
    private TableColumn<Associate,Object> tcNome,tcSexo,tcContato;
    @FXML
    private TableColumn<Associate,Long> tcChave;

    public String permission = "Negada";
    @FXML
    private ImageView btAssociate, btEmplooyee,btCargo;

    protected ObservableList<Associate> associates = null;

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    protected Image image(String url){
        return new Image(getClass().getClassLoader().getResourceAsStream(url));

    }
    @FXML
    public String screenAssociate(MouseEvent e){
        System.out.println("Aguarde...");
        return "";
    }
    RepositoryAssociate repositoryAssociate = new RepositoryAssociate();
    public void tableViewUpdate(String filter){
        tableView.setPadding(new Insets(3));
        associates = FXCollections.observableArrayList(repositoryAssociate.searchAssociatesByFilter(filter));
        tcChave.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<Associate, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getIdAssociado()) ;
            }
        });
        tcNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Associate, Object> param) {
                return new SimpleObjectProperty<>(param.getValue().getNome());
            }
        });
        tcSexo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Associate, Object> param) {
                return new SimpleObjectProperty<>(param.getValue().getSexo());
            }
        });
        tcContato.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Associate, Object> param) {
                return new SimpleObjectProperty<>(param.getValue().getContato());
            }
        });
        tableView.setItems(associates);

    }

    public void toolbar() {
        btAssociate.setImage(image("screen/images/png/avatar.png"));
        btEmplooyee.setImage(image("screen/images/png/piggy-bank.png"));
        btCargo.setImage(image("screen/images/png/share.png"));
        // btFuncionario.setGraphic(null);
       // btCargo.setGraphic(null);
    }

    public void initialize(URL location, ResourceBundle resources) {
      toolbar();
      tableViewUpdate("");
    }

    @FXML
    public String logar(MouseEvent event) {
        ModelAndView view = new ModelAndView();
        view.screenLogged("screen/authentication/authentication");
        return "ok";
    }
}
