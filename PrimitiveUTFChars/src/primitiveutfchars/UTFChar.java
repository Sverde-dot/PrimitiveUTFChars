
package primitiveutfchars;
import java.io.*;

public class UTFChar {
    public static void escribir(){
    File direc;
        String linea="";
        DataOutputStream salida=null;
        direc=new File("texto.dat");
        try{
            salida=new DataOutputStream(new FileOutputStream(direc));
                System.out.println("writeUTF escribiendo: " + linea);
                salida.writeUTF(linea);
                System.out.println("Total escrito: " + salida.size() + " Bytes");
                System.out.println("writeChars escribiendo: " + linea);
                salida.writeChars(linea);
                System.out.println("Total bytes escritos: " + salida.size() + " Bytes");
                System.out.println("writeUTF escribiendo: " + linea);
                salida.writeUTF(linea);
                System.out.println("Total escritos: " + salida.size() + " Bytes");
        }catch(IOException e){
            System.out.println("Error openando archivo");
        }finally{
            if(salida != null){
                try{
                    salida.close();
                }catch(IOException e){
                    System.out.println("Hubo un error al cerrar el archivo");
                }
            }
        }
    }
    public static void Leer(){
        File direc;
        DataInputStream entrada=null;
        String linea="";
        
        direc=new File("texto.dat");
        try{
            entrada=new DataInputStream(new FileInputStream(direc));
            while(entrada.available()!=0){
                System.out.println("Bytes por leer: " + entrada.available() + " Bytes");
                System.out.println("Primera cadena leida: " + entrada.readUTF());
                for(int i=0;i<12;i++){
                    linea=linea+entrada.readChar();
                }
                System.out.println("Segunda cadena leida: " + linea);
                System.out.println("Bytes por leer: " + entrada.available() + " Bytes");
                System.out.println("Tercera cadena leida: " + entrada.readUTF());
                System.out.println("Bytes por leer: " + entrada.available() + " Bytes");
                linea="";
            }
        }catch(IOException e){
            System.out.println("Error operando archivo");
        }finally{
            if(entrada != null){
                try{
                    entrada.close();
                }catch(IOException e2){
                    System.out.println("error al cerrar el archivo");
                }
            }
        }
    }
}
