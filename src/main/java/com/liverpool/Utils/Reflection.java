package com.liverpool.Utils;

import com.liverpool.Actor.IActions;

public class Reflection {

    public static <T> T createInstancePage(Class<T> clazz, IActions iActions) {
        try {
            return clazz.getConstructor(IActions.class).newInstance(iActions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}