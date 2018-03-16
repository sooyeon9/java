package javajava;


import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BookTableModel  extends AbstractTableModel {
    private final static String[] COLUMNS = { "ISBN", "BOOK NAME", "AUTHOR", "PRICE","YEAR","PUBLISHER","RATE"};
    
    private List<Book> Books;
    
    public BookTableModel(List<Book> Books) {
        this.Books = Books;
    }

    @Override
    public int getRowCount() {
        return Books.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Book book = Books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getIsbn();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthor();
            case 3:
            	return book.getPrice();
            case 4:
            	return book.getYear();
            case 5:
            	return book.getCompany();
            case 6:
            	return book.getStar();
                
        }
        return null;
    }
    
    
}

