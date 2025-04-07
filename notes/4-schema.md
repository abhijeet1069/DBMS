# Schema

In SQL, the database schema is what describes the structure of each table, and the datatypes that each column of the table can contain.

## Insert

Add data to the table

```sql
INSERT INTO boxoffice
(movie_id, rating, sales_in_millions)
VALUES (1, 9.9, 283742034 / 1000000);
```

## Update

Update data in table

```sql
UPDATE mytable
SET column = value_or_expr, 
    other_column = another_value_or_expr, 
    …
WHERE condition;
```

## Delete

Delete rows from table

```sql
DELETE FROM mytable
WHERE condition;
```
