package Rotors;
public class Rotor_vi extends Rotor {
	int[][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_vi() {
		// Rotor 6 Object
		wiring = new int[][] {
			{0, 9 },     //A->J
			{1, 15 },     //B->P
			{2, 6 },     //C->G
			{3, 21 },     //D->V
			{4, 14 },     //E->O
			{5, 20 },     //F->U
			{6, 12 },     //G->M
			{7, 5 },     //H->F
			{8, 24 },     //I->Y
			{9, 16 },     //J->Q
			{10, 1 },     //K->B
			{11, 4 },     //L->E
			{12, 13 },     //M->N
			{13, 7 },     //N->H
			{14, 25 },     //O->Z
			{15, 17 },     //P->R
			{16, 3 },     //Q->D
			{17, 10 },     //R->K
			{18, 0 },     //S->A
			{19, 18 },     //T->S
			{20, 23 },     //U->X
			{21, 11 },     //V->L
			{22, 8 },     //W->I
			{23, 2 },     //X->C
			{24, 19 },     //Y->T
			{25, 22 }};     //Z->W
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
