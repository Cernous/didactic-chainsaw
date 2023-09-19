package Assignment1;

public class WarehouseDB {
	
	static WarehouseDB wDB;
	private static ADTDictionary<String, InventoryRecord> sheetIR;
	
	public static void main(String[] args) {
		
		wDB = new WarehouseDB();
		wDB.creatDB();
		
	}
	
	
//	InventoryRerod ir1 = new("SP7875",,,,,);
//	InventoryRerod ir2 = new("WTB311",,,,,);
	
	public static void initial() {
		wDB.insert(new InventoryRecord());
	
	}

	public String toString() {
		return sheetIR.toString();
	}
	
	public  void creatDB() {
		sheetIR = new LDictionary(); 
	}
	
	public  boolean insert(ADTInventoryRecord o) {
		if(o instanceof InventoryRecord) {
			sheetIR.insert(((InventoryRecord)o).getSku(), (InventoryRecord) o);
			return true;
		}
		return false;
	}
	

	
	

}
