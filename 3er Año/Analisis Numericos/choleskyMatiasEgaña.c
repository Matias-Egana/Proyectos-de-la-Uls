#include <stdlib.h>
#include <stdio.h>
#include <math.h>
int main(){
	int i,j,max,k;
	printf("\n METODO DE CHOLESKY \n");
	printf("ingrese el numero de columnas: ");
	scanf("%i",&max);
	float matriz[max][max];
	float lower[max][max];
	
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
			printf("ingrese un valor para matriz[%i][%i] = ",i+1,j+1);
			scanf("%f",&matriz[i][j]);
		}
	}
	//imprimir matriz ingresada
	printf("\n\n");
	printf("\nMatriz Ingresada:\n");
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
			if(j<max-1){
				printf(" %f ",matriz[i][j]);	
			}
			else{
				printf(" %f",matriz[i][j]);
			}
		}
		if(i<max-1){
			printf("\n");
		}
	}
	 // Triangular Inferior
        for (i = 0; i < max; i++) {
            for (j = 0; j <= i; j++) {
                int sum = 0;

                if (j == i) {
                    for (k = 0; k < j; k++)
                        sum += pow(lower[j][k],2);
                    	lower[j][j] = sqrt(matriz[j][j] - sum);
                }
 
                else {

                    for (k = 0; k < j; k++)
                        sum += (lower[i][k] * lower[j][k]);
                        lower[i][j] = (matriz[i][j] - sum) / lower[j][j];
                }
            }
        }
 
        // Impresion Traspuesta Triangular
        printf("\nTriangulo inferior\n");
        for(i=0;i<max;i++){
			for(j=0;j<max;j++){
				if(j<max-1){
					printf(" %f ",lower[i][j]);	
				}
				else{
					printf(" %f",lower[i][j]);
				}
			}
		if(i<max-1){
			printf("\n");
		}
	}
	printf("\nTraspuesto\n");
	    for(i=0;i<max;i++){
			for(j=0;j<max;j++){
				if(j<max-1){
					printf(" %f ",lower[j][i]);	
				}
				else{
					printf(" %f",lower[j][i]);
				}
			}
		if(i<max-1){
			printf("\n");
		}
	}	
}
       
