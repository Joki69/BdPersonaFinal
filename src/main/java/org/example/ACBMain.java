package org.example;

import java.sql.Connection;

public class ACBMain {
    public static void main(String[] args) {
        ACBMenu menu = new ACBMenu();

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection c = connectionFactory.connect();

        PersonaController personaController = new PersonaController(c);
        ArcanaController arcanaController = new ArcanaController(c);

        int option = menu.mainMenu();
        while (option != 11) {
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
                    personaController.insertNewPersona();
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
                    personaController.mostrarPersonaArcanaNombre();
                    break;

                case 9:
                    personaController.modificarNombrePersona();
                    break;

                case 10:
                    personaController.modificarNombrePersonaPorArcana();
                    break;

                case 11:
                    arcanaController.borrarTablaArcanaNombre();
                    break;

                case 12:
                    personaController.borrarTablaPersonaPorArcana();
                    break;
                case 13:
                    break;
            }
            option = menu.mainMenu();
        }
    }
}