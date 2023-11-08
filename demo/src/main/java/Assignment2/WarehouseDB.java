package Assignment2;

import Assignment2.*;
import Assignment2.list.ADTList;
import Assignment2.list.AList;
import Assignment2.sort.*;
import Assignment2.bitree.*;

public class WarehouseDB {
	
	static WarehouseDB wDB;
	private static ADTDictionary<String, InventoryRecord> sheetIR;
	
	public static void main(String[] args) throws Exception {
		wDB = new WarehouseDB();
		wDB.initial();

		System.out.println("Size of wDB = " + wDB.size());
		System.out.println("\nTree Index: \n" + wDB.createTreeIndex("reorderdaytime").toString());
		System.out.println("\nList Index: \n" + wDB.createListIndex("inventoryvalue").toString());

		System.out.println("\nTop 3 in lowest reorder time in days:");
		System.out.println(wDB.query("reorderlvl", 2));

		// // 9. Return total inventory Value
		// System.out.println("Total Inventory Value = " + wDB.totalinventoryValue());
		// // 6. Return a dictionary of InventoryRecords that have the reordered Status True
		// System.out.println("Reordered Goods: \n" + wDB.getReorderedStat().toString());
		// // 7. Return a dictionary of InventoryRecords that have the given location
		// System.out.println("Location on Warehouse: \n" + wDB.getValuebyLocation("Warehouse").toString());
		// // 3. Remove a given record given a key
		// wDB.remove("IN0004");
		// System.out.println("Removed 5th item: \n" + wDB.toString());
		// // 5. Find Record by Key
		// System.out.println("1st item: \n" + wDB.findByKey("IN0000").toString());
		// // 4. Remove all records
		// wDB.removeAll();
		// System.out.println("Inventory after remove: \n" + wDB.toString());

	}
		
//	InventoryRerod ir1 = new("SP7875",,,,,);
//	InventoryRerod ir2 = new("WTB311",,,,,);
	
	public void initial() {
		this.creatDB(100);

		InventoryRecord ir0 = new InventoryRecord("IN0000", "Name0", "Desc0", "New Atlantis", 29.80, 450, 0, 43, 1500, true);
		InventoryRecord ir1 = new InventoryRecord("IN0001", "Name1", "Desc1", "Warehouse", 30.80, 500, 1, 43, 1000, false);
		InventoryRecord ir2 = new InventoryRecord("IN0002", "Name2", "Desc2", "Londinion", 31.80, 700, 1, 56, 1000, false);
		InventoryRecord ir3 = new InventoryRecord("IN0003", "Name3", "Desc3", "Warehouse", 32.80, 300, 2, 76, 1000, true);
		InventoryRecord ir4 = new InventoryRecord("IN0004", "Name4", "Desc4", "Cydonia", 33.80, 600, 1, 22, 1000, false);
		InventoryRecord ir5 = new InventoryRecord("IN0005", "Name5", "Desc5", "Warehouse", 34.80, 700, 3, 12, 1000, false);

		InventoryRecord[] irlist = {ir1,ir2,ir3,ir4,ir5};

		this.insert(ir0);			// 1. Insert Record
		this.insert(irlist);			// 2. Insert A list of Records
	}

	public String toString() {
		return sheetIR.toString();
	}
	
	public void creatDB(int sz) {
		sheetIR = new DLDictionary<String, InventoryRecord>(sz); 
	}
	
	public  boolean insert(ADTInventoryRecord o) {
		if(o instanceof InventoryRecord) {
			sheetIR.insert(((InventoryRecord)o).getSku(), (InventoryRecord) o);
			return true;
		}
		return false;
	}

	public int size(){
		return sheetIR.size();
	}

	public boolean insert(ADTInventoryRecord [] o){
		boolean state;
		for(int i = 0; i < o.length; i++){
			state = this.insert(o[i]);
			if (state == false){
				return state;
			}
		}
		return true;
	}

	public InventoryRecord findByKey(String SKU){
		return sheetIR.find(SKU);
	}

	public InventoryRecord remove(String SKU){
		return sheetIR.remove(SKU);
	}

	public void removeAll(){
		sheetIR.clear();
	}

	public double totalinventoryValue(){
		double total = 0;
		for(int index = 0; index < this.size(); index++){
			InventoryRecord ir = sheetIR.getValue(index);
			total += ir.getInvetoryValue();
		}
		return total;
	}

	public ADTDictionary<String, InventoryRecord> getReorderedStat(){
		ADTDictionary list = new DLDictionary<String, InventoryRecord>(wDB.size());
		for(int index = 0; index < this.size(); index++){
			InventoryRecord ir = sheetIR.getValue(index);
			if (ir.getReorderedStat()){
				list.insert(ir.getSku(), ir);
			}
		}
		return (list.size() > 0) ? list : null; 
	}

	public ADTDictionary<String, InventoryRecord> getValuebyLocation(String location){
		ADTDictionary list = new DLDictionary<String, InventoryRecord>(wDB.size());
		for(int index = 0; index < this.size(); index++){
			InventoryRecord ir = sheetIR.getValue(index);
			if (ir.getLocation() == location){
				list.insert(ir.getSku() ,ir);
			}
		}
		return (list.size() > 0) ? list : null; 
	}
	public String query(String attribute, int top) throws Exception
	{
		String out = new String();
		if ((top > this.size()) | (top < 0)) throw new Exception("Invalid top number");
		ADTList<Integer> indexes = this.createListIndex(attribute);
		for(int i = 0; i < top; i ++) out += sheetIR.getValue(indexes.getValue(i)).getSku() + "\n";
		return out;

	}
	public ADTDictionary createTreeIndex(String attribute) throws Exception
	{
		ADTList<Integer> indexes = this.createListIndex(attribute);
		ADTDictionary values;
		switch(attribute.toLowerCase())
		{
			case "sku":
			case "name":
			case "description":
			case "location":
				values = new BSTDictionary<Integer,String>();
				break;
			case "inventoryvalue":
			case "unit":
				values = new BSTDictionary<Integer,Double>();
				break;
			case "reorderlvl":
			case "reorderdaytime":
				values = new BSTDictionary<Integer,Integer>();
				break;
			case "qtytoreorder":
			case "qty":
				values = new BSTDictionary<Integer,Long>();
				break;
			case "discontinued":
			case "reordered":
				values = new BSTDictionary<Integer,Boolean>();
				break;
			default:
				throw new Exception("Attribute Invalid");
		}
		int j = (this.size()) / 2;
		for(int i = 0; i <= this.size()/2; i++)
		{
			try{
				for(int z = (i == 0) ? 1 : -1; z <= 1; z+=2){
					int current = indexes.getValue(j + (z*i));
					switch(attribute.toLowerCase())
					{
						case "sku":
							values.insert(current,sheetIR.getValue(current).getSku());
							break;
						case "name":
							values.insert(current,sheetIR.getValue(current).getName());
							break;
						case "description":
							values.insert(current,sheetIR.getValue(current).getDescription());
							break;
						case "location":
							values.insert(current,sheetIR.getValue(current).getLocation());
							break;
						case "inventoryvalue":
							values.insert(current,sheetIR.getValue(current).getInvetoryValue());
							break;
						case "unit":
							values.insert(current,sheetIR.getValue(current).getUnit());
							break;
						case "reorderlvl":
							values.insert(current,sheetIR.getValue(current).getLvl());
							break;
						case "reorderdaytime":
							values.insert(current,sheetIR.getValue(current).getReTime());
							break;
						case "qtytoreorder":
							values.insert(current,sheetIR.getValue(current).getReQty());
							break;
						case "qty":
							values.insert(current,sheetIR.getValue(current).getQty());
							break;
						case "discontinued":
							values.insert(current,sheetIR.getValue(current).getStat());
							break;
						case "reordered":
							values.insert(current,sheetIR.getValue(current).getReorderedStat());
							break;
						default:
							throw new Exception("Attribute Invalid");
					}
				}
			}
			catch(Exception e){
				break;
			}
		}
		// System.out.println(values.toString());
		return values;
	}

	public ADTList<Integer> createListIndex(String attribute) throws Exception
	{
		ADTList<Integer> indexes = new AList<Integer>(this.size());
		for(int i=0; i < this.size(); i ++) indexes.append(i);
		ADTList values;
		switch(attribute.toLowerCase())
		{
			case "sku":
			case "name":
			case "description":
			case "location":
				values = new AList<String>(this.size());
				break;
			case "inventoryvalue":
			case "unit":
				values = new AList<Double>(this.size());
				break;
			case "reorderlvl":
			case "reorderdaytime":
				values = new AList<Integer>(this.size());
				break;
			case "qtytoreorder":
			case "qty":
				values = new AList<Long>(this.size());
				break;
			case "discontinued":
			case "reordered":
				values = new AList<Boolean>(this.size());
				break;
			default:
				throw new Exception("Attribute Invalid");
		}
		
			
		for(int i = 0; i < this.size(); i++)
		{
			switch(attribute.toLowerCase())
			{
				case "sku":
					values.append(sheetIR.getValue(i).getSku());
					break;
				case "name":
					values.append(sheetIR.getValue(i).getName());
					break;
				case "description":
					values.append(sheetIR.getValue(i).getDescription());
					break;
				case "location":
					values.append(sheetIR.getValue(i).getLocation());
					break;
				case "inventoryvalue":
					values.append(sheetIR.getValue(i).getInvetoryValue());
					break;
				case "unit":
					values.append(sheetIR.getValue(i).getUnit());
					break;
				case "reorderlvl":
					values.append(sheetIR.getValue(i).getLvl());
					break;
				case "reorderdaytime":
					values.append(sheetIR.getValue(i).getReTime());
					break;
				case "qtytoreorder":
					values.append(sheetIR.getValue(i).getReQty());
					break;
				case "qty":
					values.append(sheetIR.getValue(i).getQty());
					break;
				case "discontinued":
					values.append(sheetIR.getValue(i).getStat());
					break;
				case "reordered":
					values.append(sheetIR.getValue(i).getReorderedStat());
					break;
				default:
					throw new Exception("Attribute Invalid");
			}
		}
		this.sort(values, indexes);
		// System.out.println(values.toString());
		// System.out.println(indexes.toString());
		return indexes;
	}
	/** stolen from Insert sort */
	private <E extends Comparable<? super E>> void sort(ADTList<E> A, ADTList<Integer> indexes) {
		for (int i=1; i<A.length(); i++) { // Insert i'th record
			for (int j=i; j>0; j--) {
				A.moveToPos(j);
				E value_j = A.getValue();
				A.moveToPos(j-1);
				E value_j_1 = A.getValue();
				if(value_j.compareTo(value_j_1)<0)
				{
					DSutil.swap(A, j, j-1);
					DSutil.swap(indexes, j, j-1);
				}
			}
		}
  	}

}
