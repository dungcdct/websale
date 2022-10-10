package entity;

public class seller extends user {

	private String ID_card;

	
	public seller(String username, String fullname, String address, String phone, String category, String email,
			String nameAvatar ,String id_card) {
		super(username, fullname, address, phone, category, email, nameAvatar);
		this.ID_card = id_card;
	}

	public String getID_card() {
		return ID_card;
	}

	public void setID_card(String iD_card) {
		ID_card = iD_card;
	}

	@Override
	public String toString() {
		return super.toString() + ",ID card : " + this.ID_card;
	}
}
