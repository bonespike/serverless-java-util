# serverless-java-util
A set of helper classes and utilities for working with serverless and java


# Roadmap
## 0.1 (current) - Simple POJOs and minor helpers to make working with lambda-proxy mode of serverless easier with java
## 0.2 - Expand POJOs, add more utilities
## 0.3 - add simple framework to make mapping input and output types as easy as lambda mode


# Usage
## Repo
To add this library to your project, first add the repo:
```groovy
repositories {
    maven { url 'https://github.com/bonespike/mvn-repo/raw/master/maven-deploy' }
    // ...   
}

```

And then you can the artifact like this:

```groovy

dependencies {
        compile 'com.bonespike:serverless-java-util:0.1'
        // ...
}

```

## Usage
Define your serverless function as usual, but set the handler signature so that the input and outputs are:
### http events (e.g. API Gateway)
com.bonespike.sju.ApiGatewayRequest and com.bonespike.sju.ApiGatewayResponse 

```
public class Handler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        String body = input.getBody();
        ApiGatewayResponse response = new ApiGatewayResponse();
        
        response.setBody("{'response': 'all good'}");
        
        return response;
    }
}
```

### other types coming soon