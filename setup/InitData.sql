/**
 * Author:  Zhou Shengyun <GGGZ-1101-28@Live.cn>
 * Created: Jul 3, 2016
 */

USE StudentCardSystemDB;
INSERT INTO Student(StudentID, Password, Name)
    VALUES (2014211978, '123456', 'Zhou Shengyun');
INSERT INTO Seller(SellerID, Password, Name)
    VALUES (233333, '123456', 'Seller Wang');
INSERT INTO Admin(AdminID, Password, Name)
    VALUES (666666, '123456', 'Admin Lu');
INSERT INTO ShopInfo(OwnerID,ShopName,ShopID)
    VALUES(233333,'mantingfang',123);
INSERT INTO ConsumeRecord(StudentID,ConsumeTime,Balance,ConsumeInfo,ShopID)
    VALUES(2014211978,'2016-06-01 11:23:08',80,'supper',123);
INSERT INTO ConsumeRecord(StudentID,ConsumeTime,Balance,ConsumeInfo,ShopID)
    VALUES(2014211978,'2016-07-10 15:20:08',60,'supper',123);
INSERT INTO ConsumeRecord(StudentID,ConsumeTime,Balance,ConsumeInfo,ShopID)
    VALUES(2014211978, CURRENT_TIME,60,'supper',123);
INSERT INTO ConsumeRecord(StudentID,ConsumeTime,Balance,ConsumeInfo,ShopID)
    VALUES(2014211978, '2016-07-11 10:51:09',60,'supper',123);