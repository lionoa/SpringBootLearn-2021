package springboot.springbootlearn2021.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.springbootlearn2021.entity.Book;
import springboot.springbootlearn2021.mapper.BookMapper;
import springboot.springbootlearn2021.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBooks() {
        return bookMapper.getBooks();
    }

    @Override
    public List<String> getBookCategory() {
        return bookMapper.getBookCategory();
    }

    @Override
    public int delete(Integer id) {
        return bookMapper.delete(id);
    }

    @Override
    public int update(Book book) {
        return bookMapper.update(book);
    }
}
