package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataFormatada {

    public static Object formatarData(LocalDate dataParaFormatar) {
        LocalDate date = dataParaFormatar;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);

        return formattedDate;
    }
}