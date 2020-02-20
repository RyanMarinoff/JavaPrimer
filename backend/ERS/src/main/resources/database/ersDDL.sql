/*
    Ease of database reset
*/

DROP TABLE STATUS CASCADE CONSTRAINTS;
DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE REIMBURSEMENT CASCADE CONSTRAINTS;
DROP TABLE STATUS_LOG CASCADE CONSTRAINTS;

DROP SEQUENCE STATUS_SEQ;
DROP SEQUENCE EMPLOYEE_SEQ;
DROP SEQUENCE REIMBURSEMENT_SEQ;
DROP SEQUENCE STATUS_LOG_SEQ;


/*
    STATUS table - the status of the reimbursement
    ID - Auto generated unique identifier
    CODE - The status code (like 'pending', 'processing', etc.
*/
CREATE TABLE STATUS (
    ID NUMBER(16) PRIMARY KEY,
    CODE VARCHAR2(128) NOT NULL
);
CREATE SEQUENCE STATUS_SEQ;

/*
    EMPLOYEE table - all employees of the company within
    ID - Auto generated unique identifier
    USERNAME - The username used to log into the system (no repeats allowed)
    PASSWORD - The password for the login (if time permits, encode this data)
    EMAIL - The email that the employee will receive notifications from (no repeats allowed)
    FNAME - The first name for the employee
    LNAME - The last name for the employee
*/
CREATE TABLE EMPLOYEE (
    ID NUMBER(16) PRIMARY KEY,
    USERNAME VARCHAR2(128) NOT NULL UNIQUE,
    PASSWORD VARCHAR2(128) NOT NULL,
    EMAIL VARCHAR2(256) NOT NULL UNIQUE,
    FNAME VARCHAR2(128) NOT NULL,
    LNAME VARCHAR2(128) NOT NULL,
    MANAGER_ID NUMBER(16),
    CONSTRAINT FK_MANAGER FOREIGN KEY (MANAGER_ID) REFERENCES EMPLOYEE(ID)
);
CREATE SEQUENCE EMPLOYEE_SEQ;

/*
    REIMBURSEMENT table - The requested reimbursement
    ID - Auto generated unique identifier
    AMOUNT - The dollar amount of the reimbursement request
    EMPLOYEE_ID - The employee making the reimbursement request, referenced from the EMPLOYEE table
*/
CREATE TABLE REIMBURSEMENT (
    ID NUMBER(16) PRIMARY KEY,
    AMOUNT NUMBER(10, 2) NOT NULL,
    EMPLOYEE_ID NUMBER(16) NOT NULL,
    CONSTRAINT FK_EMPLOYEE FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID)
);
CREATE SEQUENCE REIMBURSEMENT_SEQ;

/*
    STATUS_LOG table - Tracking of the status of the reimbursement process
    ID - Auto generated unique identifier
    STATUS_ID - The status of the reimbursement, referenced from the STATUS table
    REIMBURSEMENT_ID - The reimbursement that this status referes to, referenced from the REIMBURSEMENT table
    MODIFIED - The date that this modification took place
*/
CREATE TABLE STATUS_LOG (
    ID NUMBER(16) PRIMARY KEY,
    STATUS_ID NUMBER(16) NOT NULL,
    CONSTRAINT FK_STATUS FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID),
    REIMBURSEMENT_ID NUMBER(16) NOT NULL,
    CONSTRAINT FK_REIMBURSEMENT FOREIGN KEY (REIMBURSEMENT_ID) REFERENCES REIMBURSEMENT(ID),
    MODIFIED DATE NOT NULL
);
CREATE SEQUENCE STATUS_LOG_SEQ;