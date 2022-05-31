package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;

import io.restassured.http.Headers;
import io.restassured.response.Response;



public class TestOne {
	
	/*
	@Test
	public void test_1() {
		
		Response response = get("https://jsonplaceholder.typicode.com/users/10");
		
		System.out.println("Status Code:"+response.getStatusCode());
		System.out.println("Time Operation: "+response.getTime());
		System.out.println("Body: "+response.getBody());
		System.out.println("StatusLine: "+response.getStatusLine());
		System.out.println("Header: "+response.getHeader("content-type"));
		
		
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}*/
	
	
	@Test
	public void Feature_A() {
		//Llamar al servicio de users
		System.out.println("Llamar al servicio de users");
		System.out.println("Obtener el userId numero 10 desde la respuesta");
		baseURI = "https://jsonplaceholder.typicode.com";
		given().get("/users/10").then().statusCode(200).body("id", equalTo(10));
	
	}
	
	
	@Test
	public void Feature_B() {
		//Llamar al servicio de users
		System.out.println("Llamar al servicio de users");
		System.out.println("Obtener el userId numero 10 desde la respuesta");
		baseURI = "https://jsonplaceholder.typicode.com";
		given().get("/users/1").then().statusCode(200).body("id", equalTo(1));
		
		
		String response = given()
				.when()
				.get("/users/1").then().extract().body().asString();
		
	}
	
	@Test
	public void Feature_C() {
		//Llamada usersId 5
		System.out.println("Llamar al servicio de users");
		System.out.println("Obtener el userId numero 5 desde la respuesta");
		baseURI = "https://jsonplaceholder.typicode.com";
		given().get("/users/5").then().statusCode(200).body("id", equalTo(5));
		
		
		//Imprimir los datos de la respuesta
		Response response = given()
				.get("/users/5");
		
		Headers headers = response.getHeaders();
		int statusCode = response.getStatusCode();
		String body = response.getBody().asString();
		String contentType = response.getContentType();
		
		System.out.println("Status Code: "+statusCode);
		System.out.println("body: "+body);
		System.out.println("contentType: "+contentType);
	}

}
