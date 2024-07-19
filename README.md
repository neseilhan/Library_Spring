# Book Borrowing Management System

RestApi program of a book borrowing management that has authors, categories, publishers and book borrowings of the books, and crud transactions can be performed with them. 
If there are books registered in the system belonging to the category to be deleted, the deletion process will not take place. If the book to be borrowed is not in stock, it cannot be borrowed.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- PostgreSQL
- Maven

## Features

- **Category Management:** CRUD operations for book categories.
- **Author Management:** CRUD operations for authors.
- **Book Management:** CRUD operations for books.
- **Publisher Management:** CRUD operations for publishers.
- **Book Borrowing Management:** CRUD operations for book borrowing, including retrieval by categories and books.

## Database Diagram

![image](https://github.com/user-attachments/assets/a9ec301f-257b-4cfe-84b2-508a4b7a10c2)


## API Endpoints
## API Endpoints

- **GET /api/books:** Retrieve all books.
- **POST /api/books:** Create a new book.
- **GET /api/authors:** Retrieve all authors.
- **POST /api/authors:** Create a new author.
- **GET /api/categories:** Retrieve all categories.
- **POST /api/categories:** Create a new category.
- **GET /api/publishers:** Retrieve all publishers.
- **POST /api/publishers:** Create a new publisher.
- **GET /api/book-borrowings:** Retrieve all borrowing records.
- **POST /api/book-borrowings:** Create a new borrowing record.
