package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACBMenu {
	private int option;

	public ACBMenu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Borrar tablas");
			System.out.println("2. Crear tablas");
			System.out.println("3. Poblar masivamente la base de datos de demonios (persona/arcana)");
			System.out.println("4. Isertar un nuevo persona en la tabla de persona");
			System.out.println("5. Seleccionar todos los elementos de la tabla persona");
			System.out.println("6. Seleccionar todos los elementos de la tabla arcana");
			System.out.println("7. Seleccionar a un persona concreto por su nombre");
			System.out.println("8. Seleccionar todos los persona que tengan el mismo arcana");
			System.out.println("9. Seleccionar un persona y cambia su nombre");
			System.out.println("10. Modificar un conjunto de persona de arcana");
			System.out.println("11. Eliminar un registro concreto de la tabla arcana");
			System.out.println("12. Eliminar un conjunto de personas de un mismo arcana");
			System.out.println("13. Salir del programa");
			System.out.println("Escoge una opcion: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no vàlid");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10 && option != 11 && option != 12 && option != 13);

		return option;
	}

	public Identity authenticate(int tries) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("============================ACB=============================");
		System.out.println("============================================================");
		System.out.println("Avís: tens " + (3 - tries) + " intents per loginarte");
		System.out.println("============================================================");
		System.out.println("Inserta nom del usuari: ");
		String user = br.readLine();
		System.out.println("Inserta contrasenya: ");
		String password = br.readLine();

		Identity identity = new Identity(user, password);
		return identity;

	}

}
