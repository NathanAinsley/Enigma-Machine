package Rotors;

public class Rotor_Gamma extends Rotor{
	int[][] wiring;
	int Position;
	public Rotor_Gamma() {
		// Gamma Rotor Object
		wiring = new int[][] {
			{0, 5 },     //A->F
			{1, 18 },     //B->S
			{2, 14 },     //C->O
			{3, 10 },     //D->K
			{4, 0 },     //E->A
			{5, 13 },     //F->N
			{6, 20 },     //G->U
			{7, 4 },     //H->E
			{8, 17 },     //I->R
			{9, 7 },     //J->H
			{10, 12 },     //K->M
			{11, 1 },     //L->B
			{12, 19 },     //M->T
			{13, 8 },     //N->I
			{14, 24 },     //O->Y
			{15, 2 },     //P->C
			{16, 22 },     //Q->W
			{17, 11 },     //R->L
			{18, 16 },     //S->Q
			{19, 15 },     //T->P
			{20, 25 },     //U->Z
			{21, 23 },     //V->X
			{22, 21 },     //W->V
			{23, 6 },     //X->G
			{24, 9 },     //Y->J
			{25, 3 }};     //Z->D
			Position = 0;	
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

}
