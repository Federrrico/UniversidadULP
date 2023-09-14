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
        
//        pruebaData.guardarAlumno(new Alumno(34155039, "Acenjo", "Federico", LocalDate.of(1988, Month.OCTOBER, 30), true));
//        pruebaData.guardarAlumno(new Alumno(34155038, "Acenjo", "Federic1", LocalDate.of(1988, Month.OCTOBER, 30), true));
//        pruebaData.guardarAlumno(new Alumno(34155037, "Acenjo", "Federic2", LocalDate.of(1988, Month.OCTOBER, 30), true));
//        pruebaData.guardarAlumno(new Alumno(34155036, "Acenjo", "Federic3", LocalDate.of(1988, Month.OCTOBER, 30), true));
//        pruebaData.guardarAlumno(new Alumno(34155035, "Acenjo", "Federic4", LocalDate.of(1988, Month.OCTOBER, 30), true));
//        pruebaData.guardarAlumno(new Alumno(34155034, "Acenjo", "Federic5", LocalDate.of(1988, Month.OCTOBER, 30), true));
//        pruebaData.guardarAlumno(new Alumno(34155033, "Acenjo", "Federic6", LocalDate.of(1988, Month.OCTOBER, 30), true));
        
        MateriaData mpruebaData = new MateriaData();
        
//        mpruebaData.guardarMateria(new Materia("Matematicas1", 2005, true));
//        mpruebaData.guardarMateria(new Materia("Matematicas2", 2005, true));
//        mpruebaData.guardarMateria(new Materia("Matematicas3", 2005, true));
//        mpruebaData.guardarMateria(new Materia("Matematicas4", 2005, true));
//        mpruebaData.guardarMateria(new Materia("Matematicas5", 2005, true));
//        mpruebaData.guardarMateria(new Materia("Matematicas6", 2005, true));
//        mpruebaData.guardarMateria(new Materia("Matematicas7", 2005, true));

        InscripcionData idprueba = new InscripcionData();
        
        
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155039), mpruebaData.buscarMateria(6), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155039), mpruebaData.buscarMateria(7), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155038), mpruebaData.buscarMateria(8), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155038), mpruebaData.buscarMateria(9), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155037), mpruebaData.buscarMateria(10), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155037), mpruebaData.buscarMateria(11), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155036), mpruebaData.buscarMateria(12), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155036), mpruebaData.buscarMateria(6), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155035), mpruebaData.buscarMateria(7), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155035), mpruebaData.buscarMateria(8), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155034), mpruebaData.buscarMateria(9), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155034), mpruebaData.buscarMateria(10), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155033), mpruebaData.buscarMateria(11), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155033), mpruebaData.buscarMateria(12), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155033), mpruebaData.buscarMateria(6), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155033), mpruebaData.buscarMateria(7), 8.5));
//        idprueba.guardarInscripcion(new Inscripcion(pruebaData.buscarAlumnoPorDni(34155033), mpruebaData.buscarMateria(8), 8.5));
//        
//        
//        
//        
//        System.out.println("Mostramos las inscripciones:");
//        for (Inscripcion ins : idprueba.listarInscripciones()) {
//            System.out.println(ins.toString());
//        }
//        
//        System.out.println("Acualizamos nota");
//        idprueba.actualizarNota(19, 6, 8D);
//        idprueba.actualizarNota(20, 9, 7D);
//        idprueba.actualizarNota(25, 6, 9D);
//        
//        System.out.println("Obtenemos las materias cursadas de un alumno");
//        
//        for (Materia ins : idprueba.obtenerMateriasCursadas(25)) {
//            System.out.println(ins.toString());
//        }
//        
//        System.out.println("Obtenemos las materias no cursadas de un alumno");
//        for (Materia ins : idprueba.obtenerMateriasCursadas(20)) {
//            System.out.println(ins.toString());
//        }
//        
//        System.out.println("Borramos una inscripcion");
//        idprueba.borrarInscripcion(25, 6);
//        
//        System.out.println("Listamos los alumnos inscriptos en una materia");
//        for (Alumno ins : idprueba.listarAlumnosPorMateria(7)) {
//            System.out.println(ins.toString());
//        }
        
        
        
    }
    
}
