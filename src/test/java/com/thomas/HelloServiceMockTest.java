package com.thomas;

import com.thomas.repository.HelloRepository;
import com.thomas.services.HelloService;
import com.thomas.services.HelloServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private HelloRepository helloRepository;

    @InjectMocks
    private HelloService helloService = new HelloServiceImpl();

    @Test
    void testReturnedValueWithMockito() {
    	//Arrange
    	when(helloRepository.get()).thenReturn("Hello from Mockito mocked repository");
    	//Act
    	String actualValue = helloService.get();
    	//Assert
    	String expectedValue = "Hello from Mockito mocked repository";
        assertEquals(expectedValue, actualValue);
    }
    
    @Test
    void testNumberOfCallsWithMockito() {
    	//Arrange
    	when(helloRepository.get()).thenReturn("Hello from Mockito mocked repository");
    	//Act
    	helloService.get();
    	helloService.get();
    	//Assert
        Mockito.verify(helloRepository, Mockito.times(2)).get();

    }
}