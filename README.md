# InventoryApp
app to add a pirticular product and create multiple variants of that specific product.



# Run
* mvn clean install
* mvn spring-boot:run




# Important apis
* {POST /api/products}: createProduct(Product)
* {POST /api/product/product-variants/{productId}}: saveProductVariantForProduct(ProductVariant productVariaant,Long productId) 
