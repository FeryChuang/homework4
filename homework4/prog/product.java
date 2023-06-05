package homework4.prog;

public class product {
	private String name;
	private int cost;
	private int sale;
	private int stock;


	public product(String name, int cost, int sale,int stock){
		if (name!=null && cost>0 && sale>0 && stock>0) {
			this.name=name;
			this.cost=cost;
			this.sale=sale;
			this.stock=stock;
		}	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name!=null) {
			this.name = name;
		}	
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		if (cost>0) {
			this.cost = cost;
		}	
	}


	public int getSale() {
		return sale;
	}


	public void setSale(int sale) {
		if(sale>0) {
			this.sale = sale;
		}	
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void show() {
		System.out.println("name="+name+"\tcost="+cost+"\tsale="+sale+"\tstock"+stock);
	}
}
