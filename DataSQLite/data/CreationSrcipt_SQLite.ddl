DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Place;
DROP TABLE IF EXISTS Organization;
DROP TABLE IF EXISTS Organization_Event;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Cart;
DROP TABLE IF EXISTS Organization_Phone;
DROP TABLE IF EXISTS Photo;
DROP TABLE IF EXISTS PhotoGallery;
DROP TABLE IF EXISTS Page;
DROP TABLE IF EXISTS Category_Advertising;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS News_Category;
DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Voting_Item;
DROP TABLE IF EXISTS Voting;
DROP TABLE IF EXISTS Stuff;
DROP TABLE IF EXISTS Stuff_Category;
DROP TABLE IF EXISTS Advertising;
DROP TABLE IF EXISTS User_Properties;
DROP TABLE IF EXISTS Application_Properties;
DROP TABLE IF EXISTS "User";
DROP TABLE IF EXISTS News;
DROP TABLE IF EXISTS Action;
DROP TABLE IF EXISTS Organization_Page;
DROP TABLE IF EXISTS Info_Page;
DROP TABLE IF EXISTS Action_Page;
DROP TABLE IF EXISTS Category_Organization;
DROP TABLE IF EXISTS Image;
DROP TABLE IF EXISTS Contact;
DROP TABLE IF EXISTS ContactType;
DROP TABLE IF EXISTS Organization_Contact;
DROP TABLE IF EXISTS Event_Place;
DROP TABLE IF EXISTS Organization_Place;
DROP TABLE IF EXISTS Notification_Subscribe;

CREATE TABLE Address (id INTEGER NOT NULL, street varchar(255) NOT NULL, house integer(10) NOT NULL, letter varchar(1), flat integer(10), floor integer(10), place integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(place) REFERENCES Place(id));
CREATE TABLE Place (id INTEGER NOT NULL, description varchar(255), lat integer(10) NOT NULL, alt integer(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Organization (id INTEGER NOT NULL, name varchar(255), description varchar(255), logo integer(10), PRIMARY KEY (id), FOREIGN KEY(logo) REFERENCES Image(id));
CREATE TABLE Organization_Event (event integer(10) NOT NULL, organization integer(10) NOT NULL, PRIMARY KEY (event, organization), FOREIGN KEY(event) REFERENCES Event(id), FOREIGN KEY(organization) REFERENCES Organization(id));
CREATE TABLE Event (id INTEGER NOT NULL, text varchar(255), image integer(10), PRIMARY KEY (id), FOREIGN KEY(image) REFERENCES Image(id));
CREATE TABLE Cart (id INTEGER NOT NULL, stuff integer(10), PRIMARY KEY (id));
CREATE TABLE Organization_Phone (id INTEGER NOT NULL, phone integer(10) NOT NULL, description varchar(255), "order" integer(10), organization integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(organization) REFERENCES Organization(id));
CREATE TABLE Photo (id INTEGER NOT NULL, description varchar(255), url varchar(255) NOT NULL, gallery integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(gallery) REFERENCES PhotoGallery(id));
CREATE TABLE PhotoGallery (id INTEGER NOT NULL, name varchar(255), description varchar(255), PRIMARY KEY (id));
CREATE TABLE Page (id INTEGER NOT NULL, type integer(10), PRIMARY KEY (id));
CREATE TABLE Category_Advertising (category integer(10) NOT NULL, advertising integer(10) NOT NULL, PRIMARY KEY (category, advertising), FOREIGN KEY(category) REFERENCES Category(id), FOREIGN KEY(advertising) REFERENCES Advertising(id));
CREATE TABLE Category (id INTEGER NOT NULL, name varchar(255), parent integer(10), "order" integer(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE News_Category (id INTEGER NOT NULL, name varchar(255), PRIMARY KEY (id));
CREATE TABLE Person (id INTEGER NOT NULL, first_name varchar(255) NOT NULL, second_name varchar(255), surname varchar(255), photo integer(10), age integer(10), phone varchar(255), birthday date, PRIMARY KEY (id));
CREATE TABLE Voting_Item (id INTEGER NOT NULL, answer integer(10) NOT NULL, count integer(10), voting integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(voting) REFERENCES Voting(id));
CREATE TABLE Voting (id INTEGER NOT NULL, subject varchar(255) NOT NULL, isMultiselect integer(10), PRIMARY KEY (id));
CREATE TABLE Stuff (id INTEGER NOT NULL, category integer(10) NOT NULL, name integer(10) NOT NULL, description varchar(255), cost numeric(19, 2), photo integer(10), PRIMARY KEY (id), FOREIGN KEY(category) REFERENCES Stuff_Category(id));
CREATE TABLE Stuff_Category (id INTEGER NOT NULL, name varchar(255) NOT NULL, parent integer(10) NOT NULL, description varchar(255), PRIMARY KEY (id), FOREIGN KEY(parent) REFERENCES Stuff_Category(id));
CREATE TABLE Advertising (id INTEGER NOT NULL, priority integer(10) NOT NULL, text varchar(255), image integer(10), organization integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(image) REFERENCES Image(id), FOREIGN KEY(organization) REFERENCES Organization(id));
CREATE TABLE User_Properties (id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE Application_Properties (id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE "User" (id INTEGER NOT NULL, login varchar(255) NOT NULL UNIQUE, password varchar(255) NOT NULL, regDate date NOT NULL, regId varchar(255) UNIQUE, isBlocked integer(10), person integer(10) NOT NULL, IMEI integer(20) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(person) REFERENCES Person(id));
CREATE TABLE News (id INTEGER NOT NULL, "date" date, text varchar(255), category integer(10) NOT NULL, photo integer(10), PRIMARY KEY (id), FOREIGN KEY(category) REFERENCES News_Category(id));
CREATE TABLE Action (id INTEGER NOT NULL, startDate date, endDate date, subject varchar(255) NOT NULL, organization integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(organization) REFERENCES Organization(id));
CREATE TABLE Organization_Page (Organization integer(10) NOT NULL, page integer(10) NOT NULL, PRIMARY KEY (organization, page), FOREIGN KEY(organization) REFERENCES Organization(id), FOREIGN KEY(page) REFERENCES Page(id));
CREATE TABLE Info_Page (id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE Action_Page (id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE Category_Organization (category integer(10) NOT NULL, organization integer(10) NOT NULL, PRIMARY KEY (category, organization), FOREIGN KEY(category) REFERENCES Category(id), FOREIGN KEY(organization) REFERENCES Organization(id));
CREATE TABLE Image (id INTEGER NOT NULL, binaryContent blob, PRIMARY KEY (id));
CREATE TABLE Contact (id INTEGER NOT NULL, ContactType integer(10) NOT NULL, contact varchar(255), PRIMARY KEY (id), FOREIGN KEY(ContactType) REFERENCES ContactType(id));
CREATE TABLE ContactType (id INTEGER NOT NULL, name varchar(255), PRIMARY KEY (id));
CREATE TABLE Organization_Contact (organization integer(10) NOT NULL, contact integer(10) NOT NULL, PRIMARY KEY (organization, contact), FOREIGN KEY(organization) REFERENCES Organization(id), FOREIGN KEY(contact) REFERENCES Contact(id));
CREATE TABLE Event_Place (event integer(10) NOT NULL, place integer(10) NOT NULL, PRIMARY KEY (event, place), FOREIGN KEY(event) REFERENCES Event(id), FOREIGN KEY(place) REFERENCES Place(id));
CREATE TABLE Organization_Place (organization integer(10) NOT NULL, place integer(10) NOT NULL, PRIMARY KEY (organization, place), FOREIGN KEY(organization) REFERENCES Organization(id), FOREIGN KEY(place) REFERENCES Place(id));
CREATE TABLE Notification_Subscribe (id INTEGER NOT NULL, organization integer(10) NOT NULL, user integer(10) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(organization) REFERENCES Organization(id), FOREIGN KEY(user) REFERENCES User(id));
CREATE UNIQUE INDEX Notification_SubscribeIndex on Notification_Subscribe (organization, user);