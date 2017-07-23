package Application;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
 
public class ResultSetTableModel extends AbstractTableModel{
    //declaration 
    private ResultSet rs;
    public ResultSetTableModel (ResultSet rs){
        this.rs = rs;
        fireTableDataChanged();
    }
    
    // fonction GetColumncount 
    
    public int getColumnCount(){
        try{
            if (rs == null){
                return 0;
            } else {
                return rs.getMetaData().getColumnCount();
            }
            
        }catch (SQLException e){
            System.err.println("getColumncoun resultset genrating error while getting colomn count ");
            System.err.println(e.getMessage());
            return 0;
        }
    }
    
    // fonction getRouwcount
    
    public int getRowCount(){
        try {
            if (rs == null){
                return 0;
            }else {
                rs.last();
                return rs.getRow();
            }
        }catch (SQLException e){
            
            System.out.println("getrowcount resultset generating generating error while getting rows count ");
            System.out.println(e.getMessage());
            return 0;
        }   
        
    }
    
    // fonction pour returner les valeur de l index de colonne et de ligne ^^
    
    public Object getValueAt(int rowIndex , int columnIndex){
        if(rowIndex < 0 || rowIndex > getRowCount()
                || columnIndex < 0 || columnIndex > getColumnCount()){
                return null;
        }
        try {
            if(rs == null){
                return null;
            }
            else {
                rs.absolute(rowIndex +1);
                return rs.getObject(columnIndex +1);
            }
        }catch(SQLException e){
            System.out.println("getvalueat resultset generating error while fetching rows");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    //
    
    @Override
    public String getColumnName(int columnIndex){
        try{
            return rs.getMetaData().getColumnClassName(columnIndex +1);         
        }catch (SQLException e){
            System.out.println("getColumnname resultset genaration error while fetching colomn name ");
            System.out.println(e.getMessage());
        }
        return super.getColumnName(columnIndex);
    }
    
    
}
