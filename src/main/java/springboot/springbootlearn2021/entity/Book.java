package springboot.springbootlearn2021.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    /*
    书籍id
     */
    private Integer bookId;
    /*
    书名
     */
    private String bookName;
    /*
    作者
     */
    private String bookAuthor;
    /*
    书籍出版社
     */
    private String bookPublish;
    /*
    书籍类别
     */
    private String bookCategory;
    /*
    书籍价格
     */
    private String bookPrice;
    /*
    书籍简介
     */
    private String bookIntroduction;
}
