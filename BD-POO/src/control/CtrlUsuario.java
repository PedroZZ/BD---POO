package control;

import java.lang.reflect.Method;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CtrlUsuario<T> implements TableModel{

	private String[] nomes = {"Nome", "CPF","Cargo"};
	private Class<?>[] classes = new Class[]{String.class, String.class, String.class};
	private JTable tabela;
	
//	public CtrlUsuario(JTable tabela) {
//		this.tabela = tabela;
//	}
	
	// campos = {"nome", "cpf", "cargo"}
	
	private Class<T> tipo;
	private String[] campos;
	
	public CtrlUsuario(Class<T> tipo, String[] campos) { 
		this.tipo = tipo;
		this.campos = campos;
		for (String campo : campos) { 
			Method[] metodos = tipo.getDeclaredMethods();
			for (Method m : metodos) { 
				if (m.getName().equals( "get" + campo )) { 
					Class<?> classe = m.getReturnType();
					Object valor = m.invoke( instanciaDoObjeto , new Object[] {});
				}
			}
		}
	}
	 
	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int coluna) {
		return campos[coluna];
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return classes[coluna];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return nomes[rowIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
