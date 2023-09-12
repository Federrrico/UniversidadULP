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
import universidadejemplo.AccesoADatos.*;

/**
 *
 * @author federico.acenjo
 */
public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlumnoData pruebaData = new AlumnoData();
        Alumno prueba = new Alumno(34155039, "Acenjo", "Federico", LocalDate.of(1988, Month.OCTOBER, 30), true);
        pruebaData.guardarAlumno(prueba);
        System.out.println("Se guarda alumno en DB");
        MateriaData mpruebaData = new MateriaData();
        Materia mprueba = new Materia("Matematicas", 2005, true);
        mpruebaData.guardarMateria(mprueba);
        System.out.println("Se guarda materia en DB");
        InscripcionData idprueba = new InscripcionData();
        Inscripcion iprueba = new Inscripcion(prueba, mprueba, 8.5);       
        idprueba.guardarInscripcion(iprueba);
        System.out.println("Se guarda inscripcion en DB");
        
        System.out.println(idprueba.toString());
        
        
        
        
    }
    
}
