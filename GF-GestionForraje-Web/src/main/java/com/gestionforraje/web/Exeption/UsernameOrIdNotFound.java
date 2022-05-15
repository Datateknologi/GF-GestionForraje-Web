package com.gestionforraje.web.Exeption;

public class UsernameOrIdNotFound extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 9127927529989904609L;

	public UsernameOrIdNotFound(){
        super("Usuario o Id no encontrado");
    }

    public UsernameOrIdNotFound(String message){
        super(message);
    }

}
