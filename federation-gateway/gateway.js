// gateway.js
const { ApolloGateway, RemoteGraphQLDataSource} = require('@apollo/gateway');
const { ApolloServer } = require('apollo-server');

const gateway = new ApolloGateway({
    serviceList: [
        { name: 'product', url: 'http://localhost:8080/graphql' },  // URL of your Product service
        { name: 'review', url: 'http://localhost:8081/graphql' },   // URL of your Review service
    ],
    buildService({ url }) {
        return new RemoteGraphQLDataSource({
            url,
        });
    },
});

const server = new ApolloServer({
    gateway,
    subscriptions: false,
});

server.listen(4000).then(({ url }) => {
    console.log(`🚀 Gateway ready at ${url}`);
});
