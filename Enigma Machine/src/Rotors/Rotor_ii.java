package Rotors;

public class Rotor_ii extends Rotor{
	int[][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_ii() {
		// Rotor 2 Object
		wiring = new int [][] {
			{0, 0 },     //A->A
			{1, 9 },     //B->J
			{2, 3 },     //C->D
			{3, 10 },     //D->K
			{4, 18 },     //E->S
			{5, 8 },     //F->I
			{6, 17 },     //G->R
			{7, 20 },     //H->U
			{8, 23 },     //I->X
			{9, 1 },     //J->B
			{10, 11 },     //K->L
			{11, 7 },     //L->H
			{12, 22 },     //M->W
			{13, 19 },     //N->T
			{14, 12 },     //O->M
			{15, 2 },     //P->C
			{16, 16 },     //Q->Q
			{17, 6 },     //R->G
			{18, 25 },     //S->Z
			{19, 13 },     //T->N
			{20, 15 },     //U->P
			{21, 24 },     //V->Y
			{22, 5 },     //W->F
			{23, 21 },     //X->V
			{24, 14 },     //Y->O
			{25, 4 }};     //Z->E
			
		Position = 0;
		Turnover1 = 4;
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
