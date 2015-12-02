package org.tov.exceptions;

import javax.ejb.ApplicationException;

/**
 * 
 * @author <a mailto="ngromaricokemba@gmail.com">Romaric Okemba Architecte</a>
 * La classe qui gère les exceptions de l'application.
 * 
 */

@ApplicationException(rollback=true)
public class TovException extends Exception {
	
	public TovException(){
		
	}
	
    public TovException(String msg){
		super(msg);
	}
    
    public TovException(String msg,Throwable cause){
		super(msg,cause);
	}

}
