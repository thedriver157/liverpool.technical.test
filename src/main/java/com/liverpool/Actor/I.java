package com.liverpool.Actor;

public class I {
    private static final ThreadLocal<IActions> I = new ThreadLocal<>();

    public static void set(IActions instanceI) {
        I.set(instanceI);
    }

    public static IActions get() {
        return I.get();
    }

    public static void remove() {
        I.remove();
    }
}