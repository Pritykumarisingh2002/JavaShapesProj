package shape;

import java.io.*; 
public class serialization { 
	public static void main(String[] args)
    {
 
		 Emp object = new Emp(1, "Prity");
	        String filename = "p.txt";
	    
	        try
	        {  
	            FileOutputStream file = new FileOutputStream(filename);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	             
	            out.writeObject(object);
	             
	            out.close();
	            file.close();
	             
	            System.out.println("Object has been serialized");
	            
	            object.b = "Prity Singh";
	 
	        }
	         
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	        Emp object1 = null;

		        try
		        {   
		            FileInputStream file = new FileInputStream(filename);
		            ObjectInputStream in = new ObjectInputStream(file);
		    
		            object1 = (Emp)in.readObject();
		             
		            in.close();
		            file.close();
		             
		            System.out.println("Object has been deserialized ");
		            System.out.println("a = " + object1.a);
		            System.out.println("b = " + object1.b);
		        }
		         
		        catch(IOException ex)
		        {
		            System.out.println("IOException is caught");
		        }
		         
		        catch(ClassNotFoundException ex)
		        {
		            System.out.println("ClassNotFoundException is caught");
		        }
    }}