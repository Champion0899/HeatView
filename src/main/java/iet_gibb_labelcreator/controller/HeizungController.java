package iet_gibb_labelcreator.controller;

import iet_gibb_labelcreator.model.Heizung;
import iet_gibb_labelcreator.property.ControllerViewInterface;
import iet_gibb_labelcreator.view.HeizungView;
import javafx.event.ActionEvent;

import java.util.List;

public class HeizungController  implements javafx.event.EventHandler<ActionEvent> {
    protected List<Heizung> models;
    protected ControllerViewInterface view;
    protected int currentHeizung =0;

    public HeizungController(List<Heizung> models) {
        this.models = models;
    }

    public void setView(ControllerViewInterface view){
        this.view=view;
    }

    public void startView(){
        view.startView(models.get(currentHeizung));
    }

    public void showNextLabel(){
        if(currentHeizung < models.size()-1) {
            currentHeizung++;
        }else{
            currentHeizung = 0;
        }
        view.startView(models.get(currentHeizung));
    }

    public String getLabel(){
        //greift auf die Liste zu, spricht das Element currentLabel an und ruft auf diesem Objekt die toSTring Mehtode auf
        return models.get(currentHeizung).toString();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        showNextLabel();
    }
}
