package restaurantManagementSystem;

import javax.swing.ImageIcon;

public class Model_CurrentUser {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getImageAvatar() {
		return imageAvatar;
	}
	public void setImageAvatar(String imageAvatar) {
		this.imageAvatar = imageAvatar;
	}
	public Model_CurrentUser(String imagePath, String position, String name) {
        this.imageAvatar = imagePath;
        this.name = name;
        this.position = position;
    }
	public Model_CurrentUser(String position, String name) {
        this.name = name;
        this.position = position;
    }

	
	private String name;
	private String position;
	private String imageAvatar;
}
