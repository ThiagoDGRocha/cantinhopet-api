package br.com.tdgrocha;

import br.com.tdgrocha.pojos.ClientIn;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientResourceTest {

    @Test
    @Order(1)
    public void testPostClient() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ClientIn("test"))
                .when().post(Resources.CLIENT)
                .then()
                .statusCode(200);
    }

    @Test
    @Order(2)
    public void testGetAllClients() {
        given()
                .get(Resources.CLIENT)
                .then().statusCode(200)
                .body("size()", is(1), "id", hasItem(1));
    }

}
