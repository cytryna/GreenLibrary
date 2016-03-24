package s10338.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "USER_BOOK")
public class Commit {

    @EmbeddedId
    private CommitKey commitKey;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", insertable=false, updatable=false)
    private Book book;

    public Commit() {
    }

    public Commit(CommitKey commitKey, Date date, String comment) {
        this.commitKey = commitKey;
        this.date = date;
        this.comment = comment;
    }

    @Column(name = "comment")
    private String comment;

    public static class CommitKey implements Serializable {

        @Column(name = "username", nullable = false, length = 15)
        private String username;

        @Column(name = "book_id")
        private int bookId;

        public CommitKey() {
        }

        public CommitKey(String username, int bookId) {
            this.username = username;
            this.bookId = bookId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        @Override
        public String toString() {
            return "CommitKey{" +
                    "username='" + username + '\'' +
                    ", bookId=" + bookId +
                    '}';
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CommitKey getCommitKey() {
        return commitKey;
    }

    public void setCommitKey(CommitKey commitKey) {
        this.commitKey = commitKey;
    }

    public String getDateString() {
        return date.toLocalDate().toString();
    }

    @Override
    public String toString() {
        return "Commit{" +
                "commitKey=" + commitKey +
                ", date=" + date +
                ", book=" + book +
                ", comment='" + comment + '\'' +
                '}';
    }
}
