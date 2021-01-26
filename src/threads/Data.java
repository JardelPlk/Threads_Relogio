package threads;

public class Data {
	
	public int hora;
	public int minuto;
	public int segundo;
	public int alarmeH;
	public int alarmeM;
	public int cronometroH;
	public int cronometroM;
	public int cronometroS;
	public boolean opcaoAlarme;
	public boolean opcaoCronometro;
	public boolean opcaoRelogio;
	
	public Data() {
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
		this.alarmeH = 0;
		this.alarmeM = 0;
		this.cronometroH = 0;
		this.cronometroM = 0;
		this.cronometroS = 0;
		this.opcaoRelogio = true;
		this.opcaoAlarme = true;
	}
	
	public int getSegundo() {
		return segundo;
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	public int getHora() {
		return hora;
	}
	
	public void zerarCronometro() {
		cronometroS = 0;
		cronometroM = 0;
		cronometroH = 0;
	}
	
}
