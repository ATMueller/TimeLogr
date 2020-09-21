https://teams.microsoft.com/l/file/52e64457-c458-4952-8893-3ec3367dfbc5?tenantId=f5222e6c-5fc6-48eb-8f03-73db18203b63&fileType=docx&objectUrl=https%3A%2F%2Fmailuc-my.sharepoint.com%2Fpersonal%2Ffordosmk_mail_uc_edu%2FDocuments%2FMicrosoft%20Teams%20Chat%20Files%2FDesign%20Document%20-%20TimeLogr.docx&baseUrl=https%3A%2F%2Fmailuc-my.sharepoint.com%2Fpersonal%2Ffordosmk_mail_uc_edu%2F&serviceName=p2p&threadId=19:6225372448e545d391b1d552d48a78ce@thread.v2

# TimeLogr 

  

*Richard Woessner, Michelle Fordos, Andrew Mueller*

 

## TimeLogr README.md 

 

### Introduction 

TimeLogr is an enterprise web application that allows developers and clients to manage time reporting for projects. Developers will be able to log their time for various projects they work on while leaving comments on each time entry for others to see. Clients using TimeLogr can create new projects and maintain cost and time estimates. 

Users will see project dashboards that show information about the project time estimates, cost, contributors, total hours logged and comments. This makes viewing project status easy so staying within cost and time estimates is too.  


### Storyboard  

(screen mockups): Invision, FluidUI, Powerpoint, paint, etc... will be fine. 


### Functional Requirements  

#### As a developer, I want to log my time on projects so my hours are documented and can be seen by others.  

 

1. Given: A list of current projects for a client are available 

1. When: The user/service selects a project, Project A 

1. When: The user/service adds 2 hours worked and a comment about what they worked on 

1. Then: The selected project, Project A, will be updated with the user’s 2 hours and comment towards the running total 

 

2. Given: A list of current projects for a client are available 

2. When: The user/service selects a project, Project A 

2. When: The user/service adds 10 hours worked and a comment about what they worked on, going over the estimated time to complete project 

2. Then: The selected project, Project A, will be updated with the user’s 10 hours and comment towards the running total but save a warning to be displayed on the project level 

 

 

 

#### As a developer, I want to see reports of logged time on projects so I know where I should be spending my time. 

 

1. Given: Project data are available 

1. When: A user/service searches for a project name: “Project A” 

1. Then: TimeLogr will return any results that match “Project A” and show all logged time, developers that worked on that project and how long each worked for, hourly rates, total project cost and total time estimate. 

 

2. Given: Project data are available 

2. When: A user that contributed to Project A searches for a project name: “Project A” 

2. Then: TimeLogr will return any results that match “Project A” with the developer’s logged time, comments, and dates for the project, their hourly rate and a total of how much time they individually spent.  

 

 

 

#### As a client, I want to see developer time logs for each project so I know the status of a project. 

 

1. Given: Project data are available 

1. When: A user/service searches for a project name: “Project A” 

1. Then: TimeLogr will return any results that match “Project A” within the client’s projects and show project details, developers that worked on that project and how long each worked for, hourly rates, total project cost and total time estimate. 

 

2. Given: Project data are available 

2. When: A user/service searches for a project name: “Project 5u42839y” 

2. Then: TimeLogr will not return any results  

 

3. Given: A list of contributing developers on Project A 

3. When: A user selects an individual developer, John Doe 

3. Then: TimeLogr will show contact information for John Doe 

 

4. Given: The user is logged in and has selected to create a new project 

4. When: The user enters a valid project name, “Project B” details on total time estimates and budget 

4. Then: The new project will be saved under the client profile and be available for users within a client company and developers to see 

 

5. Given: The user is logged in and has selected to create a new project 

5. When: The user enters an invalid project name, “Project A” and details on total time estimates and budget 

5. Then: Project A will not be saved as it already exists for that client.  

 

6. Given: The user is logged in and has selected to create a new project 

6. When: The user enters an invalid project name, “ <*’ ” and details on total time estimates and budget 

6. Then: Project A will not be saved because it contains a character that is not valid for a project name 

 

7. Given: The user is logged in and has selected to edit an existing project 

7. When: The user enters a valid project name, “Project A” and 

7. When: The user updates details on total time estimates and budget 

7. Then: The new total time estimates and budget will be saved to Project A.  

 

 

 

 

 

### Class Diagram 

UML-based class diagram. 

Class Diagram Description: One or two lines for each class to describe use of interfaces,  classes and resources, interfaces, etc. Don't worry about putting more than a few words to each class; this does not need to be thorough. 


### JSON Schema 

{ 

  "Client": { 

    "Name": "string", 

    "Projects": { 

      "Project": { 

        "ID": integer, 

        "Name": "String", 

        "EstimatedCost": Double, 

        "EstimatedTime": Double, 

        "Developer": { 

          "ID": integer, 

          "Name": "String", 

          "HourlyPay": Double, 

          "LoggedTimes": { 

            "LoggedTime": { 

              "ID": integer, 

              "TimeDuration": double, 

              "Date": timestamp, 

              "Comment": "String" 

            } 

          } 

        } 

      } 

    } 

  } 

} 


### Scrum Roles 

**UI Specialist:** Michelle Fordos 

**Product Owner:** Drew Mueller 

**Business Logic and Persistence:** Richard Woessner 


### github.com project link 

https://github.com/Richard-Woessner/TimeLogr 


### Scrum Board  

https://trello.com/b/SuJSKsyO/ent-app-dev

 

 

### Milestone 1:  

#### Business logic and persistence team members should: 

Create interfaces for service layer. 

Create stub/mock classes that implement interfaces. 

Swap those interfaces and stubs with other team members. 

Program actual implementation classes, which implement the same interfaces as the stub/mock objects. 

#### User Interface 

Create basic web page to view projects 

Use of interfaces to coordinate listening from backend tier to UI tier 

Finalize JSON output 

#### Backend, business, persistence logic package. 

Create endpoints to view project details 

Create a controller 

Create DTO 

#### Write Unit Tests for each non-UI class. 

Write unit tests against the interface type. 

The unit tests should be in Behavior Driven Design syntax. They should reflect the “Given When Then” elaborated examples from your design document. 

 

### Standup 

6:00 p.m. EST on Wednesdays 

You have been invited to the weekly meetings. 

 

 
