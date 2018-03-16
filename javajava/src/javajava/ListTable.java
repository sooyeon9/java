package javajava;

import java.util.List;
import javax.swing.table.AbstractTableModel;


//��� Ʋ
public class ListTable  extends AbstractTableModel {
    private final static String[] COLUMNS = { "��ȣ","���", "������", "�ٹ���", "�߸ų⵵","�α⵵(1~5)"};
    
    private List<Music> Musics;
    
    public ListTable(List<Music> Musics) {
        this.Musics = Musics;
    }

    @Override
    public int getRowCount() {
        return Musics.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Music music = Musics.get(rowIndex);
    	
        switch (columnIndex) {
            case 0:
                return Musics.indexOf(music)+1;
            case 1:
                return music.getName();
            case 2:
                return music.getSinger();
            case 3:
            	return music.getTitle();
            case 4:
            	return music.getYear();
            case 5:
            	return music.getStar();
            
                
        }
        return null;
    }
    
    
}

