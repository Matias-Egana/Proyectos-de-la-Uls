#include<stdio.h>
#include<conio.h>
#include<math.h>
int main(){

	int i,j,k,max,iteracion=0;
	float a[10][10],x[10];
	float sum,temp,error,big,e;
	
	printf("\n METODO GAUSS-SEIDEL \n");
    printf("\nIntroduzca el numero de ecuaciones: \n");

    scanf("%i",&max) ;
    printf("Introduzca los coeficientes de la matriz, junto con sus respectivas soluciones = \n");

	for(i=1;i<=max;i++){
		for(j=1;j<=max+1;j++){
			printf("a[%i][%i]= ",i,j);
			scanf("%f",&a[i][j]);
		}
	}

	for(i=1;i<=max;i++){
		x[i]=0;
	}
		printf("\nIntroduzca el Error = \n");
		scanf("%f",&e);
	
	//gauss-seiden
	
	do{
		big=0;
		for(i=1;i<=max;i++){
			sum=0;
			for(j=1;j<=max;j++){
				if(j!=i){
					sum=sum+a[i][j]*x[j];
				}
			}
			temp=(a[i][max+1]-sum)/a[i][i];
			error=fabs(x[i]-temp);
		
			if(error>big){
				big=error;
			}
			x[i]=temp;
			printf("\nx[%i] =%f",i,x[i]);
		}
		iteracion++;
		printf("\niteracion = %i \n",iteracion);
		printf("\n");	
	}
	while(big>=e);	

	printf("\n\n Converge en la solucion");
	
	for(i=1;i<=max;i++){
		printf("\nx[%i]=%f",i,x[i]);
	}

}
