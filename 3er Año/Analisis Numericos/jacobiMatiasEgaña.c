#include <stdio.h>
#include <stdlib.h>

int max;
float norma(float vector1[],float vector2[]);
float suma_jacobi(float Matriz[], float vector[], int componente);

int main(){
    int i,j,iteraciones=0,iter;
    float error,epsilon;
    printf("\n METODO DE JACOBI DE RESOLUCION DE SISTEMAS Ax=b \n");

    printf("Ingrese el numero de columnas = ");
    scanf("%i",&max);
    float A[max][max],b[max],x[max],xo[max],aux[max];

    printf("\n Ingrese los coeficientes de la matriz = \n");
    
	for(i=0;i<max;i++){
		for(j=0;j<max;j++){
        	printf("Ingrese valor para la matriz [%i][%i]=",i+1,j+1); 
			scanf("%f",&A[i][j]);
    	}
	} 

    printf("\n Ingrese las soluciones de la matriz \n");
    for(i=0;i<max;i++){
        printf(" Ingrese el valor [%i]=",i);
		scanf("%f",&b[i]);
    }

    printf("\n Error = \n");
    printf("E=",i);
	scanf("%f",&epsilon);
    error=epsilon+1;

    //Jacobi
    //Error se mide como la norma del vector diferenceia entre la iteracion i e i+1
    printf("\n Ingrese el numero de iteracion , que desea realizar = \n");
    scanf("%i",&iter);
    
	printf("\n Ingrese valor inicial de la iteracion: \n");
    for(i=0;i<max;i++){
        printf("xo[%i]=",i); 
		scanf("%f",&xo[i]);
    }
    while (error>epsilon){
        for(i=0;i<max;i++){
            for(j=0;j<max;j++){
            	aux[j]=A[i][j];
			} 
            x[i]=(1/A[i][i])*(b[i]-suma_jacobi(aux,xo,i));
        }
        error=norma(x,xo);
		
        printf("\n\n Iteracion %i = \n",iteraciones);
        for(i=0;i<max;i++){
            xo[i]=x[i];
            printf("X[%i]= %f \n",i,x[i]);
        }
        iteraciones++;
        if (iteraciones==iter){
        	error=epsilon-1;
		} 
    }

    printf("Solucion del sistema\n");
    printf("Numero de iteraciones: %i \n", iteraciones);
    for(i=0;i<max;i++){
        printf("x[%i] = %f\n",i,x[i]);
    }
    return 1;
}

float norma(float vector1[],float vector2[]){
    float aux=0;
    int i;
    for(i=0;i<max;i++){
        aux=aux+(vector1[i]-vector2[i])*(vector1[i]-vector2[i]);
    }
    return aux;
}

float suma_jacobi(float Matriz[], float vector[], int componente)
{
    float aux=0;
    int i;
    for(i=0;i<max;i++){
        if (componente!=i){
            aux=aux+Matriz[i]*vector[i];
        }
    }
    return aux;
}
