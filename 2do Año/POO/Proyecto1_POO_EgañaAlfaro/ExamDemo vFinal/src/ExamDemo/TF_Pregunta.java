package ExamDemo;

public class TF_Pregunta extends Pregunta {
	private boolean Legal;
	public TF_Pregunta(String text , boolean respuesta, int peso){
		super(text);
		this.Legal = respuesta;
		super.setPeso(peso);
	}
	public boolean buscar() {
    System.out.print(getText() + " (Ingrese T o F): ");
	    // obtener respuesta del usuario y traslada a to lower case
	    String Usuario = SavitchIn.readLine().toLowerCase();
	    if (Usuario.equalsIgnoreCase("t")) {
	      if (Legal==true) {
	        System.out.println(" La Respuesta es Correcta! ");
	        return true;
	      }
	      else {
	        System.out.println( " Respuesta Incorrecta! ");
	        return false;
	      } 
	    }
	    else 
	    	if (Usuario.equalsIgnoreCase("f")) {
	    	if (Legal==false) {
	        System.out.println(" La Respuesta es Correcta! ");
		    	return true;
	    	}
	      else {
	        System.out.println(" Respuesta Incorrecta! ");
	        return false;
	      } 
	    }
	    else { // respuesta no valida true/false
	      System.out.println(" Respuesta Invalida, Debe ingresar 'T' o 'F' e Intentelo nuevamente. ");
	      return buscar(); // otra vez
	    } 	
	}	
}
