package b1tterman.github.com.create;


import b1tterman.github.com.tests.BookData;
import b1tterman.github.com.tests.BookStoreTestBase;
import b1tterman.github.com.rest.model.request.Book;
import b1tterman.github.com.rest.enums.Category;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import b1tterman.github.com.rest.model.response.BookValidatableResponse;

import static io.restassured.RestAssured.given;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testCreateBook(Book book) {
        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);


        testClient.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);
    }


}
