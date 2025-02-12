
This repo contains 3 projects to demonstrate graphQL federation.
![image](https://github.com/user-attachments/assets/2f139874-b8a5-45e9-a9f0-b3babcdd64b7)

1. **product-service** - This is built using Springboot and GraphQL . This service contains Product GraphQL Schema and the queries to get product data using id and all products.
2. **review-service** - This is built using Springboot and GraphQL . This service contains Review GraphQL Schema and Extends the Product type to add the reviews field, which allows the Review data to be fetched alongside the Product data.
3. **federation-gateway** - This is a node project which used Apollo gateway and Apollo server. The Apollo Gateway will send a query to both the Product service and Review service based on the schema composition, then combine the results and return them to the client.
