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

INSERT INTO Student(StudentID, Password, Name)
    VALUES (2014212053, '123456', 'Long Ying');

INSERT INTO ShopInfo(OwnerID, ShopName, ShopID)
    VALUES (233333, '满庭芳', 123);
INSERT INTO ConsumeRecord(StudentID,ConsumeTime,Balance,ConsumeInfo,ShopID)
    VALUES (2014211978,'2016-06-30 11:23:08',80,'supper',123);
INSERT INTO StudentCard(StudentID,StudentCardID,Balance)
    VALUES (2014211978,'newzhou',98.5);
INSERT INTO LossReportRecord(StudentID,LossReportTime,PrevStudentCardID,LaterStudentCardID)
    VALUES (2014211978,'2016-06-30 11:23:08','oldzhou','newzhou');
UPDATE ShopInfo SET ShopName='满庭芳' WHERE ShopID=123;
INSERT INTO ConsumeRecord(StudentID,ConsumeTime,Balance,ConsumeInfo,ShopID)
    VALUES (2014211978,'2016-07-08 12:09:32',50,'lunch',123);
INSERT INTO RefundRecord(StudentID,RefundTime,RefundInfo)
    VALUES (2014211978,'2016-06-08 17:20:19','5 for fruit');
INSERT INTO TopUpRecord(StudentID,TopUpTime,Balance,TopUpInfo)
    VALUES (2014211978,'2016-06-20 09:00:32',200,'充值');