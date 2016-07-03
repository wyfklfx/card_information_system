/**
 * Author:  Administrator
 * Created: 2016-7-3
 */

/*Please run with root user*/
DROP USER 'student_card'@'localhost';
CREATE USER 'student_card'@'localhost' IDENTIFIED BY '98s7ef89e98f00wekk0s09dfm0e9fj2334efdr';
GRANT ALL ON StudentCardSystemDB.* TO 'student_card'@'localhost';
