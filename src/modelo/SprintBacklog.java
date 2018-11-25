package modelo;

import java.util.ArrayList;

import modelo.Tarea.Estado;

public class SprintBacklog extends Backlog{
	
	private ArrayList<Tarea> lista;

//	private ArrayList<Tarea> toDo;
//	private ArrayList<Tarea> doing;
//	private ArrayList<Tarea> test;
//	private ArrayList<Tarea> finished;
	
	
	public SprintBacklog() {
//		toDo = new ArrayList<Tarea>();
//		doing = new ArrayList<Tarea>();
//		test = new ArrayList<Tarea>();
//		finished = new ArrayList<Tarea>();
//		
		lista = new ArrayList<Tarea>();
//		listas.add(toDo);
//		listas.add(doing);
//		listas.add(test);
//		listas.add(finished);
		
	}
	
	public ArrayList<Tarea> getLista() {
		return lista;
	}
	
	public void addTarea(Tarea tarea){
		lista.add(tarea);
	}

//	//getter y setter toDo
//	public void addTareaToDo(Tarea tarea){
//		tarea.setEstado(Estado.TODO);
//		toDo.add(tarea);
//	}
//
//	public Tarea getTareaToDo(Tarea tarea) {
//		return toDo.get(toDo.indexOf(tarea));
//	}
//
//	//getter y setter doing
//	public Tarea getTareaDoing(Tarea tarea) {
//		return doing.get(doing.indexOf(tarea));
//	}
//
//	public void addTareaDoing(Tarea tarea) {
//		tarea.setEstado(Estado.DOING);
//
//		doing.add(tarea);
//	}
//
//	//getter y setter test
//	public Tarea getTareaTest(Tarea tarea) {
//		return test.get(test.indexOf(tarea));
//	}
//
//	public void addTareaTest(Tarea tarea) {
//		tarea.setEstado(Estado.TESTING);
//
//		test.add(tarea);
//	}
//
//	//getter y setter finished
//	public Tarea getTareaFinished(Tarea tarea) {
//		return finished.get(finished.indexOf(tarea));
//	}
//
//	public void addTareaFinished(Tarea tarea) {
//		tarea.setEstado(Estado.FINISHED);
//
//		finished.add(tarea);
//	}
//	
	public void printear(){
		for(Tarea tarea: lista){
			System.out.println(tarea.getTitulo()+" : "+tarea.getEstado());
		}
	}
//
//	public ArrayList<Tarea> getToDo() {
//		return toDo;
//	}
//
//	public ArrayList<Tarea> getDoing() {
//		return doing;
//	}
//
//	public ArrayList<Tarea> getTest() {
//		return test;
//	}
//
//	public ArrayList<Tarea> getFinished() {
//		return finished;
//	}
	
	
	
	

}
