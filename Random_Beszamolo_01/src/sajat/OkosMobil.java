package sajat;

import java.time.LocalDate;

public class OkosMobil extends Mobil {
	
	private OperaciosRendszer opRendszer;
	private int memoria;
	private int processszorMagokSzama;
	
	public OkosMobil(Gyarto gyarto, int ar, LocalDate megjelenesDatuma, OperaciosRendszer opRendszer, int memoria, int processszorMagokSzama) {
		super(gyarto, ar, megjelenesDatuma);
		this.opRendszer = opRendszer;
		this.memoria = memoria;
		this.processszorMagokSzama = processszorMagokSzama;
	}

	public OkosMobil(Gyarto gyarto, int ar, LocalDate megjelenesDatuma,  int memoria, int processszorMagokSzama) {
		super(gyarto, ar, megjelenesDatuma);
		this.opRendszer = opRendszer.ANDROID;
		this.memoria = memoria;
		this.processszorMagokSzama = processszorMagokSzama;
	}

	public enum OperaciosRendszer{
		ANDROID,
		IOS;
	}
	
	@Override
	public String toString() {
		return "OkosMobil [opRendszer=" + opRendszer + ", memoria=" + memoria + ", processszorMagokSzama="
				+ processszorMagokSzama + ", arErtek()=" + arErtek() + "]";
	}

	@Override
	public double arErtek() {
		return super.getAr() / (this.memoria * this.processszorMagokSzama);
	}

	public boolean nagyobbE(OkosMobil o1) {
		if(this.arErtek() > o1.arErtek()) {
			return true;
		}else return false;
	}
	
	public OperaciosRendszer getOpRendszer() {
		return opRendszer;
	}

	public void setOpRendszer(OperaciosRendszer opRendszer) {
		this.opRendszer = opRendszer;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public int getProcessszorMagokSzama() {
		return processszorMagokSzama;
	}

	public void setProcessszorMagokSzama(int processszorMagokSzama) {
		this.processszorMagokSzama = processszorMagokSzama;
	}
	
}
