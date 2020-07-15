/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package todo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class App {
    static void exercicio01() {
	Todo todo = new Todo();
	todo.setUserId(1);
	todo.setId(1);
	
	System.out.println(todo.getId());
    }
    
    static void exercicio02() {
	ArrayList<Todo> todos = new ArrayList();
        
        Todo todo = new Todo();
        todo.setUserId(1);
        todo.setId(10);
        todo.setTitle("Terminar o Bootcamp");
        todo.setCompleted(false);
        
        todos.add(todo);
        
        System.out.println(todos.get(0).getTitle());
    }
    
    static void exercicio03() {
	ArrayList<Todo> todos = new ArrayList();
	
	try {
	    String todosJson = FileUtils.readFileToString(new File("src/main/resources/todos.json"));
	    
	    Type todoListType = new TypeToken<ArrayList<Todo>>() {}.getType();
	    Gson json = new GsonBuilder().create();

	    todos = json.fromJson(todosJson, todoListType);
	    
	    System.out.println(todos.size());
	    
	    for(Todo t: todos) {
		System.out.println(t.getTitle());
	    }
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}
    }
    
    static void exercicio04() {
	ArrayList<Todo> todos = new ArrayList();
	
	try {
	    String todosJson = FileUtils.readFileToString(new File("src/main/resources/todos.json"));
	    
	    Type todoListType = new TypeToken<ArrayList<Todo>>() {}.getType();
	    Gson json = new GsonBuilder().create();

	    todos = json.fromJson(todosJson, todoListType);
	    
	    System.out.println("Filter test...");
	    
	    todos = (ArrayList<Todo>) todos.stream()
		    	.filter(item -> item.getCompleted().equals(true))
		    	.collect(Collectors.toList());
	    
	    for(Todo t: todos) {
		System.out.println(t.getTitle());
	    }
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}
    }
    
    static void exercicio05() {
	ArrayList<Todo> todos = new ArrayList();
	
	try {
	    String todosJson = FileUtils.readFileToString(new File("src/main/resources/todos.json"));
	    
	    Type todoListType = new TypeToken<ArrayList<Todo>>() {}.getType();
	    Gson json = new GsonBuilder().create();

	    todos = json.fromJson(todosJson, todoListType);
	    
	    System.out.println("Map test...");
	    
	    Collections.sort(todos);
	    
	    for(Todo t: todos) {
		System.out.println(t.getTitle());
	    }
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}
    }
    
    static void exercicio06() {
	List<Integer> n = Arrays.asList(10, 4, 10, 1, 3);
	
	int result = n.stream()
		.reduce(0, (subtotal, item) -> subtotal + item);
	
	System.out.println(result);
    }
    
    public static void main(String[] args) {
        exercicio01();
        exercicio02();
        exercicio03();
        exercicio04();
        exercicio05();
        exercicio06();
    }
}
