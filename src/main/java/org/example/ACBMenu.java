package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

/**
 *Desde esta clase relacionado con el menu que controla en el main aqui mostraremos las opciones posibles para que el
 * usuario decida que quiere hacer, tendrá efecto en la base de datos.
 *
 *  @author Jonathan Carralero - Joki69 in GitHub
 */
public class ACBMenu {
	private int option;

	private Scanner scanner = new Scanner(System.in);
	public ACBMenu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println(" \nMENU PRINCIPAL \n");
			System.out.println("Escoge una opcion: ");

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
			System.out.println("0. Salir del programa");

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

	/**
	 * Es esta parte del codigo podremos asegurar que el usuario elige uno de los arcana correctos y ademas evitaremos
	 * tener codigo repetido dentro del resto de clases.
	 *
	 * @return
	 */
	public String arcanaChek() {
		while (true) {
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
			String entidad= scanner.nextLine();
			String comprobar = entidad.toLowerCase(Locale.ROOT);
			if (comprobar.equals("fool") || comprobar.equals("magician") || comprobar.equals("priestess") || comprobar.equals("empress")
					|| comprobar.equals("emperor") || comprobar.equals("hierophant") || comprobar.equals("lovers") || comprobar.equals("chariot")
					|| comprobar.equals("justice") || comprobar.equals("hermit") || comprobar.equals("fortune") || comprobar.equals("strength")
					|| comprobar.equals("hanged man") || comprobar.equals("death") || comprobar.equals("temperance") || comprobar.equals("devil")
					|| comprobar.equals("tower") || comprobar.equals("star") || comprobar.equals("moon") || comprobar.equals("sun") || comprobar.equals("judgement")) {
				return entidad;
			}
			else {
				System.out.println("No has seleccionado ninguna de las posibles opciones prueba otra vez\n");
			}

		}
	}

}
