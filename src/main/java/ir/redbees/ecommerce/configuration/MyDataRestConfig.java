package ir.redbees.ecommerce.configuration;

import ir.redbees.ecommerce.module.Entity.Product;
import ir.redbees.ecommerce.module.Entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsopportedActions = {HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};

        //disable for Products
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsopportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsopportedActions)));

        //disable for Products
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsopportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsopportedActions)));
    }
}
