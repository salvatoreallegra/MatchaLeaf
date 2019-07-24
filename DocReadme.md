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
  folder: integer
}
```

### POST /folders
creates a folder

#### request
```javascript
{
  name: string,
  folder: integer
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

### GET   download/{id}
allows the user to download the file or folder (folders are zipped before the download)

### POST    create
allows user to create folders

#### Request
```javascript
{name: 'string'}
```
#### Response
```javascript
['file']
```

### POST    upload
user uploads a file/files

#### Request
```javascript
[{name: 'string', data: 'dataStream'}]
```

### PATCH   trash/{id}

#### Response
```javascript
['file']
```

### PATCH   move/{id}

#### Request
```javascript
{newPath: 'string'}
```

#### Response
```javascript
['file']
```


 ## Database Entity Relationship Diagrams
![DatabaseDiagram](https://user-images.githubusercontent.com/10840988/61665895-d1b94880-ac9b-11e9-8e8e-7792f07196a8.png)
