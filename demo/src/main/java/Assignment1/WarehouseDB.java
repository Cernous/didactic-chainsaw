package Assignment1;

public class WarehouseDB {
	
	static WarehouseDB wDB;
	private static ADTDictionary<String, InventoryRecord> sheetIR;
	
	public static void main(String[] args) {
		wDB = new WarehouseDB();
		wDB.creatDB(100);
		wDB.initial();
		System.out.println(wDB.toString());
	}
		
//	InventoryRerod ir1 = new("SP7875",,,,,);
//	InventoryRerod ir2 = new("WTB311",,,,,);
	
	public void initial() {
		InventoryRecord ir1 = new InventoryRecord("IN0001", "Desc1", "Item1", "Warehouse", "$50", 57, 2850);
		InventoryRecord ir2 = new InventoryRecord("IN0002", "Desc2", "Item2", "Warehouse", "$50", 57, 2850);
		InventoryRecord ir3 = new InventoryRecord("IN0003", "Desc3", "Item3", "Warehouse", "$50", 57, 2850);
		InventoryRecord ir4 = new InventoryRecord("IN0004", "Desc4", "Item4", "Warehouse", "$50", 57, 2850);
		InventoryRecord ir5 = new InventoryRecord("IN0005", "Desc5", "Item5", "Warehouse", "$50", 57, 2850);
		wDB.insert(ir1);
		wDB.insert(ir2);
		wDB.insert(ir3);
		wDB.insert(ir4);
		wDB.insert(ir5);
	}

	public String toString() {
		return sheetIR.toString();
	}
	
	public void creatDB(int sz) {
		sheetIR = new LDictionary<String, InventoryRecord>(sz); 
	}
	
	public  boolean insert(ADTInventoryRecord o) {
		if(o instanceof InventoryRecord) {
			sheetIR.insert(((InventoryRecord)o).getSku(), (InventoryRecord) o);
			return true;
		}
		return false;
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

	public InventoryRecord remove(String SKU){
		InventoryRecord state;
		state = sheetIR.remove(SKU);
		return state;
	}

	
}
