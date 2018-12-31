package leddisplay2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author milos.tygl
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane displayPane;

    @FXML
    private void handleButtonDisplayNumberAction(ActionEvent event) {
        displayString = "-3.141592653-12";
        displayNumber();
    }

    @FXML
    private void handleButtonDisplayNoneAction(ActionEvent event) {
        displayAllSegments(false);
    }

    @FXML
    private void handleButtonDisplayAllAction(ActionEvent event) {
        displayAllSegments(true);
    }

    private String displayString;

    /**
     *
     * @param pos
     * @return
     */
    private char digitFromDisplayString(int pos) {
        if (pos < 0) {
            return ' ';
        }
        if (displayString == null) {
            return ' ';
        }
        if (displayString.length() == 0) {
            return ' ';
        }
        if (displayString.length() < pos + 1) {
            return ' ';
        }
        char displayDigit = displayString.charAt(pos);
        return displayDigit;
    }

    /**
     *
     */
    private void displayNumber() {
        ObservableList observableListDisplayPane = displayPane.getChildren();
        Object[] objectDisplayPane = observableListDisplayPane.toArray();
        int displayStringIndex = -1;
        
        for (Object objectDigitPane : objectDisplayPane) {
            Pane digitPane = (Pane) objectDigitPane;
            ObservableList observableListDigitPane = digitPane.getChildren();
            Object[] objectDigitSegment = observableListDigitPane.toArray();

            Shape shapeDigitSegmentA = (Shape) objectDigitSegment[0];
            Shape shapeDigitSegmentB = (Shape) objectDigitSegment[1];
            Shape shapeDigitSegmentC = (Shape) objectDigitSegment[2];
            Shape shapeDigitSegmentD = (Shape) objectDigitSegment[3];
            Shape shapeDigitSegmentE = (Shape) objectDigitSegment[4];
            Shape shapeDigitSegmentF = (Shape) objectDigitSegment[5];
            Shape shapeDigitSegmentG = (Shape) objectDigitSegment[6];
            Shape shapeDigitSegmentP = (Shape) objectDigitSegment[7];

            displayStringIndex++;
            char cx = digitFromDisplayString(displayStringIndex);
            LedDigit ledDigit = new LedDigit(cx);

            shapeDigitSegmentA.setVisible(ledDigit.isSegmentA());
            shapeDigitSegmentB.setVisible(ledDigit.isSegmentB());
            shapeDigitSegmentC.setVisible(ledDigit.isSegmentC());
            shapeDigitSegmentD.setVisible(ledDigit.isSegmentD());
            shapeDigitSegmentE.setVisible(ledDigit.isSegmentE());
            shapeDigitSegmentF.setVisible(ledDigit.isSegmentF());
            shapeDigitSegmentG.setVisible(ledDigit.isSegmentG());
            shapeDigitSegmentP.setVisible(ledDigit.isSegmentP());
        }
    }

    /**
     *
     */
    private void displayAllSegments(boolean isSegmentVisible) {
        ObservableList observableListDisplayPane = displayPane.getChildren();
        Object[] objectDisplayPane = observableListDisplayPane.toArray();

        for (Object objectDigitPane : objectDisplayPane) {
            Pane digitPane = (Pane) objectDigitPane;
            ObservableList observableListDigitPane = digitPane.getChildren();
            Object[] objectDigitSegment = observableListDigitPane.toArray();

            Shape shapeDigitSegmentA = (Shape) objectDigitSegment[0];
            Shape shapeDigitSegmentB = (Shape) objectDigitSegment[1];
            Shape shapeDigitSegmentC = (Shape) objectDigitSegment[2];
            Shape shapeDigitSegmentD = (Shape) objectDigitSegment[3];
            Shape shapeDigitSegmentE = (Shape) objectDigitSegment[4];
            Shape shapeDigitSegmentF = (Shape) objectDigitSegment[5];
            Shape shapeDigitSegmentG = (Shape) objectDigitSegment[6];
            Shape shapeDigitSegmentP = (Shape) objectDigitSegment[7];

            shapeDigitSegmentA.setVisible(isSegmentVisible);
            shapeDigitSegmentB.setVisible(isSegmentVisible);
            shapeDigitSegmentC.setVisible(isSegmentVisible);
            shapeDigitSegmentD.setVisible(isSegmentVisible);
            shapeDigitSegmentE.setVisible(isSegmentVisible);
            shapeDigitSegmentF.setVisible(isSegmentVisible);
            shapeDigitSegmentG.setVisible(isSegmentVisible);
            shapeDigitSegmentP.setVisible(isSegmentVisible);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayAllSegments(false);
    }

}
