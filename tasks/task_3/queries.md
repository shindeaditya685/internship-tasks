1. Write a SQL query to retrieve the top 5 customers who have purchased the most books (by total quantity) over the last year.
```sql
SELECT C.customer_id, C.name, SUM(OD.quantity) AS total_books_purchased
FROM Customers C
JOIN Orders O ON C.customer_id = O.customer_id
JOIN OrderDetails OD ON O.order_id = OD.order_id
WHERE O.order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
GROUP BY C.customer_id, C.name
ORDER BY total_books_purchased DESC
LIMIT 5;

```

2. Write a SQL query to retrieve the top 5 customers who have purchased the most books (by total quantity) over the last year.
```sql
SELECT B.author, SUM(B.price * OD.quantity) AS total_revenue
FROM Books B
JOIN OrderDetails OD ON B.book_id = OD.book_id
JOIN Orders O ON OD.order_id = O.order_id
GROUP BY B.author
ORDER BY total_revenue DESC;
```

3. Write a SQL query to retrieve all books that have been ordered more than 10 times, along with the total quantity ordered for each book.
```sql
SELECT B.book_id, B.title, SUM(OD.quantity) AS total_quantity_ordered
FROM Books B
JOIN OrderDetails OD ON B.book_id = OD.book_id
GROUP BY B.book_id, B.title
HAVING total_quantity_ordered > 10
ORDER BY total_quantity_ordered DESC;

```