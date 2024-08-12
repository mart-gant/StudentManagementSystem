package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.exception.StudentNotFoundException;
import com.example.studentmanagementsystem.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    private MockMvc mockMvc;

    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Preferowana metoda do inicjalizacji mocków
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

        // Inicjalizacja obiektu student
        student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setEmail("john@example.com");
        student.setCourse("Computer Science");
    }

    @Test
    public void testGetStudentById() throws Exception {
        when(studentService.getStudentById(1L)).thenReturn(student); // Nie używamy Optional

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.course").value("Computer Science"));

        verify(studentService, times(1)).getStudentById(1L);
    }

    @Test
    public void testGetStudentByIdNotFound() throws Exception {
        when(studentService.getStudentById(1L)).thenThrow(new StudentNotFoundException(1L));

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isNotFound());

        verify(studentService, times(1)).getStudentById(1L);
    }

    // Możesz dodać więcej testów dla innych metod kontrolera
}
