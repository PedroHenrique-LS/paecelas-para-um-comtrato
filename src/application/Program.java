package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.servicies.ContractService;
import model.servicies.PaypalService;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		
		Contract contract = new Contract(number, contractDate, totalValue);
		
		
		System.out.print("Entre com o numero de parcelas: ");
		int numberOfInstallments = sc.nextInt();
		
		ContractService contractServicie = new ContractService(new PaypalService());
		
		contractServicie.processContract(contract, numberOfInstallments);
		
		System.out.println("Parcelas: ");
		
		//System.out.println(contract.getInstallments().size());
		
		for (Installment installment: contract.getInstallments()) {
			
			System.out.println(installment);
			
		}
		
		
		
		
		
		
		
		
		sc.close();
		
	}
	
	
}

