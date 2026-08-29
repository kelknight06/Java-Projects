package lab9;
//Author: Kel Knight and Kendall Ward-Hill
//Date: 11/14/2025
//Purpose: to update and change the data of the inventory as well as show the data
public class Merchandise {
	private int serialNum;
	private String manufactDate;
	private int lotNum;
	
	public Merchandise() {
		serialNum = 000000;
		manufactDate = "00/00/0000";
		lotNum = 0000000; 
	}
	
	public Merchandise(int serial, String date, int lot) {
		serialNum = serial;
		manufactDate = date;
		lotNum = lot;
	}
	
	public int getSerial() {
		return serialNum;
	}
	public String getDate() {
		return manufactDate;
	}
	public int getLot() {
		return lotNum;
	}
	public void setSerial(int serial) {
		serialNum = serial;
	}
	public void setDate(String date) {
		manufactDate = date;
	}
	public void setLot(int lot) {
		lotNum = lot;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %d\n%s: %s\n%s: %d\n----", "Serial Number", serialNum, "Manufacture date",manufactDate,"Lot number",lotNum);
	}

}
