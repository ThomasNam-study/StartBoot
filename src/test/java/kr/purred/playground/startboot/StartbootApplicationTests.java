package kr.purred.playground.startboot;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import kr.purred.playground.startboot.model.domain.JournalEntry;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith (SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StartbootApplicationTests
{
	private final String SPRING_BOOT_MATCH = "스프링 부트";

	private HttpMessageConverter mappging;

	private MediaType contentType = new MediaType (MediaType.APPLICATION_JSON.getType (), MediaType.APPLICATION_JSON.getSubtype (), Charset.forName ("utf8"));

	private MockMvc mockMvc;

	@Autowired private WebApplicationContext webApplicationContext;

	@Test
	public void contextLoads()
	{
	}

	@Autowired
	void setConverters (HttpMessageConverter<?>[] converters)
	{
		this.mappging = Arrays.asList (converters).stream ().filter ((c) -> c instanceof MappingJackson2HttpMessageConverter)
			.findAny ().get ();
	}

	@Before
	public void setup()
	{
		this.mockMvc = webAppContextSetup(webApplicationContext).build ();
	}

	@Test
	public void getAll() throws Exception
	{
		mockMvc.perform (get("/journal/all"))
			.andExpect (status().isOk ())
			.andExpect (content().contentType (contentType))
			.andExpect (jsonPath("$", iterableWithSize(7)))
			.andExpect (jsonPath ("$[0]['title']", containsString (SPRING_BOOT_MATCH)));
	}

	@Test
	public void add() throws Exception
	{
		mockMvc.perform (post("/journal")
			.content (this.toJsonString (new JournalEntry("마이 테스트", "스프링 부트 단위 테스트", "05/09/2016")))
			.contentType (contentType)).andExpect (status ().isOk ());

	}

	protected String toJsonString (Object obj) throws IOException
	{
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage ();

		this.mappging.write (obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);

		return mockHttpOutputMessage.getBodyAsString ();
	}
}
