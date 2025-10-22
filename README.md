# TechTronix – Java E-Commerce Website

TechTronix is a simple full-stack e-commerce web app I built using **Java Servlets, JSP, and MySQL**.  
It follows the **MVC architecture** and was deployed on **AWS Elastic Beanstalk** with the database hosted on **Amazon RDS**.

The goal of this project was to design a basic online shopping system with separate user and admin functionality, applying everything I learned about web programming, databases, and deployment in Java.

---

##  Main Features
- User registration, login, and session management  
- Product catalog with add-to-cart and checkout flow  
- Admin panel for managing products and viewing orders  
- Order persistence using DAO pattern and MySQL  
- Simple and responsive UI built with JSP, HTML, and CSS  

---

##  Tech Stack
- **Backend:** Java Servlets, JSP, JDBC, Apache Tomcat (v10.1)  
- **Frontend:** JSP, HTML, CSS  
- **Database:** MySQL (AWS RDS)  
- **Architecture:** MVC (Model–View–Controller)

---

##  Folder Overview

    Project4413-0804/
      ├── src/
         └── main/
         ├── java/
         │ ├── Controller/             → Handles user/admin requests (e.g., ProductController, UserController)
         │ ├── DAO/                    → Data access logic using interfaces and implementations
         │ └── Model/                  → JavaBeans for Product, User, Order, CartItem, etc.
         └── webapp/
           ├── JSP pages (home, product, checkout, admin)
           ├── css/
           └── WEB-INF/
        ├── pom.xml
        └── README.md
        
- **Deployment:** AWS Elastic Beanstalk (Tomcat environment)  
- **Tools:** Maven, Eclipse IDE, GitHub  

---

## What I Learned
This project helped me understand how Java web applications work end-to-end:
- How **Servlets and JSP** communicate through controllers and views  
- Structuring a project using **MVC and DAO patterns**  
- Hosting a Java web app on **AWS Elastic Beanstalk**  
- Managing connections with **RDS** and configuring environment variables  
- Debugging deployment and database issues in the cloud  

---

## Future Improvements
- Add email notifications for orders  
- Implement password encryption and validation  
- Replace JSP with a modern frontend (React or Angular)  
- Add payment gateway integration

## 📂 Folder Overview
