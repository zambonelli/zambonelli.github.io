

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

main() {
       
       
       typedef struct {
                   char nome[20];
                   char cognome[20];
                   int matr;
                   float media;
               } tstudente;
       
       tstudente stud[100];
       
       int index = 0;
       
       int op = 0;
       
       while(op!=6) {
       
        printf("\n\n\nSeleziona un' operazione\n");
        printf("1. Inserisci Studente\n");
        printf("2. Stampa Lista Studenti\n");
        printf("3. Stampa per cognome\n");
        printf("4. Calcola media totale\n");
        printf("5. Ordina\n");
        printf("6. Exit\n");
        scanf("%d",&op);
       
        if(op==1) {
                  printf("Inserisci nome\n");
                  scanf("%s",&stud[index].nome);
                  printf("Inserisci cognome\n");
                  scanf("%s",&stud[index].cognome);
                  printf("Inserisci matricola\n");
                  scanf("%d",&stud[index].matr);
                  printf("Inserisci media\n");
                  scanf("%f",&stud[index].media);
                  index++;
        }
        if(op==2) {
                  int i;
                  printf("\nLista Studenti:\n");
                  for(i=0; i<index;i++) {
                   printf("%s ",stud[i].nome);
                   printf("%s ",stud[i].cognome);
                   printf("(%d), ",stud[i].matr);
                   printf("%f\n",stud[i].media);
                  }
        }         
        if(op==3) {
                  int i;
                  char cognome[20];
                  printf("Inserisci il cognome\n");
                  scanf("%s",&cognome);
                  for(i=0; i<index;i++) {
                   int r = strcmp(stud[i].cognome,cognome);
                   if(r==0) {
                    printf("%s ",stud[i].nome);
                    printf("%s ",stud[i].cognome);
                    printf("(%d), ",stud[i].matr);
                    printf("%f\n",stud[i].media);
                   }
                  }
        }
        if(op==4) {
                  int i;
                  float media = 0;
                  for(i=0; i<index;i++) 
                   media = media + stud[i].media;
                  media = media / index;
                  printf("Calcolo la media delle medie\n");
                  printf("%f\n",media);
        }
        if(op==5) {
                  tstudente temp;
                  int start = 0;
                  int i=0;
                  // cerco il piu' piccolo da dopo start
                  int min = start;
                  
                  
                  // inizio
                  for(i=start;i<index;i++) {
                   int r = strcmp(stud[i].cognome,stud[min].cognome); 
                   if(r<0)
                    min = i;                       
                  }   
                  
                  // scambio stud[min] con stud[start]
                  temp = stud[start];
                  stud[start] = stud[min];
                  stud[min] = temp;
                  // fine
                  
        }
        if(op==6)
                printf("Fine del programma\n");
                
       }         
                
}
