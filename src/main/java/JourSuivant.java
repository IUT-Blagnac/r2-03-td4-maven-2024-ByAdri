
/**
 * Indiquer le ou les numeros de TP et d'exercice.
 *
 * @author (votre nom)
 */

import java.util.Scanner;
 
public class JourSuivant 
{
    /**
     * Fait saisir une date à l'utilisateur
     *
     * @param pfDate OUT : un tableau de trois cases représentant une
     * date. 1ere case : jour, 2nde case : mois, 3eme case : annee
     *
     */
    public static void saisieDate(int[] pfDate) {
        
    if (pfDate.length != 3) {
        System.out.print("Le tableau représentant la date a une taille inattendue : ");
        System.out.println(pfDate.length + " case(s) au lieu de 3 !");
    }
    
    else {
    Scanner clavier = new Scanner(System.in);
    
    System.out.println("Donnez le jour de la date ?");
    int jour = clavier.nextInt() ;
    System.out.println("Donnez le mois de la date ?");
    int mois = clavier.nextInt() ;
    System.out.println("Donnez l'annee de la date ?");
    int annee = clavier.nextInt() ;
    
    pfDate[0] = jour;
    pfDate[1] = mois;
    pfDate[2] = annee;
    
    }
    }

    public static boolean estBissextile(int annee) {
        if(annee%4 == 0 && annee%100 != 0 || annee%400 == 0){
            return true;
        }
        return false ;
    }
    
    public static int nbJours(int mois, int annee) {
        
    if(mois == 2){       
        if (estBissextile(annee)){
            return 29;
        }
        else {
            return 28;
        }
    }
    else {
        if(mois == 4 || mois == 6 || mois == 9 || mois == 11){
            return 30;
        }
        else {
            return 31;
        }
    }
    }

    /**
     * Calcul la validité d'une date
     *
     * @param pfDate IN : date initiale
     * @return true si et seulement si pfDate est valide
     *
     */
    public static boolean dateValide(int[] pfDate) {
        
    if (pfDate.length != 3) {
        System.out.print("Un tableau représentant une date a une taille inattendue : ");
        System.out.println(pfDate + " case(s) au lieu de 3 !");
        return false ;
    }
    
    if( pfDate[0]>=1 && pfDate[0]<=nbJours(pfDate[1], pfDate[2]) && pfDate[1]>=1 && pfDate[1]<=12 && 1582<pfDate[2]){
        return true;
    }
    else{
        return false;
    }
    
    }

    /**
     * Calcul du jour suivant
     *
     * @param pfDateJourCourant IN : date initiale
     * @param pfDateJourSuivant OUT : date du jour suivant
     *
     */
    public static void jourSuivant(int[] pfDateJourCourant, int[] pfDateJourSuivant) {
        
    if (pfDateJourCourant.length != 3 || pfDateJourSuivant.length != 3) {
        System.out.print("Un tableau représentant une date a une taille inattendue : ");
        System.out.println(pfDateJourCourant.length + " ou " + pfDateJourSuivant.length + " case(s) au lieu de 3 !");
    }
    
    else{
    
    
    if( pfDateJourCourant[0] == nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) ){
        
        pfDateJourSuivant[0] = 1;
        
        if( pfDateJourCourant[1] == 12 ){
            pfDateJourSuivant[2] = pfDateJourCourant[2] + 1;
            pfDateJourSuivant[1] = 1;
        }
        else{
       
            pfDateJourSuivant[1] = pfDateJourCourant[1] + 1;
            pfDateJourSuivant[2] =  pfDateJourCourant[2] ;
      }
    
    }
    else{
        pfDateJourSuivant[0] = pfDateJourCourant[0] + 1;
        pfDateJourSuivant[1] =  pfDateJourCourant[1] ;
        pfDateJourSuivant[2] =  pfDateJourCourant[2] ;
    }
    
    }
    }
 
    public static void main(String [] args) {

    /* Déclaration des variables */
    int[] date = new int[3] ;
    int[] dateJS = new int[3] ;
    int[] dateS = new int[3] ;
    boolean valide = false ;

    Scanner clavier = new Scanner(System.in);
  
    saisieDate(date); // appel d'une procédure (retourne rien)   
    valide =  dateValide(date) ; // appel d'une fonction
    
    if (valide == true) {
        jourSuivant(date, dateJS);  // appel d'une procédure (retourne rien)
        System.out.println("La jour suivant est : "+ dateJS[0] + "/" + dateJS[1] + "/" + dateJS[2]);
        
    } 
    
    else {
        
        System.out.println("La date du "
                   + date[0] + "/" + date[1] + "/" + date[2]
                   + " n'est pas une date valide.");
                   
    }
     
    if (valide == true) {
 
        surlendemain(date, dateJS, dateS);  // appel d'une procédure (retourne rien)
        System.out.println("La surlendemain est : "+ dateS[0] + "/" + dateS[1] + "/" + dateS[2]);
        
    } 
    
    else { 
        System.out.println("La date du "
                   + date[0] + "/" + date[1] + "/" + date[2]
                   + " n'est pas une date valide.");      
    }
    
    } 

    /**
     * Calcul du surlendemain d'une date donnée
     *
     * @param pfDateJourCourant IN : date initiale
     * @param pfDateJourSuivant IN : date jour suivant
     * @param pfDateJourSurlendemain OUT : date du surlendemain
     *
     */
    public static void surlendemain(int[] pfDateJourCourant, int[] pfDateJourSuivant, int[] pfDateJourSurlendemain){
        
        if (pfDateJourCourant.length != 3 || pfDateJourSuivant.length != 3 || pfDateJourSurlendemain.length != 3) {
        System.out.print("Un tableau représentant une date a une taille inattendue : ");
        System.out.println(pfDateJourCourant.length + " ou " + pfDateJourSuivant.length + "ou" + pfDateJourSurlendemain.length +" case(s) au lieu de 3 !");
    }
    
    else{
    
    
    if( pfDateJourCourant[0] == nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) ){
        
        pfDateJourSuivant[0] = 1;
        pfDateJourSurlendemain[0] = 2;
        
        if( pfDateJourCourant[1] == 12 ){
            pfDateJourSuivant[2] = pfDateJourCourant[2] + 1;
            pfDateJourSuivant[1] = 1;
            pfDateJourSurlendemain[2] = pfDateJourCourant[2] + 1;
            pfDateJourSurlendemain[1] = 1;
        }
        else{
            pfDateJourSuivant[1] = pfDateJourCourant[1] + 1;
            pfDateJourSuivant[2] =  pfDateJourCourant[2] ;
            pfDateJourSurlendemain[1] = pfDateJourSuivant[1] + 1;
            pfDateJourSurlendemain[2] = pfDateJourSuivant[2] ;
            
      }
    
    }
    else{
        pfDateJourSuivant[0] =  pfDateJourCourant[0] + 1;
        pfDateJourSuivant[1] =  pfDateJourCourant[1] ;
        pfDateJourSuivant[2] =  pfDateJourCourant[2] ;
        pfDateJourSurlendemain[0] =  pfDateJourSuivant[0] + 1;
        pfDateJourSurlendemain[1] =  pfDateJourSuivant[1] ;
        pfDateJourSurlendemain[2] =  pfDateJourSuivant[2] ;
        
    }
    
    }  
    }
    
}



