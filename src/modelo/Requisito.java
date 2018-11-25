package modelo;

public class Requisito {
	private int ID;
	private final int n = 0;
	private String texto;

	
	
	
	public Requisito(int id, String texto){
		this.ID=id;
		this.texto= texto;
	}

	public Requisito() {
		this.ID=n+1;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getID() {
		return ID;
	}
	

}
