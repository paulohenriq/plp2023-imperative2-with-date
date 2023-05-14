package li2.plp.imperative2.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Data {
    private LocalDate data;
    private String dataFormatada;
    private String dataOriginal;

    public Data(String token) throws DateTimeParseException {
      this.dataOriginal = token;
      this.converterParaLocalDate();
    }

    public void converterParaLocalDate() throws DateTimeParseException{
      String dataStr = this.dataOriginal.substring(3);
      String format = this.dataOriginal.substring(0, 2);
      String formatStr = "dd/MM/yyyy";
      switch (format) { 
        case "US":
          formatStr = "MM/dd/yyyy";
          break;
        case "BR":
          formatStr = "dd/MM/yyyy";
          break;
        case "JP":
          formatStr = "yyyy/MM/dd";
          break;
        default:
          break;
      }
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
      try {
        LocalDate parsedDate = LocalDate.parse(dataStr, formatter);
        this.data = parsedDate;
        this.dataFormatada = parsedDate.format(formatter);
      } catch (DateTimeParseException e) {
          throw new DateTimeParseException("Valor de data "+this.dataOriginal+" é inválido", this.dataOriginal, 0);
      }
    }

    public String getDataOriginal() {
        return dataOriginal;
    }

    public LocalDate getLocalDate() {
      return data;
    }

  @Override
    public String toString() {
        return "" + this.dataFormatada;
    }
}
