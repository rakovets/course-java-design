package com.rakovets.course.design.example.pattern.chain_of_responsibility.example.middleware;

import com.rakovets.course.design.example.pattern.chain_of_responsibility.example.server.Server;

/**
 * Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
