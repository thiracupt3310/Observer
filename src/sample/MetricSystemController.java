package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MetricSystemController implements Observer{
    @FXML
    Label mgLabel, gLabel, kgLabel;
    private MetricSystem metricSystem;

    public void initialize(){
        metricSystem = new MetricSystem();
    }

    @Override
    public void update(double value, String unit) {
        if (unit.equals("kg")){
            metricSystem.setFromKg(value);
        } else  if (unit.equals("lb")){
            metricSystem.setFromEnglishSystem(value);
        }
        mgLabel.setText(String.format("%.2f",metricSystem.getMg()));
        gLabel.setText(String.format("%.2f", metricSystem.toGram()));
        kgLabel.setText(String.format("%.2f", metricSystem.toKilogram()));
    }
}
