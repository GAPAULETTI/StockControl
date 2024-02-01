package com.gypdev.stock.Utils;

public class Util {

    public static String generateAlpha(){

        String palabra = "";

        int caracter = 3;

        for (int i = 0; i < caracter; i++){
            int codigoAscii = (int)Math.floor(Math.random()*(122-97)+97);
            palabra = palabra + (char)codigoAscii;
        }
        return palabra;
    }
    public static String generateCode(){
        int randomNum = (int)(Math.floor(Math.random()*(9999-0000+1)+0000));
        String codigo = generateAlpha() + randomNum;

        return codigo;
    }

}
