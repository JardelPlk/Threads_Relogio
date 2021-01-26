package threads;

public class Cronometro implements Runnable {
	
	Data data;
	
	public Cronometro(Data data) {
		this.data = data;
	}
		
	@Override
	public void run() {
		while(data.opcaoCronometro) {
		
			//Usamos a mesma lógica do relógio
			data.cronometroS++;
			
			if(data.cronometroS==60) {
				data.cronometroS=0;
				data.cronometroM++;
			}
			
			if(data.cronometroM==60) {
				data.cronometroM=0;
				data.cronometroH++;
			}
			
			if(data.cronometroH==24) 
				data.cronometroH=0;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
