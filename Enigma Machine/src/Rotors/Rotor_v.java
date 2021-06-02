package Rotors;
public class Rotor_v extends Rotor {
	int[][] wiring;
	int Position;
	int Turnover1;
	int Turnover2;
	Boolean canTurn;
	public Rotor_v() {
		// Rotor 5 Object
		wiring = new int[][] {
			{0, 21 },     //A->V
			{1, 25 },     //B->Z
			{2, 1 },     //C->B
			{3, 17 },     //D->R
			{4, 6 },     //E->G
			{5, 8 },     //F->I
			{6, 19 },     //G->T
			{7, 24 },     //H->Y
			{8, 20 },     //I->U
			{9, 15 },     //J->P
			{10, 18 },     //K->S
			{11, 3 },     //L->D
			{12, 13 },     //M->N
			{13, 7 },     //N->H
			{14, 11 },     //O->L
			{15, 23 },     //P->X
			{16, 0 },     //Q->A
			{17, 22 },     //R->W
			{18, 12 },     //S->M
			{19, 9 },     //T->J
			{20, 16 },     //U->Q
			{21, 14 },     //V->O
			{22, 5 },     //W->F
			{23, 4 },     //X->E
			{24, 2 },     //Y->C
			{25, 10 }};     //Z->K 
		Position = 0;
		Turnover1 = 25;
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
