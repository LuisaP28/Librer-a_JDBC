package model;

import database.CRUDLibro;
import database.ConfigDB;
import entity.Autor;
import entity.Libro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibroModel implements CRUDLibro {
    public Object insertLibro(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Libro objLibro = (Libro) obj;

        try {
            String sql = "INSERT INTO libros (titulo, año_publicacion, precio) VALUES (?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setDate(2, objLibro.getAño_publicacion());
            objPrepare.setDouble(3, objLibro.getPrecio());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()) {
                objLibro.setId(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Libro insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());

        }
        ConfigDB.closeConnection();
        return objLibro;
    }
    public boolean updateLibro(Object obj) {
        Connection objConecction = ConfigDB.openConnection();
        Libro objLibro= (Libro) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE libros SET titulo = ?, año_publicacion = ?, precio = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setDate(2, objLibro.getAño_publicacion());
            objPrepare.setDouble(3, objLibro.getPrecio());
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, " Actualizado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    public void deleteLibro(Object obj) {
    }

    public List<Object> findAllLibro() {
        return null;
    }

    public Object encontrarPorIdLibro(int id) {
        return null;
    }

    public List<Libro> encontrarPorNombreLibro(String name) {
        return null;
    }

    public List<Autor> encontrarPorNombreAutor(String name) {
        return null;
    }
}

