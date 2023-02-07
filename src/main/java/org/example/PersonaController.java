package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonaController {
    private Connection connection;
    private Scanner scanner;

    public PersonaController(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

    public void borrarTablaPersona(){
        try{
            Statement st = connection.createStatement();

            st.executeUpdate("DROP TABLE persona");
        }catch (SQLException e){
            System.out.println("No se ha podido borrar persona");
        }
    }

    public void crearTablaPersona(){
        try{
            Statement st = connection.createStatement();

            st.executeUpdate("CREATE TABLE persona (" +
                    "id_persona serial," +
                    "id_arcana integer," +
                    "nombre_arcana varchar(1000)," +
                    "nombre_persona text," +
                    "historia text," +
                    "PRIMARY KEY(id_persona)," +
                    "    CONSTRAINT fk_arcana" +
                    "      FOREIGN KEY(id_arcana)" +
                    "      REFERENCES arcana(id_arcana));");

            st.close();

        }catch (SQLException e){
            System.out.println("Error: No se pueden crear las tablas, fijate si ya estan creadas.");
        }
    }

    public void poblarPersona(){
        List<String[]> csvData = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Demonios.csv"));
            String line;

            while ((line = br.readLine()) != null){
                String[] data = line.split("\",\"");
                csvData.add(data);
            }

            for (String[] data : csvData) {
                try{
                    String nombre_arcana = data[0];
                    String nombre_persona = data[1];
                    String historia = data[2];

                    String sql = "INSERT INTO persona " + "(nombre_arcana,nombre_persona,historia) VALUES(?,?,?)";

                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1,nombre_arcana);
                    pst.setString(2,nombre_persona);
                    pst.setString(3,historia);

                    pst.executeUpdate();
                    pst.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void insertNewPersona() {
        ResultSet rs = null;
        System.out.println("Escribe el arcana del persona que quieras añadir");
        String nombre_arcana = scanner.nextLine();
        System.out.println("Escribe el nombre del persona que quieras añadir");
        String nombre_persona = scanner.nextLine();
        System.out.println("Escribe la historia del persona que quieras añadir");
        String historia = scanner.nextLine();
        try{
            String sql = "INSERT INTO persona " + "(nombre_arcana,nombre_persona,historia) VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nombre_arcana);
            pst.setString(2, nombre_persona);
            pst.setString(3, historia);

            pst.executeUpdate();
            pst.close();
        }catch (SQLException e){
            System.out.println("No se han podido modificar los datos");
        }
    }






    public void mostrarPersona(){
        System.out.println("\nPERSONAS");
        ResultSet rs = null;
        String sql = "SELECT * FROM persona";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("******************************************************" +
                        "\nID Persona: " + rs.getString("id_persona") +
                        "\nID Arcana: " + rs.getString("id_arcana") +
                        "\nNombre Arcana: " + rs.getString("nombre_arcana") +
                        "\nNombre Persona: " + rs.getString("nombre_persona") +
                        "\nHistoria del persona: " + rs.getString("historia") +
                        "\n******************************************************");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            System.out.println("Error: La tabla characters no existe");
        }
    }
    public void mostrarPersonaNombre(){
        ResultSet rs = null;
        System.out.println("Introduce el nombre del persona:");
        String nombrePersona = scanner.nextLine();

        String sql = "SELECT * FROM persona WHERE nombre_persona = '"+ nombrePersona + "'";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("******************************************************" +
                        "\nID Persona: " + rs.getString("id_persona") +
                        "\nID Arcana: " + rs.getString("id_arcana") +
                        "\nNombre Arcana: " + rs.getString("nombre_arcana") +
                        "\nNombre Persona: " + rs.getString("nombre_persona") +
                        "\nHistoria del persona: " + rs.getString("historia") +
                        "\n******************************************************");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            System.out.println("Error: El parametro " + nombrePersona + " no existe");
        }
    }
    public void mostrarPersonaArcanaNombre(){
        ResultSet rs = null;
        System.out.println("Elige uno de estos arcana:");
        System.out.println("Fool \n" +
                        "Magician\n" +
                        "Priestess\n" +
                        "Empress\n" +
                        "Emperor\n" +
                        "Hierophant\n" +
                        "Lovers\n" +
                        "Chariot\n" +
                        "Justice\n" +
                        "Hermit\n" +
                        "Fortune\n" +
                        "Strength\n" +
                        "Hanged Man\n" +
                        "Death\n" +
                        "Temperance\n" +
                        "Devil\n" +
                        "Tower\n" +
                        "Star\n" +
                        "Moon\n" +
                        "Sun\n" +
                "Judgement");
        String arcana = scanner.nextLine();

        String sql = "SELECT * FROM persona WHERE nombre_arcana = '"+ arcana + "'";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("******************************************************" +
                        "\nID Persona: " + rs.getString("id_persona") +
                        "\nID Arcana: " + rs.getString("id_arcana") +
                        "\nNombre Arcana: " + rs.getString("nombre_arcana") +
                        "\nNombre Persona: " + rs.getString("nombre_persona") +
                        "\nHistoria del persona: " + rs.getString("historia") +
                        "\n******************************************************");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            System.out.println("Error: El parametro " + arcana + " no existe");
        }
    }
    public void modificarNombrePersona(){
        ResultSet rs = null;
        System.out.println("Escribe el nombre del persona que quieras modificar");
        String viejoNombre= scanner.nextLine();
        System.out.println("Ahora el nuevo nombre para el persona");
        String nuevoNombre = scanner.nextLine();
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE persona SET nombre_persona = '" + nuevoNombre + "' WHERE nombre_persona = '" + viejoNombre + "'");
        }catch (SQLException e){
            System.out.println("No se han podido modificar los datos");
        }
    }
    public void modificarNombrePersonaPorArcana(){
        ResultSet rs = null;
        System.out.println("Escribe el arcana de los persona que quieras modificar");
        String viejoArcana= scanner.nextLine();
        System.out.println("Ahora el nuevo arcana para los persona");
        String nuevoArcana = scanner.nextLine();
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE persona SET nombre_arcana = '" + nuevoArcana + "' WHERE nombre_arcana = '" + viejoArcana + "'");
        }catch (SQLException e){
            System.out.println("No se han podido modificar los datos");
        }
    }

    public void borrarTablaPersonaPorArcana(){
        ResultSet rs = null;
        System.out.println("Elige uno de estos arcana:");
        System.out.println("Fool \n" +
                "Magician\n" +
                "Priestess\n" +
                "Empress\n" +
                "Emperor\n" +
                "Hierophant\n" +
                "Lovers\n" +
                "Chariot\n" +
                "Justice\n" +
                "Hermit\n" +
                "Fortune\n" +
                "Strength\n" +
                "Hanged Man\n" +
                "Death\n" +
                "Temperance\n" +
                "Devil\n" +
                "Tower\n" +
                "Star\n" +
                "Moon\n" +
                "Sun\n" +
                "Judgement");
        String entidad = scanner.nextLine();

        try{
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM persona WHERE nombre_arcana = '" + entidad + "'");
        }catch (SQLException e){
            System.out.println("No se han podido borrar los parametros seleccionados");
        }
    }
}
