package rentrecord.jmi.edu;


	import java.util.Date;

	import vehicle.jmi.edu.Vehicle;
	import customer.jmi.edu.Customer;

	public class RentRecord {
	//ÿ����¼������Ӧ��һ���ͻ������һ���������Լ��⳵��ʼʱ�䡢����ʱ�䡢Ԥ��������ʻ��̣�������������״̬�����⡢���⣩��    
	   Customer cust ; //Ĭ��null
	   Vehicle  ve;
	   
	   Date  begintime;//��ʼʱ��
	   Date  endtime;//����ʱ��
	   
	   float yufukuan;//Ԥ����
	   float rentmoney; //���
	   
	   float licheng;  //��ʻ���
	   int status;   //����״̬������1������2��
		
	public   RentRecord(Customer cust,Vehicle  ve){
		   this.cust = cust;
		   this.ve = ve;
		   begintime = new Date();
		   yufukuan = (float) (ve.getCarprice()*0.01);    //�����۵�1%֧��
	       status  = 1;
	   }
	   /**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
		public Customer getCust() {
			return cust;
		}
		public void setCust(Customer cust) {
			this.cust = cust;
		}
		public Vehicle getVe() {
			return ve;
		}
		public void setVe(Vehicle ve) {
			this.ve = ve;
		}
		public Date getBegintime() {
			return begintime;
		}
		public void setBegintime(Date begintime) {
			this.begintime = begintime;
		}
		public Date getEndtime() {
			return endtime;
		}
		public void setEndtime(Date endtime) {
			this.endtime = endtime;
		}
		public float getYufukuan() {
			return yufukuan;
		}
		public void setYufukuan(float yufukuan) {
			this.yufukuan = yufukuan;
		}
		public float getRentmoney() {
			return rentmoney;
		}
		public void setRentmoney(float rentmoney) {
			this.rentmoney = rentmoney;
		}
		public float getLicheng() {
			return licheng;
		}
		public void setLicheng(float licheng) {
			this.licheng = licheng;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}

	}
