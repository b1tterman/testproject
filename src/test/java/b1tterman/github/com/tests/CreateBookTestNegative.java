package b1tterman.github.com.tests;

import b1tterman.github.com.rest.model.request.Book;
import b1tterman.github.com.rest.model.response.BookResponse;
import org.testng.annotations.Test;

public class CreateBookTestNegative extends BookStoreTestBase{

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testCreate(Book book) {
        testClient.create(book).checkStatusCode(400).
        checkErrorResponse(BookResponse.createError400());
    }

}
