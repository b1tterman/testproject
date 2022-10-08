package b1tterman.github.com.tests.delete;

import b1tterman.github.com.rest.model.request.Book;
import b1tterman.github.com.rest.model.response.BookValidatableResponse;
import b1tterman.github.com.tests.BookStoreTestBase;
import org.testng.annotations.Test;

public class DeleteBookTest extends BookStoreTestBase {

    @Test
    public void testDeleteBook() {
        BookValidatableResponse response = testClient.create(Book.defaultOf()).
                checkStatusCode(201);

        testClient.delete(response.getId()).
                checkStatusCode(200);

        testClient.read(response.getId()).
                checkStatusCode(404);
    }
    
    @Test
    public void testDeleteNotExistBook() {
        testClient.delete(9999).
                checkStatusCode(404);
    }
}
