package controller;

import database.CRUDAutor;
import entity.Autor;
import model.AutorModel;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

public class AutorController{


public AutorController(){

}
    public void update() {
        String listAutores = this.getAll(this.objAutorModel.findAllAutor());
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listAutores + "\nIngrese el ID del autor a editar:"));
        Autor objAutor = (Autor)this.objAutorModel.encontrarPorNombreAutor(String.valueOf(idUpdate));
        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Autor no encontrado.");
        } else {
            String name = JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre", objAutor.getNombre());
            String nationality = JOptionPane.showInputDialog(null, "Ingresa la nueva nacionalidad", objAutor.getNacionalidad());
            objAutor.setNombre(objAutor.getNombre());
            objAutor.setNacionalidad(objAutor.getNacionalidad());
            this.objAutorModel.updateAutor(objAutor);
        }

    }

    public void encontrarPorNombreAutor() {
        String nombreAutor = JOptionPane.showInputDialog(null, "Ingresa el nombre del autor a buscar:");
        String list = "List Author: \n";

        Autor objAutor;
        for(Iterator obj = this.objAutorModel.encontrarPorNombreAutor(nombreAutor).iterator(); obj.hasNext(); list = list + objAutor.toString() + "\n") {
            Object object = obj.next();
            objAutor = (Autor)obj;
        }

        JOptionPane.showMessageDialog(null, list);
    }

    public void delete() {
        String listaAuthorString = this.getAll(this.objAutorModel.findAllAutor());
        boolean confirm = true;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listaAuthorString + " Ingresa el ID del autor a eliminar"));
        Autor objAutor = (Autor)this.objAutorModel.encontrarPorIdAutor(idDelete);
        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, " Autor no encontrado.");
        } else {
            int confirmDialog = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar el autor: \n" + objAutor.toString());
            if (confirmDialog == 0) {
                this.objAutorModel.deleteAutor(objAutor);
            }
        }

    }

    public void getAll() {
        String list = this.getAll(this.objAutorModel.findAllAutor());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject) {
        String list = "List Authors \n";

        Autor objAutor;
        for(Iterator var3 = listObject.iterator(); var3.hasNext(); list = list + objAutor.toString() + "\n") {
            Object obj = var3.next();
            objAutor = (Autor)obj;
        }

        return list;
    }

    public void insert() {
        Autor objAutor = new Autor();
        String name = JOptionPane.showInputDialog("Inserte el nombre del autor: ");
        String nationality = JOptionPane.showInputDialog("Inserte la nacionalidad del autor: ");
        objAutor.setNombre(name);
        objAutor.setNacionalidad(nationality);
        objAutor = (Autor)this.objAutorModel.insertAutor(objAutor);
        JOptionPane.showMessageDialog(null, objAutor.toString());
    }

    public static AutorModel objAutorModel = new AutorModel();


}
