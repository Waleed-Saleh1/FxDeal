# ProgressSoft-task
# FX Deal Data Warehouse

The FX Deal Data Warehouse project is a Scrum team effort to develop a data warehouse for Bloomberg, enabling the analysis of Foreign Exchange (FX) deals. This project focuses on accepting deal details and persisting them into a database while ensuring data integrity and preventing duplicate imports.


<h1>How to Run </h1>

<ul>
<li><code>mvn clean install</code> to clean if exists files and install packages</li>
<li><code>mvn spring-boot:run</code>  to start spring boot</li>
</ul>


<h3>Guide to Build and Run Project</h3>
When you Import this project, You need to fulfill the requirements.

1. Right click on project > Properties > **Java Build path**
2. Change your **JDK if 17 is not set.**
3. You need **Maven 3+** configured in your system (or You can download Maven 3+ from [here](https://maven.apache.org/download.cgi))
4. Once you are set up with all these things,
Right-click on project > Run as > Maven clean (you can directly do this using **mvn clean** command in cmd at specific project dir)
5. Again right click on project, Find **Maven >** in options, Click on **Update project**
check the **Update snapshots forcefully** option and press ok.
6. Now you can refresh your project. Run clean and build project.

<h3>Guide to access enpoints using swagger</h3>

- open this URL after you build and run the Project (http://localhost:8080/swagger-ui/index.html).
