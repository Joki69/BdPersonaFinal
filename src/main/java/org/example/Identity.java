package org.example;

/**
 * Desde esta clase generamos la identidad del dueño de la base de datos a la que accederemos
 *
 *  @author Jonathan Carralero - Joki69 in GitHub
 */
public class Identity {
	private String user;
	private String password;

	/**
	 * Con este contructor le pasaremos el nombre y la contraseña de nuestro usuario
	 * @param user
	 * @param password
	 */
	public Identity(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * Accederemos a la información del nombre
	 *
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Podremos modificar el nombre del usuario
	 *
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Podremos ver la contraseña del usuario
	 *
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Podremos modificar la contraseña del usuario
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Con este metodo mostraremos por terminal la información del usuario
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "Identity [user=" + user + ", password=" + password + "]";
	}

}
