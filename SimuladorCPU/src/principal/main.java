package principal;

import java.util.ArrayList;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Instruccion> instrucciones = new ArrayList<Instruccion>();
		
		
		instrucciones.add(new Instruccion(1,1,1,1));//ADD
		instrucciones.add(new Instruccion(2,2,2,2));//MULT
		
		instrucciones.add(new Instruccion(1,1,1,1));//ADD
		
		instrucciones.add(new Instruccion(1,1,1,1));//ADD
		
		instrucciones.add(new Instruccion(1,1,1,1));//ADD
		instrucciones.add(new Instruccion(2,2,2,5));//ADD
		instrucciones.add(new Instruccion(1,1,2,6));//ADD
		
		instrucciones.add(new Instruccion(4,2,0,0));//sw r2, (0)
		instrucciones.add(new Instruccion(3, 0, 0, 4));//lw r4, (r0)
		
		for (int i=0;i<4;i++)//Rellenamos con nops al final para evitar que se quede fuera de rango
			instrucciones.add(new Instruccion(0,0,0,0));
		instrucciones.add(new Instruccion(88,0,0,0));//TRAP
		for (int i=0;i<4;i++)//Rellenamos con nops al final para evitar que se quede fuera de rango
			instrucciones.add(new Instruccion(0,0,0,0));
		
		Procesador segmentado = new Procesador();
		segmentado.inicializa(instrucciones);
		segmentado.ejecuta();
		System.out.println("Banco de registros: ");
		for(int a:segmentado.getBancoRegistros())
			System.out.print(" - "+a+" - ");
		
		
		System.out.println("\nMemoria: ");
		for(int a:UnidadesFuncionales.memoria)
			System.out.print(" - "+a+" - ");

	}

}
