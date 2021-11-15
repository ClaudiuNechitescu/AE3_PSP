package es.florida.AE3_PSP;

import java.util.*;

public class App {
	/**
	 * Método main que crea 10 hilos, los cuales inician el run de cada minero
	 * 
	 * @author Claudiu Andrei Nechitescu
	 * */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Thread> threads = new ArrayList<Thread>();
		int stockInicial = 50;
		Mina mina = new Mina(50);
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(new Minero(mina)));
			threads.get(i).setName("Minero " + (i + 1));
			threads.get(i).start();
		}
		while (mina.getStock() > 0) {
			Thread.sleep(2000);
		}
		System.out.println("Stock inicial de la mina: " + stockInicial + " recursos. Recursos extraídos: "+Mina.totalExtraido);
	}

}
