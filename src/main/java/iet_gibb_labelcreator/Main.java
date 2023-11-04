package iet_gibb_labelcreator;

import iet_gibb_labelcreator.controller.HeizungController;
import iet_gibb_labelcreator.model.Heizung;
import iet_gibb_labelcreator.model.Holzheizung;
import iet_gibb_labelcreator.model.Pelletsheizung;
import iet_gibb_labelcreator.model.Schnitzelheizung;
import iet_gibb_labelcreator.view.AlternativeLabelView;
import iet_gibb_labelcreator.view.HeizungView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

/**
 * Macht eine Instanz von jeder Heizung und gibt dann das Resultat aus.
 @author     Lorin Baumann
 @version    2023.2.2
 @since      07.09.2023
 */

public class Main extends Application {
    private static Heizung heizung;
    @Override
    public void start(Stage stage) throws Exception {
        List<Heizung> labels = createModels();
        HeizungController controller = new HeizungController(labels);
        AlternativeLabelView alternativeView = new AlternativeLabelView(stage, controller);
        HeizungView view = new HeizungView(stage, controller);    /* Views können nun hier ausgewechselt werden.  */
        controller.setView(alternativeView);
        controller.startView();
    }
    protected List<Heizung> createModels() {
        ArrayList<Heizung> heizungen = new ArrayList<>();
        heizung = new Holzheizung(20000, "Tanne");
        heizungen.add(heizung);
        heizung = new Pelletsheizung(20000);
        heizungen.add(heizung);
        heizung = new Schnitzelheizung(20000, "Tanne");
        heizungen.add(heizung);

        return heizungen;
    }
    public static void main(String[] args){
        launch(args);
    }
}
