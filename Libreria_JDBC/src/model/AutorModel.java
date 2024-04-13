package model;

import database.CRUDAutor;
import database.ConfigDB;
import entity.Autor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUDAutor {
    @Override
    public Object insertAutor(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Autor objAutor = (Autor)obj;

        try {
            String sql = "INSERT INTO autor(nombre, nacionalidad) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objAutor.getNombre());
            objPrepare.setString(2, objAutor.getNacionalidad());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()) {
                objAutor.setId(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, " Autor insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error > " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objAutor;
    }

    @Override
    public boolean updateAutor(Object obj) {
        Connection objConecction = ConfigDB.openConnection();
        Autor objAutor = (Autor)obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE autor SET nombre = ?, nacionalidad = ? WHERE id_autor = ?;";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objAutor.getNombre());
            objPrepare.setString(2, objAutor.getNacionalidad());
            objPrepare.setInt(3, objAutor.getId());
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "La actualización se realizó con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
          return isUpdated;
    }

    @Override
    public boolean deleteAutor(Object obj) {
        Autor objAutor = (Autor) obj;
        boolean isDeleted = false;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM autor WHERE autor.id_autor = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objAutor.getId());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog( null, "El autor se eliminó con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isDeleted;
    }

    @Override
    public List<Object> findAllAutor() {
        List<Object> listAutores = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM autor ORDER BY autor.id_autor;";
            PreparedStatement objPrepareStatement = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepareStatement.executeQuery();

            while(objResult.next()) {
                Autor objAutor = new Autor();
                objAutor.setId(objResult.getInt("id_autor"));
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
                listAutores.add(objAutor);
            }
        } catch (SQLException e) {
            System.out.println("ERROR>" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listAutores;
    }


    @Override
    public Object encontrarPorIdAutor(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Autor objAutor = null;

        try {
            String sql = "SELECT * FROM autor WHERE id_autor = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()) {
                objAutor = new Autor();
                objAutor.setId(objResult.getInt("id_autor"));
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAutor;

    }

    @Override
    public List<Autor> encontrarPorNombreAutor(String nombre) {
        Connection objConnection = ConfigDB.openConnection();
        List<Autor> listAutor = new ArrayList();

        try {
            String sql = "SELECT * FROM autor WHERE nombre LIKE ?;";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);
            objPreparedStatement.setString(1, "%" + nombre + "%");
            ResultSet objResult = objPreparedStatement.executeQuery();

            while(objResult.next()) {
                Autor objAuthor = new Autor();
                objAuthor.setId(objResult.getInt("id_authors"));
                objAuthor.setNombre(objResult.getString("name_author"));
                objAuthor.setNacionalidad(objResult.getString("nationality"));
                listAutor.add(objAuthor);
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return listAutor;
    }
}
