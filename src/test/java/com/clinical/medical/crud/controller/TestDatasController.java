package com.clinical.medical.crud.controller;

import com.clinical.medical.crud.repository.DatasRepository;
import com.clinical.medical.crud.service.DatasService;
import com.clinical.medical.crud.model.dto.DatasDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DatasController.class)
@AutoConfigureMockMvc
public class TestDatasController {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DatasService datasService;

    @Mock
    private DatasRepository datasRepository;

    @Test
    public void shouldNoContentSave() throws Exception
    {
        DatasDTO datasDTOSave = new DatasDTO();
        datasDTOSave.setName("rayana");

        Mockito.when(datasService.saveDatas(datasDTOSave)).thenReturn(null);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/datas/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(datasDTOSave)))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("Nao foi possivel cadastrar dados!"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}