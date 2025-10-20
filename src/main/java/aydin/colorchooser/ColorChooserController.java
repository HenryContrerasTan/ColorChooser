package aydin.colorchooser;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ColorChooserController {

    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;

    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;

    @FXML private Rectangle colorRectangle;

    public void initialize() {

        StringConverter<Number> converter = new NumberStringConverter();


        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), converter);
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), converter);
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), converter);
        Bindings.bindBidirectional(alphaTextField.textProperty(), alphaSlider.valueProperty(), converter);


        colorRectangle.fillProperty().bind(
                Bindings.createObjectBinding(() ->
                                Color.rgb(
                                        clamp((int) redSlider.getValue(), 0, 255),
                                        clamp((int) greenSlider.getValue(), 0, 255),
                                        clamp((int) blueSlider.getValue(), 0, 255),
                                        clamp(alphaSlider.getValue(), 0.0, 1.0)
                                ),
                        redSlider.valueProperty(),
                        greenSlider.valueProperty(),
                        blueSlider.valueProperty(),
                        alphaSlider.valueProperty()
                )
        );


        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);
        alphaSlider.setValue(1.0);
    }


    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }
}


