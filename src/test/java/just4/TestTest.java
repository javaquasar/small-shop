package just4;

import just4.fun.smallshop.controllers.admin.ProductController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Vitaliy_Zinchenko on 30.01.2015.
 */
public class TestTest {

    private ProductController indexController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        indexController = new ProductController();

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    }

    @Test
    public void testCreateSignupFormInvalidUser() throws Exception {

//        when(sampleService.saveFrom(any(SignupForm.class)))
//                .thenThrow(new InvalidUserException("For Testing"));

        this.mockMvc.perform(post("/product/list")
                .param("email", "mvcemail@test.com")
                .param("firstName", "mvcfirst")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk());

    }

}
