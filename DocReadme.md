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

#### Return
```javascript
['file']
```

### GET   files/{ID} 
If it's a file it returns the file asked but a folder returns every file or folder inside of it

#### Return
```javascript
['file']
```

DELETE/{id} Deletes and file or folder that is in the trash

PATCH/{DESTINATION} Moves file to different parent

POST/{DESTINATION}

Database Entity Relationship Diagrams
![DatabaseDiagram](https://user-images.githubusercontent.com/10840988/61665895-d1b94880-ac9b-11e9-8e8e-7792f07196a8.png)
