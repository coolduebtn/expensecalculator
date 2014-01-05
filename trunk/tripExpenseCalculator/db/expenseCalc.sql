CREATE TABLE `Expenditure` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Member` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `Expenditure_Member` (
  `expenditure_id` int(10) NOT NULL,
  `member_id` int(10) NOT NULL,
  PRIMARY KEY (`expenditure_id`,`member_id`),
  CONSTRAINT `expenditure_Member_fk_expenditure` FOREIGN KEY (`expenditure_id`) REFERENCES `Expenditure` (`id`),
  CONSTRAINT `expenditure_Member_fk_member` FOREIGN KEY (`member_id`) REFERENCES `Member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Expense` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `spender_id` int(10) NOT NULL,
  `expenditure_id` int(10) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `expenseDate` date NOT NULL,
  PRIMARY KEY (`id`),
   CONSTRAINT `expense_fk_member` FOREIGN KEY (`spender_id`) REFERENCES `Member` (`id`),
   CONSTRAINT `expense_fk_expenditure` FOREIGN KEY (`expenditure_id`) REFERENCES `Expenditure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



