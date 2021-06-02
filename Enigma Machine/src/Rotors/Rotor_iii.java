package Rotors;

public class Rotor_iii extends Rotor {
	int [][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	int Setting;
	Boolean canTurn;
	public Rotor_iii() {
		// Rotor 3 Object
		wiring = new int [][] {
			{0, 1 },     //A->B
			{1, 3 },     //B->D
			{2, 5 },     //C->F
			{3, 7 },     //D->H
			{4, 9 },     //E->J
			{5, 11 },     //F->L
			{6, 2 },     //G->C
			{7, 15 },     //H->P
			{8, 17 },     //I->R
			{9, 19 },     //J->T
			{10, 23 },     //K->X
			{11, 21 },     //L->V
			{12, 25 },     //M->Z
			{13, 13 },     //N->N
			{14, 24 },     //O->Y
			{15, 4 },     //P->E
			{16, 8 },     //Q->I
			{17, 22 },     //R->W
			{18, 6 },     //S->G
			{19, 0 },     //T->A
			{20, 10 },     //U->K
			{21, 12 },     //V->M
			{22, 20 },     //W->U
			{23, 18 },     //X->S
			{24, 16 },     //Y->Q
			{25, 14 }};     //Z->O
		Position = 0;
		Turnover1 = 21;
		Turnover2 = -1;
		Setting = 1;
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
