package customer.jmi.edu;

public class Customer {
   //���������֤�š���ϵ�绰
	String name;
	String id;  //���֤��
	String tel; //��ϵ�绰
	
	public Customer(String name,String id,String tel){
		this.name = name;
		this.id  = id ;
		this.tel = tel;
	}
	
	void print(){
	 System.out.println("����:"+name);
	 System.out.println("���֤��:"+id);
	 System.out.println("��ϵ�绰:"+tel);

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
