DROP SEQUENCE seq_Address;
DROP SEQUENCE seq_Place;
DROP SEQUENCE seq_Organization;
DROP SEQUENCE seq_Event;
DROP SEQUENCE seq_Cart;
DROP SEQUENCE seq_Organization_Phone;
DROP SEQUENCE seq_Photo;
DROP SEQUENCE seq_PhotoGallary;
DROP SEQUENCE seq_Page;
DROP SEQUENCE seq_Category;
DROP SEQUENCE seq_News_Category;
DROP SEQUENCE seq_Person;
DROP SEQUENCE seq_Voting_Item;
DROP SEQUENCE seq_Voting;
DROP SEQUENCE seq_Stuff;
DROP SEQUENCE seq_Stuff_Category;
DROP SEQUENCE seq_Advertising;
DROP SEQUENCE seq_User_Properties;
DROP SEQUENCE seq_Application_Properties;
DROP SEQUENCE seq_User;
DROP SEQUENCE seq_News;
DROP SEQUENCE seq_Action;
DROP SEQUENCE seq_Info_Page;
DROP SEQUENCE seq_Action_Page;
DROP SEQUENCE seq_Image;
DROP SEQUENCE seq_Contact;
DROP SEQUENCE seq_ContactType;
DROP SEQUENCE hibernate_sequence;

DROP TABLE Address CASCADE CONSTRAINTS;
DROP TABLE Place CASCADE CONSTRAINTS;
DROP TABLE Organization CASCADE CONSTRAINTS;
DROP TABLE Organization_Event CASCADE CONSTRAINTS;
DROP TABLE Event CASCADE CONSTRAINTS;
DROP TABLE Cart CASCADE CONSTRAINTS;
DROP TABLE Organization_Phone CASCADE CONSTRAINTS;
DROP TABLE Photo CASCADE CONSTRAINTS;
DROP TABLE PhotoGallary CASCADE CONSTRAINTS;
DROP TABLE Page CASCADE CONSTRAINTS;
DROP TABLE Category_Advertising CASCADE CONSTRAINTS;
DROP TABLE Category CASCADE CONSTRAINTS;
DROP TABLE News_Category CASCADE CONSTRAINTS;
DROP TABLE Person CASCADE CONSTRAINTS;
DROP TABLE Voting_Item CASCADE CONSTRAINTS;
DROP TABLE Voting CASCADE CONSTRAINTS;
DROP TABLE Stuff CASCADE CONSTRAINTS;
DROP TABLE Stuff_Category CASCADE CONSTRAINTS;
DROP TABLE Advertising CASCADE CONSTRAINTS;
DROP TABLE User_Properties CASCADE CONSTRAINTS;
DROP TABLE Application_Properties CASCADE CONSTRAINTS;
DROP TABLE "User" CASCADE CONSTRAINTS;
DROP TABLE News CASCADE CONSTRAINTS;
DROP TABLE Action CASCADE CONSTRAINTS;
DROP TABLE Organization_Page CASCADE CONSTRAINTS;
DROP TABLE Info_Page CASCADE CONSTRAINTS;
DROP TABLE Action_Page CASCADE CONSTRAINTS;
DROP TABLE Category_Organization CASCADE CONSTRAINTS;
DROP TABLE Image CASCADE CONSTRAINTS;
DROP TABLE Contact CASCADE CONSTRAINTS;
DROP TABLE ContactType CASCADE CONSTRAINTS;
DROP TABLE Organization_Contact CASCADE CONSTRAINTS;
DROP TABLE Event_Place CASCADE CONSTRAINTS;
DROP TABLE Organization_Place CASCADE CONSTRAINTS;
DROP TABLE Notification_Subscribe CASCADE CONSTRAINTS;

CREATE TABLE Address (id number(10) NOT NULL, street varchar2(255) NOT NULL, house number(10) NOT NULL, letter varchar2(1), flat number(10), floor number(10), place number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Place (id number(10) NOT NULL, description varchar2(255), lat number(10) NOT NULL, alt number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Organization (id number(10) NOT NULL, name varchar2(255), description varchar2(500), logo number(10), PRIMARY KEY (id));
CREATE TABLE Organization_Event (event number(10) NOT NULL, organization number(10) NOT NULL, PRIMARY KEY (event, organization));
CREATE TABLE Event (id number(10) NOT NULL, text varchar2(255), image number(10), PRIMARY KEY (id));
CREATE TABLE Cart (id number(10) NOT NULL, stuff number(10), PRIMARY KEY (id));
CREATE TABLE Organization_Phone (id number(10) NOT NULL, phone number(10) NOT NULL, description varchar2(255), "order" number(10), organization number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Photo (id number(10) NOT NULL, description varchar2(255), url varchar2(255) NOT NULL, gallery number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE PhotoGallary (id number(10) NOT NULL, name varchar2(255), description varchar2(255), PRIMARY KEY (id));
CREATE TABLE Page (id number(10) NOT NULL, type number(10), PRIMARY KEY (id));
CREATE TABLE Category_Advertising (category number(10) NOT NULL, advertising number(10) NOT NULL, PRIMARY KEY (category, advertising));
CREATE TABLE Category (id number(10) NOT NULL, name varchar2(255), parent number(10), "order" number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE News_Category (id number(10) NOT NULL, name varchar2(255), PRIMARY KEY (id));
CREATE TABLE Person (id number(10) NOT NULL, first_name varchar2(255) NOT NULL, second_name varchar2(255), surname varchar2(255), photo number(10), age number(10), phone varchar2(255), birthday date, PRIMARY KEY (id));
CREATE TABLE Voting_Item (id number(10) NOT NULL, answer number(10) NOT NULL, count number(10), voting number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Voting (id number(10) NOT NULL, subject varchar2(255) NOT NULL, isMultiselect number(10), PRIMARY KEY (id));
CREATE TABLE Stuff (id number(10) NOT NULL, category number(10) NOT NULL, name number(10) NOT NULL, description varchar2(255), cost number(19, 2), photo number(10), PRIMARY KEY (id));
CREATE TABLE Stuff_Category (id number(10) NOT NULL, name varchar2(255) NOT NULL, parent number(10) NOT NULL, description varchar2(255), PRIMARY KEY (id));
CREATE TABLE Advertising (id number(10) NOT NULL, priority number(10) NOT NULL, text varchar2(255), image number(10), organization number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE User_Properties (id number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Application_Properties (id number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE "User" (id number(10) NOT NULL, login varchar2(255) NOT NULL UNIQUE, password varchar2(255) NOT NULL, regDate date NOT NULL, regId varchar2(255) UNIQUE, isBlocked number(10), person number(10) NOT NULL, IMEI number(20) NOT NULL, PRIMARY KEY (id));
CREATE TABLE News (id number(10) NOT NULL, "date" date, text varchar2(255), category number(10) NOT NULL, photo number(10), PRIMARY KEY (id));
CREATE TABLE Action (id number(10) NOT NULL, startDate date, endDate date, subject varchar2(255) NOT NULL, organization number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Organization_Page (organization number(10) NOT NULL, page number(10) NOT NULL, PRIMARY KEY (organization, page));
CREATE TABLE Info_Page (id number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Action_Page (id number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Category_Organization (category number(10) NOT NULL, organization number(10) NOT NULL, PRIMARY KEY (category, organization));
CREATE TABLE Image (id number(10) NOT NULL, binaryContent long raw, PRIMARY KEY (id));
CREATE TABLE Contact (id number(10) NOT NULL, ContactType number(10) NOT NULL, contact varchar2(255), PRIMARY KEY (id));
CREATE TABLE ContactType (id number(10) NOT NULL, name varchar2(255), PRIMARY KEY (id));
CREATE TABLE Organization_Contact (organization number(10) NOT NULL, contact number(10) NOT NULL, PRIMARY KEY (organization, contact));
CREATE TABLE Event_Place (event number(10) NOT NULL, place number(10) NOT NULL, PRIMARY KEY (event, place));
CREATE TABLE Organization_Place (organization number(10) NOT NULL, place number(10) NOT NULL, PRIMARY KEY (organization, place));
CREATE TABLE Notification_Subscribe(id number(10) NOT NULL, organization number(10) NOT NULL, "USER" number(10) NOT NULL, PRIMARY KEY (organization, "USER"));

ALTER TABLE Voting_Item ADD CONSTRAINT FKVoting_Ite446178 FOREIGN KEY (voting) REFERENCES Voting (id);
ALTER TABLE Stuff_Category ADD CONSTRAINT FKStuff_Cate803293 FOREIGN KEY (parent) REFERENCES Stuff_Category (id);
ALTER TABLE Stuff ADD CONSTRAINT FKStuff438291 FOREIGN KEY (category) REFERENCES Stuff_Category (id);
ALTER TABLE News ADD CONSTRAINT FKNews597958 FOREIGN KEY (category) REFERENCES News_Category (id);
ALTER TABLE Category_Advertising ADD CONSTRAINT FKCategory_A764572 FOREIGN KEY (category) REFERENCES Category (id);
ALTER TABLE Organization_Page ADD CONSTRAINT FKOrganization_P63049 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Organization_Page ADD CONSTRAINT FKOrganization_P989259 FOREIGN KEY (page) REFERENCES Page (id);
ALTER TABLE Photo ADD CONSTRAINT FKPhoto385414 FOREIGN KEY (gallery) REFERENCES PhotoGallary (id);
ALTER TABLE "User" ADD CONSTRAINT FKUser52166 FOREIGN KEY (person) REFERENCES Person (id);
ALTER TABLE Organization_Event ADD CONSTRAINT FKEvent_Orga395207 FOREIGN KEY (event) REFERENCES Event (id);
ALTER TABLE Organization_Event ADD CONSTRAINT FKEvent_Orga429990 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Address ADD CONSTRAINT FKAddress908953 FOREIGN KEY (place) REFERENCES Place (id);
ALTER TABLE Organization_Phone ADD CONSTRAINT FKOrganizati700363 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Category_Advertising ADD CONSTRAINT FKCategory_A580589 FOREIGN KEY (advertising) REFERENCES Advertising (id);
ALTER TABLE Category_Organization ADD CONSTRAINT FKCategory_P674365 FOREIGN KEY (category) REFERENCES Category (id);
ALTER TABLE Category_Organization ADD CONSTRAINT FKCategory_P477025 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Advertising ADD CONSTRAINT FKAdvertisin516328 FOREIGN KEY (image) REFERENCES Image (id);
ALTER TABLE Organization ADD CONSTRAINT FKOrganizati335517 FOREIGN KEY (logo) REFERENCES Image (id);
ALTER TABLE Contact ADD CONSTRAINT FKContact600209 FOREIGN KEY (ContactType) REFERENCES ContactType (id);
ALTER TABLE Organization_Contact ADD CONSTRAINT FKOrganizati685991 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Organization_Contact ADD CONSTRAINT FKOrganizati842905 FOREIGN KEY (Contact) REFERENCES Contact (id);
ALTER TABLE Event_Place ADD CONSTRAINT FKEvent_Plac346162 FOREIGN KEY (event) REFERENCES Event (id);
ALTER TABLE Event_Place ADD CONSTRAINT FKEvent_Plac210460 FOREIGN KEY (place) REFERENCES Place (id);
ALTER TABLE Event ADD CONSTRAINT FKEvent416665 FOREIGN KEY (image) REFERENCES Image (id);
ALTER TABLE Organization_Place ADD CONSTRAINT FKOrganizati415883 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Organization_Place ADD CONSTRAINT FKOrganizati136618 FOREIGN KEY (place) REFERENCES Place (id);
ALTER TABLE Action ADD CONSTRAINT FKAction875605 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Advertising ADD CONSTRAINT FKAdvertisin899732 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Notification_Subscribe ADD CONSTRAINT FKNotification_S415883 FOREIGN KEY (organization) REFERENCES Organization (id);
ALTER TABLE Notification_Subscribe ADD CONSTRAINT FKNotification_S136618 FOREIGN KEY ("USER") REFERENCES "User" (id);

CREATE SEQUENCE seq_Address;
CREATE SEQUENCE seq_Place;
CREATE SEQUENCE seq_Organization;
CREATE SEQUENCE seq_Event;
CREATE SEQUENCE seq_Cart;
CREATE SEQUENCE seq_Organization_Phone;
CREATE SEQUENCE seq_Photo;
CREATE SEQUENCE seq_PhotoGallary;
CREATE SEQUENCE seq_Page;
CREATE SEQUENCE seq_Category;
CREATE SEQUENCE seq_News_Category;
CREATE SEQUENCE seq_Person;
CREATE SEQUENCE seq_Voting_Item;
CREATE SEQUENCE seq_Voting;
CREATE SEQUENCE seq_Stuff;
CREATE SEQUENCE seq_Stuff_Category;
CREATE SEQUENCE seq_Advertising;
CREATE SEQUENCE seq_User_Properties;
CREATE SEQUENCE seq_Application_Properties;
CREATE SEQUENCE seq_User;
CREATE SEQUENCE seq_News;
CREATE SEQUENCE seq_Action;
CREATE SEQUENCE seq_Info_Page;
CREATE SEQUENCE seq_Action_Page;
CREATE SEQUENCE seq_Image;
CREATE SEQUENCE seq_Contact;
CREATE SEQUENCE seq_ContactType;

CREATE SEQUENCE hibernate_sequence;

---- �� ����� ���������. ������.

CREATE OR REPLACE TRIGGER "TSQUSER" BEFORE
  INSERT ON "User" FOR EACH ROW DECLARE BEGIN
  SELECT SEQ_USER.NEXTVAL INTO :NEW."ID" FROM DUAL;
END;
/

ALTER TRIGGER "TSQPERSON" ENABLE;

CREATE OR REPLACE TRIGGER "TSQPERSON" BEFORE
  INSERT ON Person FOR EACH ROW DECLARE BEGIN
  SELECT SEQ_PERSON.NEXTVAL INTO :NEW."ID" FROM DUAL;
END;
/

ALTER TRIGGER "TSQPERSON" ENABLE;

---- �� ����� ���������. �����