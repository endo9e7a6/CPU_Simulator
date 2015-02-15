package principal;

import java.util.ArrayList;

public class Procesador {

	ArrayList<Instruccion> bancoInstrucciones;
	int[] bancoRegistros;
	int pc;
	ALU_WB alu_wb;
	ID_ALU id_alu;
	IF_ID if_id;
	
	public int[] getBancoRegistros(){
		return this.bancoRegistros;
	}
	public void inicializa(ArrayList<Instruccion> instrucciones){
		
		this.bancoRegistros =  new int[15];
		for(int i=0;i<bancoRegistros.length;i++)
			bancoRegistros[i]=i*10;
		this.bancoInstrucciones = instrucciones;
		pc = 0;
		alu_wb = new ALU_WB();
		id_alu = new ID_ALU();
		if_id = new IF_ID();
		System.out.println("Inicializado correctamente");
	}
	
	public void ejecuta(){
		boolean status = true;
		while(status){
			System.out.println("PC: "+ pc);
			//WB(ALU_WB, bancoRegistros) ¿CUANDO RECIBA TRAP a la mierda con status
			status = UnidadesFuncionales.WB(alu_wb, bancoRegistros);
			//ALU(ID_ALU, ALU_WB)
			UnidadesFuncionales.ALU(id_alu, alu_wb);	
			//ID(IF_ID, ID_ALU, bancoRegistros
			UnidadesFuncionales.ID(if_id, id_alu, bancoRegistros);
			//IF(PC, bancoInstrucciones, IF_ID)
			UnidadesFuncionales.IF(pc, if_id, bancoInstrucciones);
			
			pc++;
		}
	}
}
