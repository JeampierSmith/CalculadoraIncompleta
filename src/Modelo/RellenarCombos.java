/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import javax.swing.JComboBox;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author jeamp
 */
public class RellenarCombos {
    public void RellenarCombobox(String tabla, String valor, JComboBox combo){
        String sql = "SELECT * FROM "+ tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.conectar();
        try
        {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getString(valor));
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString() );
        }
    }
}
