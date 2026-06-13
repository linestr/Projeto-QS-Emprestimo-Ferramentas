package modelo;

import com.google.protobuf.TextFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Classe Data que fornece métodos utilitários para manipulação de datas.
 */
public class Data {

    /**
     * Obtém a data atual no formato SQL.
     *
     * @return A data atual como um objeto Date.
     */
    public static Date dataAtual() {
        LocalDate hoje = LocalDate.now();
        return Date.valueOf(hoje);
    }

    /**
     * Converte uma string no formato "yyyy-MM-dd" para um objeto Date do SQL.
     *
     * @param dataString A string que representa a data no formato "yyyy-MM-dd".
     * @return A data convertida como um objeto Date do SQL.
     * @throws TextFormat.ParseException Se houver um erro de formato no texto.
     * @throws java.text.ParseException  Se houver um erro ao analisar a string da data.
     */
    public static Date stringParaDateSQL(String dataString) throws TextFormat.ParseException, java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataUtil = formato.parse(dataString);
        return new Date(dataUtil.getTime());
    }
}