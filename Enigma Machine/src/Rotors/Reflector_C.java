package Rotors;
public class Reflector_C extends Rotor {
	int[][] wiring;
	public Reflector_C() {
		// Reflector C object
		wiring = new int[][] {
			{0, 17 },     //A->R
			{1, 3 },     //B->D
			{2, 14 },     //C->O
			{3, 1 },     //D->B
			{4, 9 },     //E->J
			{5, 13 },     //F->N
			{6, 19 },     //G->T
			{7, 10 },     //H->K
			{8, 21 },     //I->V
			{9, 4 },     //J->E
			{10, 7 },     //K->H
			{11, 12 },     //L->M
			{12, 11 },     //M->L
			{13, 5 },     //N->F
			{14, 2 },     //O->C
			{15, 22 },     //P->W
			{16, 25 },     //Q->Z
			{17, 0 },     //R->A
			{18, 23 },     //S->X
			{19, 6 },     //T->G
			{20, 24 },     //U->Y
			{21, 8 },     //V->I
			{22, 15 },     //W->P
			{23, 18 },     //X->S
			{24, 20 },     //Y->U
			{25, 16 }};     //Z->Q
	}
	public int[][] getwiring() {
		return wiring;
	}
}
