package Assignment1;

public class WarehouseDB {
	
	static WarehouseDB wDB;
	private static ADTDictionary<String, InventoryRecord> sheetIR;
	
	public static void main(String[] args) {
		wDB = new WarehouseDB();
		wDB.initial();
		// 8. Return total records in the database
		System.out.println("Size of wDB = " + wDB.size());
		// 9. Return total inventory Value
		System.out.println("Total Inventory Value = " + wDB.totalinventoryValue());
		// 6. Return a dictionary of InventoryRecords that have the reordered Status True
		System.out.println("Reordered Goods: \n" + wDB.getReorderedStat().toString());
		// 7. Return a dictionary of InventoryRecords that have the given location
		System.out.println("Location on Warehouse: \n" + wDB.getValuebyLocation("Warehouse").toString());
		// 3. Remove a given record given a key
		wDB.remove("IN0004");
		System.out.println("Removed 5th item: \n" + wDB.toString());
		// 5. Find Record by Key
		System.out.println("1st item: \n" + wDB.findByKey("IN0000").toString());
		// 4. Remove all records
		wDB.removeAll();
		System.out.println("Inventory after remove: \n" + wDB.toString());

	}
		
//	InventoryRerod ir1 = new("SP7875",,,,,);
//	InventoryRerod ir2 = new("WTB311",,,,,);
	
	public void initial() {
		wDB.creatDB(100);

		InventoryRecord ir0 = new InventoryRecord("IN0000", "Name0", "Desc0", "New Atlantis", 29.80, 450, 0, 43, 1500, true);
		InventoryRecord ir1 = new InventoryRecord("IN0001", "Name1", "Desc1", "Warehouse", 30.80, 500, 1, 43, 1000, false);
		InventoryRecord ir2 = new InventoryRecord("IN0002", "Name2", "Desc2", "Londinion", 31.80, 700, 1, 56, 1000, false);
		InventoryRecord ir3 = new InventoryRecord("IN0003", "Name3", "Desc3", "Warehouse", 32.80, 300, 2, 76, 1000, true);
		InventoryRecord ir4 = new InventoryRecord("IN0004", "Name4", "Desc4", "Cydonia", 33.80, 600, 1, 22, 1000, false);
		InventoryRecord ir5 = new InventoryRecord("IN0005", "Name5", "Desc5", "Warehouse", 34.80, 700, 3, 12, 1000, false);

		InventoryRecord[] irlist = {ir1,ir2,ir3,ir4,ir5};

		wDB.insert(ir0);			// 1. Insert Record
		wDB.insert(irlist);			// 2. Insert A list of Records
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
			state = wDB.insert(o[i]);
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
		for(int index = 0; index < wDB.size(); index++){
			InventoryRecord ir = sheetIR.getValue(index);
			total += ir.getInvetoryValue();
		}
		return total;
	}

	public ADTDictionary<String, InventoryRecord> getReorderedStat(){
		ADTDictionary list = new DLDictionary<String, InventoryRecord>(wDB.size());
		for(int index = 0; index < wDB.size(); index++){
			InventoryRecord ir = sheetIR.getValue(index);
			if (ir.getReorderedStat()){
				list.insert(ir.getSku(), ir);
			}
		}
		return (list.size() > 0) ? list : null; 
	}

	public ADTDictionary<String, InventoryRecord> getValuebyLocation(String location){
		ADTDictionary list = new DLDictionary<String, InventoryRecord>(wDB.size());
		for(int index = 0; index < wDB.size(); index++){
			InventoryRecord ir = sheetIR.getValue(index);
			if (ir.getLocation() == location){
				list.insert(ir.getSku() ,ir);
			}
		}
		return (list.size() > 0) ? list : null; 
	}

}
