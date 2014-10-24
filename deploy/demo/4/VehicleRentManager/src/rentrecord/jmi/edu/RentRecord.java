package rentrecord.jmi.edu;


	import java.util.Date;

	import vehicle.jmi.edu.Vehicle;
	import customer.jmi.edu.Customer;

	public class RentRecord {
	//每条记录包含对应的一个客户对象和一辆车对象、以及租车开始时间、结束时间、预付款、租金、行驶里程（货车）、出租状态（在租、退租）。    
	   Customer cust ; //默认null
	   Vehicle  ve;
	   
	   Date  begintime;//开始时间
	   Date  endtime;//结束时间
	   
	   float yufukuan;//预付款
	   float rentmoney; //租金
	   
	   float licheng;  //行驶里程
	   int status;   //出租状态（在租1、退租2）
		
	public   RentRecord(Customer cust,Vehicle  ve){
		   this.cust = cust;
		   this.ve = ve;
		   begintime = new Date();
		   yufukuan = (float) (ve.getCarprice()*0.01);    //按车价的1%支付
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
