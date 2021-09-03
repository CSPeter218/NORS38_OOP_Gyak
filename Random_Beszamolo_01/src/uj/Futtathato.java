package uj;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import sajat.*;
import sajat.Mobil.Gyarto;
import sajat.OkosMobil.OperaciosRendszer;

public class Futtathato  {

	public static void main(String[] args) {
		
		OkosMobil mobilok[] = new OkosMobil[5];
		feltolt(mobilok);
		kiir(mobilok);
		Arrays.sort(mobilok, new ArSzerint());
		System.out.println("Rendezett tomb: ");
		kiir(mobilok);
		
		System.out.println("A legmagasabb ár/érték arányú mobil: " +getLegmagasabbArErtek(mobilok));
		getGyartokSzama(mobilok);
		
	}
	
	private static void getGyartokSzama(OkosMobil mobilok[]) {
		
		boolean checkedGyartok[] = new boolean[mobilok.length];
		
		for(int i = 0; i < mobilok.length; i++) {
			
			if(checkedGyartok[i] == true) {
				continue;
			}
			
			int count = 0;
			
			for(int j = i + 1; j < mobilok.length; j++) {
				
				if(mobilok[i].getGyarto().toString().equalsIgnoreCase(mobilok[j].getGyarto().toString())) {
					checkedGyartok[j] = true;
					count++;
				}
				
			}
			System.out.println(mobilok[i].getGyarto() + " " + count);
		}
		
	}
	
	public static int getLegmagasabbArErtek(OkosMobil mobilok[]) {
		int index = 0;
		
		for(int i = 0; i < mobilok.length; i++) {
			if (mobilok[index].arErtek() > mobilok[i].arErtek()) {
				index = i;
			}
		}
		
		return index;
	}
	
	private static void kiir(OkosMobil mobilok[]) {
		for(int i = 0; i < mobilok.length; i++) {
			System.out.println(mobilok[i].toString());
		}
	}
	
	public static class ArSzerint implements Comparator<Mobil> {
			public int compare(Mobil o1, Mobil o2) {
				return o1.getAr() - o2.getAr();
			}
	}
	
	
	private static void feltolt(OkosMobil mobilok[]) {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < mobilok.length; i++) {
			
			String gyarto;
			int ar;
			String datumString;
			LocalDate datum;
			String os;
			int memoria;
			int cpuMagok;
		
			System.out.println("Add meg a gyártót: ");
			gyarto = input.nextLine();
			
			System.out.println("Add meg az árát: ");
			ar = ellenBeolv(input);
			input.nextLine();
			
			System.out.println("Add meg a dátumot: ");
			datumString = input.nextLine();
			
			datum = LocalDate.parse(datumString);
			
			System.out.println("Add meg az OS-t: ");
			os = input.nextLine();
			
			System.out.println("Add meg a memória méretét: ");
			memoria = ellenBeolv(input);
			input.nextLine();
			
			System.out.println("Add meg a CPU magok számát: ");
			cpuMagok = ellenBeolv(input);
			input.nextLine();
			
			mobilok[i] = new OkosMobil(Gyarto.valueOf(gyarto), ar, datum, OperaciosRendszer.valueOf(os), memoria, cpuMagok);
			
		}
		input.close();
	}
	
	private static int ellenBeolv(Scanner scanner) {
		int szam;
		do {
			//System.out.println("Add meg a szamot: ");
			while(!scanner.hasNextInt()) {
				System.out.println("Ez nem szám!");
				scanner.next();
			}
			szam = scanner.nextInt();
			break;
		} while(true);
		return szam;
	}
}
