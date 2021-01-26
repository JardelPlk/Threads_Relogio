package threads;

public class Relogio implements Runnable {

	Data data;
	
	public Relogio(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		while(data.opcaoAlarme) {
			
			//A cada 1000 milisegundos da sleep aumentamos incrementamos o segundo
			//Quando chegar a 60 incrementamos o minuto e zeramos o segundo
			//Quando o minuto chegar a 60 incrementamos a hora e zeramos o minuto
			//E quando a hora chegar a 24 reinicializamos ela
			data.segundo++;
			
			if(data.segundo==60) {
				data.segundo=0;
				data.minuto++;
			}
			
			if(data.minuto==60) {
				data.minuto=0;
				data.hora++;
			}
			
			if(data.hora==24) 
				data.hora=0;
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
