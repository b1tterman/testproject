package b1tterman.github.com.tests.update;

import b1tterman.github.com.rest.model.request.Book;
import b1tterman.github.com.tests.BookData;
import b1tterman.github.com.tests.BookStoreTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateBookTest extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient.create(Book.defaultOf()).checkStatusCode(201).getId();
    }

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);
    }
}
