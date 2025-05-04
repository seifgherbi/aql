package tp3_Fpart.exo3;

public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws Exception {
        return productApiClient.getProduct(productId);
    }
}
