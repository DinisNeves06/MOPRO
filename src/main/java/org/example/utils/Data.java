/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.utils;
/**
 *
 * @author mdm
 */
public class Data {
        
    /**
     * O ano da data.
     */
    private int ano;
    
    /**
    * O mês da data.
    */
    private int mes;
     
    /**
    * O dia da data.
    */
    private int dia;
        
    /**
    * O ano da data por omissão.
    */
    private static final int ANO_POR_OMISSAO = 1;
    
    /**
    * O mês da data por omissão.
    */
    private static final int MES_POR_OMISSAO = 1;
    
    /**
    * O dia da data por omissão.
    */
    private static final int DIA_POR_OMISSAO = 1;
    
    /**
    * Nomes dos dias da semana.
    */
    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
                                               "Terça-feira", "Quarta-feira",
                                               "Quinta-feira", "Sexta-feira",
                                               "Sábado"};
    
    /**
    * Número de dias de cada mês do ano.
    */
    private static int[] diasPorMes = {  0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 
                                        31, 30, 31};
    
    /**
    * Nomes dos meses do ano.
    */
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro",
                                       "Março", "Abril", "Maio", "Junho",
                                       "Julho", "Agosto", "Setembro",
                                       "Outubro", "Novembro", "Dezembro"};
   
    /**
     * Constrói uma instância de Data recebendo o ano, o mês e o dia. 
     * 
     * @param ano o ano da data
     * @param mes o mÃªs da data
     * @param dia o dia da data
     */
    public Data(int ano, int mes, int dia) {        
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;              
    }
    /**
     * Constrói uma instância de Data com a data por omissÃ£o.  
     */
    public Data(Data data) {
        ano = data.ano;
        mes = data.mes;
        dia = data.dia;
    }
    /**
     * Constrói uma instância de Data com a data por omissÃ£o.  
     */
    public Data() {
        ano = ANO_POR_OMISSAO;
        mes = MES_POR_OMISSAO;
        dia = DIA_POR_OMISSAO;
    }
    
    
    /**
     * Devolve o ano da data.
     * 
     * @return ano da data
     */
    public int getAno() {
        return ano;
    }
    
    /**
     * Devolve o mês da data.
     * 
     * @return mês da data
     */
    public int getMes() {
        return mes;
    }

    /**
     * Devolve o dia da data.
     * 
     * @return dia da data
     */    
    public int getDia() {
        return dia;
    }

    /**
     * Modifica o ano, o mÃªs e o dia da data.
     * 
     * @param ano o novo ano da data
     * @param mes o novo mês da data
     * @param dia o novo dia da data
     */    
    public void setData(int ano, int mes, int dia) {
        this.ano = ano;		
        this.mes = mes;	      
        this.dia = dia;		 
    }
    
    /**
     * Devolve a descrição textual da data no formato: diaDaSemana, dia, mês, ano.
     * 
     * @return caraterÃ­sticas da data
     */
    public String toString() {
        return this.determinarDiaDaSemana() + ", " + this.dia + " de " + nomeMes[mes] + " de " + ano;
    }
   
    /**
     * Devolve a data no formato:%04d/%02d/%02d.
     * 
     * @return caraterísticas da data
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes, dia);
    }
    
    /**
     * Devolve o dia da semana da data. 
     * 
     * @return dia da semana da data
     */
    public String determinarDiaDaSemana() {
        int totalDias = contarDias();
        totalDias = totalDias % 7;

        return nomeDiaDaSemana[totalDias];
    }
   
    /**
     * Devolve true se a data for maior do que a data recebida por parÃ¢metro.  
     * Se a data for menor ou igual Ã  data recebida por parÃ¢metro, devolve
     * false.
     * 
     * @param outraData a outra data com a qual se compara a data
     * @return true se a data for maior do que a data recebida por parÃ¢metro,
     *         caso contrÃ¡rio devolve false
     */
    public boolean isMaior(Data outraData) {
        int totalDias = contarDias();
        int totalDias1 = outraData.contarDias();

        return totalDias > totalDias1;
    }

    /**
     * Devolve a diferença em número de dias entre a data e a data recebida por
     * parâmetro.     
     * 
     * @param outraData a outra data com a qual se compara a data para calcular
     *        a diferença do número de dias
     * @return diferença em número de dias entre a data e a data recebida por
     *         parâmetro
     */
    public int calcularDiferenca(Data outraData) {
        int totalDias = this.contarDias();
        int totalDias1 = outraData.contarDias();

        return Math.abs(totalDias - totalDias1);
    }
    
    /**    
     * Devolve a diferenÃ§a em número de dias entre a data e a data recebida por
     * parâmetro com ano, mês e dia    
     * 
     * @param ano o ano da data com a qual se compara a data para calcular a
     *        diferença do número de dias
     * @param mes o mês da data com a qual se compara a data para calcular a
     *        diferença do número de dias
     * @param dia o dia da data com a qual se compara a data para calcular a
     *        diferença do número de dias
     * @return diferença em número de dias entre a data e a data recebida por
     *         parâmetro com ano, mês e dia  
     */
    public int calcularDiferenca(int ano, int mes, int dia) {
        int totalDias = contarDias();
        Data outraData = new Data(ano, mes, dia);
        int totalDias1 = outraData.contarDias();

        return Math.abs(totalDias - totalDias1);
    }
    
    /**
     * Devolve true se o ano passado por parâmetro for bissexto.
     * Se o ano passado por parâmetro não for bissexto, devolve false.
     * 
     * @param ano o ano a validar
     * @return true se o ano passado por parâmetro for bissexto, caso contrário
     *         devolve false
     */        
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }
    
    /**
     * Devolve o número de dias desde o dia 1/1/1 até à  data.
     * 
     * @return número de dias desde o dia 1/1/1 até à  data
     */
    private int contarDias() {
        int totalDias = 0;

        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (isAnoBissexto(ano) && mes > 2) ? 1 : 0;
        totalDias += dia;

        return totalDias;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        final Data other = (Data) outroObjeto;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        return true;
    }
    public int compareTo(Object data){
        Data d = (Data)data;
        if (this.isMaior(d))
            return 1;
        else if (this.equals(d))
            return 0;
        else 
            return -1;
    }
}


