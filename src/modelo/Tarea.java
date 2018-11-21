/**
 * 
 */
package modelo;

import com.sun.org.apache.xpath.internal.axes.RTFIterator;

/**
 * @author Sergio
 *
 */
public class Tarea {
	private String titulo, descripcion;
	private float coste, beneficio;
	private Requisito requisito;
	private MiembroDeEquipo asignadoA;
	
	public Tarea(Requisito requisito, MiembroDeEquipo asignadoA, String titulo, String descripcion, float coste, float beneficio) {
		this.requisito = requisito;
		this.asignadoA = asignadoA;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.coste = coste;
		this.beneficio = beneficio;
	}
	
	public void asignarMiembro (MiembroDeEquipo miem){
		this.asignadoA = miem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public float getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(float beneficio) {
		this.beneficio = beneficio;
	}

	public Requisito getRequisito() {
		return requisito;
	}

	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}

	public MiembroDeEquipo getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(MiembroDeEquipo asignadoA) {
		this.asignadoA = asignadoA;
	}
	
}
