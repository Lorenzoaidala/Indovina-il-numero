package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;

public class Model {
	
	private final int NMAX= 100;
	private final int TMAX= 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;

	public void nuovaPartita() {
		this.segreto = (int) ((Math.random()*NMAX)+1);
    	this.tentativiFatti = 0;
    	this.inGioco = true;
	}
	
	public int tentativo(int tentativo) {
		//controllo se la partita è in corso
		if(!inGioco) {
			throw new IllegalStateException("La partita è già terminata");
		}
		//controllo input
		 if(!tentativoValido(tentativo)){
			throw new InvalidParameterException("Devi inserire un numero fra 1 ed NMAX");
		}
		 //il tentativo è valido
		 this.tentativiFatti++;
		 
		 if(this.tentativiFatti == TMAX) {
			 this.inGioco = false;
		 }
		 
		 if(tentativo == this.segreto) {
			 this.inGioco = false;
			 return 0;
		 }
			 else if(tentativo < this.segreto)
				 return -1;
			 else
				 return 1;
		 
	}
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo<1 || tentativo>NMAX)
			return false;
		else
			return true;
	}

	public int getSegreto() {
		return segreto;
	}

	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public void setTentativiFatti(int tentativiFatti) {
		this.tentativiFatti = tentativiFatti;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}
	
}
