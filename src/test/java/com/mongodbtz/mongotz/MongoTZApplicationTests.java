package com.mongodbtz.mongotz;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.mongodbtz.mongotz.IMDbMovie;
import com.mongodbtz.mongotz.IMDbMovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@WebMvcTest(IMDbMovieController.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class MongoTZApplicationTests {

	@MockitoBean
	private ImDbMovieService imDbMovieService;

	@Autowired
	private ObjectMapper objectMapper;

	IMDbMovie imDbMovie;

	@BeforeEach
	public void setup(){

	imDbMovie = IMDbMovie.builder()
				.imdbId("tt0938313")
				.name("The Lost World")
				.build();

	}
	//Get Controller
	//@Test
	@Order(1)
	public void getImdBMovieTest() throws Exception{
		// precondition
		List<IMDbMovie> movieList = new ArrayList<>();
		movieList.add(imDbMovie);
		movieList.add(IMDbMovie.builder().imdbId("tt0938313").name("The Lost World").build());
		given(imDbMovieService.findMovieByYearAndGenre("1997","Action").containsAll(movieList));

		// action
		//ResultActions response = mockMvc.perform(get(
				//"http://localhost:8100/api/imdbMovie/getMovieByTitle/" + imDbMovie.getName()));

		// verify the output
//		response.andExpect(status().isOk())
//				.andDo(print())
//				.andExpect(jsonPath("$.size()",
//						is(movieList.size())));

	}

	@Test
	@Order(2)
	void contextLoads() {
	}

}
