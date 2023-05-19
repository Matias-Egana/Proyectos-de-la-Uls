package ExamDemo;
import java.io.*;
import java.util.*;

/**
Clase para entrada de consola simple.
 Una clase dise�ada principalmente para la entrada de teclado simple del
 Forme un valor de entrada por l�nea. Si el usuario ingresa un
 entrada, es decir, una entrada del tipo incorrecto o una l�nea en blanco, entonces
 Se le pide al usuario que vuelva a ingresar la entrada y se le da una breve
 explicaci�n de lo que se requiere. Tambi�n incluye algunos
 m�todos para ingresar n�meros, palabras y caracteres individuales, sin
 pasando a la siguiente l�nea.
*/
public class SavitchIn
{
    /**
    
	Lee una l�nea de texto y devuelve esa l�nea como una cadena
     valor. El final de una l�nea debe indicarse mediante un
     car�cter de nueva l�nea '\ n' o por un retorno de carro '\ r'
     seguido de un car�cter de nueva l�nea '\ n'. (Casi todos los sistemas
     hacer esto autom�ticamente. Entonces no necesitas preocuparte por esto
     detalle.) Ni el '\ n', ni el '\ r' si est�n presentes, son
     parte de la cadena devuelta. Esto leer� el resto de un
     l�nea si la l�nea ya est� parcialmente le�da.
    */
    public static String readLine( )
    {
        char nextChar;
        String result = "";
        boolean done = false;

        while (!done)
        {
            nextChar = readChar( );
            if (nextChar == '\n')
               done = true;
            else if (nextChar == '\r')
            {
                //Do nothing.
                //Next loop iteration will detect '\n'.
            }
            else
               result = result + nextChar;
        }

        return result;
    }

    /**
    Lee la primera cadena de caracteres que no son espacios en blanco en
     una l�nea y devuelve esa cadena. El resto de la linea
     se descarta. Si la l�nea contiene solo espacios en blanco,
     se pide al usuario que vuelva a entrar en la l�nea.
    */
    public static String readLineWord( )
    {
        String inputString = null,
               result = null;
        boolean done = false;

        while(!done)
        {
            inputString = readLine( );
            StringTokenizer wordSource =
                                new StringTokenizer(inputString);
            if (wordSource.hasMoreTokens( ))
            {
                result = wordSource.nextToken( );
                done = true;
            }
            else
            {
                System.out.println(
                     "Your input is not correct. Your input must");
                System.out.println(
                 "contain at least one nonwhitespace character.");
                System.out.println(
                                 "Please try again. Enter input:");
           }
       }

       return result;
   }

    /**
    Condici�n previa: el usuario ha introducido un n�mero de tipo int
     en una l�nea por s� misma, excepto que puede haber
     espacios en blanco antes y / o despu�s del n�mero.
     Acci�n: lee y devuelve el n�mero como un valor de tipo
     En t. El resto de la l�nea se descarta. Si la entrada es
     no ingresado correctamente, en la mayor�a de los casos, el usuario
     se le pedir� que vuelva a ingresar la entrada. En particular, este
     se aplica a formatos num�ricos incorrectos y l�neas en blanco.
    */
    public static int readLineInt( )
    {
        String inputString = null;
        int number = -9999;//To keep the compiler happy.
                           //Designed to look like a garbage value.
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = readLine( );
                inputString = inputString.trim( );
                number = Integer.parseInt(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                         "Your input number is not correct.");
                System.out.println(
                         "Your input number must be");
                System.out.println(
                         "a whole number written as an");
                System.out.println(
                          "ordinary numeral, such as 42");
                System.out.println("Minus signs are OK,"
                          + "but do not use a plus sign.");
                System.out.println("Please try again.");
                System.out.println("Enter a whole number:");
            }
        }

        return number;
    }

    /**
    
	Requisito: el usuario ha introducido un n�mero de tipo largo
     en una l�nea por s� misma, excepto que puede haber espacios en blanco
     antes y / o despu�s del n�mero.
     Acci�n: lee y devuelve el n�mero como un valor de tipo
     largo. El resto de la l�nea se descarta. Si la entrada es
     no ingresado correctamente, en la mayor�a de los casos, el usuario
     se le pedir� que vuelva a ingresar la entrada. En particular, este
     se aplica a formatos num�ricos incorrectos y l�neas en blanco.
    */
    public static long readLineLong( )
    {
        String inputString = null;
        long number = -9999;//To keep the compiler happy.
                      //Designed to look like a garbage value.
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = readLine( );
                inputString = inputString.trim( );
                number = Long.parseLong(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                         "Your input number is not correct.");
                System.out.println(
                             "Your input number must be");
                System.out.println(
                             "a whole number written as an");
                System.out.println(
                              "ordinary numeral, such as 42");
                System.out.println("Minus signs are OK,"
                               + "but do not use a plus sign.");
                System.out.println("Please try again.");
                System.out.println("Enter a whole number:");
            }
       }

        return number;
    }

    /**
    Requisito: el usuario ha introducido un n�mero de tipo
     doble en una l�nea por s� mismo, excepto que puede haber
     espacios en blanco antes y / o despu�s del n�mero.
     Acci�n: lee y devuelve el n�mero como un valor de tipo
     doble. El resto de la l�nea se descarta. Si la entrada
     no se ingresa correctamente, entonces, en la mayor�a de los casos, el usuario
     se le pedir� que vuelva a ingresar la entrada. En particular, este
     se aplica a formatos num�ricos incorrectos y l�neas en blanco.
    */
    public static double readLineDouble( )
    {
        String inputString = null;
        double number = -9999;//To keep the compiler happy.
                      //Designed to look like a garbage value.
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = readLine( );
                inputString = inputString.trim( );
                number = Double.parseDouble(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                         "Your input number is not correct.");
                System.out.println(
                         "Your input number must be");
                System.out.println(
                          "an ordinary number either with");
                System.out.println(
                           "or without a decimal point,");
                System.out.println("such as 42 or 9.99");
                System.out.println("Please try again.");
                System.out.println("Enter the number:");
            }
        }

        return number;
    }

    /**
  
Condici�n previa: el usuario ha introducido un n�mero de tipo flotante
     en una l�nea por s� misma, excepto que puede haber espacios en blanco
     antes y / o despu�s del n�mero.
     Acci�n: lee y devuelve el n�mero como un valor de tipo
     flotador. El resto de la l�nea se descarta. Si la entrada es
     no ingresado correctamente, en la mayor�a de los casos, el usuario
     se le pedir� que vuelva a ingresar la entrada. En particular,
     esto se aplica a formatos de n�meros incorrectos y l�neas en blanco.
    */
    public static float readLineFloat( )
    {
        String inputString = null;
        float number = -9999;//To keep the compiler happy.
                      //Designed to look like a garbage value.
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = readLine( );
                inputString = inputString.trim( );
                number = Float.parseFloat(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                         "Your input number is not correct.");
                System.out.println(
                         "Your input number must be");
                System.out.println(
                          "an ordinary number either with");
                System.out.println(
                          "or without a decimal point,");
                System.out.println("such as 42 or 9.99");
                System.out.println("Please try again.");
                System.out.println("Enter the number:");
            }
        }

        return number;
    }

    /**
   Lee el primer car�cter que no sea un espacio en blanco en una l�nea y
     devuelve ese car�cter. El resto de la l�nea es
     descartado. Si la l�nea contiene solo espacios en blanco, el
     se le pide al usuario que vuelva a ingresar a la l�nea.
    */
    public static char readLineNonwhiteChar( )
    {
        boolean done = false;
        String inputString = null;
        char nonWhite = ' ';//To keep the compiler happy.

        while (! done)
        {
            inputString = readLine( );
            inputString = inputString.trim( );
            if (inputString.length( ) == 0)
            {
                System.out.println(
                         "Your input is not correct.");
                System.out.println(
                         "Your input must contain at");
                System.out.println(
                         "least one nonwhitespace character.");
                System.out.println("Please try again.");
                System.out.println("Enter input:");
            }
            else
            {
                nonWhite = (inputString.charAt(0));
                done = true;
            }
        }

        return nonWhite;
    }

    /**
  La entrada debe constar de una sola palabra en una l�nea, posiblemente
     rodeado de espacios en blanco. La l�nea se lee y se descarta.
     Si la palabra de entrada es "true" o "t", se devuelve true.
     Si la palabra de entrada es "falso" o "f", entonces falso es
     regres�. Se consideran letras may�sculas y min�sculas
     igual. Si el usuario ingresa algo m�s (por ejemplo, m�ltiples
     palabras o palabras diferentes), se pregunta al usuario
     para volver a ingresar la entrada.
    */
    public static boolean readLineBoolean( )
    {
        boolean done = false;
        String inputString = null;
        boolean result = false;//To keep the compiler happy.

        while (! done)
        {
            inputString = readLine( );
            inputString = inputString.trim( );
            if (inputString.equalsIgnoreCase("true")
                   || inputString.equalsIgnoreCase("t"))
            {
                result = true;
                done = true;
            }
            else if (inputString.equalsIgnoreCase("false")
                        || inputString.equalsIgnoreCase("f"))
            {
                result = false;
                done = true;
            }
            else
            {
                System.out.println(
                         "Your input is not correct.");
                System.out.println("Your input must be");
                System.out.println("one of the following:");
                System.out.println("the word true,");
                System.out.println("the word false,");
                System.out.println("the letter T,");
                System.out.println("or the letter F.");
                System.out.println(
                         "You may use either upper-");
                System.out.println("or lowercase letters.");
                System.out.println("Please try again.");
                System.out.println("Enter input:");
            }
         }

        return result;
    }

    /**
   Lee el siguiente car�cter de entrada y devuelve ese car�cter.
     La siguiente lectura tiene lugar en la misma l�nea donde esta
     uno se qued�.
    */
    public static char readChar( )
    {
        int charAsInt = -1; //To keep the compiler happy.
        try
        {
            charAsInt = System.in.read( );
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage( ));
            System.out.println("Fatal error. Ending program.");
            System.exit(0);
        }

        return (char)charAsInt;
    }

    /**

	Lee el siguiente car�cter de entrada que no es un espacio en blanco y devuelve
     ese personaje. La siguiente lectura tiene lugar inmediatamente
     despu�s de que el personaje lea.
    */
    public static char readNonwhiteChar( )
    {
      char next;

      next = readChar( );
      while (Character.isWhitespace(next))
          next = readChar( );

      return next;
    }


    /**
    Los siguientes m�todos no se utilizan en el texto, excepto
     para una breve referencia en el Cap�tulo 2. Ning�n c�digo de programa utiliza
     ellos. Sin embargo, algunos programadores pueden querer usarlos.
    */


    /**
   
	Condici�n previa: la siguiente entrada en la secuencia consiste en
     un valor int, posiblemente precedido por un espacio en blanco, pero
     definitivamente seguido de espacios en blanco.
     Acci�n: lee la primera cadena de caracteres que no son espacios en blanco
     y devuelve el valor int que representa. Descarta el
     primer car�cter de espacio en blanco despu�s de la palabra. La siguiente lectura
     tiene lugar inmediatamente despu�s del espacio en blanco descartado.
     En particular, si la palabra est� al final de una l�nea, la
     la pr�xima lectura tendr� lugar a partir de la siguiente l�nea.
     Si la siguiente palabra no representa un valor int,
     se lanza una NumberFormatException.

    */
    public static int readInt( ) throws NumberFormatException
    {
        String inputString = null;
        inputString = readWord( );
        return Integer.parseInt(inputString);
    }

    /**
 
	Condici�n previa: la siguiente entrada consta de un valor largo,
     posiblemente precedido por espacios en blanco, pero definitivamente
     seguido de un espacio en blanco.
     Acci�n: lee la primera cadena de caracteres que no son espacios en blanco
     y devuelve el valor largo que representa. Descarta el
     primer car�cter de espacio en blanco despu�s de leer la cadena. los
     la siguiente lectura tiene lugar inmediatamente despu�s de la
     espacio en blanco. En particular, si la cadena le�da est� en el
     final de una l�nea, la siguiente lectura tendr� lugar a partir del
     la siguiente l�nea. Si la siguiente palabra no representa una larga
     value, se lanza una NumberFormatException.
    */
    public static long readLong( )
                      throws NumberFormatException
    {
        String inputString = null;
        inputString = readWord( );
        return Long.parseLong(inputString);
    }

   /**
   Condici�n previa: la siguiente entrada consta de un valor doble,
     posiblemente precedido por espacios en blanco, pero definitivamente
     seguido de un espacio en blanco.
     Acci�n: lee la primera cadena de caracteres que no son espacios en blanco
     y devuelve el valor doble que representa. Descarta el
     primer car�cter de espacio en blanco despu�s de leer la cadena. los
     la siguiente lectura tiene lugar inmediatamente despu�s de la
     espacio en blanco. En particular, si la cadena le�da est� en el
     final de una l�nea, la siguiente lectura tendr� lugar a partir del
     la siguiente l�nea. Si la siguiente palabra no representa un
     valor doble, se lanza una NumberFormatException.

    */
    public static double readDouble( )
                       throws NumberFormatException
    {
        String inputString = null;
        inputString = readWord( );
        return Double.parseDouble(inputString);
    }

    /**
  	Condici�n previa: la siguiente entrada consiste en un valor flotante,
     posiblemente precedido por espacios en blanco, pero definitivamente
     seguido de un espacio en blanco.
     Acci�n: lee la primera cadena de caracteres que no son espacios en blanco
     y devuelve el valor flotante que representa. Descarta el
     primer car�cter de espacio en blanco despu�s de leer la cadena. los
     la siguiente lectura tiene lugar inmediatamente despu�s de la
     espacio en blanco. En particular, si la cadena le�da est� en el
     final de una l�nea, la siguiente lectura tendr� lugar a partir del
     la siguiente l�nea. Si la siguiente palabra no representa
     un valor flotante, se lanza una NumberFormatException.
    */
    public static float readFloat( )
                         throws NumberFormatException
    {
        String inputString = null;
        inputString = readWord( );
        return Float.parseFloat(inputString);
    }

    /**
 
	Lee la primera cadena de caracteres que no son espacios en blanco y
     devuelve esa cadena. Descarta el primer espacio en blanco
     car�cter despu�s de leer la cadena. La siguiente lectura toma
     colocar inmediatamente despu�s del espacio en blanco descartado. En
     en particular, si la cadena le�da est� al final de una l�nea,
     la siguiente lectura tendr� lugar a partir de la siguiente l�nea.
     Tenga en cuenta que si recibe l�neas en blanco, esperar� hasta
     obtiene un car�cter que no es de espacio en blanco.
    */
    public static String readWord( )
    {
        String result = "";
        char next;

        next = readChar( );
        while (Character.isWhitespace(next))
             next = readChar( );

        while (!(Character.isWhitespace(next)))
        {
            result = result + next;
            next = readChar( );
        }

        if (next == '\r')
        {
            next = readChar( );
            if (next != '\n')
            {
                System.out.println("Fatal error in method "
                     + "readWord of the class SavitchIn.");
                System.exit(1);
            }
        }

        return result;
    }

    /**
  	Requisito: el usuario ha introducido un n�mero de byte de tipo
     en una l�nea por s� misma, excepto que puede haber espacios en blanco
     antes y / o despu�s del n�mero.
     Acci�n: lee y devuelve el n�mero como un valor de tipo
     byte. El resto de la l�nea se descarta. Si la entrada es
     no ingresado correctamente, en la mayor�a de los casos, el usuario
     se le pedir� que vuelva a ingresar la entrada. En particular, esto se aplica
     a formatos num�ricos incorrectos y l�neas en blanco.
    */
    public static byte readLineByte( )
    {
        String inputString = null;
        byte number = -123;//To keep the compiler happy.
                      //Designed to look like a garbage value.
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = readLine( );
                inputString = inputString.trim( );
                number = Byte.parseByte(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                         "Your input number is not correct.");
                System.out.println(
                         "Your input number must be a");
                System.out.println(
                         "whole number in the range");
                System.out.println("-128 to 127, written as");
                System.out.println(
                         "an ordinary numeral, such as 42.");
                System.out.println("Minus signs are OK,"
                               + "but do not use a plus sign.");
                System.out.println("Please try again.");
                System.out.println("Enter a whole number:");
            }
        }

        return number;
    }

    /**
  
	Requisito: el usuario ha introducido un n�mero de tipo corto
     en una l�nea por s� misma, excepto que puede haber espacios en blanco
     antes y / o despu�s del n�mero.
     Acci�n: lee y devuelve el n�mero como un valor de tipo
     corto. El resto de la l�nea se descarta. Si la entrada es
     no ingresado correctamente, en la mayor�a de los casos, el usuario
     se le pedir� que vuelva a ingresar la entrada. En particular, esto se aplica
     a formatos num�ricos incorrectos y l�neas en blanco.
    */
    public static short readLineShort( )
    {
        String inputString = null;
        short number = -9999;//To keep the compiler happy.
                           //Designed to look like a garbage value.
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = readLine( );
                inputString = inputString.trim( );
                number = Short.parseShort(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                         "Your input number is not correct.");
                System.out.println(
                         "Your input number must be a");
                System.out.println(
                         "whole number in the range");
                System.out.println(
                         "-32768 to 32767, written as");
                System.out.println(
                         "an ordinary numeral, such as 42.");
                System.out.println("Minus signs are OK,"
                               + "but do not use a plus sign.");
                System.out.println("Please try again.");
                System.out.println("Enter a whole number:");
            }
        }

        return number;
    }

    public static byte readByte( ) throws NumberFormatException
    {
        String inputString = null;
        inputString = readWord( );
        return Byte.parseByte(inputString);
    }

    public static short readShort( ) throws NumberFormatException
    {
        String inputString = null;
        inputString = readWord( );
        return Short.parseShort(inputString);
    }

 // Lo siguiente no se us� intencionalmente en el c�digo para
    // otros m�todos para que alguien que lea el c�digo pueda
    // ver m�s r�pidamente lo que se estaba utilizando.
    
    /*
     Lee el primer byte del flujo de entrada y devuelve ese
     byte como int. La siguiente lectura tiene lugar donde esta
     Parado. Esta lectura es la misma que System.in.read (),
     excepto que detecta IOExceptions.
    */
    public static int read( )
    {
        int result = -1; //To keep the compiler happy
        try
        {
            result = System.in.read( );
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage( ));
            System.out.println("Fatal error. Ending program.");
            System.exit(0);
        }
        return result;
    }
}