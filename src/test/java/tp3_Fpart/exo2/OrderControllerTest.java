package tp3_Fpart.exo2;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class OrderControllerTest {

    @Test
    void testCreateOrder() {
        // Arrange
        OrderDao orderDao = mock(OrderDao.class);
        OrderService orderService = new OrderService(orderDao);
        OrderController orderController = new OrderController(orderService);

        Order order = new Order(1L, "New Laptop");


        orderController.createOrder(order);


        verify(orderDao).saveOrder(order);
    }
}
