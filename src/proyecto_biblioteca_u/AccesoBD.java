/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_biblioteca_u;

import java.sql.*;

/**
 *
 * @author ceden
 */
public class AccesoBD {
    private String host;
    private String user;
    private String password;
    private String bd;

    //Abre o Cierra conexion
    private Connection conexion;

    public AccesoBD(String host, String user, String password, String bd) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.bd = bd;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public void conectarBD() {
        try {
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);
            String cadena = "jdbc:mysql://" + this.getHost() + "/" + this.getBd();
            conexion = DriverManager.getConnection(cadena, this.getUser(), this.getPassword());
            System.out.println("Conexion exitosa a la base de datos " + this.getBd());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error de conexion a la base de datos " + e.getMessage());
            System.out.println("Error de conexion mensaje " + e.getMessage());
        }
    }

    public void actualizarBD(String sql) {
        try {
            Statement stm = conexion.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Transaccion exitosa....");
        } catch (SQLException e) {
            System.out.println("Error en la Transaccion...." + e.getMessage());
        }
    }

    public ResultSet consultaBD(String sql) {
        try {
            ResultSet dato;
            Statement stm = conexion.createStatement();
            dato = stm.executeQuery(sql);
            return dato;
        } catch (SQLException e) {
            System.out.println("Error en la Transaccion...." + e.getMessage());
        }
        return null;
    }

    public void cerrarBD() {
        try {
            System.out.println("Se Cerro correctamente");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la base de datos.. " + e.toString());
        }
    }

}
