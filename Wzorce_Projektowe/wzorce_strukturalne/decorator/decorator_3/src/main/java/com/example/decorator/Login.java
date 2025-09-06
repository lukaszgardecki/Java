package com.example.decorator;

public class Login {

    public static void main(String[] args) {

        var user = new BasicUser();
        user.printPrivileges();

        System.out.println("---");

        var adminUser = new AdminUser(user);
        adminUser.printPrivileges();

        System.out.println("---");

        var devUser = new DeveloperUser(adminUser);
        devUser.printPrivileges();
    }

}
