
## API Reference

#### Récupérer toutes les personnes

```http
  GET /localhost:9090/personnes
```


#### Récupérer une personne

```http
  GET /localhost:9090/personnes/${uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **Required**. uuid de la personne |


#### Ajouter une personne

```http
  POST /localhost:9090/personnes
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :--------------------------------- |
| `name`      | `string` | **Required**. Nom de la personne |
| `firstname`      | `string` | **Required**. Nom de la personne |

