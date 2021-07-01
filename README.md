# graphql-reactive-kotlin

Experimenting with the reactive features of ExpediaGroup's graphql-kotlin library: https://github.com/ExpediaGroup/graphql-kotlin

The stack used in this project is:
  Kotlin
  openJDK-11
  Gradle
  PostgreSQL
  graphql-kotlin-spring-server, spring reactive webflux, r2dbc
  
Here are some graphQL queries, mutations and subscriptions to test the project:

    mutation {
      saveUserDetails(userDetails: { name: $name }) {
        id
        name
      }
    }
    
    query GetUserDetails {
      getUserDetails(id: $id) {
        id
        name
      }
    }
    
    query GetAllUserDetails {
      getAllUserDetails {
        id
        name
      }
    }
    
    subscription StreamAllUserDetails {
      streamAllUserDetails {
        id
        name
      }
    }
