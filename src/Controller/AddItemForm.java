package Controller;

import Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddItemForm {

    public TextField txtId;
    public TextField txtName;
    public TextField txtDescription;
    public TextField txtQty;
    public TextField txtPrice;
    public TableColumn columId;
    public TableColumn columName;
    public TableColumn columDescription;
    public TableColumn columQty;
    public TableColumn columPrice;
    public TableView tblItems;
    static  ArrayList<Item> Items = new ArrayList<>();


    public void btnAddItemOnAction(ActionEvent actionEvent) {

        String id = txtId.getText();
        String name = txtName.getText();
        String description = txtDescription.getText();
        int qty =Integer.parseInt(txtQty.getText());
        double price  =Double.parseDouble(txtPrice.getText());

        Items.add(new Item( id,name,description,qty,price ));
        System.out.println(Items);



        columId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        columName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        columDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        columQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        columPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        LoadTable();

    }

    public void LoadTable(){
        ObservableList<Item> itemsObservableList = FXCollections.observableArrayList();

        Items.forEach((ob)->{
            itemsObservableList.add(ob);
        });

        tblItems.setItems(itemsObservableList);

    }


    public void btnRemoveitemOnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/remove_item.fxml"))));
        primaryStage.show();
    }

    public void btnLoadTableOnAction(ActionEvent actionEvent) {
        LoadTable();
    }
}
