package com.telecom.user.test;





import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.telecom.user.UserOrderApplication;
import com.telecom.user.dto.CreatePurchaseOrderByPhoneNumberInvoice;
import com.telecom.user.model.Order;
import com.telecom.user.repository.OrderRepository;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserOrderApplication.class,webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc 
public class OrderTest {


	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired  
   private Environment env;
	
	 @Mock
	 private RestTemplate restTemplate;

		private ObjectMapper mapper;
     	private CreatePurchaseOrderByPhoneNumberInvoice orderRequestObj;

  

        @Before
         public void setup() throws Exception {
           mapper = new ObjectMapper();
        
           orderRequestObj = mapper.readValue(new File("src/test/resources/orderRequest.json"),CreatePurchaseOrderByPhoneNumberInvoice.class);
          
        }
   
		@MockBean
		OrderRepository orderRepository;
	
//		@MockBean
//		RestTemplate restTemplate;
		
		@Test
		public void successTestCreateOrder() throws Exception {
        
			Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(new Order());
			
		MockHttpServletRequestBuilder  requestBuilder = MockMvcRequestBuilders.post("/users/f5675176-ce52-11ea-87d0-0242ac13002/phone-numbers/493283893499/orders/purchase/invoice").
		contentType("application/json").accept(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(orderRequestObj));
			
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	
	
		//assertEquals(orderResponseObj,mapper.readValue(result.getResponse().getContentAsString(),OrderUIResponse.class));
	//	assertNotNull(result.getResponse());
		assertEquals(400,result.getResponse().getStatus());
		}
	

}
