package Rotors;
public class Rotor_iv extends Rotor {
	int[][] wiring;
	int Position;
	int Turnover;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_iv() {
		// Rotor 4 Object
		wiring = new int[][] {
			{0, 4 },     //A->E
			{1, 18 },     //B->S
			{2, 14 },     //C->O
			{3, 21 },     //D->V
			{4, 15 },     //E->P
			{5, 25 },     //F->Z
			{6, 9 },     //G->J
			{7, 0 },     //H->A
			{8, 24 },     //I->Y
			{9, 16 },     //J->Q
			{10, 20 },     //K->U
			{11, 8 },     //L->I
			{12, 17 },     //M->R
			{13, 7 },     //N->H
			{14, 23 },     //O->X
			{15, 11 },     //P->L
			{16, 13 },     //Q->N
			{17, 5 },     //R->F
			{18, 19 },     //S->T
			{19, 6 },     //T->G
			{20, 10 },     //U->K
			{21, 3 },     //V->D
			{22, 2 },     //W->C
			{23, 12 },     //X->M
			{24, 22 },     //Y->W
			{25, 1 }};     //Z->B 
			Position = 0;
			Turnover1 = 9;
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
