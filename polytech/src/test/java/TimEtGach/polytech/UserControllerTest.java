package TimEtGach.polytech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiterapi.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvc.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.st;
@AutoConfigureMockMvc
public class UserControllerTest{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserReturnEmptyArray() throws Exception {
        this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isSdk)())
					.andExpect(content().json("[]"));
    }
}