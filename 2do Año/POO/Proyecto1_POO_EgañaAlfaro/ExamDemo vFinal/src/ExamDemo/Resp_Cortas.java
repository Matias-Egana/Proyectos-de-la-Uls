package ExamDemo;

public class Resp_Cortas extends Pregunta {
	private String resp_correcto;
	
	public Resp_Cortas(String text,String correcto,int peso){
		super(text);
		this.resp_correcto = correcto;
		super.setPeso(peso);	
	} 
	
	public boolean buscar() {
		System.out.println(getText() + " Ingrese la respuesta que crea usted correcta ");
		String resp_usuario = SavitchIn.readLine().toLowerCase();	
		if(resp_correcto.equalsIgnoreCase(resp_usuario)) {
			System.out.println("La Respuesta es Correcta!");
			return true;
		}
		else {
			System.out.println("Respuesta Incorrecta!");
			return false;
		}
	}
}
