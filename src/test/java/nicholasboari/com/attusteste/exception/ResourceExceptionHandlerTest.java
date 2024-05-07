package nicholasboari.com.attusteste.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ResourceExceptionHandlerTest {

    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;

    @Mock
    private HttpServletRequest request;

    @Test
    void testNotFound() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        when(request.getRequestURI()).thenReturn("/example");

        ResponseEntity<StandardError> response = exceptionHandler.notFound(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not found", Objects.requireNonNull(response.getBody()).getError());
        assertEquals("Resource not found", response.getBody().getMessage());
        assertEquals("/example", response.getBody().getPath());
    }

    @Test
    void testConflict() {
        ResourceConflictException exception = new ResourceConflictException("Resource conflict");
        when(request.getRequestURI()).thenReturn("/example");

        ResponseEntity<StandardError> response = exceptionHandler.conflict(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Conflict", Objects.requireNonNull(response.getBody()).getError());
        assertEquals("Resource conflict", response.getBody().getMessage());
        assertEquals("/example", response.getBody().getPath());
    }
}