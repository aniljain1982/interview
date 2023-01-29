package com.automation.restassured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic {
	public void allBooks_1() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://demoqa.com/BookStore/v1");
		requestSpecBuilder.setBasePath("Books");

		RequestSpecification requestSpecification = requestSpecBuilder.build();

		Response response = RestAssured.expect().given().spec(requestSpecification).get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("************************");
		Headers headers = response.getHeaders();
		for (Header header : headers) {
			System.out.println("Header name: " + header.getName() + " Value: " + header.getValue());
		}
		System.out.println("************************");
		System.out.println(response.header("Content-Type"));
		System.out.println(response.header("Server"));
		System.out.println("************************");
		// System.out.println(response.getBody().asPrettyString());
		System.out.println("************************");
		JsonPath jsonPath = response.jsonPath();
		List<String> listBooks = jsonPath.getList("books");
		System.out.println(listBooks);
		System.out.println("************************");
		System.out.println("Size of path: " + jsonPath.getList("books").size());
		for (int i = 0; i < jsonPath.getList("books").size(); i++) {
			String data = jsonPath.get("books[" + i + "].isbn");
			System.out.println(data);
			data = jsonPath.get("books[" + i + "].title");
			System.out.println(data);
			data = jsonPath.get("books[" + i + "].subTitle");
			System.out.println(data);
			data = jsonPath.get("books[" + i + "].author");
			System.out.println(data);
			data = jsonPath.get("books[" + i + "].publish_date");
			System.out.println(data);
			data = jsonPath.get("books[" + i + "].publisher");
			System.out.println(data);
			int pages = jsonPath.get("books[" + i + "].pages");
			System.out.println(pages);
			data = jsonPath.get("books[" + i + "].description");
			System.out.println(data);
			data = jsonPath.get("books[" + i + "].website");
			System.out.println(data);
		}

		System.out.println("************************");
		List<Map<String, String>> books = jsonPath.getList("books");
		for (Map<String, String> map : books) {
			System.out.println(map.get("isbn"));
			System.out.println(map.get("title"));
			System.out.println(map.get("subTitle"));
			System.out.println(map.get("author"));
			System.out.println(map.get("publish_date"));
			System.out.println(map.get("publisher"));
			// System.out.println(Integer.parseInt(map.get("pages")));
			System.out.println(map.get("description"));
			System.out.println(map.get("website"));
		}

		System.out.println("************************");
		List<BookResponsePojo> listBookResponsePojo = jsonPath.getList("books", BookResponsePojo.class);
		for (BookResponsePojo bookResponsePojo : listBookResponsePojo) {
			System.out.println("Isbn: " + bookResponsePojo.getIsbn());
			System.out.println("Title: " + bookResponsePojo.getTitle());
			System.out.println("Subtitle: " + bookResponsePojo.getSubTitle());
			System.out.println("Author: " + bookResponsePojo.getAuthor());
			System.out.println("Publish Date: " + bookResponsePojo.getPublish_date());
			System.out.println("Publisher: " + bookResponsePojo.getPublisher());
			System.out.println("Pages: " + bookResponsePojo.getPages());
			System.out.println("Description: " + bookResponsePojo.getDescription());
			System.out.println("Website: " + bookResponsePojo.getWebsite());
		}

		System.out.println("************************");
		BookResponsePojo[] arrayBookingResponsePojo = jsonPath.getObject("books", BookResponsePojo[].class);
		for (BookResponsePojo bookResponsePojo : arrayBookingResponsePojo) {
			System.out.println("Isbn: " + bookResponsePojo.getIsbn());
			System.out.println("Title: " + bookResponsePojo.getTitle());
			System.out.println("Subtitle: " + bookResponsePojo.getSubTitle());
			System.out.println("Author: " + bookResponsePojo.getAuthor());
			System.out.println("Publish Date: " + bookResponsePojo.getPublish_date());
			System.out.println("Publisher: " + bookResponsePojo.getPublisher());
			System.out.println("Pages: " + bookResponsePojo.getPages());
			System.out.println("Description: " + bookResponsePojo.getDescription());
			System.out.println("Website: " + bookResponsePojo.getWebsite());
		}
	}

	public void queryParameter() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://demoqa.com/BookStore/v1");
		requestSpecBuilder.setBasePath("Book");
		requestSpecBuilder.addQueryParam("ISBN", "9781449325862");

		RequestSpecification requestSpecification = requestSpecBuilder.build();
		Response response = RestAssured.expect().given().spec(requestSpecification).get();
		System.out.println("Status code: " + response.getStatusCode());
		BookResponsePojo bookResponsePojo = response.as(BookResponsePojo.class);
		System.out.println("Isbn: " + bookResponsePojo.getIsbn());
		System.out.println("Title: " + bookResponsePojo.getTitle());
		System.out.println("Subtitle: " + bookResponsePojo.getSubTitle());
		System.out.println("Author: " + bookResponsePojo.getAuthor());
		System.out.println("Publish Date: " + bookResponsePojo.getPublish_date());
		System.out.println("Publisher: " + bookResponsePojo.getPublisher());
		System.out.println("Pages: " + bookResponsePojo.getPages());
		System.out.println("Description: " + bookResponsePojo.getDescription());
		System.out.println("Website: " + bookResponsePojo.getWebsite());

	}

	public static void main(String[] args) {
		new Basic().allBooks_1();
		// new Basic().queryParameter();
	}

}
