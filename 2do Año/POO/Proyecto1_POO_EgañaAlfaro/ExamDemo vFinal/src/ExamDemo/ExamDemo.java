package ExamDemo;

public class ExamDemo {
	public static void main(String[] args) {
	    Exam miExam = new Exam();
	    miExam.agregaPregunta(new TF_Pregunta("¿La capital de Chile es Santiago?", true, 1));
	    String santiagoElec[] = {"a. Santiago", "b. Valparaiso", "c. Copiapo", "d. Magallanes", "e. Temuco"};
	    miExam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuál es la capital de Region Metropolitana?", santiagoElec, 0, 1));
	    miExam.agregaPregunta(new Resp_Cortas("¿Cuál es la capital de IV Region?", "La Serena", 1));
	    miExam.agregaPregunta(new TF_Pregunta("¿La capital de Estados Unidos es New York?", false, 1));
	    miExam.agregaPregunta(new Resp_Cortas("¿ Cuánto es 64+4 ?", "68", 1));
	    miExam.agregaPregunta(new Resp_Cortas("¿Cuál es la capital de Alemania?", "Berlin", 2));
	    miExam.agregaPregunta(new TF_Pregunta("¿La capital de Rusia es Stalingrado?", false, 1));
	    String PElec[] = {"a. Brasilia", "b. Rio de Janeiro", "c. Sao Paulo", "d. Lima"};
	    miExam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuál es la capital de Brasil?", PElec, 0,1));
    
		int puntaje = miExam.DarExam();
	    System.out.println("El Porcentaje de respuestas correctas es: " + puntaje + "%");
	}
}
