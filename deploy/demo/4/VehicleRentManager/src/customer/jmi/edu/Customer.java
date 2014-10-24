package customer.jmi.edu;

public class Customer {
   //姓名、身份证号、联系电话
	String name;
	String id;  //身份证号
	String tel; //联系电话
	
	public Customer(String name,String id,String tel){
		this.name = name;
		this.id  = id ;
		this.tel = tel;
	}
	
	void print(){
	 System.out.println("姓名:"+name);
	 System.out.println("身份证号:"+id);
	 System.out.println("联系电话:"+tel);

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Customer cust = new Customer("fh","320121","15850675602");
     cust.print();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
