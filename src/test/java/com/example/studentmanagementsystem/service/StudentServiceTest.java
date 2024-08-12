package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.exception.StudentNotFoundException;
import com.example.studentmanagementsystem.repository.StudentRepository;
import com.example.studentmanagementsystem.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Używa Mockito do wstrzykiwania zależności
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;  // Tworzy mock dla StudentRepository

    @InjectMocks
    private StudentService studentService;  // Wstrzykuje mock do StudentService

    @Test
    public void testGetStudentById_whenStudentExists() {
        // Tworzenie instancji Student do testów
        Student student = new Student("John Doe", "john.doe@example.com", "Computer Science");

        // Konfiguracja mocka studentRepository
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        // Wywołanie metody serwisu
        Student result = studentService.getStudentById(1L);

        // Assercje
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetStudentById_whenStudentDoesNotExist() {
        // Konfiguracja mocka studentRepository, aby zwracał pusty Optional
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        // Testowanie rzucania wyjątku
        assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(1L));
    }
}
