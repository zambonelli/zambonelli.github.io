#include <stdio.h>
#include <conio.h>

int leggi(int mat[3][3]);
int stampa(int mat[3][3]);
int add(int ris[3][3], int x1[3][3], int x2[3][3]);
int mol(int ris[3][3], int x1[3][3], int x2[3][3]);
int trans(int ris[3][3], int x1[3][3]);

main() {
 int a[3][3];
 int b[3][3];
 int x[3][3];
 int y[3][3];
 int z[3][3];
 
 leggi(a);
 leggi(b);
 //stampa(a);
 //stampa(b);
 add(x,a,b);
 //stampa(x);
 mol(y,x,a);
 //stampa(y);
 trans(z,b);
 add(x,y,z);
 stampa(x);
 
 getch();
}




int leggi(int mat[3][3]) {
    int i,j;
    printf("Iserisci i valori della matrice\n");
    for(i=0; i<3; i++) {
             for(j=0; j<3; j++) {
                      scanf("%d",&mat[i][j]);
             }
    }
}





int stampa(int mat[3][3]) {
    int i,j;
    printf("I valori della matrice sono\n");
    for(i=0; i<3; i++) {
             for(j=0; j<3; j++) {
                      printf("%d ",mat[i][j]);
             }
             printf("\n");
    }
    printf("\n");
}

int add(int ris[3][3], int x1[3][3], int x2[3][3]) {
    int i,j;
    for(i=0; i<3; i++)
    for(j=0; j<3; j++)
             ris[i][j] = x1[i][j] + x2[i][j]; 
}




int mol(int ris[3][3], int x1[3][3], int x2[3][3]) {
    int i,j,k;
    for(i=0; i<3; i++)
    for(j=0; j<3; j++) {
             // ris[i][j] = ?
             ris[i][j] = 0;
             for(k=0; k<3;k++)
             ris[i][j] = ris[i][j] + x1[i][k] * 
                                     x2[k][j];
    }
}


int trans(int ris[3][3], int x1[3][3]) {
    int i,j;
    for(i=0; i<3; i++)
    for(j=0; j<3; j++) 
             ris[i][j] = x1[j][i];
}
