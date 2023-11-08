package Assignment2;

import javax.naming.ldap.SortKey;

import java.lang.Math;

public class InventoryRecord implements Comparable<InventoryRecord>, ADTInventoryRecord{
	private String	sku; 				// product ID
	private String 	name;				// name of the product
	private String	description;		// description of the product
	private String	location;			// ??? location of the stock
	private double	unit;				// unit price
	private int		reorderlvl;			// reordered level (priorities)
	private int		reorderdaytime;		// reordered time in days
	private long	qtytoreorder;		// qty to reorder
	private long	qty;				// qty total in stock
	private double  invetoryValue;		// the value of whats in stock
	private boolean	discontinued;		// discontinued product
	private boolean reordered;			// reordered?

	public InventoryRecord(String SKU, String NAME, String DESC, String LOC, double UNIT, long QTY, int LVL, int TIME, long QTYRE, boolean DISC){
		this.sku = SKU;
		this.name = NAME;
		this.description = DESC;
		this.location = LOC;
		this.unit = UNIT;
		this.reorderlvl = LVL;
		this.reorderdaytime = TIME;
		this.qtytoreorder = QTYRE;
		this.qty = QTY;
		this.invetoryValue = QTY * UNIT;
		this.discontinued = DISC;
		this.reordered = ((qtytoreorder > 0) && (reorderdaytime > 0) && (reorderlvl > 0) && !(discontinued)) ? true : false;
	}

	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getUnit(){
		return unit;
	}
	public void setUnit(double unit){
		this.unit = unit;
	}
	public int getLvl() {
		return reorderlvl;
	}
	public void setLvl(int lvl) {
		this.reorderlvl = lvl;
	}
	public int getReTime() {
		return reorderdaytime;
	}
	public void setReTime(int time) {
		this.reorderdaytime = time;
	}
	public long getReQty() {
		return qtytoreorder;
	}
	public void setReQty(long reqty) {
		this.qtytoreorder = reqty;
	}
	public long getQty() {
		return qty;
	}
	public void setQty(long qty) {
		this.qty = qty;
	}
	public double getInvetoryValue() {
		invetoryValue = qty * unit;
		return invetoryValue;
	}
	public boolean getReorderedStat() {
		reordered = ((qtytoreorder > 0) && (reorderdaytime > 0) && (reorderlvl > 0) && !(discontinued)) ? true : false;
		return reordered;
	}
	public boolean getStat() {
		return discontinued;
	}
	public void setStat(boolean discontinued) {
		this.discontinued = discontinued;
	}
	
	@Override
	public int compareTo(InventoryRecord other) 
	{
		return this.getSku().compareTo(other.getSku());
	}

	public String toString(){
		return ":" + sku +":" + name + ":" + description + ":" + location + ":" + String.valueOf(unit) + ":" + String.valueOf(reorderlvl) + ":" + String.valueOf(reorderdaytime) + ":" + String.valueOf(qtytoreorder) + ":" + String.valueOf(qty) + ":" + String.valueOf(invetoryValue) + "\n";
	}
}
