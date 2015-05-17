package tp.pr5.mv.window;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class MemoryModel extends AbstractTableModel {
	
	private String [] names = {"Posición", "Valor"};
	private Vector<Integer> memory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MemoryModel constructor
	 * @param cpu
	 */
	public MemoryModel(){
		this.memory = new Vector<>();
	}

	@Override
	public int getRowCount() {
		return this.memory.size() - 1;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==1){
			return this.memory.get(rowIndex);
		}else if(columnIndex==0){
			return rowIndex;
		}else{
			return null;
		}
		
	}
	
	/**
	 * Gets the column name
	 */
	public String getColumnName(int index){
		return this.names[index];
	}
	
	
	public void storeEvent(int index, Integer value){
		if(index >= this.memory.size() - 1){
			this.memory.setSize(index + 1);
			this.memory.add(index, value);
		}else{
			this.memory.set(index,value);
		}
	}

}

