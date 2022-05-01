package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class TodoItem_Test {

	/**
	 * Teste la fonction isLate, ici, doit retourner faux
	 */
	@Test
	void isLateTimeUnder24Hours() {
		TodoItem item = new TodoItem("0", Instant.now(),"Manger");
		assertFalse(item.isLate());
	}
	
	/**
	 * Teste la fonction isLate, ici, doit retourner vrai
	 */
	@Test
	void isLateTimeUpper24Hours() {
		TodoItem item = new TodoItem("1", Instant.now().minus(1,ChronoUnit.DAYS),"Dormir");
		assertTrue(item.isLate());
	}
	
	/**
	 * Teste la fonction finalContent, ici, doit retourner faux
	 */
	@Test
	void finalContentTimeUnder24Hours() {
		TodoItem item = new TodoItem("2", Instant.now(),"Boire");
		item.finalContent();
		item.toString();
		assertFalse(item.getContent().contains("[LATE!]"));
	}
	
	/**
	 * Teste la function finalContent, ici, doit retourner vrai
	 */
	@Test
	void finalContentTimeUpper24Hours() {
		TodoItem item = new TodoItem("3", Instant.now().minus(1,ChronoUnit.DAYS),"Travailler");
		assertTrue(item.getContent().contains("[LATE!]"));
	}
}
