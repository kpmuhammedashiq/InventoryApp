package com.sample.Inventory.web.rest;

import com.sample.Inventory.domain.Product;
import com.sample.Inventory.domain.ProductVariant;
import com.sample.Inventory.repository.ProductRepository;
import com.sample.Inventory.repository.ProductVariantRepository;
import com.sample.Inventory.service.ProductService;
import com.sample.Inventory.service.ProductVariantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InventoryAppResource {
    private final Logger log = LoggerFactory.getLogger(InventoryAppResource.class);

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductVariantRepository productVariantRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductVariantService productVariantService;



    /********************************** Product end points **********************************/
    
    /**
     *  Create a new product.
     *
     * @param product the product to create.
     * @return ResponseEntity<Product>
     */
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        log.debug("REST request to save Product : {}"+ product);
        Product result = productService.save(product);
        return ResponseEntity.ok().body(result);
    }

    /**
     *  Updates an existing product.
     *
     * @param product the product to update.
     * @return ResponseEntity<Product>
     */
    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct( @RequestBody Product product) {
        log.debug("REST request to update Product : {}", product);
        Product result = productService.save(product);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     *  GET  /products : get all the products.
     *
     * @return List<Product>
     */
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        log.debug("REST request to get all Products");
        return productService.findAll();
    }

    /**
     *  get the "id" product.
     *
     * @param id the id of the product to retrieve.
     * @return ResponseEntity<Product>
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        log.debug("REST request to get Product : {}", id);
        Optional<Product> product = productService.findById(id);
        return ResponseEntity.ok()
                .body(product.get());
    }

    /**
     *  delete the "id" product.
     *
     * @param id the id of the product to delete.
     * @return ResponseEntity<Void>.
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        log.debug("REST request to delete Product : {}", id);
        productService.deleteById(id);
        return ResponseEntity.ok()
                .body("product deleted!!");
    }









    /********************************** ProductVariant end points **********************************/

    /**
     * Create a new productVariant of a particular product.
     *
     * @param id of the parent product
     * @param productVariant the productVariant to create.
     * @return ResponseEntity<ProductVariant>
     */
    @PostMapping("/product/product-variants/{id}")
    public ResponseEntity<ProductVariant> saveProductVariantForProduct(@RequestBody ProductVariant productVariant,@PathVariable Long id){
        log.debug("REST request to create ProductVariant for a product : {}", id);
        Product product=productService.findById(id).get();
        productVariant.setProduct(product);
        ProductVariant result =productVariantRepository.save(productVariant);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * Create a new productVariant.
     *
     * @param productVariant the productVariant to create.
     * @return ResponseEntity<ProductVariant>
     */
    @PostMapping("/product-variants")
    public ResponseEntity<ProductVariant> createProductVariant(@RequestBody ProductVariant productVariant) {
        log.debug("REST request to save ProductVariant : {}", productVariant);
        ProductVariant result = productVariantService.save(productVariant);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * Updates an existing productVariant.
     *
     * @param productVariant the productVariant to update.
     * @return ResponseEntity<ProductVariant>
     */
    @PutMapping("/product-variants")
    public ResponseEntity<ProductVariant> updateProductVariant(@RequestBody ProductVariant productVariant) {
        log.debug("REST request to update ProductVariant : {}", productVariant);
        ProductVariant result = productVariantService.save(productVariant);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * {@code GET  /product-variants} : get all the productVariants.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productVariants in body.
     */
    @GetMapping("/product-variants")
    public List<ProductVariant> getAllProductVariants() {
        log.debug("REST request to get all ProductVariants");
        return productVariantService.findAll();
    }

    /**
     *  get the "id" productVariant.
     *
     * @param id the id of the productVariant to retrieve.
     * @return ResponseEntity<ProductVariant>
     */
    @GetMapping("/product-variants/{id}")
    public ResponseEntity<ProductVariant> getProductVariant(@PathVariable Long id) {
        log.debug("REST request to get ProductVariant : {}", id);
        Optional<ProductVariant> productVariant = productVariantService.findById(id);
        return ResponseEntity.ok()
                .body(productVariant.get());
    }

    /**
     *  delete the "id" productVariant.
     *
     * @param id the id of the productVariant to delete.
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/product-variants/{id}")
    public ResponseEntity<String> deleteProductVariant(@PathVariable Long id) {
        log.debug("REST request to delete ProductVariant : {}", id);
        productVariantService.deleteById(id);
        return ResponseEntity.ok()
                .body("product variant deleted!!");
    }

}
