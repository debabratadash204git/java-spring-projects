package builder;

public class User {
	
	private long id;
	private String username;
	private String email;
	private int phonenumber;
	private String address;
	
	

	private User(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.email = builder.email;
		this.phonenumber = builder.phonenumber;
		this.address = builder.address;
	}
	
	public static class Builder{
		
		private long id;
		private String username;
		private String email;
		private int phonenumber;
		private String address;
		
		public Builder(long id, String username){
			this.id = id;
			this.username = username;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		

		public Builder phonenumber(int phonenumber) {
			this.phonenumber = phonenumber;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		@Override
		public String toString() {
			return "Builder [id=" + id + ", username=" + username + ", email=" + email + ", phonenumber=" + phonenumber
					+ ", address=" + address + "]";
		}
		
		public User build() {
			return new User(this);
		}
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user1 = new User.Builder(10, "deba").email("hello@gmail.com").address("Bangalore").build();
		System.out.println(user1.toString());

	}

}
