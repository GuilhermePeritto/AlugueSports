package Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calcular {
    public static BigDecimal somar(Double... valores) {
        BigDecimal resultado = new BigDecimal(String.valueOf(valores[0]));
        for (int i = 1; i < valores.length; i++) {
            resultado = resultado.add(new BigDecimal(String.valueOf(valores[i])));
        }
        return resultado;
    }
    public static BigDecimal subtrair(Double... valores) {
        BigDecimal resultado = new BigDecimal(String.valueOf(valores[0]));
        for (int i = 1; i < valores.length; i++) {
            resultado = resultado.subtract(new BigDecimal(String.valueOf(valores[i])));
        }
        return resultado;
    }
    public static BigDecimal multiplicar(Double... valores) {
        BigDecimal resultado = new BigDecimal(String.valueOf(valores[0]));
        for (int i = 1; i < valores.length; i++) {
            resultado = resultado.multiply(new BigDecimal(String.valueOf(valores[i])));
        }
        return resultado;
    }
    public static BigDecimal dividir(Double... valores) {
        BigDecimal resultado = new BigDecimal(String.valueOf(valores[0]));
        for (int i = 1; i < valores.length; i++) {
            resultado = resultado.divide(new BigDecimal(String.valueOf(valores[i])), 2, RoundingMode.HALF_UP);
        }
        return resultado;
    }
}