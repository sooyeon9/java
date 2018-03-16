package Hashtable;

class Hashtable{
		LinkedList[] value;
		Hashtable(){
			value = new LinkedList[6];
			for(int i=0; i<6; i++)
				value[i] = new LinkedList();
		}
	
	int hashFunction(String key){
		return (key.length())%6;
	}	
	
	void getValue(String key){
		LinkedList a  = value[hashFunction(key)];
		if(a.findvalue(key).equals("None"))
			System.out.println("존재하지 않음!");
		else
			System.out.println("["+hashFunction(key)+","+key+","+a.findvalue(key)+"]");
	}
	
	void setValue(String key, String num){
		value[hashFunction(key)].insert(key,num);
	}
	
	boolean hasValue(int index){
		if(value[index]==null)
			return true;
		else
			return false;
		}
	
	void showAll(){
		for(int i=0; i<6; i++){
			if(value[i].isEmpty())
				System.out.println("["+i+","+"null]");
			else
				value[i].print_list(i);}
	}

}


public class Run {
	public static void main(String[] args){
		Hashtable table = new Hashtable();
		table.setValue("Jonh","111-1111");
		table.setValue("No","123-4567"); 
		table.setValue("Sam","222-2222"); 
		table.setValue("Jee","456-7890");
		table.setValue("Sandra","333-3333"); 
		table.setValue("Jaewon","000-0000"); 
		table.setValue("Lisa" ,"444-4444");
		table.setValue("Chris","555-5555");
		
		// getValue  Lisa, Chris, Kim
		table.getValue("Lisa");
		table.getValue("Chris");
		table.getValue("Kim");
		
		table.showAll();
	}	
}
