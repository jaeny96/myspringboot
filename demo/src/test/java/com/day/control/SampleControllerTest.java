package com.day.control;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SampleController.class)
class SampleControllerTest {
	@Autowired
	//mocker : 가짜객체 - 컨트롤러를 제어해줄 수 있는 dispatcher servlet용 가짜객체 
	// ~ 가짜 객체에 해당 dispatcher servlet이 주입된것
	private MockMvc mockMvc;
	@Test
	void test() throws Exception{
		MockHttpServletRequestBuilder requestBuilder;
		requestBuilder = MockMvcRequestBuilders.get("/hello");
		requestBuilder.accept(MediaType.APPLICATION_JSON); //요청 형식 지정
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		
		ResultMatcher matcher = MockMvcResultMatchers.status().isOk(); //예상되는 응답상태 코드값 : OK(200)
		resultActions.andExpect(matcher); //테스트 코드
		ContentResultMatchers contentMathers = MockMvcResultMatchers.content();
		String expectedContent="hi";
		ResultMatcher matcher1 = contentMathers.string(expectedContent);
		resultActions.andExpect(matcher1);
//		fail("Not yet implemented");
	}

	@Test
	void testAdd() throws Exception{
		MockHttpServletRequestBuilder requestBuilder;
		requestBuilder = MockMvcRequestBuilders.post("/add");
		requestBuilder.accept(MediaType.APPLICATION_JSON); //요청 형식 지정
		requestBuilder.contentType(MediaType.APPLICATION_JSON);
		requestBuilder.content("{\"id\":\"id1\"}");
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		
		ResultMatcher matcher = MockMvcResultMatchers.status().isOk(); //예상되는 응답상태 코드값 : OK(200)
		resultActions.andExpect(matcher); //테스트 코드
		ContentResultMatchers contentMathers = MockMvcResultMatchers.content();
		String expectedContent="id1";
		ResultMatcher matcher1 = contentMathers.string(expectedContent);
		resultActions.andExpect(matcher1);
	}
}
