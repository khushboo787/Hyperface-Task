# Hyperface-Task

# To-Do List Application

## Overview

This To-Do List application is designed to help users manage their tasks effectively. Users can add, mark, remove, and view tasks, providing a simple and intuitive interface to keep track of their daily activities.

## Features

- **Add New Tasks**: Users can add a new task with a description. Each task will have a unique ID generated automatically.
- **Mark Tasks as Complete**: Users can mark a task as complete using its unique ID. Completed tasks are clearly indicated in the task list.
- **Remove Tasks**: Users can remove a task using its unique ID. Removed tasks will no longer appear in the task list.
- **View All Tasks**: Users can list all tasks, displaying each task's ID, description, and completion status (e.g., "Complete" or "Pending").

## Technologies Used
- Java
- Spring Boot
- MySQL

 ### Setup and Installation

 **Clone the repository:**

```
git clone https://github.com/khushboo787/Hyperface-Task
```


#### The application will be accessible at http://localhost:8080

### Build and Run the Application
```
mvn clean install
mvn spring-boot:run
```
### API Endpoints
- **Add a New Task:** `POST : http://localhost:8080/api/tasks/addTask`

##### Request
```

{
  "description": "buy new books"
}

```
##### Response

```

{
  "id": 1,
  "description": "buy new books",
  "status": "Pending"
}

```


- **Mark Task as Complete:** `PUT : http://localhost:8080/api/tasks/markTaskAsComplete/{id}`

##### Request
```
 PUT : http://localhost:8080/api/tasks//markTaskAsComplete/1

```
##### Response

```

{
  "id": 1,
  "description": "buy new books",
  "status": "Complete"
}

```


- **Remove a Task:** `DELETE : http://localhost:8080/api/tasks/deleteTaskById/{id}`

##### Request
```
 DELETE : http://localhost:8080/api/tasks/deleteTaskById/4

```
##### Response

```
Task with ID 4 deleted successfully.

```

- **View All Tasks:** `GET : http://localhost:8080/api/tasks/getAllTasks`

##### Request
```
 GET : http://localhost:8080/api/tasks/getAllTasks

```
##### Response

```
[
  {
    "id": 5,
    "description": "buy vegetables",
    "status": "Pending"
  },
  {
    "id": 7,
    "description": "buy books",
    "status": "Complete"
  },
  {
    "id": 9,
    "description": "buy vegetables",
    "status": "Pending"
  }
]

```


