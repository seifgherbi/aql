package tp3_Fpart.exo3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    @Test
    void testGetProductSuccess() throws Exception {
        // Arrange
        ProductApiClient productApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(productApiClient);

        Product mockProduct = new Product("123", "Phone");
        when(productApiClient.getProduct("123")).thenReturn(mockProduct);

        // Act
        Product product = productService.getProduct("123");

        // Assert
        assertNotNull(product);
        assertEquals("123", product.getId());
        assertEquals("Phone", product.getName());
        verify(productApiClient).getProduct("123");
    }

    @Test
    void testGetProductThrowsException() throws Exception {
        // Arrange
        ProductApiClient productApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(productApiClient);

        when(productApiClient.getProduct("invalid")).thenThrow(new RuntimeException("API failure"));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct("invalid");
        });

        assertEquals("API failure", exception.getMessage());
        verify(productApiClient).getProduct("invalid");
    }
}
