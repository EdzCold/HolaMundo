import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.io.*;

class Test
{
	public static void main(String[] args)
	{
		
		//String input = "مدينة المكسيك";
		String a = "Calle 20ᴬ";
		//String b = "";
		String c = "BAÑUELOS";
		String d = "Nueva Vallejo I Secc 07750 墨西哥城 CDMX";
		String e = "&puerto A";
		String f = "quotation mark";
		String g = "STA ROSALIA";
		String h = "Calle Monte Parnaso";
		String i = "C DE LOS PALACIOS";
		String j = "puertoA & puertoB";
		String k = "los &puerto;";


		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(a, "UTF-8") + " " + a);
		//System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(b, "UTF-8"));
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(c, "UTF-8") + " " + c);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(d, "UTF-8") + " " + d);

		System.out.println(" C-------------------------------------------------------");
		
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(e, "UTF-8") + " " + e);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(f, "UTF-8") + " " + f);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(g, "UTF-8") + " " + g);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(h, "UTF-8") + " " + h);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(i, "UTF-8") + " " + i);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(j, "UTF-8") + " " + j);
		System.out.println(" Comprobar direccion:  " + isUTF8MisInterpreted(k, "UTF-8") + " " + k);


	}


	public static boolean isUTF8MisInterpreted( String input, String encoding) 
	{
            
		CharsetDecoder decoder = Charset.forName("UTF-16").newDecoder();
            
		CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
            
		ByteBuffer tmp;


            
		try {
            
			tmp = encoder.encode(CharBuffer.wrap(input));
            //System.out.println(tmp);
		}
            
		catch(CharacterCodingException e) 
		{
                
			return false;
            
		}
            
		try {
                
			decoder.decode(tmp);
			return true;
            
		}     

		catch(CharacterCodingException e){
                
			return false;
            
		}
	
        
	}
}