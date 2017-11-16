
import testArea001.*;


public class javaTestArea 
{
    String[] columnNames = {"First Name",
            "Last Name",
            "Music Type",
            "The Year Of Birth",
            "Married"};
    
    
    Object[][] data = { 
    			{"eli", "levin", "dos music", new Integer(34), new Boolean(true)},
    			{"shalom", "lizrovitch", "dance music", new Integer(35), new Boolean(true)},
    			{"yaron", "kessler", "heavy metal music", new Integer(44), new Boolean(true)},
    			{"yivgenya", "krinos", "classic music", new Integer(43), new Boolean(false)},
    			{"noam", "meiri", "doc music", new Integer(55), new Boolean(false)}
     };

    
    
	//constructor
	public javaTestArea() {	
		
		for (String one: columnNames) 
		{
			System.out.println(one);
		}
		
		for (Object[] objData : data) 
		{
			System.out.println();
			
			for (Object rowData: objData) 
			{
				System.out.print (rowData +",  ");
			}		
		}
	}
	
	
	public static void main(String[] args) 
	{
		javaTestArea jta = new javaTestArea();
		
		
		
//		SimpleTableDemo std = new SimpleTableDemo();
//		std.main(null);
		
//		TableDemo td = new TableDemo();
//		td.main(null);
		
	}

}
