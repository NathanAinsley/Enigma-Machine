package Rotors;
public class Reflector_B extends Rotor {
	int[][] wiring;
	public Reflector_B() {
		// Reflector B object
		wiring = new int[][] {
			{0, 4 },     //A->E
			{1, 13 },     //B->N
			{2, 10 },     //C->K
			{3, 16 },     //D->Q
			{4, 0 },     //E->A
			{5, 20 },     //F->U
			{6, 24 },     //G->Y
			{7, 22 },     //H->W
			{8, 9 },     //I->J
			{9, 8 },     //J->I
			{10, 2 },     //K->C
			{11, 14 },     //L->O
			{12, 15 },     //M->P
			{13, 1 },     //N->B
			{14, 11 },     //O->L
			{15, 12 },     //P->M
			{16, 3 },     //Q->D
			{17, 23 },     //R->X
			{18, 25 },     //S->Z
			{19, 21 },     //T->V
			{20, 5 },     //U->F
			{21, 19 },     //V->T
			{22, 7 },     //W->H
			{23, 17 },     //X->R
			{24, 6 },     //Y->G
			{25, 18 }};     //Z->S
	}
	public int[][] getwiring() {
		return wiring;
	}
}
