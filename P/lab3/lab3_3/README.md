Add quote:

```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{"quote":"May the Force be with you", "movie":{"id":1,"title":"Star Wars", "year":1977}}' \
    http://localhost:8080/addQuote
```

Add movie:

```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{"title":"Star Wars", "year":"1977"}' \
    http://localhost:8080/addMovie
```

Show all quotes

```bash
curl -X GET http://localhost:8080/quotes
```

Show all movies:

```bash
curl -X GET http://localhost:8080/shows
```

Show quotes by id

```bash
curl -X GET http://localhost:8080/quoteById/
```

Show movies by id

```bash
curl -X GET http://localhost:8080/movieById/
```

Show movies by name

```bash
curl -X GET http://localhost:8080/movie/{title}
```

Update quote

```bash
curl -X GET http://localhost:8080/updateQuote/
```

Update movie

```bash
curl -X GET http://localhost:8080/updateMovie/
```

Delete quote

```bash
curl -X GET http://localhost:8080/deleteQuote/{id}
```

Delete Movie

```bash
curl -X GET http://localhost:8080/deleteMovie/{id}
```

Returns a random quote for the specified show/film.

```bash
curl -X GET http://localhost:8080/quote?show=1
```