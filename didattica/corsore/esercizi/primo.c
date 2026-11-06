#include<stdio.h>
#include<conio.h>

int isprimo(int x);

main() {
       
 int trovati = 0;
 int x = 1;
 
 while(trovati < 100) {
         int primo = isprimo(x);
         if(primo == 1) {
                  printf("%d\n",x);
                  trovati++;
         }      
         x++;
 } 
 getch();
}



 int isprimo(int x) {
 // riceve x
 int primo = 1;
 int cont = 2;
 while(cont < x) {
            if(x%cont==0)
                         primo = 0;
            cont ++;
 }
 // risponde primo
  return primo;
  }
 
