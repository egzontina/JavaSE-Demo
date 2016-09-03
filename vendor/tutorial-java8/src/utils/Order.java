package utils;
import java.util.List;


public class Order {
	
	private Long orderRef;
	private List<Product> product;
	
	
	public Long getOrderRef() {
		return orderRef;
	}
	public void setOrderRef(Long orderRef) {
		this.orderRef = orderRef;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	

}
