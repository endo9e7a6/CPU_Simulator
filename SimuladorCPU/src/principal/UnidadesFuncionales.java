package principal;

import java.util.ArrayList;

public class UnidadesFuncionales {
	public static int[] memoria=new int[1000];

	public static boolean WB(ALU_WB alu_wb, int[] bancoRegistros){
//		System.out.println("Soy WB, Datos:" + alu_wb)
		if(alu_wb.codOp == 88)//trap
			return false;
		if(alu_wb.codOp == 0)//nop
			return true;
		bancoRegistros[alu_wb.rC] = alu_wb.C;
		return true;
	}
	public static void MEM(ID_ALU id_alu, ALU_WB alu_wb){
		
		switch(id_alu.codOp){
		case 3://lw
			alu_wb.codOp=3;
			alu_wb.C=memoria[id_alu.A];
			break;
		case 4://sw
			alu_wb.codOp=0;
			memoria[id_alu.rC]=id_alu.A;
			break;

		}
		alu_wb.rC = id_alu.rC;
	}
    public static void ALU(ID_ALU id_alu, ALU_WB alu_wb){

		alu_wb.codOp=id_alu.codOp;
		switch(id_alu.codOp){
		case 0://nop
			
			break;		

		case 1://add
			alu_wb.C=id_alu.A + id_alu.B;
			break;
		case 2://mult
			alu_wb.C=id_alu.A * id_alu.B;
			break;
		case 88://trap
			
		default:
			
			break;
		}
		alu_wb.rC = id_alu.rC;
	}
    public static void ID(IF_ID if_id, ID_ALU id_alu, int[] bancoRegistros){

		id_alu.codOp = if_id.codOp;
		id_alu.A = bancoRegistros[if_id.rA];
		id_alu.B = bancoRegistros[if_id.rB];
		id_alu.rC = if_id.rC;
		
		
	}
    public static void IF(int pc, IF_ID if_id, ArrayList<Instruccion> bancoInstrucciones){
    	  	
		Instruccion ins = bancoInstrucciones.get(pc);

		if_id.codOp=ins.codOp;
		if_id.rA=ins.rA;
		if_id.rB=ins.rB;
		if_id.rC=ins.rC;
	}
}
