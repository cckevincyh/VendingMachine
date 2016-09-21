package indi.cc.vendingmachine.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tools {
	
	   public static boolean copy(String fileFrom, String fileTo) {  
	        try {  
	            FileInputStream in = new java.io.FileInputStream(fileFrom);  
	            FileOutputStream out = new FileOutputStream(fileTo);  
	            byte[] bt = new byte[1024];  
	            int count;  
	            while ((count = in.read(bt)) > 0) {  
	                out.write(bt, 0, count);  
	            }  
	            in.close();  
	            out.close();  
	            return true;  
	        } catch (IOException ex) {  
	            return false;  
	        }  
	    }  
	
}
