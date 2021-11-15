package es.florida.AE3_PSP;

public class Mina {
	int stock;
	static int totalExtraido=0;
	public Mina(int stock) {
		this.stock = stock;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public void setStock(int valor) {
		this.stock=valor;
	}
}
