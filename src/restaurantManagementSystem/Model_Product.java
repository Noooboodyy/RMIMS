package restaurantManagementSystem;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Product {



    public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Model_Product(ImageIcon icon, String productName, String price) {
        this.icon = icon;
        this.productName = productName;
        this.price = price;
    }

    private ImageIcon icon;
    private String productName;
    private String price;
}
