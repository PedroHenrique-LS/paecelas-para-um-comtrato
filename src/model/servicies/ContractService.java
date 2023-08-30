package model.servicies;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}



	public void processContract(Contract contract, int months) {
		
		LocalDate referencMonth = contract.getDate(); //LocalDate.now();
		double basicValue = contract.getTotalValue() / months;
		
		for(int i=0; i < months; i++) {
			
			referencMonth = referencMonth.plusMonths(1);
			
			double interest = onlinePaymentService.interest(basicValue, i+1);
			double fee = onlinePaymentService.paymentFee(basicValue + interest);
			double installmentValue = basicValue + interest + fee;
			
			
			contract.addInstallment(new Installment(referencMonth, installmentValue));
			
		}
		
	}
	
}
