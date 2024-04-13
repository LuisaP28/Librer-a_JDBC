package database;

import entity.Autor;
import entity.Libro;

import java.util.List;

public interface CRUDLibro {
    Object insertLibro(Object obj);

    boolean updateLibro(Object obj);

    void deleteLibro(Object obj);

    List<Object> findAllLibro();

    Object encontrarPorIdLibro(int id);

    List<Libro> encontrarPorNombreLibro(String obj);

    List<Autor> encontrarPorNombreAutor(String obj);
}
