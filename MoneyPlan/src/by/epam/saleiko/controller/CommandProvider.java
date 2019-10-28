package by.epam.saleiko.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.saleiko.controller.comands.Command;
import by.epam.saleiko.controller.comands.CommandName;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.SIGN_IN, new SingIn());
		repository.put(CommandName.REGISTER, new Register());
		repository.put(CommandName.DELETE_USER, new DeleteUser());
		repository.put(CommandName.CREATE_LOAN, new CreateLoan());
		repository.put(CommandName.PAY_LOAN, new PayLoan());
		repository.put(CommandName.DELETE_LOAN, new DeleteLoan());
		repository.put(CommandName.GET_LOANS_AFTER, new GetLoansAfter());
		repository.put(CommandName.CREATE_PAYMENT, new CreatePayment());
		repository.put(CommandName.GET_PAYMENTS_AFTER, new GetPaymentsAfter());
		repository.put(CommandName.DELETE_PAYMENT, new DeletePayment());
		repository.put(CommandName.MONTHLY_EXPENSES, new MonthlyExpenses);
		repository.put(CommandName.SAVE, new Save());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest);
	}
	
	Command getCommand(String name){
		CommandName commandName =null;
		Command command = null;
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
			catch(IllegalArgumentException | NullPointerException e){
				command = repository.get(CommandName.WRONG_REQUEST);
				}
		}
		return command;
	}
}
