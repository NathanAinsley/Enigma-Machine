package Rotors;
public class Rotor_i extends Rotor {
	int[][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_i() {
		// Rotor 1 Object
		wiring = new int[][] {
			{0, 4 },     //A->E
			{1, 10 },     //B->K
			{2, 12 },     //C->M
			{3, 5 },     //D->F
			{4, 11 },     //E->L
			{5, 6 },     //F->G
			{6, 3 },     //G->D
			{7, 16 },     //H->Q
			{8, 21 },     //I->V
			{9, 25 },     //J->Z
			{10, 13 },     //K->N
			{11, 19 },     //L->T
			{12, 14 },     //M->O
			{13, 22 },     //N->W
			{14, 24 },     //O->Y
			{15, 7 },     //P->H
			{16, 23 },     //Q->X
			{17, 20 },     //R->U
			{18, 18 },     //S->S
			{19, 15 },     //T->P
			{20, 0 },     //U->A
			{21, 8 },     //V->I
			{22, 1 },     //W->B
			{23, 17 },     //X->R
			{24, 2 },     //Y->C
			{25, 9 }};     //Z->J
			Position = 0;
			Turnover1 = 16;
			Turnover2 = -1;
			canTurn = true;
	}
	public int[][] getwiring() {
		return wiring;
	}
	public int getPosition() {
		return Position;
	}
	public void incPosition() {
		if(Position<26) {
			this.Position = Position + 1;
			
		}
		if (Position >25) {
			this.Position = 0;
			}
	}
	public int getTurnover1() {
		return Turnover1;
	}
	public int getTurnover2() {
		return Turnover2;
	}
	public boolean getCanTurn() {
		return canTurn;
	}
	public void setCanTurn(boolean CanTurn) {
		canTurn = CanTurn;
	}
	
}
