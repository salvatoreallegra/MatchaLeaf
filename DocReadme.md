## API Data Type
### File
```javascript
{ //File
  id: integer,
  name: string
}
```

### Folder
```javascript
{
  id: integer,
  name: string,
  files: [ File ],
  folders: [ Folder ],
}
```


## API Endpoints

### POST /files
creates a file

#### request
```javascript
{
  name: string,
  data: byte[],
  folderId: integer
}
```

### POST /folders
creates a folder

#### request
```javascript
{
  name: string,
  folderId: integer
}
```

### GET /folders/{id} 
Returns a folder by id

#### Response
```javascript
Folder
```

### GET /files/{ID} 
Returns a file with its data for the purpose of downloading

#### Response
```javascript
{
  name: string,
  data: byte[]
}
```

### PATCH /files/{id}/trash

#### Response
```javascript
  File
```

### PATCH /files/{id}/move

#### Request
```javascript
{
  folderId: integer
}
```

#### Response
```javascript
  File
```


 ## Database Entity Relationship Diagrams
![DatabaseDiagram](https://user-images.githubusercontent.com/10840988/61665895-d1b94880-ac9b-11e9-8e8e-7792f07196a8.png)
