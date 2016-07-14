Prerequisites
============
maven 3.x
jdk1.7
mysql5.x
Tomcat7.x

Technologies used
=================
Spring4.x MVC
Hibernate3.x annotation
JSP
JSTL


Steps to execute project
=======================
1. Open mysql with credentials root/root 
2. create database testdb 
3. run attached FLASHSALE.sql query
4. Import FlashSaleWebApp maven project into eclipse
5. Right click on pom.xml and Run as "Maven clean" and then "Maven install"
6. Right click on project and Run as "Run on Server" and select Apache Tomcat server

Note: 
a. By default 1 product will be stored in DB.
b. For every person clicks on Add to Cart, Customer and Order table will be updated. Once Order becomes 10, the user will    be shown "Out of stock" message on UI.
c. Once order is full i.e Out of stock, to again execute project from scratch, run FLASHSALE.sql query and refresh the page




