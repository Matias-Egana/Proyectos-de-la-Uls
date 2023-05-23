#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
int main(){

	int continuar=0;
	int numero;

	while(continuar < 1){
		srand(time(NULL)); //Semilla
		int a = rand() % 10;
		int b = rand() % 10;
		int c = rand() % 10;
		int d = rand() % 10;
		int millar= 0;
		int centena = 0;
		int decena = 0;
		int unidad = 0;
		int toque = 0;
		int fama = 0;
		int intento = 0;
		int intentosres = 10;
		int valido=0;
		system("cls");
		printf("\nBIENVENIDO AL JUEGO DEL TOQUE Y FAMA.\n");
		sleep(1);


		while(a==b || a==c || a==d || b==c || b==d || c==d){
			a=rand() % 10;
			b=rand() % 10;
			c=rand() % 10;
			d=rand() % 10;
		}
		
		while(intento<10){
			valido = 1;
			while(valido == 1){
				printf("\nPORFAVOR INGRESE UN NUMERO DE CUATRO DIGITOS DIFERENTES ENTRE SI. ESTE DEBE SER <9999 Y >100.\n");
				scanf("%i",&numero);
				sleep(1);
			if(numero<=9999 && numero>=100){
				while(numero>=1000){
					numero=numero-1000;
					millar=millar+1;
				}
				while(numero>=100){
					numero=numero-100;
					centena=centena+1;
				}
				while(numero>=10){
					numero=numero-10;
					decena=decena+1;
				}
				unidad = numero;
				if(millar==centena || millar==decena || millar==unidad || centena==decena || centena==unidad || decena==unidad){
					printf("\n\nERROR. LOS DIGITOS DEL NUMERO INGRESADO DEBEN SER DISTINTOS ENTRE SI.\n\n");
					millar = 0;
					centena = 0;
					decena = 0;
					unidad = 0;
					sleep(1);
				}
				else{
					valido=0;
					intento=intento+1;
				}
			}
			else{
				printf("\n\nERROR. EL NUMERO INGRESADO SUPERA O ES INFERIOR A LA CANTIDAD DE DIGITOS ADMITIDO.\n\n");
				millar = 0;
				centena = 0;
				decena = 0;
				unidad = 0;
				sleep(1);
			}//if(n9999 && n100) for while(v=1)


			}//while(valido = 1)
		if(millar==a && centena==b && decena==c && unidad==d){
			printf("\n\nFAMA = 4. FELICIDADES, HAZ GANADO EL JUEGO DEL TOQUE Y FAMA!\n\n");
			sleep(1);
			fama = 4;
			intento = 10;
		}
		else{
			if(millar==a){
				fama= fama+1;}
			else{
				if(millar==b || millar==c || millar==d){
					toque=toque+1;
				} 
			}
			if(centena==b){
				fama= fama+1;}
			else{
				if(centena==a || centena==c || centena==d){
					toque=toque+1;
				} 
			}
			if(decena==c){
				fama= fama+1;}
			else{
				if(decena==a || decena==b || decena==d){
					toque=toque+1;
				} 
			}
			if(unidad==d){
				fama= fama+1;}
			else{
				if(unidad==a || unidad==b || unidad==c){
					toque=toque+1;
				} 
			}
		
		}//if(millar=a && centena=b && decena=c && unidad=d)
		intentosres=intentosres-1;
		printf("\n\nTOQUES = %i.\n",toque);
		sleep(1);
		printf("\nFAMAS = %i.\n\n",fama);
		sleep(1);
	//	printf("\nmillar %i",millar);
	//	printf("\ncentena %i",centena);
	//	printf("\ndecena %i",decena);
	//	printf("\nunidad %i\n",unidad);
		printf("\nRANDOM = %i %i %i %i.\n",a,b,c,d);
		sleep(1);
		toque = 0;
		fama = 0;
		millar = 0;
		centena = 0;
		decena = 0;
		unidad = 0;
		if(intentosres<1){
			intento=10;		
		}
		if(intento != 10){
			printf("\nINTENTOS RESTANTES = %i.\n",intentosres);
			sleep(1);
		}
		
		
		
		}//while(intento<10)

		continuar=continuar+1;
		printf("\nFIN DEL JUEGO.\n");
		sleep(2);
		printf("\nPRESIONE 1 PARA VOLVER A EMPEZAR, DE LO CONTRARIO PULSE CUALQUIER OTRO NUMERO PARA SALIR.\n");
		scanf("%i",&continuar);
		sleep(1);
		if(continuar==1){
			continuar=continuar-1;
		}

	}//while(continuar < 1)



}//main
