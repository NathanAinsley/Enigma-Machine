package Rotors;

public class Rotor_Beta extends Rotor{
	int[][] wiring;
	int Position;
	public Rotor_Beta() {
		// Beta Rotor object
		wiring = new int[][] {
			{0, 11 },     //A->L
			{1, 4 },     //B->E
			{2, 24 },     //C->Y
			{3, 9 },     //D->J
			{4, 21 },     //E->V
			{5, 2 },     //F->C
			{6, 13 },     //G->N
			{7, 8 },     //H->I
			{8, 23 },     //I->X
			{9, 22 },     //J->W
			{10, 15 },     //K->P
			{11, 1 },     //L->B
			{12, 16 },     //M->Q
			{13, 12 },     //N->M
			{14, 3 },     //O->D
			{15, 17 },     //P->R
			{16, 19 },     //Q->T
			{17, 0 },     //R->A
			{18, 10 },     //S->K
			{19, 25 },     //T->Z
			{20, 6 },     //U->G
			{21, 5 },     //V->F
			{22, 20 },     //W->U
			{23, 7 },     //X->H
			{24, 14 },     //Y->O
			{25, 18 }};     //Z->S
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
