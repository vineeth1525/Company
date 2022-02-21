	package com.cgg.data2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.client.EmployeeClient;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@MockBean
	RestTemplate restTemplate;

	@MockBean
	EmployeeClient employeeClient;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllEmployeesTest() throws Exception {
		EmployeeDto[] emp = new EmployeeDto[2];
		emp[0] = new EmployeeDto("ram", "eee", 1200l, 5);
		emp[1] = new EmployeeDto("ram", "eee", 1200l, 5);
//		emp.add(employee1);
//		emp.add(employee2);

		Mockito.when(restTemplate.getForObject("http://localhost:8080/employee/getAllEmployee", EmployeeDto[].class))
				.thenReturn(emp);
		mockMvc.perform(get("/company/get")).andExpect(status().isOk());
//		Mockito.when(restTemplate.getForObject(any(String.class), null)
		Assert.assertEquals(emp.length, 2);
	}

	@Test
	public void getAllEmployeesUsingFeignTest() throws Exception {
		List<EmployeeDto> employee = new ArrayList<>();
		EmployeeDto emp1 = new EmployeeDto("ram", "eee", 1200l, 5);
		EmployeeDto emp2 = new EmployeeDto("ram", "eee", 1200l, 6);
		employee.add(emp1);
		employee.add(emp2);
		 Mockito.when(employeeClient.getEmployeeList()).thenReturn(employee);
		mockMvc.perform(get("/company/getAllEmployees-feign")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Assert.assertEquals(employee.size(), 2);
//	assertThat(employeeClient.getEmployeeList())
	}
}