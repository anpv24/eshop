create database eshopDB;
use eshopDB;
create table category (
	categoryId int primary key,
    categoryName varchar(50) not null,
    status int 
);
create table product (
	productId int primary key,
    productName varchar(50) not null,
    price int,
    originalPrice int,
    viewCount int,
    description varchar(512),
    status int,
    categoryId int,
    foreign key (categoryId) references category (categoryId)
);
create table productImage(
	imageId int primary key,
    imagePath varchar(500),
    isDefault int,
    productId int,
    foreign key (productId) references product(productId)
);
create table productColor(
	colorId int primary key,
    colorName varchar(100),
	productId int,
	foreign key (productId) references product(productId)
);
create table productSize(
	sizeId int primary key,
    sizeName varchar(100),
	productId int,
	foreign key (productId) references product(productId)
);
create table users(
	userId int primary key,
    username varchar(50),
    password varchar(50),
    fullname varchar(100),
    avatar varchar(512),
    email varchar(50),
    phone varchar(20),
    address varchar(300),
    isAdmin int
);
create table orders(
	orderId int primary key,
    userId int,
    foreign key (userId) references users(userId),
    totalMoney int,
    payment varchar(50),
    bookingDate datetime,
    deliveryDate datetime,
    shippingWay varchar(100),
    state int,
    color varchar(50),
    size varchar(50),
    note varchar(500),
    transportFee int
);
create table orderDetail(
	orderDetailId int primary key,
    productId int,
    foreign key (productId) references product(productId),
    orderId int,
    foreign key (orderId) references orders(orderId),
    quantity int
);

create table product_detail(
	monitor varchar(100),
    os varchar(50),
    rearCamera varchar(100),
    frontCamera varchar(100),
    chip varchar(100),
    ram varchar(50),
    rom varchar(50),
    sim varchar(100),
    battery varchar(50),
    charge varchar(50),
	productId int,
    primary key (productId),
    foreign key (productId) references product(productId)
);

insert into users values(1,"admin","admin1234","","","","","",0);
insert into users values(2,"user","user1234","","","","","",1);

insert into category values(1,"Iphone",1);
insert into category values(2,"Oppo",1);
insert into category values(3,"SamSung",1);
insert into category values(4,"Xiaomi",1);

insert into product values(1,"iphone",30000000,10000000,0,"Màn hình Dynamic Island - Sự biến mất của màn hình tai thỏ thay thế bằng thiết kế viên thuốc, OLED 6,7 inch, hỗ trợ always-on display<br/>Cấu hình iPhone 14 Pro Max mạnh mẽ, hiệu năng cực khủng từ chipset A16 Bionic<br/>Làm chủ công nghệ nhiếp ảnh - Camera sau 48MP, cảm biến TOF sống động<br/>Pin liền lithium-ion kết hợp cùng công nghệ sạc nhanh cải tiến",1,1);
insert into product values(2,"oppo",30000000,10000000,0,"Chuyên gia chân dung, toả sáng khoảnh khắc đêm - Cụm camera 64MP + 2MP + 2MP nhiều tính năng tiện ích<br/>Thiết kế tinh xảo, cao cấp và mỏng nhẹ, phù hợp với trải nghiệm hàng ngày<br/>Sạc nhanh siêu tốc, tràn đầy năng lượng cho cả ngày - Viên pin 4500mAh, Sạc nhanh siêu tốc 33W<br/>Gấp đôi hiệu suất, xử lí mọi tác vụ - Con chip Qualcomm Snapdragon 695 mạnh mẽ trong phân khúc",1,2);
insert into product values(3,"samsung",30000000,10000000,0,"Thoả sức chụp ảnh, quay video chuyên nghiệp - Camera đến 200MP, chế độ chụp đêm cải tiến, bộ xử lí ảnh thông minh<br/>Chiến game bùng nổ - chip Snapdragon 8 Gen 2 8 nhân tăng tốc độ xử lí, màn hình 120Hz, pin 5.000mAh<br/>Nâng cao hiệu suất làm việc với Siêu bút S Pen tích hợp, dễ dàng đánh dấu sự kiện từ hình ảnh hoặc video<br/>Thiết kế bền bỉ, thân thiện - Màu sắc lấy cảm hứng từ thiên nhiên, chất liệu kính và lớp phim phủ PET tái chế",1,3);
insert into product values(4,"xiaomi",30000000,10000000,0,"Ống kính nhiếp ành Leica chuyên nghiệp - Cảm biến máy ảnh lớn 1 inch, chụp chân dung và chụp đêm siêu rõ nét<br/>Snapdragon 8 Gen 2 dẫn đầu - Siêu nhanh và tiết kiệm năng lượng, đa nhiệm mượt mà, chiến game cực đã<br/>Màn hình giải trí sống động - Độ phân giải WQHD+ cùng công nghệ Amoled 120Hz phản hồi cực nhạy<br/>Dẫn đầu sạc siêu nhanh - Sạc nhanh 120W, sạc đầy 100% chỉ trong 19 phút.",1,4);

insert into productimage values(1,"iphone-13-pro-M.jpg",1,1);
insert into productimage values(2,"iphone-13-pro-S1.jpg",0,1);
insert into productimage values(3,"iphone-13-pro-S2.jpg",0,1);
insert into productimage values(4,"oppo-find-x5-pro-M.jpg",1,2);
insert into productimage values(5,"oppo-find-x5-pro-S.jpg",0,2);
insert into productimage values(6,"samsung-galaxy-s22-ultra-S-2.jpg",1,3);
insert into productimage values(7,"samsung-galaxy-s22-ultra-S-1.jpg",0,3);
insert into productimage values(8,"samsung-galaxy-s22-ultra-den-M.jpg",0,3);
insert into productimage values(9,"xiaomi-12t-pro-M.jpg",1,4);
insert into productimage values(10,"xiaomi-12t-S.jpg",0,4);

insert into product_detail values("6.7 inch","IOS","48MP","12MP","A15","6GB","128GB","1 sim", "4352mAh","33W",1);
insert into product_detail values("6.7 inch","Android","48MP","12MP","Snapdragon","6GB","128GB","2 sim", "5000mAh","120W",2);
insert into product_detail values("6.7 inch","Android","48MP","12MP","Snapdragon","6GB","128GB","2 sim", "5000mAh","65W",3);
insert into product_detail values("6.7 inch","Android","48MP","12MP","Snapdragon","6GB","128GB","2 sim", "5500","65W",4);

insert into productcolor values(1,"black",1);
insert into productcolor values(2,"yellow",1);
insert into productcolor values(3,"blue",1);
insert into productcolor values(4,"black",2);
insert into productcolor values(5,"yellow",2);
insert into productcolor values(6,"blue",2);
insert into productcolor values(7,"black",3);
insert into productcolor values(8,"yellow",3);
insert into productcolor values(9,"blue",3);
insert into productcolor values(10,"black",4);
insert into productcolor values(11,"yellow",4);
insert into productcolor values(12,"blue",4);

insert into productsize values(1,"64GB",1);
insert into productsize values(2,"128GB",1);
insert into productsize values(3,"256GB",1);
insert into productsize values(4,"64GB",2);
insert into productsize values(5,"128GB",2);
insert into productsize values(6,"256GB",2);
insert into productsize values(7,"64GB",3);
insert into productsize values(8,"128GB",3);
insert into productsize values(9,"256GB",3);
insert into productsize values(10,"64GB",4);
insert into productsize values(11,"128GB",4);
insert into productsize values(12,"256GB",4);