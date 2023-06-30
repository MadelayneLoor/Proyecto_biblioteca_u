/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_biblioteca_u;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ceden
 */
public class PersonaBens {

    private int Id_Persona;
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private Date Fecha_Nacimiento;
    private String Direccion;
    private String Telefono;
    AccesoBD bd;

    public PersonaBens() {
        bd = new AccesoBD("localhost", "root", "Anthony", "biblioteca_utm");
        bd.conectarBD();
    }

    public int getId_Persona() {
        return Id_Persona;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setId_Persona(int Id_Persona) {
        this.Id_Persona = Id_Persona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int incremento() {
        int cont = 0;
        try {
            ResultSet rs;
            rs = (ResultSet) bd.consultaBD("Select max(Id_Persona) from Persona");
            if (rs.next()) {
                cont = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return cont;
    }

    public void insertar_Persona() {
        try {
            String cadena = "Insert into Persona values ('" + this.incremento() + "','" + this.getCedula() + "','" + this.getNombre() + "','" + this.getApellido() + "','" + this.getFecha_Nacimiento() + "','" + this.getDireccion() + "','" + this.getTelefono() + "')";
            bd.actualizarBD(cadena);
        } catch (Exception e) {
            System.out.println("No se pudo realizar la insercion de la Persona");
        }
    }

    public void Consultar_Persona() {
        try {
            ResultSet result;
            result = (ResultSet) bd.consultaBD("Select * from Persona");
            System.out.println("Id\tCedula\t\tNombre\tApellido\tNacimiento\tDireccion\tTelefono");
            while (result.next()) {
                System.out.print(result.getString(1) + "\t");
                System.out.print(result.getString(2) + "\t");
                System.out.print(result.getString(3) + "\t");
                System.out.print(result.getString(4) + "\t\t");
                System.out.print(result.getString(5) + "\t");
                System.out.print(result.getString(6) + "\t");
                System.out.println(result.getString(7) + " ");
                
            }
        } catch (SQLException e) {
        }
    }

    public void Actualizar_Persona() {
    }

    public void Eliminar_Persona() {
    }
}
