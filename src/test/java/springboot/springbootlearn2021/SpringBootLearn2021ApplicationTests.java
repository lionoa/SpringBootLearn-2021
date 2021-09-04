package springboot.springbootlearn2021;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.springbootlearn2021.entity.Book;
import springboot.springbootlearn2021.mapper.BookMapper;

import java.util.List;

@SpringBootTest
class SpringBootLearn2021ApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        List<Book> books = bookMapper.getBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }

        List<String> bookCategory = bookMapper.getBookCategory();
        System.out.println(bookCategory);


    }

    @Test
    void delete() {
        int delete = bookMapper.delete(4);
        System.out.println(delete);
    }

    @Test
    void update() {
        Book book = new Book(6, "中文书", "小李", "中国出版社", "1", "123", "fasdfasdfasdfasdfasdfasdfasdf");
        int update = bookMapper.update(book);
        System.out.println(update);
    }

}
