package Rotors;
public class Rotor_vii extends Rotor {
	int[][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_vii() {
		// Rotor 7 Object
		wiring = new int[][] {
			{0, 13 },     //A->N
			{1, 25 },     //B->Z
			{2, 9 },     //C->J
			{3, 7 },     //D->H
			{4, 6 },     //E->G
			{5, 17 },     //F->R
			{6, 2 },     //G->C
			{7, 23 },     //H->X
			{8, 12 },     //I->M
			{9, 24 },     //J->Y
			{10, 18 },     //K->S
			{11, 22 },     //L->W
			{12, 1 },     //M->B
			{13, 14 },     //N->O
			{14, 20 },     //O->U
			{15, 5 },     //P->F
			{16, 0 },     //Q->A
			{17, 8 },     //R->I
			{18, 21 },     //S->V
			{19, 11 },     //T->L
			{20, 15 },     //U->P
			{21, 4 },     //V->E
			{22, 10 },     //W->K
			{23, 16 },     //X->Q
			{24, 3 },     //Y->D
			{25, 19 }};     //Z->T
			Position = 0;
			Turnover1 = 12;
			Turnover2 = 0;
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
