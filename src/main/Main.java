package main;

import java.util.Scanner;

import threads.Alarme;
import threads.Cronometro;
import threads.Data;
import threads.Relogio;

public class Main {

	public static void main(String args[]) {
		
		Scanner entradaInt = new Scanner(System.in);
		Data data = new Data();
		
		//Thread relógio que iniciara automaticamente sem nenhum comeando do usuário
		Thread relogio = new Thread(new Relogio(data));
		relogio.start();
				
		boolean opcao = true;
		//Menu ficará executando enquanto for verdade
		while(opcao == true) {
			
			System.out.println("\nEscolha uma das alternativas:");
			System.out.println("1 - Ajustar horário");
			System.out.println("2 - Visualizar horário");
			System.out.println("3 - Iniciar cronômetro");
			System.out.println("4 - Visualizar cronômetro");
			System.out.println("5 - Parar cronômetro");
			System.out.println("6 - Zerar cronômetro");
			System.out.println("7 - Definir alarme");
			System.out.println("8 - Sair do sistema");
			int alternativa = entradaInt.nextInt();
			
			switch(alternativa) {
				case 1:
					System.out.println("\nDigite as horas:");
					data.hora = entradaInt.nextInt();
					System.out.println("Digite os minutos:");
					data.minuto = entradaInt.nextInt();
					System.out.println("Digite os segundos:");
					data.segundo = entradaInt.nextInt();
					break;
					
				case 2:
					System.out.println("\n"+ data.getHora() +":"+ data.getMinuto() +":"+ data.getSegundo());
					break;
					
				case 3:
					//Criação da thread cronometro, e se ela for pausada e iniciada novamente
					//será criada outra thread mas com o mesmo valor
					Thread cronometro = new Thread(new Cronometro(data));
					data.opcaoCronometro = true;
					cronometro.start();
					break;
					
				case 4:
					System.out.println("\n"+ data.cronometroH +":"+ data.cronometroM +":"+ data.cronometroS);
					break;
					
				case 5:
					//Com o comando a seguir o while da thread cronometro vai parar, parando a thread
					data.opcaoCronometro = false;
					System.out.println("\n"+ data.cronometroH +":"+ data.cronometroM +":"+ data.cronometroS);
					break;
				
				case 6:
					data.zerarCronometro();
					break;
					
				case 7:
					System.out.println("\nDigite as horas:");
					data.alarmeH = entradaInt.nextInt();
					System.out.println("Digite os minutos:");
					data.alarmeM = entradaInt.nextInt();
					
					Thread alarme = new Thread(new Alarme(data));
					alarme.start();
					break;
				
				case 8:
					System.out.println("\nThau, obrigado por acessar :)");
					//Matar as threads e encerrar o sistema
					data.opcaoRelogio = false;
					data.opcaoAlarme = false;
					data.opcaoCronometro = false;
					opcao = false;
					break;
			}
		
		}
		
	}
	
}
