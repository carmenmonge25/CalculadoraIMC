/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CalcularIMC.imc.controller;

import com.CalcularIMC.imc.model.CalculadoraIMC;
import com.CalcularIMC.imc.view.VistaCalculadoraIMC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Carmen Monge Montes
 */
public class IMCController implements ActionListener{
    
    private final VistaCalculadoraIMC vista = null;
    private final CalculadoraIMC calculadora = new CalculadoraIMC();
    private String mensajeError;

    private boolean esValido(String txt){
        boolean esValido;
        /**
         * El regex permite máximo tres cifras en la parte entera pero no
         * introducir 0. La parte decimal es opcional, se incdica con un 
         * punto y como máximo debe tener dos decimales. Permite que haya 
         * parte entera sin parte decimal (ni punto), pero no permite que 
         * haya parte decimal sin parte entera.
         */
        String regex = "(?!0(?:\\\\.0{1,2})?$)\\\\d{1,3}(\\\\.\\\\d{1,2})?";
        try{
            
            esValido = txt.matches(regex);
            if(!esValido){
                throw new NumberFormatException("Error: Introduce solo números "
                        + "válidos");
            }
        }catch(NumberFormatException e){
            mensajeError=e.getMessage();
            esValido=false;
        }
        return esValido;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double peso, altura;
        if(esValido(vista.getTxtPeso())&& esValido(vista.getTxtAltura())){
            peso=Double.parseDouble(vista.getTxtPeso());
            altura=Double.parseDouble(vista.getTxtAltura());
            calculadora.calcular(peso, altura);
        }else{
            vista.mostrarMensajeError(mensajeError);
        }
    }
    
    
}
