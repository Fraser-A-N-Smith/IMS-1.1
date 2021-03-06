package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum Action {
	CREATE("To save a new entity into the database"), READ("To read an entity from the database"),
	UPDATE("To change an entity already in the database"), DELETE("To remove an entity from the database"),
	RETURN("To return to domain selection"), ADDITEM("To add an item to an order"),
	DELETEITEM("To delete an item from an order"), CALCULATECOST("Calculates the cost of your order");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	Action(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	public static void printActions() {
		for (int i = 0; i < 6; i++) {
			Action actions = Action.values()[i];
			LOGGER.info(actions.getDescription());
		}
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printActions2() {

		for (Action action : Action.values()) {
			LOGGER.info(action.getDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static Action getAction(Utils utils) {
		Action action = null;
		do {
			try {
				action = Action.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (action == null);
		return action;
	}

}
