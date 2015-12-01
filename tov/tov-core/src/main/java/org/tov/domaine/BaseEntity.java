package org.tov.domaine;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import org.tov.utils.DateTools;

/**
 * 
 * @author <a mailto="ngromaricokemba@gmail.com">Romaric Okemba Architecte<a/>
 * Cette classe est la base de toutes les entités du domaine de l'application.
 *
 *
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable,Cloneable{
	
	/**
	 * Code généré par Eclipse
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Code de l'utilisateur qui a cré l'application
	 */
	
	@Column(name="C_USR_CRE")
	protected String codeUsrCre;
	
	/**
	 * Code de l'utilisateur qui a modifié
	 */
	
	@Column(name="C_USR_MOD")
	private String codeUsrMod;
	
	/**
	 * Code de l'utilisateur qui a supprimé l'entité
	 */
	@Column(name="C_USR_DEL")
	private String codeUsrDel;
	
	/**
	 * etat de l'entité
	 */
	@Column(name="ETAT")
	private String etat;
	
	/**
	 * Date création de l'entité
	 */
	@Column(name="D_CREATION")
	private String dateCreate;
	
	/**
	 * Date modification de l'entité
	 */
	@Column(name="D_UPDATE")
	private String dateUpdate;
	
	
	/**
	 * Version de l'entité
	 */
	
	@Version
	@Column(name="VERSION")
	private long vrsion;
	
	/**
	 * Méthode qui s'execute avant la création de l'entité en Base de données
	 */
	
	@PrePersist
	public void prePersist(){
		
		if (this.dateCreate==null){
			//On affecte la date de création
			this.dateCreate=DateTools.getDateToString(new Date());
		}else{
			//On modification
			this.dateUpdate=DateTools.getDateToString(new Date());
		}
	
	}
	

	/**
	 * Méthode qui permet de retourner une chaine de caractère contenant le nom de L'entité
	 * @return {@link String}
	 */
	public abstract String getEntityCode();
	
	
	/**
	 *  Permet de cloner un objet. Intérressant pour créer un objet en partant d'ue copie
	 *   @return {@link Object}
	 */
	
     @Override
    public Object clone() throws CloneNotSupportedException {
    	
    	return super.clone();
    }
     
     /**
      * Renvoi la date de création de l'entité au format Date
      * @return {@link Date}
      */
     public Date getDateDateCreation(){
    	 try {
			return DateTools.getDateValue(this.dateCreate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
     }
     
     /**
      * Renvoi la date de modification de l'entité au format Date
      * @return {@link Date}
      */
     
     public Date getDateModification(){
    	 try {
			return DateTools.getDateValue(this.dateUpdate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
     }
     

	/**
	 * 
	 * @return {@link Serializable}
	 * Permet de retourner la valeur de la clé d'une entité.
	 * 
	 */
	
   public abstract Serializable  getId();
   
   /**
    * Méthode qui permet de modifier la valeur de la clé d'une entité
    * @param id
    */
 
   public abstract void setId(Serializable id);

   
//getters and Setters
   
public String getCodeUsrCre() {
	return codeUsrCre;
}

public void setCodeUsrCre(String codeUsrCre) {
	this.codeUsrCre = codeUsrCre;
}

public String getCodeUsrMod() {
	return codeUsrMod;
}

public void setCodeUsrMod(String codeUsrMod) {
	this.codeUsrMod = codeUsrMod;
}

public String getCodeUsrDel() {
	return codeUsrDel;
}

public void setCodeUsrDel(String codeUsrDel) {
	this.codeUsrDel = codeUsrDel;
}

public String getEtat() {
	return etat;
}

public void setEtat(String etat) {
	this.etat = etat;
}

public long getVrsion() {
	return vrsion;
}

public void setVrsion(long vrsion) {
	this.vrsion = vrsion;
}

public String getDateCreate() {
	return dateCreate;
}

public void setDateCreate(String dateCreate) {
	this.dateCreate = dateCreate;
}

public String getDateUpdate() {
	return dateUpdate;
}

public void setDateUpdate(String dateUpdate) {
	this.dateUpdate = dateUpdate;
}
  
}
