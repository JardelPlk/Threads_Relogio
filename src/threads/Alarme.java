package threads;

public class Alarme implements Runnable {

	Data data;
	
	public Alarme(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		while(data.opcaoAlarme) {
		
			if(data.hora == data.alarmeH && data.minuto == data.alarmeM) {
				System.out.println("");
				System.out.println(" ______   _       ______   ______   _________   _____");
				System.out.println("|  __  | | |     |  __  | |  __  | |  _   _  | |  ___|");
				System.out.println("| |__| | | |     | |__| | | |  |_| | | | | | | | |___");
				System.out.println("|  __  | | |     |  __  | | |      | | | | | | |  ___|");
				System.out.println("| |  | | | |___  | |  | | | |      | | |_| | | | |___");
				System.out.println("|_|  |_| |_____| |_|  |_| |_|      |_|     |_| |_____|");

				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
