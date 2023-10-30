package Controlador;

import Modelo.Calculadora;
import config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculadoraController {

    Calculadora calculadora;
    Conexion conexionDB;

    public CalculadoraController() {
        calculadora = new Calculadora();
        conexionDB = new Conexion();
    }

    public String calcularYGuardar(String expresion) {
        double resultado = calculadora.calcular(expresion);
        Connection conexion = conexionDB.conectar();

        try {
      
            String consulta = "INSERT INTO operaciones (operacion, resultado) VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, expresion);
            statement.setDouble(2, resultado);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al guardar en la base de datos: " + e.getMessage());
        } finally {
            conexionDB.desconectar(); // Cierra la conexión a la base de datos
        }

        return String.valueOf(resultado);
    }
}
