## API Data Type
### File
```javascript
{//File
  id: 'integer',
  fileName: 'string',
  path: 'string',
  isFolder: 'boolean'
  }
```


## API Endpoints

### `GET    files` 
Returns a list of files

#### Response
```javascript
['file']
```

### GET   files/{ID} 
If it's a file it returns the file asked but a folder returns every file or folder inside of it

#### Response
```javascript
['file']
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
