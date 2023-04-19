SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table Hospital;
TRUNCATE table Person;
TRUNCATE table Doctor;
ALTER TABLE User DROP COLUMN userContactNo,RENAME COLUMN userEmail TO email,RENAME COLUMN userRoleId TO roleId;
SET FOREIGN_KEY_CHECKS = 1;


ALTER TABLE Person DROP COLUMN email , DROP COLUMN password , DROP COLUMN roleId;

ALTER TABLE Hospital DROP COLUMN hospitalAdminEmail , DROP COLUMN hospitalAdminPassword , DROP COLUMN roleId;

ALTER TABLE Doctor DROP COLUMN email , DROP COLUMN password , DROP COLUMN roleId;

