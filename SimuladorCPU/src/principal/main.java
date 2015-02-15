package principal;

import java.util.ArrayList;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Instruccion> instrucciones = new ArrayList<Instruccion>();
		
		
		instrucciones.add(new Instruccion(2,2,2,2));
		instrucciones.add(new Instruccion(0,0,0,0));
		instrucciones.add(new Instruccion(1,1,1,1));
		instrucciones.add(new Instruccion(0,0,0,0));
		instrucciones.add(new Instruccion(1,1,1,1));

		instrucciones.add(new Instruccion(88,0,0,0));
		for (int i=0;i<4;i++)//Rellenamos con nops al final para evitar que se quede fuera de rango
			instrucciones.add(new Instruccion(0,0,0,0));
		
		Procesador segmentado = new Procesador();
		segmentado.inicializa(instrucciones);
		segmentado.ejecuta();
		System.out.println("Banco de registros: ");
		for(int a:segmentado.getBancoRegistros())
			System.out.print(" - "+a+" - ");

	}

}
