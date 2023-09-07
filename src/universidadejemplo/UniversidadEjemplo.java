/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo;

import java.time.LocalDate;
import java.time.Month;
import javax.swing.*;
import universidadejemplo.Entidades.*;

/**
 *
 * @author federico.acenjo
 */
public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno prueba = new Alumno(34155039, "Acenjo", "Federico", LocalDate.of(1988, Month.OCTOBER, 30), true);
        
        System.out.println(prueba.toString());
    }
    
}
