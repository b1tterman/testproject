package b1tterman.github.com.rest.model.response;

import b1tterman.github.com.rest.model.request.Book;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Accessors(chain = true)
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse extends Book{

    private Integer id;
    private OffsetDateTime lastUpdated;

    @EqualsAndHashCode.Exclude
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public static BookResponse error400(String path) {
        return new BookResponse().setStatus(400).
                setError("Bad Request").setPath(path);
    }

    public static BookResponse createError400() {
        return error400("/rest-api/books");
    }

    public static BookResponse updateError400(Integer id) {
        return error400(String.format("/rest-api/books/%s", id));
    }
}
