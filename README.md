# InventoryApp
* app to add a pirticular product and create multiple variants of that specific product.
* two entities Product and ProductVariant


# Run
* mvn clean install
* mvn spring-boot:run




# Important apis
* {POST /api/products}: createProduct(Product)
* {POST /api/product/product-variants/{productId}}: saveProductVariantForProduct(ProductVariant, productId) 
