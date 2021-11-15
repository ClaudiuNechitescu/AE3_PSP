package es.florida.AE3_PSP;


public class Minero implements Runnable{
	int bolsa;
	int tiempoExtraccion=1000;
	Mina mina;
	
	
	public Minero(Mina mina) {
		this.bolsa=0;
		this.mina=mina;
	}
	/**
	 * Método que extrae una cantidad aleatoria entre 1 y 10 de recursos
	 * 
	 * @author Claudiu Andrei Nechitescu
	 * */
	public void extraerRecurso() throws InterruptedException {
		while(mina.getStock() > 0) {
			int extraidos = (int) (Math.random()*10)+1;
			synchronized (mina) {
				if((mina.getStock() - extraidos) >= 0) {
					mina.setStock(mina.getStock()-extraidos);
					Mina.totalExtraido+=extraidos;
					bolsa += extraidos;
					System.out.println(Thread.currentThread().getName() + " ha extraído " + extraidos + " recursos."+" Ha extraído " + this.bolsa+" recursos en total."+" Quedan "+mina.getStock()+" recursos por extraer.");
					Thread.sleep(tiempoExtraccion);
				} else {
					System.out.println(Thread.currentThread().getName() + " no puede extraer " + extraidos + ", solo quedan " + mina.getStock()+" recursos.");
				}
			}
		}
		
		
		
	}
	
	/**
	 * Método heredado que inicia el thread
	 * 
	 * @author Claudiu Andrei Nechitescu
	 * */
	@Override
	public void run() {
		try {
			extraerRecurso();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
