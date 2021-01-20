README.md
# Employee Reimbursment System (ERS)

## Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
JDBC connection to a Postgres database
Database uses AWS RDB
Application deployment via Tomcat Server
Tech 3 - version 3.0
Features
List of features ready and TODOs for future development

Awesome feature 1
Awesome feature 2
Awesome feature 3
To-do list:

Wow improvement to be done 1
Wow improvement to be done 2
Getting Started
(include git clone command) (include all environment setup steps)

Be sure to include BOTH Windows and Unix command
Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)

All the code required to get started
Images of what it should look like
Usage
Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

Contributors
Here list the people who have contributed to this project. (ignore this section, if its a solo project)

License
This project uses the following license: <license_name>.

----------------------------------------------------------------------------------------------------------------------------

# Employee Reimbursment System (ERS)

## Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

**State-chart Diagram (Reimbursement Statuses)** 
![](./imgs/state-chart.jpg)

**Reimbursement Types**

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)

## Technical Requirements

The back-end system shall use JDBC to connect to a Postgres database. The application shall deploy onto a Tomcat Server. The middle tier shall use Servlet technology for dynamic Web application development. The front-end view shall use HTML/CSS/JavaScript to make an application that can call server-side components in a generally RESTful manner. Passwords shall be encrypted in Java and securely stored in the database. The middle tier shall follow proper layered architecture, have reasonable (~70%) test coverage of the service layer, and implement log4j for appropriate logging. Webpages shall be styled to be functional and readable. 

**Stretch Goals:**
* Replace JDBC with Hibernate to manage the database connection.
* Users can upload a document or image of their receipt when submitting reimbursements which can stored in the database and reviewed by a financial manager.
* Postgres Database shall be hosted remotely on an AWS RDS. 
* Java application shall be hosted remotely on an EC2.
* Static files (webpages) shall be hosted on an S3 bucket. 
