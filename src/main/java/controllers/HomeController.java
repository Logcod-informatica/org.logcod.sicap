package controllers;

import calendar.ConfigCalendar;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import utilities.Utilities;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane screenHome;
    @FXML
    private TableView<Associate> tableView;
    @FXML
    private TableColumn<Associate,Object> tcNome,tcSexo,tcContato,tcChequeEdit,tcChequeRemove,tcChequeView;
    @FXML
    private TableColumn<Associate,Long> tcChave;
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

    @FXML
    public String screenAssociate(MouseEvent e){
       ModelAndView view = new ModelAndView();
       view.screenFormAssociate("screen/register/register-associate",null);
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
        tcChequeEdit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Associate, Object> param) {
                return new SimpleObjectProperty<>(new CheckBox());
            }
        });

        tcChequeRemove.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Associate, Object> param) {
                 CheckBox edit = new CheckBox();
                 edit.setOnAction(new EventHandler<ActionEvent>() {
                     @Override
                     public void handle(ActionEvent event) {

                         Associate associate = param.getValue();
                         System.out.println("Id: "+associate.getIdAssociado() + " Nome: "+associate.getNome() + "Nascimento: "+ ConfigCalendar.setFormatarDateCalendar(associate.getNascimento()));

                     }
                 });
                return new SimpleObjectProperty<>(edit);
            }
        });
        tcChequeView.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Associate, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Associate, Object> param) {
                return new SimpleObjectProperty<>(new CheckBox());
            }
        });

        tableView.setItems(associates);

    }

    public void toolbar() {
        btAssociate.setImage(Utilities.image("screen/images/png/avatar.png"));
        btEmplooyee.setImage(Utilities.image("screen/images/png/piggy-bank.png"));
        btCargo.setImage(Utilities.image("screen/images/png/share.png"));
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
