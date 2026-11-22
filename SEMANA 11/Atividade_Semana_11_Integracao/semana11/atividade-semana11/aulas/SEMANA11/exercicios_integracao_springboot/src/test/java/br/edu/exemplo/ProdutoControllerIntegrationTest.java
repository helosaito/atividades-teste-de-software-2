package br.edu.exemplo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest @AutoConfigureMockMvc @Transactional
class ProdutoControllerIntegrationTest {
    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @Test void deveCadastrarProdutoPelaApi() throws Exception {
        mockMvc.perform(post("/produtos").contentType(MediaType.APPLICATION_JSON).content("{\"nome\":\"Mouse\",\"preco\":80.0}"))
            .andExpect(status().isOk()).andExpect(jsonPath("$.id").isNumber()).andExpect(jsonPath("$.nome").value("Mouse")).andExpect(jsonPath("$.preco").value(80.0));
    }
    @Test void deveBuscarProdutoPelaApi() throws Exception {
        MvcResult post=mockMvc.perform(post("/produtos").contentType(MediaType.APPLICATION_JSON).content("{\"nome\":\"Mouse\",\"preco\":80.0}"))
            .andExpect(status().isOk()).andReturn();
        JsonNode json=objectMapper.readTree(post.getResponse().getContentAsString()); long id=json.get("id").asLong();
        mockMvc.perform(get("/produtos/{id}",id)).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.nome").value("Mouse")).andExpect(jsonPath("$.preco").value(80.0));
    }
}
