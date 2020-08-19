package com.cg.customerinfo.JUnit4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.customerinfo.controllers.CustomerController;
import com.cg.customerinfo.models.Customer;
import com.cg.customerinfo.services.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class TestCustomerController {

	@Autowired
	public MockMvc mockMvc;

	@MockBean
	public CustomerService custService;

	String mockJson = "{\"custName\": \"ABCD\",\"city\": \"KOLKATA\",\"age\": 55,\"phone\": \"1234567890\"}";

	@Test
	public void testAddCustomer() throws Exception {
		// Customer mockCustomer= new Customer(null, "TestCustomer",
		// "Honolulu",55,"1234567890");

		Mockito.when(custService.addCustomer(Mockito.any(Customer.class))).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/customer/add")
				.accept(MediaType.APPLICATION_JSON).content(mockJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		// assertEquals("http://localhost:8081/api/customer/1",
		// response.getHeader(HttpHeaders.LOCATION));
	}

}
