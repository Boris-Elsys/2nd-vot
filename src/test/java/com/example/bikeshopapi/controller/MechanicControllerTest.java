package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import com.example.bikeshopapi.service.MechanicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MechanicController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class MechanicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MechanicService mechanicService;

    private ObjectMapper objectMapper;

    @MockBean
    private MechanicResource mechanic1;

    @BeforeEach()
    void setUp() {

        objectMapper = new ObjectMapper();
        mechanic1 = new MechanicResource();

    }

    @Test
    void getAll() throws Exception {

        MechanicResource mechanic = new MechanicResource();
        MechanicResource mechanic2 = new MechanicResource();

        when(mechanicService.getAll()).thenReturn(List.of(mechanic, mechanic2));

        mockMvc.perform(get("/api/mechanic"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    void getById() throws Exception {

        MechanicResource mechanic = new MechanicResource();
        MechanicResource mechanic2 = new MechanicResource();

        mechanic.setId(1L);
        mechanic2.setId(2L);
        mechanic.setName("Az");
        mechanic2.setName("Ti");
        mechanic.setBikeShopId(1L);
        mechanic2.setBikeShopId(2L);

        when(mechanicService.getById(1L)).thenReturn(mechanic);
        when(mechanicService.getById(2L)).thenReturn(mechanic2);

        mockMvc.perform(get("/api/mechanic/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Az"))
                .andExpect(jsonPath("$.bikeShopId").value(1L));

        mockMvc.perform(get("/api/mechanic/{id}", 2L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("Ti"))
                .andExpect(jsonPath("$.bikeShopId").value(2L));

    }

    @Test
    void create() throws Exception {

        MechanicResource mechanic = new MechanicResource();

        mechanic.setId(1L);
        mechanic.setName("Az");
        mechanic.setBikeShopId(1L);

        when(mechanicService.save(any(MechanicResource.class))).thenReturn(mechanic);

        mockMvc.perform(post("/api/mechanic")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mechanic)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Az"))
                .andExpect(jsonPath("$.bikeShopId").value(1L));

    }

    @Test
    void update() throws Exception {

        mechanic1.setId(1L);
        mechanic1.setName("Az");
        mechanic1.setBikeShopId(1L);

        when(mechanicService.save(any(MechanicResource.class))).thenReturn(mechanic1);

        mockMvc.perform(post("/api/mechanic")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mechanic1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Az"))
                .andExpect(jsonPath("$.bikeShopId").value(1L));

        mechanic1.setName("Ti");
        mechanic1.setBikeShopId(1L);


        mockMvc.perform(put("/api/mechanic/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mechanic1)))
                .andExpect(status().isOk());

    }

    @Test
    void deleteTest() throws Exception {
        MechanicResource mechanic = new MechanicResource();
        mechanic.setId(1L);
        mechanic.setName("Az");
        mechanic.setBikeShopId(1L);

        when(mechanicService.save(any(MechanicResource.class))).thenReturn(mechanic);

        mockMvc.perform(post("/api/mechanic")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mechanic)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Az"))
                .andExpect(jsonPath("$.bikeShopId").value(1L));

        mockMvc.perform(delete("/api/mechanic/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(204));
    }

}