package ExamDemo;

public abstract class Pregunta {
	/* Variable peso,privado para usarlo solo en esta clase y 
	   para usarlos fuera de la clase se usa get y set
	  
	*/	
		private String text;
		
		/* Una variable text para el texto de la pregunta */
		
		public Pregunta(String text) {
			this.text = text;
		}	// constructor Pregunta 
	
		private int peso;
		
		public int getPeso() {
			return this.peso;
		}
		
		public void setPeso(int pes) {
			this.peso = pes;
		}
				
		public String getText() {
			return text; 
		}
		
		public abstract boolean buscar(); 
		
		
		/*
		 Pedirá la pregunta, lee la respuesta del usuario
		 y return un resultado boolean indicando si el usuario la respondió correctamente. 
		 */
		
}
