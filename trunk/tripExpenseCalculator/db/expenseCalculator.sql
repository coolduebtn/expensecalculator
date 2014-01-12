CREATE TABLE `Account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`username`),
  UNIQUE (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Expenditure` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `creator_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `expenditure_fk_creator` FOREIGN KEY (`creator_id`) REFERENCES `Account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `Expenditure_Member` (
  `expenditure_id` int(10) NOT NULL,
  `member_id` int(10) NOT NULL,
  PRIMARY KEY (`expenditure_id`,`member_id`),
  CONSTRAINT `expenditure_Member_fk_expenditure` FOREIGN KEY (`expenditure_id`) REFERENCES `Expenditure` (`id`),
  CONSTRAINT `expenditure_Member_fk_member` FOREIGN KEY (`member_id`) REFERENCES `Account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Expense` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `spender_id` int(10) NOT NULL,
  `expenditure_id` int(10) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `expenseDate` date NOT NULL,
  PRIMARY KEY (`id`),
   CONSTRAINT `expense_fk_account` FOREIGN KEY (`spender_id`) REFERENCES `Account` (`id`),
   CONSTRAINT `expense_fk_expenditure` FOREIGN KEY (`expenditure_id`) REFERENCES `Expenditure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into Account values (1,'chandan','cooldudebtn@gmail.com','admin','admin');
insert into Account values(2,'chandu','agl.chandan@gmail.com','chandan','chandan');



