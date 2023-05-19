package ExamDemo;

public class Selec_Mul_Pregunta extends Pregunta{
	
	/*-	Selec_Mul_Pregunta.java: Otra extensi�n de la clase Preguntas, 
	 * 	esta vez para definir las preguntas de selecci�n m�ltiple.  Recordar que preguntas de selecci�n m�ltiple deben tener al menos 2 elecciones. 
	 *  Esta clase deber� contener:
		un m�todo concreto buscar().Imprimir� la pregunta, seguida por las elecciones, 
		identific�ndolas por letras 'a', 'b', 'c', etc.una variable para registrar la elecci�n (un array de Strings)
 		y la respuesta correcta (un int -- es el index de la respuesta correcta en el array de elecciones).
 		un constructor que crea la pregunta de elecci�n m�ltiple, dado el texto de la pregunta, el array de elecciones, 
 		la respuesta correcta y el peso "peso".
	 */
	private String[] array_elecciones;
	private int correcta;
	String[] alternativas = {"a","b","c","d","e"};
	public Selec_Mul_Pregunta(String text,String[] array,int respuesta_correcta,int peso){
		super(text);
		this.array_elecciones = array;
		this.correcta = respuesta_correcta;
		this.setPeso(peso);
	}
	
	
	public boolean buscar() {
		int index = 0;
		int i=0;
		System.out.println(getText());
		for(String j:array_elecciones) {	//imprimo alternativas
			System.out.println(j);
		}
		System.out.println("Ingrese la altenativa que crea usted correcta");
		String respuestaUsuario = SavitchIn.readLine().toLowerCase();
		for(i=0 ; i<array_elecciones.length ; i++) {
			if(respuestaUsuario.equalsIgnoreCase(alternativas[i])){
				index = i;
			}
		}
			if(array_elecciones[correcta].equalsIgnoreCase(array_elecciones[index])) {
				System.out.println("Correcta!");
				return true;
			}
				
			else {
				System.out.println("InCorrecta!");
				return false;
			}
	}
}
