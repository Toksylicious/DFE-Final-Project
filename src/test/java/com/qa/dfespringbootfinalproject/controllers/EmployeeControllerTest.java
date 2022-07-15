package com.qa.dfespringbootfinalproject.controllers;


//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfespringbootfinalproject.entities.Employee;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void getAllTest() throws Exception {
		List<Employee> output = new ArrayList<>();
		Employee entry = new Employee(1L, "Boris", "Johnson", "bjohnson@uk.com","Administration", "10 Downing Street");
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/employee/getAll")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(content().json(outputAsJSON));
			
	}

	@Test
	public void getByIdTest() throws Exception {
		Employee entry = new Employee(1L, "Boris", "Johnson", "bjohnson@uk.com","Administration", "10 Downing Street");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/employee/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(content().json(entryAsJSON));	
		
	}
	
	@Test
	public void createTest() throws Exception {
		Employee entry = new Employee("Rishi", "Sunak", "Rsnaky@uk.com","Finance", "11 Downing Street");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Employee result = new Employee(2L, "Rishi", "Sunak", "Rsnaky@uk.com","Finance", "11 Downing Street");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/employee/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
		        .andExpect(content().json(resultAsJSON));
			
	}
	
	@Test
	public void updateTest() throws Exception {
		Employee entry = new Employee ("Bright", "James", "bijj@uk.com","Admin", "16 Browning Street" );
		Employee result = new Employee(1L, "Bright", "James", "bijj@uk.com","Admin", "16 Browning Street" );
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/employee/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
		        .andExpect(content().json(resultAsJSON));
	
	}	

	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/employee/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(content().string("true"));
		        		
	}
	
}
