package Controller;

import Model.Item;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class RemoveItemForm {

    public TextField txtId;

    public void btnRemoveOnAction(ActionEvent actionEvent){
            AddItemForm.Items.removeIf(ob -> txtId.getText().equals(ob.getId()));
    }
}
