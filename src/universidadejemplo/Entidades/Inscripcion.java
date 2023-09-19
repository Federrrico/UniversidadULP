/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.Entidades;

import java.time.LocalDate;

/**
 *
 * @author federico.acenjo
 */
public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private Double nota;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }
    
    

    public Inscripcion(Alumno alumno, Materia materia, Double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(int idInscripcion, Alumno idAlumno, Materia idMateria, Double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = idAlumno;
        this.materia = idMateria;
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getIdAlumno() {
        return alumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.alumno = idAlumno;
    }

    public Materia getIdMateria() {
        return materia;
    }

    public void setIdMateria(Materia idMateria) {
        this.materia = idMateria;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion N°: " + idInscripcion + " " + alumno.toString()+ " " + materia.toString() + ", Nota: " + nota;
    }
    
    
    
}
