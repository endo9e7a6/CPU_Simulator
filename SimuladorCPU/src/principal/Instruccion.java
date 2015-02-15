package principal;

public class Instruccion {

	public Instruccion(int codOp, int rA, int rB, int rC) {
		super();
		this.codOp = codOp;
		this.rA = rA;
		this.rB = rB;
		this.rC = rC;
	}
	
	public int codOp;//TRAP: 88
	                 //NOP:  0
	                 //ADD:  1
					 //MULT: 2
	public int rA;
	public int rB;
	public int rC;
}
