package sajat;

import java.time.LocalDate;

public abstract class Mobil {
		
		private Gyarto gyarto;
		private int ar;
		private LocalDate megjelenesDatuma;
		
		public enum Gyarto {
			 HUAWEI,
			 SAMSUNG,
			 APPLE,
			 ASUS;
		 }
		
		public Mobil(Gyarto gyarto, int ar, LocalDate megjelenesDatuma) {
			super();
			this.gyarto = gyarto;
			this.ar = ar;
			this.megjelenesDatuma = megjelenesDatuma;
		}

		@Override
		public String toString() {
			return "Mobil [gyarto=" + gyarto + ", ar=" + ar + ", megjelenesDatuma=" + megjelenesDatuma + "]";
		}

		public Gyarto getGyarto() {
			return gyarto;
		}

		public void setGyarto(Gyarto gyarto) {
			this.gyarto = gyarto;
		}

		public int getAr() {
			return ar;
		}

		public void setAr(int ar) {
			this.ar = ar;
		}

		public LocalDate getMegjelenesDatuma() {
			return megjelenesDatuma;
		}

		public void setMegjelenesDatuma(LocalDate megjelenesDatuma) {
			this.megjelenesDatuma = megjelenesDatuma;
		}
		
		abstract public double arErtek();
		
}	
