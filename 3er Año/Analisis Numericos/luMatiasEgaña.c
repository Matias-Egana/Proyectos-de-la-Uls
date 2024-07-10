#include <stdio.h>

int main(){
	int max,i,j,c;
	printf("\n METODO DE FACTORIZACION LU \n");
	printf("ingrese el numero de columnas: ");
	scanf("%i",&max);
	float matriz[max][max],l[max][max],u[max][max],factor;
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
			printf("ingrese un valor para matriz[%i][%i] = ",i+1,j+1);
			scanf("%f",&matriz[i][j]);
			u[i][j]=matriz[i][j];
		}
	}
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
	
	//triangulo Inferior
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
			if(i==j){
				l[i][j] = 1;
			}
			if(i<j){
				factor=matriz[j][i]/matriz[i][i];
				l[j][i] = factor;
				for(c=0;c<max;c++){
					matriz[j][c]=matriz[j][c]-(factor*matriz[i][c]);
					u[j][c] = matriz[j][c];
				}
			}
		}
	}
	printf("\n\n");
	printf("impresion de resultados");
	printf("\nMatriz L :\n");
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
			if(j<max-1){
				printf(" %f ",l[i][j]);	
			}
			else{
				printf(" %f",l[i][j]);
			}
		}
		if(i<max-1){
			printf("\n");
		}
	}
	printf("\n");
	printf("\nMatriz U :\n");
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
			if(j<max-1){
				printf(" %f ",u[i][j]);	
			}
			else{
				printf(" %f",u[i][j]);
			}
		}
		if(i<max-1){
			printf("\n");
		}
	}
}
