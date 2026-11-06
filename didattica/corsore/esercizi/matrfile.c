#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

main() {
       int i,j,ok,n_letti;
       float x[3][3];
       float y[3][3];
       float el;
       FILE *file;
       
       // init matr
       for(i=0;i<3;i++)
       for(j=0;j<3;j++)
       x[i][j] = i*j;
       
       //print
       for(i=0;i<3;i++) {
                        for(j=0;j<3;j++) 
                                         printf("%f ",x[i][j]);
                        printf("\n");
       }
       
       
       // save to file
       file = fopen("x.dat","w");
       for(i=0;i<3;i++)
       for(j=0;j<3;j++)
       fprintf(file,"%f\n",x[i][j]);
       fclose(file);
       
       printf("\n\n");
       
       
       // read file
       n_letti = 0;
       file=fopen("x.dat", "r");
       while (!feof(file)) {
             ok = fscanf(file,"%f", &el);
             if(ok < 0) break;
             i = n_letti / 3;
             j = n_letti % 3;
             n_letti ++;
             y[i][j] = el;
             
       }
       fclose(file);
       
       //print
       for(i=0;i<3;i++) {
                        for(j=0;j<3;j++) 
                                         printf("%f ",y[i][j]);
                        printf("\n");
       }
       
       
       
       getch();
}
