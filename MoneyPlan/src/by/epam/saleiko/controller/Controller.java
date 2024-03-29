package by.epam.saleiko.controller;

import by.epam.saleiko.controller.comands.Command;

public final class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';
	
	public String executeTask(String request){
		String commandName;
		Command executionCommand;
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName);
		String response;
		response = executionCommand.execute(request);
		return response;
	}
}
