package b1tterman.github.com.tests.update;

import b1tterman.github.com.rest.model.request.Book;
import b1tterman.github.com.rest.model.response.BookResponse;
import b1tterman.github.com.tests.BookData;
import b1tterman.github.com.tests.BookStoreTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateBookNegative extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp(){
        id = testClient.create(Book.defaultOf()).
                checkStatusCode(201).getId();
    }

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.updateError400(id));

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(Book.defaultOf());

    }

}
