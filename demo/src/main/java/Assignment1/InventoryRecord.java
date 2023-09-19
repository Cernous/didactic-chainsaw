package Assignment1;



public class InventoryRecord implements Comparable<InventoryRecord>, ADTInventoryRecord{
	private String	sku; 
	private String	description;
	private String	bin;
	private String	location;
	private String	unit;
	private long	qty;
	private double  invetoryValue;
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getQty() {
		return qty;
	}
	public void setQty(long qty) {
		this.qty = qty;
	}
	public double getInvetoryValue() {
		return invetoryValue;
	}
	public void setInvetoryValue(double invetoryValue) {
		this.invetoryValue = invetoryValue;
	}
	
	 public int compareTo(InventoryRecord other)
     {
    	 return this.getSku().compareTo(other.getSku());
     }


	
}
