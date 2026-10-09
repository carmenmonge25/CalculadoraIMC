/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CalcularIMC.imc.model;

/**
 *
 * @author Carmen Monge Montes
 */
public class CalculadoraIMC {
    final String BAJOP = "Bajo Peso";
    final String PNORMAL = "Peso Normal";
    final String SOBREP = "Sobrepeso";
    final String OBESO = "Obesidad";
    
    // Calcula el IMC
    public double calcular(double peso, double altura){
        return altura*altura/peso;
    }
    
    // Devuelve la clasificación según el IMC
    public String clasificar(double imc){
        String clasi;
        if(imc<18.5){
            clasi=BAJOP;
        }else if(imc<25){
            clasi=PNORMAL;
        }else if(imc<30){
            clasi=SOBREP;
        }else{
            clasi=OBESO;
        }
        return clasi;
    }

}
