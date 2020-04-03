package PaqueteNomina;





import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author ranbr
 */
public class Nomina_ implements Serializable {

    private String nombre;
    private String apellido;
    private String departamento;
    private String puesto;
    private int dia, mes, año, telefono;
    private String ubicacion;
    private float sueldo;
    private boolean activo;

    public Nomina_() {
        nombre = "NN";
        apellido = "NN";
        departamento = "NN";
        puesto = "NN";
        dia = 0;
        mes = 0;
        año = 0;
        ubicacion = "NN";
        telefono = 0;
        sueldo = 0;

        activo = true;
    }
    

    public Nomina_(String nombre, String apellido, String departamento, String puesto, int dia, int mes, int año, int telefono, String ubicacion, float sueldo, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.puesto = puesto;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.sueldo = sueldo;
        this.activo = activo;
    }

    public Nomina_(String departamento, boolean activo) {
        this.departamento = departamento;
        this.activo = activo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicaion) {
        this.ubicacion = ubicaion;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre
                + "\nApellido: " + apellido
                + "\nDepartamento: " + departamento
                + "\nPuesto: " + puesto
                + "\nFecha: " + dia + "/" + "/" + mes + "/" + año
                + "\nTelefono: " + telefono
                + "\nUbicacion: " + ubicacion
                + "\nSueldo: " + sueldo;

    }

    public int getTamaño() {
        return getNombre().length() * 2 + 2 + 4 + 1;
    }

}
