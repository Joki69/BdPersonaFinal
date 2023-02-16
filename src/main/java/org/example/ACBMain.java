package org.example;

import java.sql.Connection;
/**
 * Clase Main donde iniciare las conexiones con la base de datos y mostrare un menu
 * dentro de un bucle para poder acceder a todas las funciones, el usuario podrá hacer inserts
 * deletes updates y selects
 *
 * @author Jonathan Carralero - Joki69 in GitHub
 */
public class ACBMain {
    public static void main(String[] args) {
        ACBMenu menu = new ACBMenu();

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();

        PersonaController personaController = new PersonaController(c);
        ArcanaController arcanaController = new ArcanaController(c);

        int option = menu.mainMenu();
        while (option != 14) {
            switch (option) {
                case 1:
                    personaController.borrarTablaPersona();
                    arcanaController.borrarTablaArcana();

                    break;

                case 2:
                    arcanaController.crearTablaArcana();
                    personaController.crearTablaPersona();

                    break;

                case 3:
                    arcanaController.poblarArcana();
                    personaController.poblarPersona();

                    break;

                case 4:
                    personaController.insertNewPersona(menu);
                    break;

                case 5:
                    personaController.mostrarPersona();
                    break;

                case 6:
                    arcanaController.mostrarArcana();
                    break;

                case 7:
                    personaController.mostrarPersonaNombre();
                    break;

                case 8:
                    personaController.mostrarPersonaArcanaNombre(menu.arcanaChek());
                    break;

                case 9:
                    personaController.modificarNombrePersona();
                    break;

                case 10:
                    personaController.modificarNombrePersonaPorArcana(menu);
                    break;

                case 11:
                    arcanaController.borrarTablaArcanaNombre(menu.arcanaChek());
                    break;

                case 12:
                    personaController.borrarTablaPersonaPorArcana(menu.arcanaChek());
                    break;
                case 13:
                    menu.arcanaChek();
                    break;
            }
            option = menu.mainMenu();
        }
    }
}