package interfaz;

public class Contacto {
	private String nombre;
	private int telefono;
	private boolean persona;
	
	public Contacto(String nombre, int telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		persona = true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setPersona(boolean persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		String persona;
		if (this.persona==false) {
			persona="Familiar";
		} else {
			persona="Amigo";
		}
		return "Nombre: " + nombre + " TLF: " + telefono + " - " + persona;
	}
	
	
}

