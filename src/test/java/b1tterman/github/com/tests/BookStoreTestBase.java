package b1tterman.github.com.tests;

import b1tterman.github.com.rest.client.TestClient;

public class BookStoreTestBase {

    protected static TestClient testClient;

    static {
        testClient = new TestClient();
    }
}
