import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.io.*;

class Caso1
{
	public static void main(String[] args)
	{
		
		String d = "Nueva Vallejo I Secc 07750 墨西哥城 CDMX";
		String f = "quotation mark";

		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(d, "UTF-8") + " " + d);
		System.out.println(" ----------------------------------------------------  " );
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(f, "UTF-8") + " " + f);

	}


	public static boolean isUTF8MisInterpreted(String input, String encoding) 
	{
        
        CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
		CharsetDecoder decoder = Charset.forName("UTF-16").newDecoder();
            
		ByteBuffer tmp;


            
		try {
            
			tmp = encoder.encode(CharBuffer.wrap(input));
            String v = new String(tmp.array());
            System.out.println("Encoder: " + v);
            System.out.println("Bytes: " + tmp.array());
			
		}
            
		catch(CharacterCodingException ex) 
		{
            System.out.println("catch1  " + ex.getStackTrace());
			return false;
            
		}
            
		try {
			decoder.decode(tmp);
            System.out.println(decoder.decode(tmp));
			return true;
            
		}     

		catch(CharacterCodingException ex){
                System.out.println("catch2  " + ex.getStackTrace());
			return false;
            
		}
	
        
	}
}