package time.line.timeline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class TimeLineController implements Initializable {
    @FXML
    private Slider slTimeLine;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private Button btnJugar;


    public void onJugarBtn(ActionEvent actionEvent) {
        int date[] = separarCadena(String.valueOf(dpFecha.getValue()));
        sliderInfo(date[0]);

    }
    public int[] separarCadena(String val){
        String year = "";
        String month = "";
        String day = "";
        int numbers[] = new int[3];
        String[] parts = val.split("-");
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    public void onFechaAct(ActionEvent actionEvent) {
        btnJugar.setDisable(false);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnJugar.setDisable(true);
        slTimeLine.setDisable(true);
    }

    public String validatePeriods(int year){
        String message;
        if (year >= 1760 && year <= 1830) {
            message = "Un día del período de la Industria 1.0 que se caracterizó por\n" +
                    "la predominancia de las industrias metalúrgica, textil y por el ferrocarril como principal medio de transporte, que\n" +
                    "utilizaba el carbón como fuente de energía. Por su parte, el telégrafo y el teléfono revolucionaron la forma en la que\n" +
                    "las comunicaciones eran concebidas hasta ese momento. \n";
        }else if (year >= 1850 && year <= 1914) {
            message = "Un día del período de la Industria 2.0 el cual supuso el\n" +
                    "desarrollo de las industrias química, eléctrica y automovilística. El coche y más tarde el avión, nacieron al albor de\n" +
                    "los cambios en este segundo periodo, que se extendió durante más de un siglo. Estos medios cambiaron el carbón\n" +
                    "por el petróleo como fuente de energía.";
        }else if (year >= 1960 && year <= 1970){
            message = "Un día del período de la Industria 3.0 caracterizada por el uso\n" +
                    "de la electrónica, las tecnologías de la información y las telecomunicaciones. Estos cambios permitieron la\n" +
                    "automatización de los procesos de producción y el surgimiento de Internet, que sin duda, ha supuesto una\n" +
                    "importante innovación en nuestro modo de ver y entender la vida y sobre todo la comunicación. Las energías\n" +
                    "alternativas y renovables, la nuclear y el petróleo se han erigido durante estos años como las principales fuentes de\n" +
                    "energía.\n";
        }else if (year >= 2011 && year <= 2020){
            message = "Un día del período de la Industria 4.0, esta nueva revolución\n" +
                    "no ha hecho sino multiplicar la velocidad, el alcance y el impacto de las herramientas que surgieron en el periodo\n" +
                    "anterior, mediante la conexión de los mundos digital, físico y biológico. Fábricas inteligentes, lugares de producción\n" +
                    "en los que los dispositivos están conectados entre sí con el objetivo de difuminar las barreras entre la demanda, el\n" +
                    "diseño, la fabricación y el suministro";
        }else {
            message = "Período de transición\n" +
                    "entre evoluciones industriales";
        }
        return message;
    }

    public void validateMessage(int[] date){
        String message;
        if (date[0] < 1760){
            message = "Ups! La industria todavía no surgía como tal.";
        }else if ( date[0] > 2022 && date[0]<2100){
            message = "Ups! No sé adivinar el futuro";
        }else if (date[0] > 2100){
            message = "Ups! Fuera de rango";
        }
    }
    public void sliderInfo(int year){
        slTimeLine.setValue(year);
    }
}