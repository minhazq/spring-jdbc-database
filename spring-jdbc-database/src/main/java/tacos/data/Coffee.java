package tacos.data;

public class Coffee {

	
	String coffeetype;
	String milktype;
	int sugerquantity;
	
	public Coffee(String coffeetype,String milktype,int sugerquantity) {
		this.coffeetype=coffeetype;
		this.milktype = milktype;
		this.sugerquantity=sugerquantity;
	}

	public String getCoffeetype() {
		return coffeetype;
	}

	public void setCoffeetype(String coffeetype) {
		this.coffeetype = coffeetype;
	}

	public String getMilktype() {
		return milktype;
	}

	public void setMilktype(String milktype) {
		this.milktype = milktype;
	}

	public int getSugerquantity() {
		return sugerquantity;
	}

	public void setSugerquantity(int sugerquantity) {
		this.sugerquantity = sugerquantity;
	}
	
}
