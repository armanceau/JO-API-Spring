
# JO-API-Spring

A brief description of what this project does and who it's for


## API Reference

### 01- Personnes

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
| `uuid`      | `string` | **`Required`** uuid de la personne |


#### Ajouter une personne

```http
  POST /localhost:9090/personnes
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :--------------------------------- |
| `name`      | `string` | **`Required`** Nom de la personne |
| `firstname`      | `string` | **`Required`** Nom de la personne |


#### Supprimer une personne

```http
  DELETE /localhost:9090/personnes/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid de la personne |


#### Mettre à jour une personne

```http
  PUT /localhost:9090/personnes/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid de la personne |
| `name`      | `string` | **`Required`** Nom de la personne |
| `firstname`      | `string` |  **`Required`** Nom de la personne |


#### Mettre à jour partiellement une personne

```http
  PATCH /localhost:9090/personnes/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid de la personne |
| `name`      | `string` | Nom de la personne |
| `firstname`      | `string` |  Nom de la personne |


### 02- Stades

#### Récupérer tous les stades

```http
  GET /localhost:9090/stades
```


#### Récupérer un stade

```http
  GET /localhost:9090/stade/${uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid du stade |


#### Ajouter un stade

```http
  POST /localhost:9090/stades
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :--------------------------------- |
| `name`      | `string` | **`Required`** Nom du stade |
| `adresse`      | `string` | **`Required`** Adresse du stade |
| `ville`      | `string` | **`Required`** Ville du stade |
| `capacite`      | `integer` | **`Required`** Capacité du stade |


#### Supprimer un stade

```http
  DELETE /localhost:9090/stade/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid du stade |


#### Mettre à jour un stade

```http
  PUT /localhost:9090/stades/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid du stade |
| `name`      | `string` | **`Required`** Nom du stade |
| `adresse`      | `string` |  **`Required`** Adresse du stade |
| `ville`      | `string` |  **`Required`** Ville du stade |
| `capacite`      | `integer` |  **`Required`** Capacité du stade |


#### Mettre à jour partiellement un stade

```http
  PATCH /localhost:9090/stades/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid du stade |
| `name`      | `string` | Nom du stade |
| `adresse`      | `string` |  Adresse du stade |
| `ville`      | `string` |  Ville du stade |
| `capacite`      | `integer` | Capacité du stade |


### 03- Epreuves

#### Récupérer toutes les épreuves

```http
  GET /localhost:9090/epreuves
```


#### Récupérer une épreuve

```http
  GET /localhost:9090/epreuve/${uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid de l'épreuve |


#### Ajouter une épreuve

```http
  POST /localhost:9090/epreuve
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :--------------------------------- |
| `name`      | `string` | **`Required`** Nom de l'épreuve |
| `date`      | `date` | **`Required`** date de l'épreuve |
| `stade`      | `stade` | **`Required`** Stade où l'épreuve à lieu |


#### Supprimer une épreuve

```http
  DELETE /localhost:9090/epreuve/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid de l'érpeuve |

<!-- 
#### Mettre à jour un stade

```http
  PUT /localhost:9090/stades/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid du stade |
| `name`      | `string` | **`Required`** Nom du stade |
| `adresse`      | `string` |  **`Required`** Adresse du stade |
| `ville`      | `string` |  **`Required`** Ville du stade |
| `capacite`      | `integer` |  **`Required`** Capacité du stade |


#### Mettre à jour partiellement un stade

```http
  PATCH /localhost:9090/stades/{uuid}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `uuid`      | `string` | **`Required`** uuid du stade |
| `name`      | `string` | Nom du stade |
| `adresse`      | `string` |  Adresse du stade |
| `ville`      | `string` |  Ville du stade |
| `capacite`      | `integer` | Capacité du stade | -->