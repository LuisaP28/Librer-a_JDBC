package database;

import entity.Autor;

import java.util.List;

public interface CRUDAutor {
    Object insertAutor(Object obj);

    boolean updateAutor(Object obj);

    boolean deleteAutor(Object obj);

    List<Object> findAllAutor();

    Object encontrarPorIdAutor(int obj);

    List<Autor> encontrarPorNombreAutor(String obj);
}
