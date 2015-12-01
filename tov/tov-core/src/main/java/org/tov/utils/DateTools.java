package org.tov.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateTools {

	/**
	 * Format de stockage de la Date. 
	 */
	
	private static final SimpleDateFormat FORMAT_DATE_BD = new SimpleDateFormat("yyyyMMdd");
	
	/***
	 * Format d'affichage de la date au niveau utiisateur pour les Francrophones
	 */
	
	private static final SimpleDateFormat FORMAT_DATE_FR = new SimpleDateFormat("dd/MM/yyyy");
	
	
	/**
	 * Format d'affichage de la date niveau utilisateur pour anglophones
	 */
	
	private static final SimpleDateFormat FORMAT_DATE_EN = new SimpleDateFormat("yyyy/MM/ddd");
	
	
	/**
	 * Format date Complete 
	 */
	
	private static final String FORMAT_DATE_COMPLETE = "yyyyMMddHHmmSS";
	
	/**
	 * Objet utisant un format de date complet
	 * 
	 */
	
	private static final SimpleDateFormat OBJET_FORMAT_DATE_COMPLETE = new SimpleDateFormat(FORMAT_DATE_COMPLETE);
	

	/**
	 * Méthode qui permet de construire une date au format retenue par l'application
	 * @param date
	 * @return {@link String}
	 */
	
	public static String getDate(Date date) {
		SimpleDateFormat simpleFormat = DateTools.FORMAT_DATE_BD;
		String maDate = simpleFormat.format(date);
		return simpleFormat.format(date);
	}
	
	
	/**
	 * Renvoit une date au format EN
	 * @param date
	 * @return {@link String}
	 */
	public static String getDateEN(Date date) {
		SimpleDateFormat simpleFormat = DateTools.FORMAT_DATE_FR;
		String maDate = simpleFormat.format(date);
		return simpleFormat.format(date);
	}
	
	
	/**
	 * Renvoit une date au format FR
	 * @param date
	 * @return {@link String}
	 */
	public static String getDateFR(Date date) {
		SimpleDateFormat simpleFormat = DateTools.FORMAT_DATE_FR;
		String maDate = simpleFormat.format(date);
		return simpleFormat.format(date);
	}
	
	
	/**
	 * renvoie une date au format complte en string 
	 * @param date
	 * @return {@link String}
	 */

	public static String getDateToString(Date date) {
		SimpleDateFormat simpleFormat = DateTools.OBJET_FORMAT_DATE_COMPLETE;
		String maDate = simpleFormat.format(date);
		return simpleFormat.format(date);
	}
	
	/***
	 * Renvoi la date au format Complet
	 * @param p$strDate
	 * @return {@link Date}
	 * @throws java.text.ParseException
	 */

	public static Date getDateValue(String p$strDate)throws java.text.ParseException {
		Date date;
		SimpleDateFormat formater = new SimpleDateFormat(FORMAT_DATE_COMPLETE);
		if (p$strDate == null || p$strDate.trim().isEmpty())
			return null;

		date = formater.parse(p$strDate);
		return date;
	}


	
	
	/***
	 *  Renvoie la différence entre deux dates.
	 * @param dateStart
	 * @param dateStart
	 * @return {@link Long}
	 */
	
	public static long getIntervaleOfDate(Date dateStart,Date dateEnd){
		
		
		long time1 = dateStart.getTime();
		long time2 = dateStart.getTime();
		long diff = time2 - time1;
		
		long val= diff/(1000*60*60*24);
	     
		return val;
	}
	
	/***
	 * Permet de retourner le N° d'une date, de savoir si c'est lundi ou mardi mais
	 * ce sont les positions des jours qui sont renvoyées
	 * 
	 * @param date
	 * @return {@link String}
	 */
	
	public static String getDayOfDate(Date date){
		
		//Position du Jour à 
		String numberOfDay = null;
		
		GregorianCalendar calendar =new GregorianCalendar();
		
		calendar.setTime(date);
		
		//On récupère la date en format entier
		int dateSearch =calendar.get(calendar.DAY_OF_WEEK);
	 
		switch (dateSearch) {
		
		case GregorianCalendar.MONDAY:
			//on lui affecte lundi
			numberOfDay=Day.MONDAY;
			
			break;
		case GregorianCalendar.TUESDAY:
			
			numberOfDay=Day.TUESDAY;
			break;
			
		case GregorianCalendar.WEDNESDAY:
			
			numberOfDay=Day.WEDNESDAY;
			break;
			
		case GregorianCalendar.THURSDAY:
			
			numberOfDay=Day.THURSDAY;
			break;
			
		case GregorianCalendar.FRIDAY:
			
			numberOfDay=Day.THURSDAY;
			break;
			
		case GregorianCalendar.SATURDAY:
			
			numberOfDay=Day.SATURDAY;
			break;
			
		case GregorianCalendar.SUNDAY:
			numberOfDay=Day.SUNDAY;
			break;
		default:
			//ça devrait pas erreur
			break;
		}
		
		return numberOfDay;
	}


}
