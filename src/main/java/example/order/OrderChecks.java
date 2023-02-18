package example.order;

import io.restassured.response.Response;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderChecks {
    public void orderCreatedSuccessfully(Response response){
                response.then().log().all()
                .extract().response();
                response.then().assertThat().body("track", notNullValue())
                .and()
                .statusCode(HTTP_CREATED);
    }

    public void orderListNotNull(Response response){
                response.then().log().all()
                .assertThat().body("orders", notNullValue())
                .and()
                .statusCode(HTTP_OK);
    }
}