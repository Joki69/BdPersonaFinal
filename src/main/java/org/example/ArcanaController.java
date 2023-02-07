package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArcanaController {
    private Connection connection;
    private Scanner scanner;

    public ArcanaController(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }


    public void borrarTablaArcana(){
        try{
            Statement st = connection.createStatement();

            st.executeUpdate("DROP TABLE arcana");
        }catch (SQLException e){
            System.out.println("No se ha podido borrar la tabla arcana");
        }
    }

    public void crearTablaArcana(){
        try{
            Statement st = connection.createStatement();

            st.executeUpdate("CREATE TABLE arcana (" +
                    "id_arcana serial," +
                    "nombre varchar(1000)," +
                    "primary key(id_arcana));");

            st.close();

        }catch (SQLException e){
            System.out.println("Error: No se pueden crear las tablas, fijate si ya estan creadas.");
        }
    }

    public void poblarArcana(){
        List<String[]> csvData = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Arcanas.csv"));
            String line;

            while ((line = br.readLine()) != null){
                String[] data = line.split("\n");
                csvData.add(data);
            }

            for (String[] data : csvData) {
                try{
                    String nombre = data[0];

                    String sql = "INSERT INTO arcana " + "(nombre) VALUES(?)";

                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1,nombre);

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

    public void mostrarArcana(){
        System.out.println("\nARCANAS");
        ResultSet rs = null;
        String sql = "SELECT * FROM arcana";
        try{
            Statement st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("******************************************************" +
                        "\nID Arcana: " + rs.getString("id_arcana") +
                        "\nNombre Arcana: " + rs.getString("nombre") +
                        "\n******************************************************");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            System.out.println("Error: La tabla characters no existe");
        }
    }

    public void borrarTablaArcanaNombre(){
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
            st.executeUpdate("DELETE FROM arcana WHERE nombre = '" + entidad + "'");
        }catch (SQLException e){
            System.out.println("No se ha podido borrar el parametro de arcana seleccionado");
        }
    }

}
