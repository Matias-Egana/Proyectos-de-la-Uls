package ExamDemo;

public class Exam {
	/*Es una clase que entrega una colección de preguntas para un examen dado. El examen parte vacío (no existen preguntas), 
	y proporciona un método para agregar preguntas a un examen. Esta clase deberá contener:
	Un array de preguntas.  
	Estudie la forma de limitar el nº límite de preguntas, por ahora cree un array de tamaño 10.
	Un contador para el nº de preguntas en el array.
	Un método agregaPregunta() , el que toma una pregunta (de cualquier tipo) como argumento y la agrega al examen.
	
	Un método darExam() el cual administra el examen al usuario, con el fin de garantizar el nº de respuestas,
	 con su porcentaje y el redondeo apropiado, como resultado.
	 */
	private Object[] Array_Preguntas = new Object[10];
	private int PuntajeUsuario=0;
	private int PuntajeTotal=0;
	private int n_Pregunta=0;

	public void agregaPregunta(Object pregunta) {
		if(n_Pregunta<10) {
			Array_Preguntas[n_Pregunta] = pregunta;
			n_Pregunta++;
		}
		else {
			System.out.println("Error limite excedido");
		}
	}
	public int DarExam() {
		System.out.println("**************Examen******************");
		boolean correccion;
		int Resultado = 0;
		int i = 0;
			for(i=0;i<n_Pregunta;i++) {
				if(Array_Preguntas[i].getClass() == Resp_Cortas.class) {
					Resp_Cortas respuestacorta = (Resp_Cortas) Array_Preguntas[i] ;
			//		System.out.println(""+respuestacorta.getText()+"(respuestacorta)");
					correccion = respuestacorta.buscar();
					if(correccion) {
						PuntajeUsuario = PuntajeUsuario + respuestacorta.getPeso();
					}
					PuntajeTotal = PuntajeTotal + respuestacorta.getPeso();
				}
				if(Array_Preguntas[i].getClass() == TF_Pregunta.class) {
					TF_Pregunta tfpregunta = (TF_Pregunta) Array_Preguntas[i] ;	//creo objeto y la incializo en el arreglo;
				//	System.out.println(""+tfpregunta.getText()+"(tfpregunta)");
					correccion = tfpregunta.buscar();
					if(correccion) {
						PuntajeUsuario = PuntajeUsuario + tfpregunta.getPeso();
					}
					PuntajeTotal = PuntajeTotal +tfpregunta.getPeso();
				}
				if(Array_Preguntas[i].getClass() == Selec_Mul_Pregunta.class) {
					Selec_Mul_Pregunta selecmulpregunta = (Selec_Mul_Pregunta) Array_Preguntas[i] ;
				//	System.out.println(""+selecmulpregunta.getText()+"(selecmulpregunta)");
					correccion = selecmulpregunta.buscar();
					if(correccion) {
						PuntajeUsuario = PuntajeUsuario + selecmulpregunta.getPeso();
					}
					PuntajeTotal = PuntajeTotal +selecmulpregunta.getPeso();
				}
			}
			double Porcentaje = (PuntajeUsuario*100)/PuntajeTotal;
			Resultado = (int)Porcentaje;
			System.out.println("El Puntaje Obtenido es: " +PuntajeUsuario);
			System.out.println("El Puntaje Total es: " +PuntajeTotal);
			return Resultado;
	}
}
