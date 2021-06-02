package Rotors;
public class Rotor_viii extends Rotor {
	int[][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_viii() {
		// Rotor 8 Object
		wiring = new int[][] {
			{0, 5 },     //A->F
			{1, 10 },     //B->K
			{2, 16 },     //C->Q
			{3, 7 },     //D->H
			{4, 19 },     //E->T
			{5, 11 },     //F->L
			{6, 23 },     //G->X
			{7, 14 },     //H->O
			{8, 2 },     //I->C
			{9, 1 },     //J->B
			{10, 9 },     //K->J
			{11, 18 },     //L->S
			{12, 15 },     //M->P
			{13, 3 },     //N->D
			{14, 25 },     //O->Z
			{15, 17 },     //P->R
			{16, 0 },     //Q->A
			{17, 12 },     //R->M
			{18, 4 },     //S->E
			{19, 22 },     //T->W
			{20, 13 },     //U->N
			{21, 8 },     //V->I
			{22, 20 },     //W->U
			{23, 24 },     //X->Y
			{24, 6 },     //Y->G
			{25, 21 }};     //Z->V
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
