package b1tterman.github.com.rest.client;

import b1tterman.github.com.props.TestConfig;
import b1tterman.github.com.rest.model.request.Book;
import b1tterman.github.com.rest.model.response.BookValidatableResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.*;

@AllArgsConstructor
public class TestClient {

    private String baseUri;
    private String basePath;

    public TestClient() {
        this(TestConfig.Uri.value, TestConfig.Path.value);
    }

    public RequestSpecification getRequestSpec() {
        return given().baseUri(baseURI).
                basePath(basePath).
                contentType(ContentType.JSON).
                log().all();
    }

    public RequestSpecification getRequestSpec(Object body) {
        return getRequestSpec().body(body);
    }

    public BookValidatableResponse create(Book book) {
        Response response = getRequestSpec(book).when().
                post("/books");

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse read(Integer id) {
        Response response = getRequestSpec().when().
                get("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse update(Integer id, Book book) {
        Response response = getRequestSpec(book).when().
                put("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse delete(Integer id){
        Response response = getRequestSpec().when().
                delete("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

}
