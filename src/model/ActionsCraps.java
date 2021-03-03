package model;

import controll.ControllCraps;

public interface ActionsCraps {
	
	String START_GAME="Iniciar Juego";
	
	//Menu
	String VIEW_ADD_PLAYER="Vista Añadir Jugador";
	String VIEW_GAME="Vista del Juego";
	String VIEW_DELETE_PLAYER="Eliminar Jugador";
	String LIST_PLAYER="Listar Jugadores";
	String HELP="Ayuda";
	
	//Acciones
	String ADD_PLAYER="Añadir Jugador";
	String THROW_DICE="Lanzar Dados";
	String PLAYER_START="Jugador inicial";
	String AGAIN_START="Empezar de cero";
	
	
	void exit();
	void begin();
	String[] readInput(String option);
	void writeOuput(String option,String[] output, boolean state);
	void setControll(ControllCraps controll);

}
