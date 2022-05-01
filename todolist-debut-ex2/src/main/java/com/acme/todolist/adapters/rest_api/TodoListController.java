package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.service.AddTodoItemService;
import org.springframework.http.HttpStatus;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItem addTodoItem;
	
	
	@Inject
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem item ) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.addTodoItem= item;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	@PostMapping("/todos")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void ajouterItem(@RequestBody TodoItem item) {
		this.addTodoItem.addTodoItem(item);
	}
	
	
}
