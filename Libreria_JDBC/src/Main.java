import controller.AutorController;
import controller.LibroController;
import database.ConfigDB;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();
        AutorController objAutorController = new AutorController();
        LibroController objLibroController = new LibroController();

        String option;
        label91:
        do {
            option = JOptionPane.showInputDialog("    MENU\n    1. Menú autores\n    2. Menú libros\n    3. Salir\n    Seleccione una opción\n");
            switch (option) {
                case "1":
                    while (true) {
                        String option2 = JOptionPane.showInputDialog("MENU AUTHORS\n1. Crear un nuevo autor.\n2. Encontrar autores.\n3. Encontrar autores por nombre\n4. Editar autor.\n5. Eliminar autor.\n6. Salir.\n");
                        switch (option2) {
                            case "1":
                                objAutorController.insert();
                                break;
                            case "2":
                                objAutorController.getAll();
                                break;
                            case "3":
                                objAutorController.encontrarPorNombreAutor();
                                break;
                            case "4":
                                objAutorController.update();
                                break;
                            case "5":
                                objAutorController.delete();
                                break;
                            case "6":
                                continue label91;
                        }
                    }
                case "2":
                    do {
                        String option3 = JOptionPane.showInputDialog("MENU BOOKS\n1. Crear un nuevo libro.\n2. Encontrar autor.\n3. Edidar autor.\n4. Eliminar autor.\n5. Salir.\n");
                        switch (option3) {
                            case "1":
                                objLibroController.equals(objAutorController);
                                break;
                            case "2":
                                objLibroController.equals(objAutorController);
                                break;
                            case "3":
                                objAutorController.encontrarPorNombreAutor();
                                break;
                            case "4":
                                objAutorController.delete();
                                break;
                            case "5":
                                continue label91;
                        }
                    } while (true);
            }
        } while (!option.equals("3"));
    }
}

