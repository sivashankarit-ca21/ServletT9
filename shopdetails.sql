drop database shankari;
create database shankari;
create table shankari.shopdetails(shop_id varchar(10),shop_name varchar(100),address_line varchar(100),contact_no varchar(10),pincode varchar(100));
insert into  shankari.shopdetails(shop_id,shop_name,address_line,contact_no,pincode)values('1','SHANNU BAKES','Kannakampalayam pirivu,Tirupur','9876543210','641612');
insert into  shankari.shopdetails(shop_id,shop_name,address_line,contact_no,pincode)values('2','BALAJI BAKES AND COOKIES','Rakkiyapalayam pirivu,Tirupur','9876543211','641604');
insert into  shankari.shopdetails(shop_id,shop_name,address_line,contact_no,pincode)values('3','AYRA SUPER MARKET','Nehru Nagar,Palladam','9876543212','641602');
insert into  shankari.shopdetails(shop_id,shop_name,address_line,contact_no,pincode)values('4','SURYA CLINIC','Gandhi Nagar,Avinasi','9876543213','641670');
Insert into  shankari.shopdetails(shop_id,shop_name,address_line,contact_no,pincode)values('5','RIYA BAKES','CTC,Tirupur','9876543810','627004');
select * from shankari.shopdetails;
